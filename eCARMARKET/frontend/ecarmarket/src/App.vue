<template>  
    <HeaderComponent/>
     <HomeComponent/>
     <PartnersComponent/>
     <FooterComponent/>
</template>

<script>
import HeaderComponent from './components/mainPageComponent/HeaderComponent.vue'
import HomeComponent from './components/mainPageComponent/HomeComponent.vue'
import FooterComponent from './components/mainPageComponent/FooterComponent.vue'
import PartnersComponent from './components/mainPageComponent/PartnersComponent.vue'

export default {
  name: 'App',
  components: {
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    PartnersComponent
  }
};


</script>

<style>

</style>
