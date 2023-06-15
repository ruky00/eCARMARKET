<template>
      <footer>
        <h2>A solution for Investors, Analysts and Industry Leaders</h2>
        <button type="button" onclick="location.href='/register'">Try it now</button>
        <button type="button" onclick="location.href='/register'" id="button-arrow"><img src="../../assets/images/arrow.png" alt=""></button>

        <div class="cards">
            <div id="card1"></div>
            <div id="card2">
                <h2>Contact Us</h2>
                <p>example@ecarmarket.es</p>
                <p>+34 625 19 25 83</p>
            </div>
            <div id="card3"></div>
        </div>
    </footer>
</template>

<script>

export default{
    name:'FooterComponent'
}

</script>

<style>
@import '@/assets/css/footerComponent.css';
</style>