<template>
	<div class="cont">
		<div class="form sign-in">
			<form @submit="submitLogin">
				<h2>Sign In</h2>
				<label>
					<span>Email Address</span>
					<input type="email" v-model="username" required>
				</label>
				<label>
					<span>Password</span>
					<input type="password" v-model="password" required>
				</label>
				<button class="submit" type="submit">Sign In</button>
			</form>
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
				<form @submit.prevent="submitRegister">
					<h2>Sign Up</h2>
					<label>
						<span>Name</span>
						<input type="text" v-model="registerName" required>
					</label>
					<label>
						<span>Surname</span>
						<input type="text" v-model="registerSurname" required>
					</label>
					<label>
						<span>Email</span>
						<input type="email" v-model="registerEmail" required>
					</label>
					<label>
						<span>Password</span>
						<input type="password" v-model="registerPassword" required>
					</label>
					<label>
						<span>Confirm Password</span>
						<input type="password" v-model="registerConfirmPassword" required>
					</label>
					<button class="submit" type="submit">Sign Up Now</button>
				</form>
			</div>
		</div>
	</div>
</template>
  
<script>
    export default{
        name:'LoginComponent',
        data(){
			return{
				username:'',
				password:''
			}
        },
        methods: {
			// Métodos del componente
			async sesionStart(){
				var payload = {
					email:this.email,
					password:this.password
				};
				await this.axios.post('/login', payload)
				.then(response => {
					console.log(response);
				})
				.cath(error =>{
					var data = error.response.data;
					console.log(data)
				})
			},  
			toggleSignup() {
				document.querySelector('.cont').classList.toggle('s-signup');
			},
			submitLogin(event) {
				event.preventDefault();	// Prevent form submission

				// Create request payload
				const payload = {
					username: this.username,
					password: this.password
				};

				// Make the POST request to the backend
				fetch('http://localhost:8081/api/auth/login', {
					method: 'POST',
					headers: {
						'Content-Type': 'application/json'
					},
					body: JSON.stringify(payload)
				})
					.then(response => {
						// Handle the response from the backend
						if (response.ok) {
							return response.json();
						} else {
							throw new Error('Error' + response.statusText);
						}
					})
					.then(data => {
						// Handle the data reveived from the backend
						console.log('Response: ', data);

						// Reset the form fileds
						this.username = '';
						this.password = '';
						
						// Redirect to a new page or perform other actions if needed
						this.$router.push('/form');
					})
					.catch(error => {
						// Handle any error that ocurred
						alert("Error: " + error);
					});

				// Reset the form fileds
				this.username = '';
				this.password = '';
			},
			submitRegister() {

				if (this.registerPassword !== this.registerConfirmPassword) {
					alert("Both passwords must be the same");
					return;
				}

				// Create request payload
				const payload = {
					"name": this.registerName,
					"surname": this.registerSurname,
					"email": this.registerEmail,
					"occupation": "Policymaker",
					"permision": "true",
					"encodedPassword": this.registerPassword,

				};

				console.log(JSON.stringify(payload))

				// Make the POST request to the backend
				fetch('http://localhost:8081/api/register', {
					method: 'POST',
					headers: {
						'Content-Type': 'application/json'
					},
					body: JSON.stringify(payload)
				})
					.then(response => {
						// Handle the response from the backend
						if (response.ok) {
							return response.json();
						} else {
							throw new Error('Error' + response.statusText);
						}
					})
					.then(data => {
						// Handle the data reveived from the backend
						console.log(data);

						// Reset the form fileds
						this.registerName = '';
						this.registerSurname = '';
						this.registerEmail = '';
						this.occupation = '';
						this.permision = '';
						this.encodedPassword = '';

						// Redirect to a new page or perform other actions if needed
						this.$router.push('/confirm');
					})
					.catch(error => {
						// Handle any error that ocurred
						alert("Error: " + error);
					});

				// Reset the form fileds
				this.registerName = '';
				this.registerSurname = '';
				this.registerEmail = '';
				this.occupation = '';
				this.permision = '';
				this.encodedPassword = '';
			}
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
  