<template>
    <div id="partners-section">
        <h2>A solution for Investors, Analysts and Industry Leaders</h2>
        <div class="cards">
            <div id="card1"><img src="../../assets/tesla.png" alt="Tesla Logo"></div>
            <div id="card2"><img src="../../assets/tesla.png" alt="BYD Logo"></div>
            <div id="card3"><img src="../../assets/tesla.png" alt="Cupra Logo"></div>
        </div>
    </div>
</template>

<script>

export default{
    name:'PartnersComponent'
}

</script>

<style>
@import "@/assets/variables.css";

#partners-section {
    height: 800px;
    background-color: var(--half-baked-300);    
    justify-content: center
}

h2{
    font-size: 1.5em;
    color: var(--corn-field-100);
    font-family: var(--titles);
    display: flex;
    justify-content:center;
}

.cards {
    display: flex;
    align-items: center;
    justify-content: space-around;
    flex-direction: row;
    width: 100%;
    margin-top: 50px;
}

.cards div img{
    height: 400px;
    width: 500px;
    background-color: var(--half-baked-800);
    border-radius: 50px;
}

.cards div img{
    height: 50px;
    width: 50px;
}

#card2 {
    display: flex;
    align-items: center;
    flex-direction: column;
}

</style>