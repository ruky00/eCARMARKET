<template>
    <HeaderComponent></HeaderComponent>
    <div class="info">
        <form action="" class="info-form">
            <div class="username">
                <img src="../../assets/images/user.png" alt="User">
                <input type="text" name="username" id="username" placeholder="Username">
            </div>
            <div class="email">
                <input type="email" name="email" id="email" placeholder="Email">
            </div>
            <div class="password">
                <input type="password" name="oldPassword" id="oldPassword" placeholder="Old Password">
                <input type="password" name="newPassword" id="newPassword" placeholder="New Password">
            </div>
            <ProfileFormComponent></ProfileFormComponent>
            <div class="buttons">
                <input id="save" type="submit" value="Save">
                <input id="clear" type="button" value="Clear" @click="clearForm()">
            </div>
        </form>
    </div>
    <FooterComponent></FooterComponent>
</template>

<script>
    import HeaderComponent from '../mainPageComponent/HeaderComponent.vue';
    import ProfileFormComponent from './ProfileFormComponent.vue';
    import FooterComponent from '../mainPageComponent/FooterComponent.vue';

    export default {
        name: 'UserProfileComponent',
        components:{
            HeaderComponent,
            ProfileFormComponent,
            FooterComponent,
        },
        methods: {
            clearForm() {
                document.getElementById("username").value = "";
                document.getElementById("email").value = "";
                document.getElementById("oldPassword").value = "";
                document.getElementById("newPassword").value = "";
            },
        }
    }
</script>

<style>
@import "../../assets/css/variables.css";
@import "../../assets/css/common.css";
    @import "../../assets/css/userCSS/userProfileComponent.css";
</style>