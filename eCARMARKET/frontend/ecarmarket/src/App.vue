<template>  
    <HeaderComponent/>
     <HomeComponent/>
</template>

<script>
import HeaderComponent from './components/mainPageComponent/HeaderComponent.vue'
import HomeComponent from './components/mainPageComponent/HomeComponent.vue'

export default {
  name: 'App',
  components: {
    HeaderComponent,
    HomeComponent
  }
};


</script>

<style>
#app {
  display: block;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align:center;
  color: #2c6e50;
}

</style>
