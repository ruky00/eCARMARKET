<template>
     <form action="/search" class="search-bar">
            <input type="text" name="search" id="search" placeholder="Search...">
            <button type="submit" class="search-icon"><img src="../../assets/search.png" alt=""></button>
        </form>
</template>

<script>

export default{
    name: 'SearchBarComponent',
   
}

</script>

<style>
.search-bar {
    display: flex;
    justify-content: center;
    align-items: center;
}

#search {
    height: 40px;
    width: 50%;
    border-radius: 30px;
    border: none;
    background-color: rgb(255, 255, 255, 0.5);
    transition: 0.5s;
    padding: 10px 70px 10px 25px;
    font-size: 20px;
} 

#search:focus {
    background-color: white;
    outline: none;
}

.search-icon {
    background-color: transparent;
    border: none;
}

.search-icon:hover {
    cursor: pointer;
}

.search-icon img {
    height: 30px;
    position: relative;
    right: 60px;
    top: 1px
}
</style>