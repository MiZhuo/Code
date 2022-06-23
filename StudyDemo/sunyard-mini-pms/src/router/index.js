import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export const constantRouterMap = [
    {
      path: '/login',
      component: ()=> import('@/views/login/login'),
    },{
      path: '',
      redirect: '/home'
    },{
        path: '/home',
        name: 'home',
        component: ()=> import('@/views/home/home.vue')
    },{
      path: '/404',
      component: () => import('@/views/404'),
    },{
      path: '*',
      redirect: '/404',
    }
]

export default new Router({
  //mode: 'history',
  routes: constantRouterMap
})
