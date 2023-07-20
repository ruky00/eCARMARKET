<template>
    <div id="second-section">
        <h2>THE STOCK MARKET WITHIN YOUR REACH</h2>
        <div class="stocks">
            <div alt="" id="TSLA" class="not-focused left" @click="changeState('TSLA')">
                <h2 id="TSLAName"></h2>
            </div>
            <div alt="" id="FORD" class="focused center" @click="changeState('FORD')">
                <h2 id="FORDName"></h2>
            </div>
            <div alt="" id="VLVOF" class="not-focused right" @click="changeState('VLVOF')">
                <h2 id="VLVOFName"></h2>
            </div>
        </div>
    </div>

    <div id="secondToThird" class="spacer"></div>
</template>


<script>
    export default{
        name: 'StocksComponent',
        mounted() {
            const script = document.createElement('script');
            script.src = 'https://d3js.org/d3.v7.min.js';
            script.async = true;
            script.onload = () => {
                this.generateGraph("TSLA");
                this.generateGraph("FORD");
                this.generateGraph("VLVOF");
            };
            document.head.appendChild(script);
        },
        methods: {
            changeState(clickedId) {
                var centerId = document.getElementsByClassName('focused')[0].id;
                var clickedClass = document.getElementById(clickedId).classList[1];

                if(centerId !== clickedId) {
                    document.getElementById(clickedId).classList.remove('not-focused');
                    document.getElementById(clickedId).classList.remove(clickedClass);
                    document.getElementById(clickedId).classList.add('focused');
                    document.getElementById(clickedId).classList.add('center');

                    document.getElementById(centerId).classList.remove('focused');
                    document.getElementById(centerId).classList.remove('center');
                    document.getElementById(centerId).classList.add('not-focused');
                    document.getElementById(centerId).classList.add(clickedClass);
                }
            },

            async generateGraph(graphId) {
                // Set dimensions and margins for the chart

                const margin = { top: 10, right: 0, bottom: 40, left: 0 };

                const width = 900 - margin.left - margin.right;
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
                        .attr("width", width + margin.left + margin.right)
                        .attr("height", height + margin.top + margin.bottom)
                    .append("g")
                        .attr("transform", `translate(${margin.left},${margin.top})`);

                // Create a dataset

                var url = `/${graphId}.json`//'http://localhost:8081/api/monthly?symbol=' + graphId;

                window.$.getJSON(url, function(jsonData) {
                    const dataset = [];

                    const data = jsonData["Monthly Time Series"];

                    Object.keys(data).forEach(key => {
                        dataset.push({ date: new Date(key), value: data[key]["4. close"]})
                    });
                    document.getElementById(`${graphId}Name`).innerHTML = jsonData["Meta Data"]["2. Symbol"];

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
    @import "@/assets/css/mainPageCSS/stocksComponent.css";
</style>