<template>
  <div class="cont">
    <div class="form sign-in">
      <h2>Sign In</h2>
      <label>
        <span>Email Address</span>
        <input type="email" name="email">
      </label>
      <label>
        <span>Password</span>
        <input type="password" name="password">
      </label>
      <button class="submit" type="button">Sign In</button>
      <p class="forgot-pass">Forgot Password ?</p>
    <router-link to="/" style="text-decoration: none;"><p class="forgot-pass">Go back home</p></router-link> 
    </div>

    <div class="sub-cont">
      <div class="img">
        <div class="img-text m-up">
          <h2>New here?</h2>
          <p>Sign up and discover great amount of new opportunities!</p>
        </div>
        <div class="img-text m-in">
          <h2>One of us?</h2>
          <p>If you already has an account, just sign in.</p>
        </div>
        <div class="img-btn">
          <span class="m-up">Sign Up</span>
          <span class="m-in">Sign In</span>
        </div>
      </div>
      <div class="form sign-up">
        <h2>Sign Up</h2>
        <label>
          <span>Name</span>
          <input type="text">
        </label>
        <label>
          <span>Email</span>
          <input type="email">
        </label>
        <label>
          <span>Password</span>
          <input type="password">
        </label>
        <label>
          <span>Confirm Password</span>
          <input type="password">
        </label>
        <button type="button" class="submit">Sign Up Now</button>
      </div>
    </div>
  </div>
  </template>
  
  <script>
    export default{
        name:'LoginComponent',
        methods: {
    // Métodos del componente
    toggleSignup() {
      document.querySelector('.cont').classList.toggle('s-signup');
    },
  },
  mounted() {
    // Lógica adicional al montar el componente
    document.querySelector('.img-btn').addEventListener('click', this.toggleSignup);
  },
    }
  </script>
  
  <style>
    @import '../../assets/css/login.css';
  </style>
  