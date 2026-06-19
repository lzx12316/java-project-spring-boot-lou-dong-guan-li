import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import baoxiuxinxi from '@/views/modules/baoxiuxinxi/list'
    import aboutus from '@/views/modules/aboutus/list'
    import qingjiashenqing from '@/views/modules/qingjiashenqing/list'
    import fangyuanxinxi from '@/views/modules/fangyuanxinxi/list'
    import fangyuanchengshi from '@/views/modules/fangyuanchengshi/list'
    import zulinxinxi from '@/views/modules/zulinxinxi/list'
    import zuhu from '@/views/modules/zuhu/list'
    import fangyuanleixing from '@/views/modules/fangyuanleixing/list'
    import jiaofeixinxi from '@/views/modules/jiaofeixinxi/list'
    import discussfangyuanxinxi from '@/views/modules/discussfangyuanxinxi/list'
    import systemintro from '@/views/modules/systemintro/list'
    import config from '@/views/modules/config/list'
    import erjiguanliyuan from '@/views/modules/erjiguanliyuan/list'
    import tuizuxinxi from '@/views/modules/tuizuxinxi/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '通知公告',
        component: news
      }
      ,{
	path: '/baoxiuxinxi',
        name: '报修信息',
        component: baoxiuxinxi
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/qingjiashenqing',
        name: '请假申请',
        component: qingjiashenqing
      }
      ,{
	path: '/fangyuanxinxi',
        name: '房源信息',
        component: fangyuanxinxi
      }
      ,{
	path: '/fangyuanchengshi',
        name: '房源城市',
        component: fangyuanchengshi
      }
      ,{
	path: '/zulinxinxi',
        name: '租赁信息',
        component: zulinxinxi
      }
      ,{
	path: '/zuhu',
        name: '租户',
        component: zuhu
      }
      ,{
	path: '/fangyuanleixing',
        name: '房源类型',
        component: fangyuanleixing
      }
      ,{
	path: '/jiaofeixinxi',
        name: '缴费信息',
        component: jiaofeixinxi
      }
      ,{
	path: '/discussfangyuanxinxi',
        name: '房源信息评论',
        component: discussfangyuanxinxi
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/erjiguanliyuan',
        name: '二级管理员',
        component: erjiguanliyuan
      }
      ,{
	path: '/tuizuxinxi',
        name: '退租信息',
        component: tuizuxinxi
      }
      ,{
	path: '/newstype',
        name: '通知公告分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
