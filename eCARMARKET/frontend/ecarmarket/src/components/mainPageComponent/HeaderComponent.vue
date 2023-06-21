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
                <div class="burger" id="burger">
                    <button class="burger-button" @click="showSidePanel">
                        <img src="../../assets/images/burger.png" alt="">
                    </button>
                </div>
                <div class="user">
                    <a href="/login"><img class="logo" src="../../assets/images/user.png" alt="User"></a>
                </div>
            </nav>
    </header>
        <div class="side-panel" id="side-panel">
            <div class="close-side">
                <button class="close-side" @click="hideSidePanel"><img src="../../assets/images/close.png" alt=""></button>
            </div>
            <div class="links-side">
                <a href="/">Link 1</a>
                <a href="/">Link 2</a>
                <a href="/">Link 3</a>
                <a href="/">Link 4</a>
            </div>
            <div class="user-side">
                <a href="/login"><img class="logo" src="../../assets/images/user.png" alt="User"></a>
            </div>
        </div>
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
        window.addEventListener('scroll', this.hideSidePanel);
        window.addEventListener('load', this.hideSidePanel);
        window.addEventListener('load', this.changeVisibility);
    },
    methods: {
        headerScroll() {
            if (window.pageYOffset > 5)
                document.getElementById('sticky-header').classList.add("header-color");

            else
                document.getElementById('sticky-header').classList.remove("header-color");
        },
        hideSidePanel() {
            var elementWidth = document.getElementById('side-panel').clientWidth;
            var windowWidth = window.innerWidth;
            var totalOffset = elementWidth + windowWidth;
            document.getElementById('side-panel').style.transition = "transform 1s ease";
            requestAnimationFrame(() => {
                document.getElementById('side-panel').style.transform = "translateX(" + totalOffset + "px)";
            });
        },
        showSidePanel () {
            var elementWidth = document.getElementById('side-panel').clientWidth;
            var windowWidth = window.innerWidth;
            var totalOffset = windowWidth - elementWidth;
            document.getElementById('side-panel').style.transition = "transform 1s ease";
            requestAnimationFrame(() => {
                document.getElementById('side-panel').style.transform = "translateX(" + totalOffset + "px)";
            });
        },
        changeVisibility () {
            document.getElementById('side-panel').style.transition = "visibility 0s ease 2s";
            document.getElementById('side-panel').style.visibility = "visible";
        }
    }
}

</script>

<style>
@import '@/assets/css/mainPageCSS/headerComponent.css';
</style>