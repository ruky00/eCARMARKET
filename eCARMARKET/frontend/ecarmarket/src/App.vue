<template>  
    <HeaderComponent/>
    <HomeComponent/>
    <StocksComponent/>
    <PartnersComponent/>
    <FooterComponent/>
</template>

<script>
import HeaderComponent from './components/mainPageComponent/HeaderComponent.vue'
import HomeComponent from './components/mainPageComponent/HomeComponent.vue'
import StocksComponent from './components/mainPageComponent/StocksComponent.vue'
import FooterComponent from './components/mainPageComponent/FooterComponent.vue'
import PartnersComponent from './components/mainPageComponent/PartnersComponent.vue'

export default {
  name: 'App',
  components: {
    HeaderComponent,
    HomeComponent,
    StocksComponent,
    FooterComponent,
    PartnersComponent
  }
};


</script>

<style>
@import "./assets/css/variables.css";
@import "./assets/css/common.css";
@import "./assets/css/waves.css";
</style>
