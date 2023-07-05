<template>
    <div class="news">
        <h2>NEWS</h2>
        <div id="new1"></div>
        <div id="new2"></div>
        <div id="new3"></div>
        <div id="new4"></div>
    </div>
</template>

<script>
    export default {
        name: 'StockComponent',
        mounted() {
            this.generateNews()
        },
        methods: {
            async generateNews() {
                var url = '/news.json';

                window.$.getJSON(url, function(jsonData) {
                    for (let i = 0; i < 4; i++) {
                        const title = jsonData['articles'][i]['title'];
                        const link = jsonData['articles'][i]['url'];
                        
                        const para = document.createElement("p");
                        para.textContent = title;
                        
                        const div = document.getElementById(`new${i+1}`);
                        div.appendChild(para);
                        div.addEventListener('click', () => {
                            window.open(link, '_blank');
                        });
                    }
                });
            }
        }
    }
</script>

<style>
    @import "../../assets/css/userCSS/newsComponent.css";
</style>