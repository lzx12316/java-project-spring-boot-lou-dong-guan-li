import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import erjiguanliyuanList from '../pages/erjiguanliyuan/list'
import erjiguanliyuanDetail from '../pages/erjiguanliyuan/detail'
import erjiguanliyuanAdd from '../pages/erjiguanliyuan/add'
import zuhuList from '../pages/zuhu/list'
import zuhuDetail from '../pages/zuhu/detail'
import zuhuAdd from '../pages/zuhu/add'
import fangyuanchengshiList from '../pages/fangyuanchengshi/list'
import fangyuanchengshiDetail from '../pages/fangyuanchengshi/detail'
import fangyuanchengshiAdd from '../pages/fangyuanchengshi/add'
import fangyuanleixingList from '../pages/fangyuanleixing/list'
import fangyuanleixingDetail from '../pages/fangyuanleixing/detail'
import fangyuanleixingAdd from '../pages/fangyuanleixing/add'
import fangyuanxinxiList from '../pages/fangyuanxinxi/list'
import fangyuanxinxiDetail from '../pages/fangyuanxinxi/detail'
import fangyuanxinxiAdd from '../pages/fangyuanxinxi/add'
import zulinxinxiList from '../pages/zulinxinxi/list'
import zulinxinxiDetail from '../pages/zulinxinxi/detail'
import zulinxinxiAdd from '../pages/zulinxinxi/add'
import tuizuxinxiList from '../pages/tuizuxinxi/list'
import tuizuxinxiDetail from '../pages/tuizuxinxi/detail'
import tuizuxinxiAdd from '../pages/tuizuxinxi/add'
import baoxiuxinxiList from '../pages/baoxiuxinxi/list'
import baoxiuxinxiDetail from '../pages/baoxiuxinxi/detail'
import baoxiuxinxiAdd from '../pages/baoxiuxinxi/add'
import jiaofeixinxiList from '../pages/jiaofeixinxi/list'
import jiaofeixinxiDetail from '../pages/jiaofeixinxi/detail'
import jiaofeixinxiAdd from '../pages/jiaofeixinxi/add'
import qingjiashenqingList from '../pages/qingjiashenqing/list'
import qingjiashenqingDetail from '../pages/qingjiashenqing/detail'
import qingjiashenqingAdd from '../pages/qingjiashenqing/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discussfangyuanxinxiList from '../pages/discussfangyuanxinxi/list'
import discussfangyuanxinxiDetail from '../pages/discussfangyuanxinxi/detail'
import discussfangyuanxinxiAdd from '../pages/discussfangyuanxinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'erjiguanliyuan',
					component: erjiguanliyuanList
				},
				{
					path: 'erjiguanliyuanDetail',
					component: erjiguanliyuanDetail
				},
				{
					path: 'erjiguanliyuanAdd',
					component: erjiguanliyuanAdd
				},
				{
					path: 'zuhu',
					component: zuhuList
				},
				{
					path: 'zuhuDetail',
					component: zuhuDetail
				},
				{
					path: 'zuhuAdd',
					component: zuhuAdd
				},
				{
					path: 'fangyuanchengshi',
					component: fangyuanchengshiList
				},
				{
					path: 'fangyuanchengshiDetail',
					component: fangyuanchengshiDetail
				},
				{
					path: 'fangyuanchengshiAdd',
					component: fangyuanchengshiAdd
				},
				{
					path: 'fangyuanleixing',
					component: fangyuanleixingList
				},
				{
					path: 'fangyuanleixingDetail',
					component: fangyuanleixingDetail
				},
				{
					path: 'fangyuanleixingAdd',
					component: fangyuanleixingAdd
				},
				{
					path: 'fangyuanxinxi',
					component: fangyuanxinxiList
				},
				{
					path: 'fangyuanxinxiDetail',
					component: fangyuanxinxiDetail
				},
				{
					path: 'fangyuanxinxiAdd',
					component: fangyuanxinxiAdd
				},
				{
					path: 'zulinxinxi',
					component: zulinxinxiList
				},
				{
					path: 'zulinxinxiDetail',
					component: zulinxinxiDetail
				},
				{
					path: 'zulinxinxiAdd',
					component: zulinxinxiAdd
				},
				{
					path: 'tuizuxinxi',
					component: tuizuxinxiList
				},
				{
					path: 'tuizuxinxiDetail',
					component: tuizuxinxiDetail
				},
				{
					path: 'tuizuxinxiAdd',
					component: tuizuxinxiAdd
				},
				{
					path: 'baoxiuxinxi',
					component: baoxiuxinxiList
				},
				{
					path: 'baoxiuxinxiDetail',
					component: baoxiuxinxiDetail
				},
				{
					path: 'baoxiuxinxiAdd',
					component: baoxiuxinxiAdd
				},
				{
					path: 'jiaofeixinxi',
					component: jiaofeixinxiList
				},
				{
					path: 'jiaofeixinxiDetail',
					component: jiaofeixinxiDetail
				},
				{
					path: 'jiaofeixinxiAdd',
					component: jiaofeixinxiAdd
				},
				{
					path: 'qingjiashenqing',
					component: qingjiashenqingList
				},
				{
					path: 'qingjiashenqingDetail',
					component: qingjiashenqingDetail
				},
				{
					path: 'qingjiashenqingAdd',
					component: qingjiashenqingAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discussfangyuanxinxi',
					component: discussfangyuanxinxiList
				},
				{
					path: 'discussfangyuanxinxiDetail',
					component: discussfangyuanxinxiDetail
				},
				{
					path: 'discussfangyuanxinxiAdd',
					component: discussfangyuanxinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
