<template>
    <HeaderComponent></HeaderComponent>
    <div class="first-section">
        <div class="left">
            <StockComponent></StockComponent>
        </div>
        <div class="right">
            <div class="right1">
                <NewsComponent></NewsComponent>
            </div>
            <div class="right2">

            </div>
        </div>

    </div>    
    <FooterComponent></FooterComponent>
</template>

<script>
    import HeaderComponent from '../mainPageComponent/HeaderComponent.vue';
    import StockComponent from './StockComponent.vue';
    import NewsComponent from './NewsComponent.vue';
    import FooterComponent from '../mainPageComponent/FooterComponent.vue';

    export default {
        name: 'UserHomeComponent',
        components:{
            HeaderComponent,
            StockComponent,
            NewsComponent,
            FooterComponent,
        },
        methods: {
        }
    }
</script>

<style>
    @import "../../assets/css/userCSS/userHomeComponent.css";
</style>