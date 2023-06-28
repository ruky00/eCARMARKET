<template>
    <div id="second-section">
        <h2>THE STOCK MARKET WITHIN YOUR REACH</h2>
        <div class="stocks">
            <div alt="" id="s1" class="not-focused left" @click="changeState('s1')">
                <h2 id="s1Name"></h2>
            </div>
            <div alt="" id="s2" class="focused center" @click="changeState('s2')">
                <h2 id="s2Name"></h2>
            </div>
            <div alt="" id="s3" class="not-focused right" @click="changeState('s3')">
                <h2 id="s3Name"></h2>
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
                this.generateGraph("s1");
                this.generateGraph("s2");
                this.generateGraph("s3");
            };
            document.head.appendChild(script);

            window.addEventListener('resize', this.updateSvgSize);
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
                
                async function fetchData() {
                    const response = await fetch('/s1.json');
                    const json = await response.json();
                    return json;
                }

                var jsonData = await fetchData();

                const dataset = [];

                Object.keys(jsonData["Time Series (Daily)"]).forEach(key => {
                    dataset.push({ date: new Date(key), value: jsonData["Time Series (Daily)"][key]["4. close"]})
                });

                document.getElementById(`${graphId}Name`).innerHTML = jsonData["Meta Data"]["2. Symbol"];

                // Define the x and y domains

                x.domain(window.d3.extent(dataset, d => d.date));
                y.domain([window.d3.min(dataset, d => d.value) - 3, window.d3.max(dataset, d => d.value)]);

                // Add the x-axis

                svg.append("g")
                    .attr("transform", `translate(0,${height})`)
                    .call(window.d3.axisBottom(x)
                        .ticks(window.d3.timeMonth.every(1))
                        .tickFormat(window.d3.timeFormat("%b %Y")))

                // Add the y-axis

                svg.append("g")
                    .call(window.d3.axisLeft(y))

                // Create the line generator

                const line = window.d3.line()
                    .x(d => x(d.date))
                    .y(d => y(d.value));

                // Add the line path to the SVG element

                svg.append("path")
                    .datum(dataset)
                    .attr("fill", "none")
                    .attr("stroke", "steelblue")
                    .attr("stroke-width", 1)
                    .attr("d", line)
            },
        }
    }
</script>

<style>
    @import "@/assets/css/mainPageCSS/stockComponent.css";
</style>