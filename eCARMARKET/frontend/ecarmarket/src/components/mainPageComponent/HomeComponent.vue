<template>
    <div id="first-section">
        <div class="intro">
            <h1>A solution for Investors, Analysts and Industry Leaders</h1>
            <div class="start-here">
              <router-link to="/login"><button type="button">Start Here</button></router-link> 
                <button type="button" onclick="location.href='/register'" id="button-arrow"><img src="../../assets/images/arrow.png" alt=""></button>
            </div>
        </div>
    </div>
    <div id="firstToSecond" class="spacer"></div>
</template>


<script>
    export default{
        name: 'HomeComponent',
        mounted () {
        window.addEventListener('resize', this.adaptSpacer);
        window.addEventListener('load', this.positionSpacer);
        },
        methods: {
            adaptSpacer() {
                var elementHeight = document.getElementById('firstToSecond').clientHeight;
                var topOffset = 1000 - elementHeight;
                document.getElementById('firstToSecond').style.top = topOffset.toString() + "px"
            },
            positionSpacer() {
                var elementHeight = document.getElementById('firstToSecond').clientHeight;
                var topOffset = 1000 - elementHeight;
                document.getElementById('firstToSecond').style.top = topOffset.toString() + "px"
            }
        }
    }
</script>

<style>
@import "@/assets/css/mainPageCSS/homeComponent.css";
</style>