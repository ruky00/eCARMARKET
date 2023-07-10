<template>
	<div class="cont">
		<div class="form sign-in">
			<Form @submit="handleLogin" :validation-schema="schema">
				<h2>Sign In</h2>
				<label>
					<span>Email Address</span>
					<Field type="email" name="username" />
				</label>
				<label>
					<span>Password</span>
					<Field type="password" name="password" />
					<ErrorMessage name="password" class="error-feedback" />
				</label>
				<button class="submit" type="submit">Sign In</button>
			</Form>
			<p class="forgot-pass">Forgot Password ?</p>
			<router-link to="/" style="text-decoration: none;">
				<p class="forgot-pass">Go back home</p>
			</router-link>
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
				<button class="submit" type="submit">Sign Up Now</button>
			</div>
		</div>
	</div>
</template>
  
<script>
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";
export default {
	name: 'LoginComponent',
	components: {
		Form,
		Field,
		ErrorMessage,
	},
	data() {
		const schema = yup.object().shape({
			username: yup.string().required("Username is required!"),
			password: yup.string().required("Password is required!"),
		});
		return {
			loading: false,
			schema,
		};
	},
	computed: {
		loggedIn() {
			return this.$store.state.status.loggedIn;
		},
	},
	created() {
		if (this.loggedIn) {
			this.$router.push("/form");
		}
	},
	methods: {
		handleLogin(user) {
			this.loading = true;
			
			this.$store.dispatch("login", user).then(
				() => {
					(this.$store.dispatch("getPersonal",user).then(
						response=>{
							console.log(response)
							if(response != null){
								this.$router.push("/home");
							}else{
								this.$router.push('/profile')
							}
						}

					))
				},
				(error) => {
					this.loading = false;
					this.message =
						(error.response &&
							error.response.data &&
							error.response.data.message) ||
						error.message ||
						error.toString();
				}
			);
		},
	},
	mounted() {
		// Lógica adicional al montar el componente
		document.querySelector('.img-btn').addEventListener('click', this.toggleSignup);
	},
}
</script>
  
<style>
@import "../../assets/css/variables.css";
@import "../../assets/css/common.css";
@import '../../assets/css/authCSS/login.css';
</style>
  