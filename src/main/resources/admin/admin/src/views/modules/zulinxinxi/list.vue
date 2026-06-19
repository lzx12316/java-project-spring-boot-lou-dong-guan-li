<template>
	<div class="main-content" :style='{"padding":"30px","flexWrap":"wrap","display":"flex"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"width":"80%","margin":"0 0 20px","alignItems":"flex-start","flexDirection":"column","display":"flex"}' :inline="true" :model="searchForm">
				<el-row :style='{"border":"1px solid #654B3C","width":"auto","overflow":"hidden","borderRadius":"20px","display":"inline-block"}' >
					<div :style='{"margin":"0 0 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"none","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">房源名称</label>
						<el-input v-model="searchForm.fangyuanmingcheng" placeholder="房源名称" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 0 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"none","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">房源类型</label>
						<el-input v-model="searchForm.fangyuanleixing" placeholder="房源类型" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 0 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"none","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">房源城市</label>
						<el-input v-model="searchForm.fangyuanchengshi" placeholder="房源城市" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 0 0 0","display":"inline-block"}' class="select">
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"none","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">是否支付</label>
						<el-select clearable v-model="searchForm.ispay" placeholder="是否支付">
							<el-option v-for="(item,index) in isPayOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<el-button class="search" type="success" @click="search()">
						<span class="icon iconfont icon-chakan14" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
						查询
					</el-button>
				</el-row>

				<el-row class="actions" :style='{"width":"100%","margin":"20px 0","flexWrap":"wrap","display":"flex"}'>
					<el-button class="add" v-if="isAuth('zulinxinxi','新增')" type="success" @click="addOrUpdateHandler()">
						<span class="icon iconfont icon-tianjia14" :style='{"margin":"0 2px","fontSize":"14px","color":"#654B3C","height":"40px"}'></span>
						创建
					</el-button>
					<el-button class="del" v-if="isAuth('zulinxinxi','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						<span class="icon iconfont icon-shanchu10" :style='{"margin":"0 2px","fontSize":"14px","color":"#654B3C","height":"40px"}'></span>
						删减
					</el-button>


					<el-button class="btn18" v-if="isAuth('zulinxinxi','支付')" :disabled="dataListSelections.length?false:true" type="success" @click="payBatch()">
						<span class="icon iconfont icon-kuaijiezhifu" :style='{"margin":"0 2px","fontSize":"14px","color":"#654B3C","height":"40px"}'></span>
						批量支付
					</el-button>

					<el-button class="btn18" v-if="isAuth('zulinxinxi','租赁金额')" type="success" @click="chartDialog1()">
						<span class="icon iconfont icon-qita19" :style='{"margin":"0 2px","fontSize":"14px","color":"#654B3C","height":"40px"}'></span>
						租赁金额
					</el-button>
				</el-row>
			</el-form>
			<div :style='{"width":"100%","padding":"10px","boxShadow":""}'>
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","boxShadow":"0 4px 8px rgba(0,0,0,.3)","borderColor":"#eee","borderWidth":"1px 0 0 1px","background":"#fff","width":"100%","borderStyle":"solid"}' 
					:border='true'
					v-if="isAuth('zulinxinxi','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='false'  
						prop="fangyuanmingcheng"
						label="房源名称">
						<template slot-scope="scope">
							{{scope.row.fangyuanmingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="dizhi"
						label="地址">
						<template slot-scope="scope">
							{{scope.row.dizhi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="fangyuanleixing"
						label="房源类型">
						<template slot-scope="scope">
							{{scope.row.fangyuanleixing}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="fangyuanchengshi"
						label="房源城市">
						<template slot-scope="scope">
							{{scope.row.fangyuanchengshi}}
						</template>
					</el-table-column>
					<!-- 无 -->
					<el-table-column :resizable='true' :sortable='false' prop="fengmian" width="200" label="封面">
						<template slot-scope="scope">
							<div v-if="scope.row.fengmian">
								<img v-if="scope.row.fengmian.substring(0,4)=='http'" :src="scope.row.fengmian.split(',')[0]" width="100" height="100" style="object-fit: cover">
								<img v-else :src="$base.url+scope.row.fengmian.split(',')[0]" width="100" height="100" style="object-fit: cover">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="mianji"
						label="面积/㎡">
						<template slot-scope="scope">
							{{scope.row.mianji}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="yuezu"
						label="月租/元">
						<template slot-scope="scope">
							{{scope.row.yuezu}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="yajin"
						label="押金/元">
						<template slot-scope="scope">
							{{scope.row.yajin}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="dingjin"
						label="定金/元">
						<template slot-scope="scope">
							{{scope.row.dingjin}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="zongjine"
						label="总金额/元">
						<template slot-scope="scope">
							{{scope.row.zongjine}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="zuhuzhanghao"
						label="租户账号">
						<template slot-scope="scope">
							{{scope.row.zuhuzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="zuhuxingming"
						label="租户姓名">
						<template slot-scope="scope">
							{{scope.row.zuhuxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shouji"
						label="手机">
						<template slot-scope="scope">
							{{scope.row.shouji}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="qiandingshijian"
						label="签订时间">
						<template slot-scope="scope">
							{{scope.row.qiandingshijian}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="ispay" label="是否支付">
						<template slot-scope="scope">
							<span style="margin-right:10px">{{scope.row.ispay=='已支付'?'已支付':'未支付'}}</span>
							<el-button v-if="scope.row.ispay!='已支付' && isAuth('zulinxinxi','支付') " type="text" size="small" @click="payHandler(scope.row)">支付</el-button>
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if=" isAuth('zulinxinxi','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								<span class="icon iconfont icon-chakan14" :style='{"margin":"0 2px","fontSize":"14px","color":"#965F40","height":"40px"}'></span>
								查看
							</el-button>
							<el-button class="btn8" v-if="isAuth('zulinxinxi','退租')" @click="tuizuxinxiCrossAddOrUpdateHandler(scope.row,'cross','否','是','','')" type="success">
								<span class="icon iconfont icon-qita20" :style='{"margin":"0 2px","fontSize":"14px","color":"#965F40","height":"40px"}'></span>
								退租
							</el-button>
							<el-button class="btn8" v-if="isAuth('zulinxinxi','报修')" @click="baoxiuxinxiCrossAddOrUpdateHandler(scope.row,'cross','否','是','','')" type="success">
								<span class="icon iconfont icon-qita20" :style='{"margin":"0 2px","fontSize":"14px","color":"#965F40","height":"40px"}'></span>
								报修
							</el-button>
							<el-button class="btn8" v-if="isAuth('zulinxinxi','缴费')" @click="jiaofeixinxiCrossAddOrUpdateHandler(scope.row,'cross','否','是','','')" type="success">
								<span class="icon iconfont icon-qita20" :style='{"margin":"0 2px","fontSize":"14px","color":"#965F40","height":"40px"}'></span>
								缴费
							</el-button>
							<el-button class="edit" v-if=" isAuth('zulinxinxi','修改') " type="success" @click="addOrUpdateHandler(scope.row.id)">
								<span class="icon iconfont icon-xiugai13" :style='{"margin":"0 2px","fontSize":"14px","color":"#965F40","height":"40px"}'></span>
								修改
							</el-button>




							<el-button class="del" v-if="isAuth('zulinxinxi','删除') " type="primary" @click="deleteHandler(scope.row.id )">
								<span class="icon iconfont icon-shanchu16" :style='{"margin":"0 2px","fontSize":"14px","color":"#965F40","height":"40px"}'></span>
								删除
							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 50, 100, 200]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="< "
				next-text="> "
				:hide-on-single-page="true"
				:style='{"width":"100%","padding":"0","margin":"20px 0 0","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
			></el-pagination>
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

		<tuizuxinxi-cross-add-or-update v-if="tuizuxinxiCrossAddOrUpdateFlag" :parent="this" ref="tuizuxinxiCrossaddOrUpdate"></tuizuxinxi-cross-add-or-update>
		<baoxiuxinxi-cross-add-or-update v-if="baoxiuxinxiCrossAddOrUpdateFlag" :parent="this" ref="baoxiuxinxiCrossaddOrUpdate"></baoxiuxinxi-cross-add-or-update>
		<jiaofeixinxi-cross-add-or-update v-if="jiaofeixinxiCrossAddOrUpdateFlag" :parent="this" ref="jiaofeixinxiCrossaddOrUpdate"></jiaofeixinxi-cross-add-or-update>




		<el-dialog
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="zongjineChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>
	</div>
</template>

<script>
import * as echarts from 'echarts'
import chinaJson from "@/components/echarts/china.json";
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import tuizuxinxiCrossAddOrUpdate from "../tuizuxinxi/add-or-update";
import baoxiuxinxiCrossAddOrUpdate from "../baoxiuxinxi/add-or-update";
import jiaofeixinxiCrossAddOrUpdate from "../jiaofeixinxi/add-or-update";
	export default {
		data() {
			return {
				searchForm: {
					key: ""
				},
				form:{},
				isPayOptions: [],
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				sfshVisiable: false,
				shForm: {},
				chartVisiable: false,
				chartVisiable1: false,
				chartVisiable2: false,
				chartVisiable3: false,
				chartVisiable4: false,
				chartVisiable5: false,
				addOrUpdateFlag:false,
				tuizuxinxiCrossAddOrUpdateFlag: false,
				baoxiuxinxiCrossAddOrUpdateFlag: false,
				jiaofeixinxiCrossAddOrUpdateFlag: false,
				layouts: ["total","prev","pager","next","sizes","jumper"],
			};
		},
		created() {
			this.init();
			this.getDataList();
			this.contentStyleChange()
		},
		mounted() {
		},
		filters: {
			htmlfilter: function (val) {
				return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
			}
		},
		computed: {
			tablename(){
				return this.$storage.get('sessionTable')
			},
		},
		components: {
			AddOrUpdate,
			tuizuxinxiCrossAddOrUpdate,
			baoxiuxinxiCrossAddOrUpdate,
			jiaofeixinxiCrossAddOrUpdate,
		},
		methods: {
			contentStyleChange() {
				this.contentPageStyleChange()
			},
			// 分页
			contentPageStyleChange(){
				let arr = []

				// if(this.contents.pageTotal) arr.push('total')
				// if(this.contents.pageSizes) arr.push('sizes')
				// if(this.contents.pagePrevNext){
				//   arr.push('prev')
				//   if(this.contents.pagePager) arr.push('pager')
				//   arr.push('next')
				// }
				// if(this.contents.pageJumper) arr.push('jumper')
				// this.layouts = arr.join()
				// this.contents.pageEachNum = 10
			},
			tuizuxinxiCrossAddOrUpdateHandler(row,type,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue){
				if(crossOptPay=='是'&&row.ispay!='已支付'){
					this.$message({
						message: "请支付完成再操作",
						type: "success",
						duration: 1500,
						onClose: () => {
						}
					});
					return
				}
				this.showFlag = false;
				this.addOrUpdateFlag = false;
				this.tuizuxinxiCrossAddOrUpdateFlag = true;
				this.$storage.set('crossObj',row);
				this.$storage.set('crossTable','zulinxinxi');
				this.$storage.set('statusColumnName',statusColumnName);
				this.$storage.set('statusColumnValue',statusColumnValue);
				this.$storage.set('tips',tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$message({
								message: tips,
								type: "success",
								duration: 1500,
								onClose: () => {
									this.getDataList();
								}
							});
							this.showFlag = true;
							this.tuizuxinxiCrossAddOrUpdateFlag = false;
							return;
						}
					}
				}
				this.$nextTick(() => {
					this.$refs.tuizuxinxiCrossaddOrUpdate.init(row.id,type);
				});
			},
			baoxiuxinxiCrossAddOrUpdateHandler(row,type,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue){
				if(crossOptPay=='是'&&row.ispay!='已支付'){
					this.$message({
						message: "请支付完成再操作",
						type: "success",
						duration: 1500,
						onClose: () => {
						}
					});
					return
				}
				this.showFlag = false;
				this.addOrUpdateFlag = false;
				this.baoxiuxinxiCrossAddOrUpdateFlag = true;
				this.$storage.set('crossObj',row);
				this.$storage.set('crossTable','zulinxinxi');
				this.$storage.set('statusColumnName',statusColumnName);
				this.$storage.set('statusColumnValue',statusColumnValue);
				this.$storage.set('tips',tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$message({
								message: tips,
								type: "success",
								duration: 1500,
								onClose: () => {
									this.getDataList();
								}
							});
							this.showFlag = true;
							this.baoxiuxinxiCrossAddOrUpdateFlag = false;
							return;
						}
					}
				}
				this.$nextTick(() => {
					this.$refs.baoxiuxinxiCrossaddOrUpdate.init(row.id,type);
				});
			},
			jiaofeixinxiCrossAddOrUpdateHandler(row,type,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue){
				if(crossOptPay=='是'&&row.ispay!='已支付'){
					this.$message({
						message: "请支付完成再操作",
						type: "success",
						duration: 1500,
						onClose: () => {
						}
					});
					return
				}
				this.showFlag = false;
				this.addOrUpdateFlag = false;
				this.jiaofeixinxiCrossAddOrUpdateFlag = true;
				this.$storage.set('crossObj',row);
				this.$storage.set('crossTable','zulinxinxi');
				this.$storage.set('statusColumnName',statusColumnName);
				this.$storage.set('statusColumnValue',statusColumnValue);
				this.$storage.set('tips',tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$message({
								message: tips,
								type: "success",
								duration: 1500,
								onClose: () => {
									this.getDataList();
								}
							});
							this.showFlag = true;
							this.jiaofeixinxiCrossAddOrUpdateFlag = false;
							return;
						}
					}
				}
				this.$nextTick(() => {
					this.$refs.jiaofeixinxiCrossaddOrUpdate.init(row.id,type);
				});
			},
			payHandler(row){
				this.$storage.set('paytable','zulinxinxi');
				this.$storage.set('payObject',row);
				this.$router.push('pay');
			},
			// 批量支付
			payBatch(){
				for(let x in this.dataListSelections){
					if(this.dataListSelections[x].ispay=='已支付'){
						this.$message.error('所选订单存在已支付订单')
						return false
					}
				}
				this.$confirm('是否支付所选订单？').then(_ => {
					let arr = JSON.parse(JSON.stringify(this.dataListSelections))
					for(let i in arr){
						arr[i].ispay = '已支付'
						this.$http({
							url: 'zulinxinxi/update',
							method: "post",
							data: arr[i]
						}).then(res=>{
							
						})
					}
					this.$message({
						message: "支付成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.getDataList()
						}
					});
				}).catch(_ => {});
			},


//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{
        var zongjineChart1 = echarts.init(document.getElementById("zongjineChart1"),'macarons');
        this.$http({
            url: `zulinxinxi/value/fangyuanmingcheng/zongjine`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].fangyuanmingcheng);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].fangyuanmingcheng
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '租赁金额',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                zongjineChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    zongjineChart1.resize();
                };
            }
        });
      })
    },




    init () {
		this.isPayOptions = "已支付,未支付".split(',')
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.fangyuanmingcheng!='' && this.searchForm.fangyuanmingcheng!=undefined){
            params['fangyuanmingcheng'] = '%' + this.searchForm.fangyuanmingcheng + '%'
          }
           if(this.searchForm.fangyuanleixing!='' && this.searchForm.fangyuanleixing!=undefined){
            params['fangyuanleixing'] = '%' + this.searchForm.fangyuanleixing + '%'
          }
           if(this.searchForm.fangyuanchengshi!='' && this.searchForm.fangyuanchengshi!=undefined){
            params['fangyuanchengshi'] = '%' + this.searchForm.fangyuanchengshi + '%'
          }
    params['sort'] = 'qiandingshijian';
    params['order'] = 'desc';
			if(this.searchForm.ispay!='' && this.searchForm.ispay!=undefined){
				params['ispay'] = this.searchForm.ispay
			}
			let user = JSON.parse(this.$storage.getObj('userForm'))
			console.log(user)
			this.$http({
				url: "zulinxinxi/page",
				method: "get",
				params: params
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.dataList = data.data.list;
					this.totalPage = data.data.total;
				} else {
					this.dataList = [];
					this.totalPage = 0;
				}
				this.dataListLoading = false;
			});
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 下载
    download(file){
      let arr = file.replace(new RegExp('upload/', "g"), "")
      axios.get(this.$base.url + 'file/download?fileName=' + arr, {
      	headers: {
      		token: this.$storage.get('Token')
      	},
      	responseType: "blob"
      }).then(({
      	data
      }) => {
      	const binaryData = [];
      	binaryData.push(data);
      	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
      		type: 'application/pdf;chartset=UTF-8'
      	}))
      	const a = document.createElement('a')
      	a.href = objectUrl
      	a.download = arr
      	// a.click()
      	// 下面这个写法兼容火狐
      	a.dispatchEvent(new MouseEvent('click', {
      		bubbles: true,
      		cancelable: true,
      		view: window
      	}))
      	window.URL.revokeObjectURL(data)
      },err=>{
		  axios.get((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] :'') + this.$base.name + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: this.$storage.get('Token')
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  })
	  })
    },
	// 预览
	preClick(file){
		if(!file){
			return false
		}
		window.open((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] + this.$base.name + '/' + file :this.$base.url + file))
	},
	zulinxinxistatusChange(e,row){
		if(row.status==0){
			row.passwordwrongnum = 0
		}
		this.$http({
			url:'zulinxinxi/update',
			method:'post',
			data:row
		}).then(res=>{
			if(row.status==1){
				this.$message.error('该用户已锁定')
			}else{
				this.$message.success('该用户已解除锁定')
			}
		})
	},
    // 删除
    async deleteHandler(id ) {
		var ids = id? [Number(id)]: this.dataListSelections.map(item => {
			return Number(item.id);
		});
		await this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
			confirmButtonText: "确定",
			cancelButtonText: "取消",
			type: "warning"
		}).then(async () => {
			await this.$http({
				url: "zulinxinxi/delete",
				method: "post",
				data: ids
			}).then(async ({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.search();
						}
					});
            
				} else {
					this.$message.error(data.msg);
				}
			});
		});
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 1px solid #654B3C;
				border-radius: 0;
				padding: 0 12px;
				box-shadow: none;
				outline: none;
				color: #000;
				width: 170px;
				font-size: 14px;
				border-width: 0 1px 0 0;
				height: 40px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 1px solid #654B3C;
				border-radius: 0;
				padding: 0 10px;
				box-shadow: none;
				outline: none;
				color: #000;
				width: 170px;
				font-size: 14px;
				border-width: 0 1px 0 0;
				height: 40px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 1px solid #654B3C;
				border-radius: 0;
				padding: 0 10px 0 30px;
				box-shadow: none;
				outline: none;
				color: #000;
				width: 170px;
				font-size: 14px;
				border-width: 0 1px 0 0;
				height: 40px;
			}
	
	.center-form-pv .search {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0 24px;
				outline: none;
				color: #fff;
				background: #654B3C;
				width: auto;
				font-size: 14px;
				float: right;
				height: 40px;
			}
	
	.center-form-pv .search:hover {
				opacity: 0.5;
			}
	
	.center-form-pv .actions .add {
				border: 1px solid #654B3C;
				cursor: pointer;
				border-radius: 15px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #654B3C;
				background: none;
				width: auto;
				font-size: 14px;
				height: 30px;
			}
	
	.center-form-pv .actions .add:hover {
				opacity: 0.5;
			}
	
	.center-form-pv .actions .del {
				border: 1px solid #654B3C;
				cursor: pointer;
				border-radius: 15px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #654B3C;
				background: none;
				width: auto;
				font-size: 14px;
				height: 30px;
			}
	
	.center-form-pv .actions .del:hover {
				opacity: 0.5;
			}
	
	.center-form-pv .actions .statis {
				border: 1px solid #654B3C;
				cursor: pointer;
				border-radius: 15px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #654B3C;
				background: none;
				width: auto;
				font-size: 14px;
				height: 30px;
			}
	
	.center-form-pv .actions .statis:hover {
				opacity: 0.5;
			}
	
	.center-form-pv .actions .btn18 {
				border: 1px solid #654B3C;
				cursor: pointer;
				border-radius: 15px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #654B3C;
				background: none;
				width: auto;
				font-size: 14px;
				height: 30px;
			}
	
	.center-form-pv .actions .btn18:hover {
				opacity: 0.5;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				margin: 0 0 10px;
				color: #999;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				box-shadow: 0 4px 8px rgba(0,0,0,.3);
				background: #fff;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				border-color: #eee;
				border-width: 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #fff;
				background: rgba(150, 95, 64, .5);
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0 6px;
				margin: 0 10px 0 0;
				outline: none;
				color: #965F40;
				background: transparent;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view:hover {
				opacity: 0.5;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add:hover {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0 6px;
				margin: 0 10px 0 0;
				outline: none;
				color: #965F40;
				background: none;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit:hover {
				opacity: 0.5;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 6px;
				margin: 0 10px 0 0;
				outline: none;
				color: #965F40;
				background: none;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del:hover {
				opacity: 0.5;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 6px;
				margin: 4px;
				outline: none;
				color: #965F40;
				background: none;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8:hover {
				opacity: 0.5;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #965F4070;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #FFF;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #965F40;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	// list one
	.one .list1-view {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0 0;
				margin: 0 0 6px;
				outline: none;
				color: #000;
				background: #EDEDED;
				width: calc(100% / 3);
				font-size: 14px;
				height: 40px;
			}
	
	.one .list1-view:hover {
				opacity: 0.5;
			}
	
	.one .list1-edit {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0 0;
				margin: 0 0 6px;
				outline: none;
				color: #000;
				background: #EDEDED;
				width: calc(100% / 3);
				font-size: 14px;
				height: 40px;
			}
	
	.one .list1-edit:hover {
				opacity: 0.5;
			}
	
	.one .list1-del {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 0 6px;
				outline: none;
				color: #000;
				background: #EDEDED;
				width: calc(100% / 3);
				font-size: 14px;
				height: 40px;
			}
	
	.one .list1-del:hover {
				opacity: 0.5;
			}
	
	.one .list1-btn8 {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0 0;
				margin: 6px 0;
				outline: none;
				color: #000;
				background: #EDEDED;
				width: calc(100% / 3);
				font-size: 14px;
				height: 40px;
			}
	
	.one .list1-btn8:hover {
				opacity: 0.5;
			}
	
	.main-content .el-table .el-switch {
				display: inline-flex;
				vertical-align: middle;
				line-height: 30px;
				position: relative;
				align-items: center;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--left {
				cursor: pointer;
				margin: 0 10px 0 0;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--right {
				cursor: pointer;
				margin: 0 0 0 10px;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core {
				border: 1px solid #0000ff;
				cursor: pointer;
				border-radius: 15px;
				margin: 0;
				outline: 0;
				background: #0000ff;
				display: inline-block;
				width: 60px;
				box-sizing: border-box;
				transition: border-color .3s,background-color .3s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core::after {
				border-radius: 100%;
				top: 1px;
				left: 1px;
				background: #FFF;
				width: 26px;
				position: absolute;
				transition: all .3s;
				height: 26px;
			}
	.main-content .el-table .el-switch.is-checked /deep/ .el-switch__core::after {
				margin: 0 0 0 -27px;
				left: 100%;
			}
	
	.main-content .el-table .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	.main-content .el-table .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				display: inline-block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
</style>
