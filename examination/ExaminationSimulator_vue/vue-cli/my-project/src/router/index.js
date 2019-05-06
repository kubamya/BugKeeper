import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import userSign from '@/view/userSign/userSign.vue'
import main from '@/view/main/main.vue'

//demo
import binding from '@/view/demo/binding.vue'
import demo from '@/view/demo/demo.vue'
import start from '@/view/start/start.vue'
import edit from '@/view/edit/edit.vue'


Vue.use(Router)

export default new Router({
  routes: [
    
    {
      path: '/demo',
      name: 'demo',
      component: demo
    },
    {
      path: '/binding',
      name: 'binding',
      component: binding
    },
    {
      path: '/main',
      name: 'main',
      component: main,
      children: [
        {
          path: '/start',
          name: 'start',
          component: start
        },
        {
          path: '/edit',
          name: 'edit',
          component: edit
        },
      ]
    },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/userSign',
      name: 'userSign',
      component: userSign
    }
  ]
})
