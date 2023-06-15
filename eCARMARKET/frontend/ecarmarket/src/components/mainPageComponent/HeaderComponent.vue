<template>

    <header>
        <a href="/"><img class="logo" src="../../assets/logo.jpg" alt="Logo"></a>
            <nav>
                <div class="links">
                    <a href="/">Link 1</a>
                    <a href="/">Link 2</a>
                    <a href="/">Link 3</a>
                    <a href="/">Link 4</a>
                </div>
                <div class="user">
                    <a href="/login"><img class="logo" src="../../assets/user.png" alt="User"></a>
                </div>
            </nav>
    </header>
</template>

<script>

export default{
    name: 'HeaderComponent'
}

</script>

<style>
@import "@/assets/variables.css";
header{
    height: 70px;
    background-color: var(--half-baked-600);
    display: flex;
    padding: 20px 20px 0px 20px;
    justify-content: space-between;
    position: sticky;

}

nav {
    display: flex;
    justify-content: space-around;
    align-items: center;
    width: 700px;
}
a {
    text-decoration: none;
    color: black;
    font-size: xx-large;
}

a:hover {
    color: #444;
}

.logo {
    height: 80px;
}

.links {
    display: flex;
    gap: 30px
}

</style>