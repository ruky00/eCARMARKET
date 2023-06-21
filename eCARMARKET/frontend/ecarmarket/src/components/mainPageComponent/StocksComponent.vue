<template>
    <div id="second-section">
        <h2>THE STOCK MARKET WITHIN YOUR REACH</h2>
        <div class="stocks">
            <img src="@/assets/images/stock1.png" alt="" id="s1" class="not-focused" @click="changeState('s1')">
            <img src="@/assets/images/stock2.png" alt="" id="s2" class="focused" @click="changeState('s2')">
            <img src="@/assets/images/stock3.png" alt="" id="s3" class="not-focused" @click="changeState('s3')">
        </div>
    </div>

    <div id="secondToThird" class="spacer"></div>
</template>


<script>
    export default{
        name: 'StocksComponent',
        methods: {
            changeState(clickedId) {
                var clickedImg = document.getElementById(clickedId).src;
                var centerImg = document.getElementById('s2').src;
                document.getElementById(clickedId).src = centerImg;
                document.getElementById('s2').src = clickedImg;
            }
        }
    }
</script>

<style>
    @import "@/assets/css/mainPageCSS/stockComponent.css";
</style>