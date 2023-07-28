<template>
	<div class="container">
        <h1>Please confirm your email to continue</h1>
    </div>
</template>
  
<script>
    export default{
        name:'ConfirmEmailComponent',
    }
</script>
  
<style>
	@import "../../assets/css/variables.css";
	@import "../../assets/css/common.css";

    html, body{
        width: 100%;
        height: 100%;
        font-family: var(--text);
        color: var(--corn-field-100);
        font-weight: bold;
        font-size: 1vw;
    }

    #app {
        width: 100%;
        height: 100%;
    }

    .container {
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
</style>
  