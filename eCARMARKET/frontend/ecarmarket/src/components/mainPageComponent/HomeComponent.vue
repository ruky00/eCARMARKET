<template>
    <div id="first-section">
        <div class="intro">
            <h1>A solution for Investors, Analysts and Industry Leaders</h1>
            <button type="button" onclick="location.href='/register'">Start Here</button>
            <button type="button" onclick="location.href='/register'" id="button-arrow"><img src="../../assets/arrow.png" alt=""></button>
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
@import "@/assets/variables.css";
#first-section {
    height: 500px;
    background-color: var(--half-baked-600);
    display: flex;
}

.intro {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    color: var(--corn-field-100);
}

.intro h1 {
    width: 50%;
    font-family: var(--titles);
    font-size: 4em;
    text-align: center;
}

.intro button {
    font-size: 2.5em;
    color: var(--corn-field-100);
    background-color: var(--half-baked-900);
    border: none;
    padding: 10px 60px 10px 25px;
    border-radius: 50px;
}

.intro button:hover {
    cursor: pointer;
}

#button-arrow {
    background-color: var(--half-baked-900);
    border: none;
    position: relative;
    left: 100px;
    bottom: 53px;
    width: 30px;
    padding: 0px;
}

#button-arrow:hover {
    cursor: pointer;
}

#button-arrow img {
    height: 30px;
}

#button-arrow img:hover {
    cursor: pointer;
}
.spacer {
    aspect-ratio: 900/200;
    width: 100%;
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
}

#firstToSecond {
    background-image: url("../../assets/waves/firstToSecondSection.svg");
}
</style>