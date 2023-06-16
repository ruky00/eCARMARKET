<template>
    <div id="second-section">
        <h2>THE STOCK MARKET WITHIN YOUR REACH</h2>
        <div class="stocks">
            <img src="@/assets/images/stock.png" alt="" id="s1" class="not-focused" @click="changeState('s1')">
            <img src="@/assets/images/stock.png" alt="" id="s2" class="focused" @click="changeState('s2')">
            <img src="@/assets/images/stock.png" alt="" id="s3" class="not-focused" @click="changeState('s3')">
        </div>
    </div>

    <div id="secondToThird" class="spacer"></div>
</template>


<script>
    export default{
        name: 'StocksComponent',
        methods: {
            changeState(clickedId) {
                var focusedId = document.getElementsByClassName("focused")[0].id;
                document.getElementById(focusedId).classList.remove("focused");
                document.getElementById(focusedId).classList.add("not-focused");
                document.getElementById(clickedId).classList.remove("not-focused");
                document.getElementById(clickedId).classList.add("focused");
            }
        }
    }
</script>

<style>
    @import "@/assets/css/stockComponent.css";
</style>