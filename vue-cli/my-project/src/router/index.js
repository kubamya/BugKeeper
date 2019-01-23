import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import userSign from '@/view/userSign/userSign.vue'
import main from '@/view/main/main.vue'
//缺陷管理
import bugManage from '@/view/main/bugManage/bugManage.vue'
//项目管理
import projectManage from '@/view/main/projectManage/projectManage.vue'
//人员管理
import staffManage from '@/view/main/staffManage/staffManage.vue'
//系统设置
import systemSetting from '@/view/main/systemSetting/systemSetting.vue'
//统计分析
import dataAnalysis from '@/view/main/dataAnalysis/dataAnalysis.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/main',
      name: 'main',
      component: main,
      children: [
        {
          path: '/bugManage',
          name: 'bugManage',
          component: bugManage
        },
        {
          path: '/projectManage',
          name: 'projectManage',
          component: projectManage
        },
        {
          path: '/staffManage',
          name: 'staffManage',
          component: staffManage
        },
        {
          path: '/systemSetting',
          name: 'systemSetting',
          component: systemSetting
        },
        {
          path: '/dataAnalysis',
          name: 'dataAnalysis',
          component: dataAnalysis
        }
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
