<template>
    <div id="partners-section">
        <h2>PARTNER COMPANIES</h2>
        <div class="images">
            <img src="../../assets/tesla.png" alt="Tesla Logo">
            <img src="../../assets/byd1.png" alt="BYD Logo" style="height: 200px;">
            <img src="../../assets/cupra.png" alt="Cupra Logo" style="height: 300px;">
            
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
    height: 10%;
    background-color: var(--half-baked-300);    
    justify-content: center
}

h2{
    font-size: 2.5em;
    color: var(--corn-field-100);
    font-family: var(--titles);
    display: flex;
    justify-content:center;
}

.images{
    width: 100%;
    display:flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
}
.images img{
    width: 400px;
    height: 400px;
}
</style>