<template>

    <header>
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
}
}

</script>

<style>
@import '@/assets/css/headerComponent.css';
</style>