<template>
    <div class="stock">
        <div class="buttons" id="buttons">
            <button type="button" class="selected" :id="button1"></button>
            <button type="button" :id="button2"></button>
            <button type="button" :id="button3"></button>
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
            },
            button1: {
                type: String,
                required: true
            },
            button2: {
                type: String,
                required: true
            },
            button3: {
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
                this.searchStockSymbol(['Tesla', 'Volvo', 'Ford']);
            };
            document.head.appendChild(script);
        },
        methods: {
            loadCompanies() {

                window.$.getJSON('http://localhost:8081/api/me/profile', (profile) => {
                    this.searchStockSymbol(profile.favCompany);
                });
            },
            searchStockSymbol(companiesArray) {

                window.$.getJSON('/companies.json', (companies) => {
                    var stockSymbols = [];
                    for (let i = 0; i < companiesArray.length; i++) {
                        stockSymbols.push(companies[companiesArray[i]]);
                    }

                    if (this.graphId === 'graphLeft') {
                        this.currentId = 'l1';
                        var lElement = document.getElementById('l1');
                        lElement.innerHTML = stockSymbols[0];
                        lElement.addEventListener('click', () => this.moveGraph('l1', stockSymbols[0]));

                        lElement = document.getElementById('l2');
                        lElement.innerHTML = stockSymbols[1];
                        lElement.addEventListener('click', () => this.moveGraph('l2', stockSymbols[1]));

                        lElement = document.getElementById('l3');
                        lElement.innerHTML = stockSymbols[2];
                        lElement.addEventListener('click', () => this.moveGraph('l3', stockSymbols[2]));

                        this.generateGraph(stockSymbols[0]);
                    }
                    else if (this.graphId === 'graphRight') {
                        this.currentId = 'r1';
                        var rElement = document.getElementById('r1');
                        rElement.innerHTML = stockSymbols[0];
                        rElement.addEventListener('click', () => this.moveGraph('r1', stockSymbols[0]));

                        rElement = document.getElementById('r2');
                        rElement.innerHTML = stockSymbols[1];
                        rElement.addEventListener('click', () => this.moveGraph('r2', stockSymbols[1]));

                        rElement = document.getElementById('r3');
                        rElement.innerHTML = stockSymbols[2];
                        rElement.addEventListener('click', () => this.moveGraph('r3', stockSymbols[2]));

                        this.generateGraph(stockSymbols[0]);
                    }
                });
            },
            generateGraph(symbol, pos='moveMid') {

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
                heading.classList.add(pos);
                document.getElementById(this.graphId).appendChild(heading);

                this.svg = window.d3.select(`#${this.graphId}`)
                    .append("svg")
                        .attr("viewBox", "0 0 900 400")
                        .attr("id", `${this.graphId}Svg`)
                        .attr("class", pos)
                    .append("g")
                        .attr("transform", `translate(${margin.left},${margin.top})`);

                if (this.graphId === "graphRight") {
                    window.d3.select("#graphRightSvg").attr("height", "15vw")
                }

                // Create a dataset

                var url = `/${symbol}.json`//'http://localhost:8081/api/monthly?symbol=' + graphId;

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
                });
            },

            moveGraph(id, symbol) {
                if (this.currentId < id) {

                    const currentSvgOld = document.getElementById(`${this.graphId}Svg`);
                    currentSvgOld.classList.remove('moveMid');
                    currentSvgOld.classList.add('moveLeft');

                    const currentH2Old = document.getElementById(this.graphName);
                    currentH2Old.classList.remove('moveMid');
                    currentH2Old.classList.add('moveLeft');

                    setTimeout(() => {
                        this.generateGraph(symbol, 'moveRight');
                        setTimeout(() => {
                            const currentSvgOld = document.getElementById(`${this.graphId}Svg`);
                            currentSvgOld.classList.remove('moveRight');
                            currentSvgOld.classList.add('moveMid');

                            const currentH2Old = document.getElementById(this.graphName);
                            currentH2Old.classList.remove('moveRight');
                            currentH2Old.classList.add('moveMid');
                        }, 5);
                    }, 500);
                }
                else if (this.currentId > id) {
                    const currentSvgOld = document.getElementById(`${this.graphId}Svg`);
                    currentSvgOld.classList.remove('moveMid');
                    currentSvgOld.classList.add('moveRight');

                    const currentH2Old = document.getElementById(this.graphName);
                    currentH2Old.classList.remove('moveMid');
                    currentH2Old.classList.add('moveRight');

                    setTimeout(() => {
                        this.generateGraph(symbol, 'moveLeft');
                        setTimeout(() => {
                            const currentSvgOld = document.getElementById(`${this.graphId}Svg`);
                            currentSvgOld.classList.remove('moveLeft');
                            currentSvgOld.classList.add('moveMid');

                            const currentH2Old = document.getElementById(this.graphName);
                            currentH2Old.classList.remove('moveLeft');
                            currentH2Old.classList.add('moveMid');
                        }, 10);
                    }, 500);
                }

                    document.getElementById(this.currentId).classList.remove('selected');
                    document.getElementById(id).classList.add('selected');
                    this.currentId = id;
            }
        }
    }
</script>

<style>
    @import "../../assets/css/userCSS/stockComponent.css";
</style>