<template>

    <header :id="headerId" @scroll="headerScroll">
        <a href="/"><img class="logo" src="../../assets/images/logo_yellow.png" alt="Logo"></a>
        <SearchBarComponent/>
            <nav>
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
    props: {
        headerId: {
            type: String,
            required: true,
        },
    },
    mounted () {
        window.addEventListener('scroll', this.headerScroll);
        window.addEventListener('scroll', this.hideSidePanel);
        window.addEventListener('load', this.hideSidePanel);
        window.addEventListener('load', this.changeVisibility);

        this.showSearchBar();
    },
    methods: {
        showSearchBar() {
            if (this.headerId == 'mainPage'){
                const header = document.getElementById(this.headerId);
                const form = header.getElementsByTagName('form')[0];
                form.style.display = 'none';
            }
        },
        headerScroll() {
            var tag = "header-color"
            try {
                if (window.pageYOffset > 5)
                    document.getElementById(this.headerId).classList.add(tag);

                else
                    document.getElementById(this.headerId).classList.remove(tag);
            }
            catch (e){
                console.log(e);
            }
        },
        hideSidePanel() {
            try {
                var elementWidth = document.getElementById('side-panel').clientWidth;
                var windowWidth = window.innerWidth;
                var totalOffset = elementWidth + windowWidth;
                document.getElementById('side-panel').style.transition = "transform 1s ease";
                requestAnimationFrame(() => {
                    document.getElementById('side-panel').style.transform = "translateX(" + totalOffset + "px)";
                });
            }
            catch {
                elementWidth = 0;
            }
        },
        showSidePanel () {
            try {
                var elementWidth = document.getElementById('side-panel').clientWidth;
                var windowWidth = window.innerWidth;
                var totalOffset = windowWidth - elementWidth;
                document.getElementById('side-panel').style.transition = "transform 1s ease";
                requestAnimationFrame(() => {
                    document.getElementById('side-panel').style.transform = "translateX(" + totalOffset + "px)";
                });
            }
            catch {
                elementWidth = 0;
            }
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