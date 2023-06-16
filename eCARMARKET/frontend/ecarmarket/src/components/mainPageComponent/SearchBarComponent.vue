<template>
     <form action="/search" class="search-bar">
            <button type="submit" class="search-icon"><img src="../../assets/images/search.png" alt=""></button>
            <input type="text" name="search" id="search" placeholder="Search...">
        </form>
</template>

<script>

export default{
    name: 'SearchBarComponent',
}

</script>

<style>
@import '../../assets/css/searchbarComponent.css';
</style>