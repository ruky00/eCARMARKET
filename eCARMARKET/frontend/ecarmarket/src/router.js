import { createRouter, createWebHistory } from 'vue-router';
const routes =createRouter({
   history: createWebHistory(),
   routes:[
      {
         path:'/',
         name:'home',
         component: ()=> import("../src/components/mainPageComponent/MainPage")
      },
      {
         path:'/login',
         name:'login',
         component:()=> import("../src/components/authComponents/LoginComponent")
      }
   ]
});

export default routes;