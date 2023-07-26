<template>
    <div :id="id" class="news">
        <h2>NEWS</h2>
        <div :id="new1"></div>
        <div :id="new2"></div>
        <div :id="new3"></div>
        <div :id="new4"></div>
    </div>
</template>

<script>
    export default {
        name: 'StockComponent',
        props: {
            id: {
                type: String,
                required: true,
            },
            new1: {
                type: String,
                required: true,
            },
            new2: {
                type: String,
                required: true,
            },
            new3: {
                type: String,
                required: true,
            },
            new4: {
                type: String,
                required: true,
            },
        },
        mounted() {
            this.generateNews();
            this.showSecondSection();
        },
        methods: {
            showSecondSection() {
                const queryString = window.location.search;
                if(this.id == 'secondSectionNews' && queryString != "") {
                    document.getElementById('second-section').style.display = "flex";
                    document.getElementById(this.id).style.height = "45vw";

                    const ids = [this.new1, this.new2, this.new3, this.new4];

                    for(let i=0; i<ids.length; i++) {
                        document.getElementById(ids[i]).style.height = "4vw";
                    }
                    const urlParams = new URLSearchParams(queryString);
                    const search = urlParams.get('search');
                    this.generateNews(search);
                }
            },
            async generateNews(q="tesla") {
                
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

                console.log(yesterday, q);

                var url = '/news.json'; //`https://newsapi.org/v2/everything?q=${q}&from=${yesterday}&sortBy=popularity&apiKey=7c72a80e39d84bb0b085084474b70b4e&language=en`;//

                const ids = [this.new1, this.new2, this.new3, this.new4]

                window.$.getJSON(url, function(jsonData) {
                    for (let i = 0; i < ids.length; i++) {
                        const title = jsonData['articles'][i]['title'];
                        const link = jsonData['articles'][i]['url'];
                        
                        const para = document.createElement("p");
                        para.textContent = title;
                        
                        const div = document.getElementById(ids[i]);
                        div.innerHTML = "";
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