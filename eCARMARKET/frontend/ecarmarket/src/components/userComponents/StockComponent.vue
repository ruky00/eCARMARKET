<template>
    <div class="stock">
        <div class="buttons">
            <button type="button">1</button>
            <button type="button">2</button>
            <button type="button">3</button>
        </div>
        <div class="graph" id="graph">
            <h2 id="graphName"></h2>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'StockComponent',
        mounted() {
            const script = document.createElement('script');
            script.src = 'https://d3js.org/d3.v7.min.js';
            script.async = true;
            script.onload = () => {
                this.generateGraph("graph");
            };
            document.head.appendChild(script);
        },
        methods: {
            async generateGraph(graphId) {
                // Set dimensions and margins for the chart

                const margin = { top: 10, right: 0, bottom: 40, left: 40 };

                const width = 950 - margin.left - margin.right;
                const height = 400 - margin.top - margin.bottom;

                // Set uo the x and y scales

                const x = window.d3.scaleTime()
                    .range([0, width]);

                const y = window.d3.scaleLinear()
                    .range([height, 0]);

                // Create the SVG element and append it to the chart container

                const svg = window.d3.select(`#${graphId}`)
                    .append("svg")
                        .attr("viewBox", "0 0 900 400")
                    .append("g")
                        .attr("transform", `translate(${margin.left},${margin.top})`);

                // Create a dataset

                var url = '/s1.json'//'http://localhost:8081/api/monthly?symbol=' + graphId;

                window.$.getJSON(url, function(jsonData) {
                    const dataset = [];

                    Object.keys(jsonData["Time Series (Daily)"]).forEach(key => {
                        dataset.push({ date: new Date(key), value: jsonData["Time Series (Daily)"][key]["4. close"]})
                    });
                    document.getElementById(`${graphId}Name`).innerHTML = jsonData["Meta Data"]["2. Symbol"];

                    /* Object.keys(jsonData["Monthly Time Series"]).forEach(key => {
                        dataset.push({ date: new Date(key), value: jsonData["Monthly Time Series"][key]["4. close"]})
                    });
                    document.getElementById(`${graphId}Name`).innerHTML = jsonData["Meta Data"]["2. Symbol"]; */

                    // Define the x and y domains

                    x.domain(window.d3.extent(dataset, d => d.date));
                    y.domain([window.d3.min(dataset, d => d.value) - 3, window.d3.max(dataset, d => d.value)]);

                    // Add the x-axis

                    svg.append("g")
                        .attr("transform", `translate(0,${height})`)
                        .call(window.d3.axisBottom(x))
                        .attr("stroke-width", 4);

                    // Add the y-axis

                    svg.append("g")
                        .call(window.d3.axisLeft(y))
                        .attr("stroke-width", 4)

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
                });
            },
        }
    }
</script>

<style>
    @import "../../assets/css/userCSS/stockComponent.css";
</style>