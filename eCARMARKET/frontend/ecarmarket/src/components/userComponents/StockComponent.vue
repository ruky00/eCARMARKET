<template>
    <div class="stock">
        <div class="buttons">
            <button type="button" @click="generateGraph(this.graphId, '1')">1</button>
            <button type="button" @click="generateGraph(this.graphId, '2')">2</button>
            <button type="button" @click="generateGraph(this.graphId, '3')">3</button>
        </div>
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
            }    
        },
        mounted() {
            const script = document.createElement('script');
            script.src = 'https://d3js.org/d3.v7.min.js';
            script.async = true;
            script.onload = () => {
                this.generateGraph(this.graphId);
            };
            document.head.appendChild(script);
        },
        methods: {
            async generateGraph(graphId, id='1') {
                
                document.getElementById(`${graphId}`).innerHTML = '';

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

                var pos = ''

                if (id === '1') pos = 'moveLeft';
                else if (id === '2') pos = 'moveMid';
                else if (id === '3') pos = 'moveRight'

                var heading = document.createElement('h2');
                heading.id = this.graphName;
                heading.classList.add(pos);
                document.getElementById(graphId).appendChild(heading);

                this.svg = window.d3.select(`#${graphId}`)
                    .append("svg")
                        .attr("viewBox", "0 0 900 400")
                        .attr("id", `${graphId}Svg`)
                        .attr("class", pos)
                    .append("g")
                        .attr("transform", `translate(${margin.left},${margin.top})`);

                if (graphId === "graphRight") {
                    window.d3.select("#graphRightSvg").attr("height", "15vw")
                }
                
                // Get the current date
                var today = new Date();

                // Substract 1 day from the current date
                today.setDate(today.getDate() - 1);

                // Get the year, month and day components
                const year = today.getFullYear();
                const month = (today.getMonth() + 1).toString().padStart(2, '0'); // Months are zero-based
                const day = today.getDate().toString().padStart(2, '0');

                // Format the date string in YYYY-MM-DD format

                const yesterday = `${year}-${month}-${day}`

                console.log(yesterday)

                // Create a dataset

                var url = `/s${id}.json`//'http://localhost:8081/api/monthly?symbol=' + graphId;

                window.$.getJSON(url, (jsonData) => {
                    var data = [];
                    
                    Object.keys(jsonData["Time Series (Daily)"]).forEach(key => {
                        data.push({ date: new Date(key), value: jsonData["Time Series (Daily)"][key]["4. close"]})
                    });
                    document.getElementById(this.graphName).innerHTML = jsonData["Meta Data"]["2. Symbol"];

                    /* Object.keys(jsonData["Monthly Time Series"]).forEach(key => {
                        data.push({ date: new Date(key), value: jsonData["Monthly Time Series"][key]["4. close"]})
                    });
                    document.getElementById(`${graphId}Name`).innerHTML = jsonData["Meta Data"]["2. Symbol"]; */
                    
                    // Define the x and y domains

                    this.x.domain(window.d3.extent(data, d => d.date));
                    this.y.domain([window.d3.min(data, d => d.value) - 3, window.d3.max(data, d => d.value)]);

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

                    // Create the line generator
                    const self = this;
                    const line = window.d3.line()
                        .x(d => self.x(d.date))
                        .y(d => self.y(d.value));

                    this.svg.selectAll(".xAxis")
                        .transition()
                        .duration(3000)
                        .call(window.d3.axisBottom(this.x))
                        
                    this.svg.selectAll(".yAxis")
                        .transition()
                        .duration(3000)
                        .call(window.d3.axisLeft(this.y))

                    // Add the line path to the SVG element

                    this.svg.append("path")
                        .datum(data)
                        .attr("fill", "none")
                        .attr("stroke", "steelblue")
                        .attr("stroke-width", 5)
                        .attr("d", line)
                });

                /* // Get the current date
                var today = new Date();

                // Substract 1 day from the current date
                today.setDate(today.getDate() - 1);

                // Get the year, month and day components
                const year = today.getFullYear();
                const month = (today.getMonth() + 1).toString().padStart(2, '0'); // Months are zero-based
                const day = today.getDate().toString().padStart(2, '0');

                // Format the date string in YYYY-MM-DD format

                const yesterday = `${year}-${month}-${day}`

                console.log(yesterday)

                // Create a dataset

                var url = `/s1.json`//'http://localhost:8081/api/monthly?symbol=' + graphId;

                window.$.getJSON(url, function(jsonData) {
                    const dataset = [];

                    Object.keys(jsonData["Time Series (Daily)"]).forEach(key => {
                        dataset.push({ date: new Date(key), value: jsonData["Time Series (Daily)"][key]["4. close"]})
                    });
                    document.getElementById(`${graphId}Name`).innerHTML = jsonData["Meta Data"]["2. Symbol"]; */

                    /* Object.keys(jsonData["Monthly Time Series"]).forEach(key => {
                        dataset.push({ date: new Date(key), value: jsonData["Monthly Time Series"][key]["4. close"]})
                    });
                    document.getElementById(`${graphId}Name`).innerHTML = jsonData["Meta Data"]["2. Symbol"]; */

                    // Define the x and y domains

                    /* x.domain(window.d3.extent(dataset, d => d.date));
                    y.domain([window.d3.min(dataset, d => d.value) - 3, window.d3.max(dataset, d => d.value)]);

                    // Add the x-axis

                    svg.append("g")
                        .attr("transform", `translate(0,${height})`)
                        .call(window.d3.axisBottom(x))
                        .attr("stroke-width", 4)
                        .attr("class", "xAxis");

                    // Add the y-axis

                    svg.append("g")
                        .call(window.d3.axisLeft(y))
                        .attr("stroke-width", 4)
                        .attr("class", "yAxis");

                    // Create the line generator

                    const line = window.d3.line()
                        .x(d => x(d.date))
                        .y(d => y(d.value));

                    // Add the line path to the SVG element

                    svg.append("path")
                        .datum(dataset)
                        .attr("fill", "none")
                        .attr("stroke", "steelblue")
                        .attr("stroke-width", 5)
                        .attr("d", line)
                }); */
            },
        }
    }
</script>

<style>
    @import "../../assets/css/userCSS/stockComponent.css";
</style>