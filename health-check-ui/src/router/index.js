/* eslint-disable no-unused-vars */
import Vue from 'vue'
import VueRouter from 'vue-router'
import { getAuthority } from '@/utils/authority';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: { name: 'login' }
  },
  {
    path: '/login',
    name: 'login',
    component: () => import("@/views/Login.vue")
  },
  {
    path: '/list',
    name: 'list',
    component: () => import("@/views/List.vue")
  },
  {
    path: '/detail',
    name: 'detail',
    component: () => import("@/views/Detail.vue")
  },
  {
    path: '*',
    name: '404',
    component: () => import("@/views/404.vue")
  },
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {

  const authority = getAuthority()
  const USER_INFO = localStorage.getItem('USER_INFO')

  if ( authority && USER_INFO ) {
    next()
  } else {
    if (to.name !== 'login') {
      next({ name: 'login' })
      return false
    } else {
      next()
    }
  }
})

export default router
