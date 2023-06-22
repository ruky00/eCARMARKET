<template>
    <div id="second-section">
        <h2>THE STOCK MARKET WITHIN YOUR REACH</h2>
        <div class="stocks">
            <img src="@/assets/images/stock1.png" alt="" id="s1" class="not-focused left" @click="changeState('s1')">
            <img src="@/assets/images/stock2.png" alt="" id="s2" class="focused center" @click="changeState('s2')">
            <img src="@/assets/images/stock3.png" alt="" id="s3" class="not-focused right" @click="changeState('s3')">
        </div>
    </div>

    <div id="secondToThird" class="spacer"></div>
</template>


<script>
    export default{
        name: 'StocksComponent',
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
            }
        }
    }
</script>

<style>
    @import "@/assets/css/mainPageCSS/stockComponent.css";
</style>