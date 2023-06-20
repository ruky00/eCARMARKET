<template>

    <header id="sticky-header" @scroll="headerScroll">
        <a href="/"><img class="logo" src="../../assets/images/logo.jpg" alt="Logo"></a>
        <SearchBarComponent/>
            <nav>
                <div class="links">
                    <a href="/">Link 1</a>
                    <a href="/">Link 2</a>
                    <a href="/">Link 3</a>
                    <a href="/">Link 4</a>
                </div>
                <div class="user">
                    <a href="/login"><img class="logo" src="../../assets/images/user.png" alt="User"></a>
                </div>
            </nav>
    </header>
</template>

<script>
import SearchBarComponent from './SearchBarComponent.vue';

export default{
    name: 'HeaderComponent',
    components:{
        SearchBarComponent,
    },
    mounted () {
        window.addEventListener('scroll', this.headerScroll);
    },
    methods: {
        headerScroll() {
            if (window.pageYOffset > 5)
                document.getElementById('sticky-header').classList.add("header-color");

            else
                document.getElementById('sticky-header').classList.remove("header-color");
        }
    }
}

</script>

<style>
@import '@/assets/css/mainPageCSS/headerComponent.css';
</style>