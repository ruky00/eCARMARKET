<template>
<div class="container">
    <div class="error-wrapper">
      <h1 class="error-code">404</h1>
      <p class="error-message">Oops! Page not found.</p>
     <router-link to="/"><button class="error-button" @click="goHome">Volver a Inicio</button></router-link>
    </div>
  </div>
</template>

<script>
    export default{
        name:'404Component'
    }
</script>

<style>
@import "../../assets/css/variables.css";
@import "../../assets/css/common.css";
    .container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.error-wrapper {
  text-align: center;
}

.error-code {
  font-size: 8rem;
  color: #333;
  margin: 0;
}

.error-message {
  font-size: 1.5rem;
  color: #555;
  margin: 1rem 0;
}

.error-button {
  padding: 0.5rem 1rem;
  font-size: 1rem;
  color: #fff;
  background-color: #333;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.error-button:hover {
  background-color: #555;
}
</style>