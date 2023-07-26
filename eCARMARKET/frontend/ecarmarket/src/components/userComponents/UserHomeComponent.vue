<template>
    <HeaderComponent headerId="userHome"/>
    <div class="first-section">
        <div class="left">
            <StockComponent graphId="graphLeft" graphName="graphLeftName" button1="l1" button2="l2" button3="l3"/>
        </div>
        <div class="right">
            <div class="right1">
                <NewsComponent id="firstSectionNews" new1="firstSNew1" new2="firstSNew2" new3="firstSNew3" new4="firstSNew4"/>
            </div>
            <div class="right2">
                <StockComponent graphId="graphRight" graphName="graphRightName" button1="r1" button2="r2" button3="r3"/>
            </div>
        </div>
    </div>    
    <div id="second-section" class="second-section">
        <div class="left">
            <SingleStockComponent graphId="singleGraph" graphName="singleGraphName"/>
        </div>
        <div class="right">
            <NewsComponent id="secondSectionNews" new1="secondSNew1" new2="secondSNew2" new3="secondSNew3" new4="secondSNew4"/>
        </div>
    </div>
    <FooterComponent/>
</template>

<script>
    import HeaderComponent from '../mainPageComponent/HeaderComponent.vue';
    import StockComponent from './StockComponent.vue';
    import NewsComponent from './NewsComponent.vue';
    import SingleStockComponent from './SingleStockComponent.vue';
    import FooterComponent from '../mainPageComponent/FooterComponent.vue';

    export default {
        name: 'UserHomeComponent',
        components:{
    HeaderComponent,
    StockComponent,
    NewsComponent,
    SingleStockComponent,
    FooterComponent
},
        methods: {
        }
    }
</script>

<style>
@import "../../assets/css/variables.css";
@import "../../assets/css/common.css";
    @import "../../assets/css/userCSS/userHomeComponent.css";
</style>