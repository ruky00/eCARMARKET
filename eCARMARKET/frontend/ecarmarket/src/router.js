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
      },
      {
         path:'/:pathMatch(.*)*',
         component: () => import('../src/components/erroComponents/404Component')
      }
   ]
});

export default routes;