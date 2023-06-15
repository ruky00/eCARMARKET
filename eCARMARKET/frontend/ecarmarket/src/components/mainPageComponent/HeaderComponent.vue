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
@import '@/assets/css/headerComponent.css';
</style>