<template>
    <div id="first-section">
        <div class="intro">
            <h1>A solution for Investors, Analysts and Industry Leaders</h1>
            <button type="button" onclick="location.href='/register'">Start Here</button>
            <button type="button" onclick="location.href='/register'" id="button-arrow"><img src="../../assets/images/arrow.png" alt=""></button>
        </div>
    </div>
    <div id="firstToSecond" class="spacer"></div>
</template>


<script>
    export default{
        name: 'HomeComponent'
    }
</script>

<style>
@import "@/assets/css/homeComponent.css";
</style>