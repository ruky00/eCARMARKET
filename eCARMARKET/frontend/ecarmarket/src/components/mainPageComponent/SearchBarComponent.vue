<template>
    <form action="/search" class="search-bar">
        <input type="text" name="search" id="search" placeholder="Search...">
        <button type="submit" class="search-icon"><img src="../../assets/images/search.png" alt=""></button>
    </form>
</template>

<script>

export default{
    name: 'SearchBarComponent',
    methods: {
        searchBarShow() {
            document.getElementById("outside-button").style.display = "none";
            document.getElementById("search-bar-small").style.display = "flex";
        }
    }
}

</script>

<style>
@import '../../assets/css/mainPageCSS/searchbarComponent.css';
</style>