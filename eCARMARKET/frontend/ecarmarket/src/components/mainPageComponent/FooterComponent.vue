<template>
      <footer>
        <img src="../../assets/images/logo_yellow.png" alt="" class="logo">
        <div class="footer-middel">
            <div class="left">
                <h2>A solution for Investors, Analysts and Industry Leaders</h2>
                <div class="try-button">
                    <button type="button" onclick="location.href='/register'">Try it now</button>
                    <button type="button" onclick="location.href='/register'" id="button-arrow"><img src="../../assets/images/arrow.png" alt=""></button>
                </div>
            </div>
            <div class="right">
                <div class="us">
                    <h3>FOLLOW US</h3>
                    <div class="socials">
                        <a href="/"><img src="../../assets/images/linkedin.png" alt="" title="Carlos Fernández López"></a>
                        <a href="/"><img src="../../assets/images/linkedin.png" alt="" title="Álvaro Ibáñez Coedo"></a>
                        <a href="https://es.linkedin.com/in/miguel-angel-contreras-cordoba-58441a223"><img src="../../assets/images/linkedin.png" alt="" title="Miguel Ángel Contreras Córdoba"></a>
                    </div>
                </div>
                <div class="call">
                    <h3>CONTACT US</h3>
                    <h4>example@ecarmarket.es</h4>
                    <h4>+34 665 32 31 23</h4>
                </div>
            </div>
        </div>
        <hr>
        <p>&copy; Website created by Carlos Fernández López, Álvaro Ibáñez Coedo y Miguel Ángel Contreras Córdoba</p>
    </footer>
</template>

<script>

export default{
    name:'FooterComponent'
}

</script>

<style>
@import '@/assets/css/mainPageCSS/footerComponent.css';
</style>