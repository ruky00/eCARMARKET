<template>  
    <HeaderComponent headerId="mainPage"/>
    <HomeComponent/>
    <StocksComponent/>
    <PartnersComponent/>
    <FooterComponent/>
</template>

<script>
import HeaderComponent from "./HeaderComponent.vue"
import HomeComponent from "./HomeComponent.vue";
import StocksComponent from "./StocksComponent.vue";
import FooterComponent from "./FooterComponent.vue";
import PartnersComponent from "./PartnersComponent.vue";


export default {
  name: 'MainPage',
  components: {
    HeaderComponent,
    HomeComponent,
    StocksComponent,
    FooterComponent,
    PartnersComponent,
  }
};


</script>

<style>
@import "../../assets/css/mainPageCSS/waves.css";
</style>
