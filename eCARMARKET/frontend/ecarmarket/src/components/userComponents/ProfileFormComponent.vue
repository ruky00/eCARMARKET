<template>
	<div class="position">
		<div class="container">
			<div class="text">
				We want to know you
			</div>
			<form @submit.prevent="submitForm">
				<div class="form-row">
				<div class="input-data">
					<input type="text" required v-model="role">
					<div class="underline"></div>
					<label for="">What role do you have?</label>
				</div>
				<div class="input-data">
					<input type="text" required v-model="org">
					<div class="underline"></div>
					<label for="">Organization you are working on</label>
				</div>
				</div>
				<div class="form-row">
				<div class="input-data">
		
					<label for="">Whats your favourite EV company?</label>
					<Multiselect
					v-model="selectedTags"
					mode="tags"
					placeholder="Select 3 EV companies"
					:options="options"
					:searchable="true"
					:createTag="false"
					:disabled="isDisabled"></Multiselect>
				</div>
				<div class="input-data">
					<label for="">Want to recieve overviews?</label>
					<div class="radio-buttons">
						<input type="radio" id="yes" value="yes" name="overviews" required v-model="recive">
						<label for="yes">Yes</label>
						<input type="radio" id="no" value="no" name="overviews" required v-model="recive">
						<label for="no">No</label>
					</div>
				</div>
			</div>
			<div class="form-row submit-btn">
				<div class="input-data">
						<div class="inner"></div>
						<input type="submit" value="submit">
					</div>
				</div>
			</form>
		</div>
	</div>
</template>

<script>
  import Multiselect from '@vueform/multiselect'
    export default{
      components:{
        Multiselect
      },
      name:'ProfileFormComponent',
      data() {
		return {
			options: ['Tesla', 'Cupra', 'Ford','Volvo','MG'],
			selectedTags: [],
			maxTags:3,
			isDisabled:false
		}
		},
		computed: {
			isMaxTagsReached() {
				return this.selectedTags.length >= this.maxTags;
			}
		},
		methods: {
			async makePost(body) {
				try{
					const url = "http://localhost:8081/api/me/profile/";

					const response = await fetch(url, {
						method: 'POST',
						headers: {
							'Content-Type': 'application/json',
						},
						body: JSON.stringify(body),
					});

					return response;
				} catch (error) {
					console.error('Error fetching data:', error);
				}
			},
			submitForm() {
				if (this.selectedTags.length < 3) {
					alert("Please select 3 companies")
					return 0;
				}

				const recive = this.recive === "yes" ? true : false;

				const body = 
				{
					"rol" : this.rol,
					"org" : this.org,
					"favCompany" : [
						this.selectedTags[0],
						this.selectedTags[1],
						this.selectedTags[2]
					],
					"allowOverview" : recive
				}

				this.makePost(body)
					.then(() => {
						// The fetch request is completed, and now we can redirect
						this.$router.push('/userHome');
					})
					.catch((error) => {
						console.error('Error making POST request:', error);
					});
				
				return 0;
			}
		},
		watch: {
			isMaxTagsReached(value) {
				this.isDisabled = value;
			}
		}
	}
</script>

<style>
@import '@vueform/multiselect/themes/default.css';
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
@import '../../assets/css/userCSS/profileFormComponent.css';
</style>