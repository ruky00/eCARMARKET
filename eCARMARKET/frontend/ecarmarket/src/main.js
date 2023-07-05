import '@babel/polyfill'
import 'mutationobserver-shim'
import { createApp } from 'vue'
import App from './App.vue'
import routes from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import store from "../src/store/index";
axios.defaults.baseURL = 'http://localhost:8081/api'


createApp(App).use(routes).use(VueAxios,axios).use(store).mount('#app')
