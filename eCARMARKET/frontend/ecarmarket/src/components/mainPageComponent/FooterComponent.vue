<template>
      <footer>
        <h2>A solution for Investors, Analysts and Industry Leaders</h2>
        <button type="button" onclick="location.href='/register'">Try it now</button>
        <button type="button" onclick="location.href='/register'" id="button-arrow"><img src="../../assets/arrow.png" alt=""></button>

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
@import "@/assets/variables.css";

footer {
    height: 800px;
    background-color: var(--half-baked-950);
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    color: var(--corn-field-100);
}

footer h2 {
    font-family: var(--titles);
}

footer button {
    font-size: 1.5em;
    color: var(--corn-field-100);
    background-color: var(--half-baked-900);
    border: none;
    padding: 10px 60px 10px 25px;
    border-radius: 50px;
}

footer #button-arrow {
    left: 65px;
    bottom: 37px;
}

footer #button-arrow img {
    height: 20px;
}

.cards {
    display: flex;
    align-items: center;
    justify-content: space-around;
    flex-direction: row;
    width: 100%;
    margin-top: 50px;
}

.cards div {
    height: 400px;
    width: 500px;
    background-color: var(--half-baked-800);
    border-radius: 50px;
}

#card2 {
    display: flex;
    align-items: center;
    flex-direction: column;
}


</style>