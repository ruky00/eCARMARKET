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

                console.log(yesterday);

                var url = '/news.json'; //`https://newsapi.org/v2/everything?q=tesla&from=${yesterday}&sortBy=popularity&apiKey=7c72a80e39d84bb0b085084474b70b4e&language=en`;//

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