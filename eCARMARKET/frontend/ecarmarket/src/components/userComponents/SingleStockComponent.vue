<template>
    <div class="stock">
        <div class="graph" :id="graphId">
        </div>
    </div>
</template>

<script>


    export default {
        name: 'StockComponent',
        props: {
            graphId: {
                type: String,
                required: true
            },
            graphName: {
                type: String,
                required: true
            }
        },
        data () {
            return {
                xAxis: '',
                yAxis: '',
                x: '',
                y: '',
                svg: '',
                height: '',
                currentId: '1',
            }    
        },
        mounted() {
            const script = document.createElement('script');
            script.src = 'https://d3js.org/d3.v7.min.js';
            script.async = true;
            script.onload = () => {
                this.generateGraph('TSLA');
            };
            document.head.appendChild(script);

            this.checkQuery();
        },
        methods: {
            checkQuery() {
                const queryString = window.location.search;
                if(this.graphId == 'singleGraph' && queryString != "") {
                    const urlParams = new URLSearchParams(queryString);
                    const search = urlParams.get('search');

                    this.searchStockSymbol(search);
                }
            },
            searchStockSymbol(search) {

                window.$.getJSON('/companies.json', (companies) => {
                    var stockName = "";

                    Object.keys(companies).forEach(name => {
                        
                        if (search.toLowerCase() == name.toLowerCase()) {
                            stockName = name;
                        }
                    });
                    this.generateGraph(companies[stockName]);
                });
            },
            generateGraph(symbol) {

                document.getElementById(`${this.graphId}`).innerHTML = '';


                // Set dimensions and margins for the chart

                const margin = { top: 10, right: 0, bottom: 40, left: 40 };

                const width = 950 - margin.left - margin.right;
                this.height = 400 - margin.top - margin.bottom;

                // Set uo the x and y scales
                this.x = window.d3.scaleTime()
                .range([0, width]);

                this.y = window.d3.scaleLinear()
                    .range([this.height, 0]);
                
                

                // Create the SVG element and append it to the chart container

                var heading = document.createElement('h2');
                heading.id = this.graphName;
                document.getElementById(this.graphId).appendChild(heading);

                this.svg = window.d3.select(`#${this.graphId}`)
                    .append("svg")
                        .attr("viewBox", "0 0 900 400")
                        .attr("id", `${this.graphId}Svg`)
                    .append("g")
                        .attr("transform", `translate(${margin.left},${margin.top})`);
                
                // Create a dataset

                var url = `/${symbol}.json`//'http://localhost:8081/api/monthly?symbol=' + graphId;

                window.$.getJSON(url, (jsonData) => {
                    var data = [];
                    const dataset = jsonData["Monthly Time Series"];
                    var newDataset = {};
                    
                    Object.keys(dataset).forEach(key => {
                        data.push({ date: new Date(key), value: dataset[key]["4. close"]})
                        newDataset[new Date(key)] = dataset[key]["4. close"]
                    });
                    document.getElementById(this.graphName).innerHTML = jsonData["Meta Data"]["2. Symbol"];
                    
                    // Define the x and y domains

                    this.x.domain(window.d3.extent(data, d => d.date));
                    this.y.domain([window.d3.min(data, d => d.value) - 3, window.d3.max(data, d => d.value)]);

                    // Create the line segments
                    const lineSegments = [];
                    let segmentData = [];
                    let isGoingUp = false;
                    let isGoingDown = false;

                    // Loop through the data to create line segments
                    for (let i = 0; i < data.length; i++) {
                        const currentData = data[i];
                        const previousData = i > 0 ? data[i - 1] : null;

                        // Check if the line is going up or down
                        if (previousData && currentData.value > previousData.value) {
                            if (isGoingDown) {
                                // If the line was going down, start a new segment
                                lineSegments.push(segmentData);
                                segmentData = [previousData];
                            }
                            isGoingUp = true;
                            isGoingDown = false;
                        } else if (previousData && currentData.value < previousData.value) {
                            if (isGoingUp) {
                                // If the line was going up, start a new segment
                                lineSegments.push(segmentData);
                                segmentData = [previousData];
                            }
                            isGoingUp = false;
                            isGoingDown = true;
                        }

                        // Add the current data to the segment
                        segmentData.push(currentData);

                        // If it's the last data point, add the final segment
                        if (i === data.length - 1) {
                            lineSegments.push(segmentData);
                        }
                    }

                    // Create the line generator
                    const self = this;
                    const line = window.d3.line()
                        .x(d => self.x(d.date))
                        .y(d => self.y(d.value));

                    // Add the line segments to the SVG element
                    lineSegments.forEach((segment) => {
                        const isGoingUp = segment[segment.length - 1].value > segment[0].value;
                        const segmentColor = isGoingUp ? 'red' : 'green';

                        this.svg
                            .append('path')
                            .datum(segment)
                            .attr('fill', 'none')
                            .attr('stroke', segmentColor)
                            .attr('stroke-width', 3)
                            .attr('d', line);
                    });

                    // Add the x-axis

                    this.svg.append("g")
                        .attr("transform", `translate(0,${this.height})`)
                        .call(window.d3.axisBottom(this.x))
                        .attr("stroke-width", 4)
                        .attr("class", "xAxis");

                    // Add the y-axis

                    this.svg.append("g")
                        .call(window.d3.axisLeft(this.y))
                        .attr("stroke-width", 4)
                        .attr("class", "yAxis");

                    // Create the circle that travels along the curve of chart
                    var focus = this.svg
                        .append('g')
                        .append('circle')
                            .style("fill", "none")
                            .attr("stroke", "black")
                            .attr('r', 8.5)
                            .style("opacity", 0)

                    // Create the text that travels along the curve of chart
                    var focusText = this.svg
                        .append('g')
                        .append('text')
                            .style("opacity", 0)
                            .attr("text-anchor", "left")
                            .attr("alignment-baseline", "middle")

                    // Create a rect on top of the svg area: this rectangle recovers mouse position
                    this.svg
                        .append('rect')
                        .style("fill", "none")
                        .style("pointer-events", "all")
                        .attr('width', width)
                        .attr('height', this.height)
                        .on('mouseover', mouseover)
                        .on('mousemove', mousemove)
                        .on('mouseout', mouseout);

                    // What happens when the mouse move -> show the annotations at the right positions.
                    function mouseover() {
                        focus.style("opacity", 1)
                        focusText.style("opacity",1)
                    }

                    function mousemove() {
                        // Recover the x-coordinate of the mouse pointer relative to the SVG element
                        var [mouseX] = window.d3.pointer(event, this);
                        // Use the x-scale invert function to convert the x-coordinate to the corresponding date value
                        var selectedDate = self.x.invert(mouseX);
                        if (selectedDate.getTimezoneOffset() == -120) selectedDate.setHours(2);
                        else if (selectedDate.getTimezoneOffset() == -60) selectedDate.setHours(1);

                        selectedDate.setMinutes(0);
                        selectedDate.setSeconds(0);
                        
                        for(let i = 0; i < 10; i++) {
                            if(newDataset[selectedDate] != undefined) break;
                            else selectedDate.setDate(selectedDate.getDate() - 1);
                        }

                        // Find the closest data point based on the selected date
                        var index = 0;
                        var selectedTimestamp = Math.floor(selectedDate.getTime() / 1000);
                        for (let i = 0; i < data.length; i++) {
                            var dateTimestamp = Math.floor(data[i].date.getTime() / 1000);
                            if(dateTimestamp == selectedTimestamp) {
                                index = i;
                                break;
                            }
                        }
                        var selectedData = data[index];
                        
                        // Update the position and content of the focus circle and text
                        focus
                            .attr("cx", self.x(selectedData.date))
                            .attr("cy", self.y(selectedData.value));
                        focusText
                            .html(selectedData.value)
                            .attr("x", self.x(selectedData.date) + 15)
                            .attr("y", self.y(selectedData.value));
                    }
                    function mouseout() {
                        focus.style("opacity", 0)
                        focusText.style("opacity", 0)
                    }
                });
            },
        }
    }
</script>

<style>
    @import "../../assets/css/userCSS/singleStockComponent.css";
</style>