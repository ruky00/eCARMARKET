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
         path:'/userHome',
         name:'userHome',
         component: () => import('../src/components/userComponents/UserHomeComponent')
      },
      {
         path:'/confirm',
         name:'confirm',
         component: () => import('../src/components/authComponents/ConfirmEmailComponent')
      },
      {
         path:'/:pathMatch(.*)*',
         component: () => import('../src/components/erroComponents/404Component')
      },
     
   ]
});

export default routes;