<template>
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
@import '../../assets/css/variables.css';

*{
  margin: 0;
  padding: 0;
  outline: none;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}
body{
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  padding: 10px;
  font-family: 'Poppins', sans-serif;
  background: linear-gradient(115deg, var(--half-baked-500) 10%, var(--half-baked-900) 90%);
}
.container{
  max-width: 800px;
  background: #fff;
  width: 800px;
  padding: 25px 40px 10px 40px;
  box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
  border-radius: 20px;
}
.container .text{
  text-align: center;
  font-size: 41px;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  background: -webkit-linear-gradient(right,var(--corn-field-400), var(--half-baked-900), var(--half-baked-900), var(--corn-field-400));
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
.container form{
  padding: 30px 0 0 0;
}
.container form .form-row{
  display: flex;
  margin: 32px 0;
}
form .form-row .input-data{
  width: 100%;
  height: 40px;
  margin: 0 20px;
  position: relative;
}
form .form-row .textarea{
  height: 70px;
}
.input-data input,
.textarea textarea{
  display: block;
  width: 100%;
  height: 100%;
  border: none;
  font-size: 17px;
  border-bottom: 2px solid rgba(0,0,0, 0.12);
}
.input-data input:focus ~ label, .textarea textarea:focus ~ label,
.input-data input:valid ~ label, .textarea textarea:valid ~ label{
  transform: translateY(-20px);
  font-size: 14px;
  color: #3498db;
}
.textarea textarea{
  resize: none;
  padding-top: 10px;
}
.input-data label{
  position: absolute;
  pointer-events: none;
  bottom: 10px;
  font-size: 16px;
  transition: all 0.3s ease;
}
.textarea label{
  width: 100%;
  bottom: 40px;
  background: #fff;
}
.input-data .underline{
  position: absolute;
  bottom: 0;
  height: 2px;
  width: 100%;
}
.input-data .underline:before{
  position: absolute;
  content: "";
  height: 2px;
  width: 100%;
  background: #3498db;
  transform: scaleX(0);
  transform-origin: center;
  transition: transform 0.3s ease;
}
.input-data input:focus ~ .underline:before,
.input-data input:valid ~ .underline:before,
.textarea textarea:focus ~ .underline:before,
.textarea textarea:valid ~ .underline:before{
  transform: scale(1);
}
.submit-btn .input-data{
  overflow: hidden;
  height: 45px!important;
  width: 25%!important;
}
.submit-btn .input-data .inner{
  height: 100%;
  width: 300%;
  position: absolute;
  left: -100%;
  background: -webkit-linear-gradient(right, var(--half-baked-900), var(--corn-field-400), var(--half-baked-900), var(--corn-field-400));
  transition: all 0.4s;
}
.submit-btn .input-data:hover .inner{
  left: 0;
}
.submit-btn .input-data input{
  background: none;
  border: none;
  color: #fff;
  font-size: 17px;
  font-weight: 500;
  text-transform: uppercase;
  letter-spacing: 1px;
  cursor: pointer;
  position: relative;
  z-index: 2;
}
@media (max-width: 700px) {
  .container .text{
    font-size: 30px;
  }
  .container form{
    padding: 10px 0 0 0;
  }
  .container form .form-row{
    display: block;
  }
  form .form-row .input-data{
    margin: 35px 0!important;
  }
  .submit-btn .input-data{
    width: 40%!important;
  }
}

</style>