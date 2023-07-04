<template>
	<div class="position">
		<div class="container">
			<div class="text">
				We want to know you
			</div>
			<form action="#">
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
					<input type="text" required v-model="recive">
					<div class="underline"></div>
					<label for="">Want to recieve overviews?</label>
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