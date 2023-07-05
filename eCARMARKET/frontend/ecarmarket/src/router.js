import { createRouter, createWebHistory } from 'vue-router';
const routes = createRouter({
   history: createWebHistory(),
   routes: [
      {
         path: '/',
         name: 'home',
         component: () => import("../src/components/mainPageComponent/MainPage")
      },
      {
         path: '/login',
         name: 'login',
         component: () => import("../src/components/authComponents/LoginComponent")
      }, {
         path: '/form',
         name: 'form',
         component: () => import('../src/components/userComponents/ProfileFormComponent'),
      },
      {
         path: '/:pathMatch(.*)*',
         component: () => import('../src/components/erroComponents/404Component')
      },

   ]

});
//routes.beforeEach((to, from, next) => {
 //  const publicPages = ['/login', '/', ''];
   //const authRequired = !publicPages.includes(to.path);
   //const loggedIn = localStorage.getItem('user');

   // trying to access a restricted page + not logged in
   // redirect to login page
   //if (authRequired && !loggedIn) {
   //   next('/login');
  // } else {
   //   next();
  // }
//});

export default routes;