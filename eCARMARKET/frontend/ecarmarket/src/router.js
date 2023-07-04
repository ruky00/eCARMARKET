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
         path:'/form',
         name:'form',
         component: () => import('../src/components/userComponents/ProfileFormComponent'),
      },
      {
         path:'/profile',
         name:'profile',
         component: () => import('../src/components/userComponents/UserProfileComponent')
      },
      {
         path:'/:pathMatch(.*)*',
         component: () => import('../src/components/erroComponents/404Component')
      },
     
   ]
});

export default routes;