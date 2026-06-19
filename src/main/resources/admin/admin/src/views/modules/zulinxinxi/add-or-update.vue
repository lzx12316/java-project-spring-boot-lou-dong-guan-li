<template>
	<div class="addEdit-block" :style='{"padding":"30px"}'>
		<el-form
			:style='{"padding":"30px","boxShadow":"none","borderRadius":"6px","flexWrap":"wrap","display":"flex"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="160px"
		>
			<template >
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="房源名称" prop="fangyuanmingcheng">
					<el-input v-model="ruleForm.fangyuanmingcheng" placeholder="房源名称" clearable  :readonly="ro.fangyuanmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="房源名称" prop="fangyuanmingcheng">
					<el-input v-model="ruleForm.fangyuanmingcheng" placeholder="房源名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="地址" prop="dizhi">
					<el-input v-model="ruleForm.dizhi" placeholder="地址" clearable  :readonly="ro.dizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="地址" prop="dizhi">
					<el-input v-model="ruleForm.dizhi" placeholder="地址" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="房源类型" prop="fangyuanleixing">
					<el-input v-model="ruleForm.fangyuanleixing" placeholder="房源类型" clearable  :readonly="ro.fangyuanleixing"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="房源类型" prop="fangyuanleixing">
					<el-input v-model="ruleForm.fangyuanleixing" placeholder="房源类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="房源城市" prop="fangyuanchengshi">
					<el-input v-model="ruleForm.fangyuanchengshi" placeholder="房源城市" clearable  :readonly="ro.fangyuanchengshi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="房源城市" prop="fangyuanchengshi">
					<el-input v-model="ruleForm.fangyuanchengshi" placeholder="房源城市" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.fengmian" label="封面" prop="fengmian">
					<file-upload
						tip="点击上传封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
						@change="fengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.fengmian" label="封面" prop="fengmian">
					<img v-if="ruleForm.fengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="面积/㎡" prop="mianji">
					<el-input v-model="ruleForm.mianji" placeholder="面积/㎡" clearable  :readonly="ro.mianji"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="面积/㎡" prop="mianji">
					<el-input v-model="ruleForm.mianji" placeholder="面积/㎡" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="月租/元" prop="yuezu">
					<el-input-number v-model="ruleForm.yuezu" placeholder="月租/元" :readonly="ro.yuezu"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="月租/元" prop="yuezu">
					<el-input v-model="ruleForm.yuezu" placeholder="月租/元" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="押金/元" prop="yajin">
					<el-input-number v-model="ruleForm.yajin" placeholder="押金/元" :readonly="ro.yajin"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="押金/元" prop="yajin">
					<el-input v-model="ruleForm.yajin" placeholder="押金/元" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="定金/元" prop="dingjin">
					<el-input-number v-model="ruleForm.dingjin" placeholder="定金/元" :readonly="ro.dingjin"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="定金/元" prop="dingjin">
					<el-input v-model="ruleForm.dingjin" placeholder="定金/元" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="总金额/元" prop="zongjine">
					<el-input v-model="zongjine" placeholder="总金额/元" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.zongjine" label="总金额/元" prop="zongjine">
					<el-input v-model="ruleForm.zongjine" placeholder="总金额/元" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="租户账号" prop="zuhuzhanghao">
					<el-input v-model="ruleForm.zuhuzhanghao" placeholder="租户账号" clearable  :readonly="ro.zuhuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="租户账号" prop="zuhuzhanghao">
					<el-input v-model="ruleForm.zuhuzhanghao" placeholder="租户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="租户姓名" prop="zuhuxingming">
					<el-input v-model="ruleForm.zuhuxingming" placeholder="租户姓名" clearable  :readonly="ro.zuhuxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="租户姓名" prop="zuhuxingming">
					<el-input v-model="ruleForm.zuhuxingming" placeholder="租户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="签订时间" prop="qiandingshijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.qiandingshijian" 
						type="datetime"
						:readonly="ro.qiandingshijian"
						placeholder="签订时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.qiandingshijian" label="签订时间" prop="qiandingshijian">
					<el-input v-model="ruleForm.qiandingshijian" placeholder="签订时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0","justifyContent":"center","display":"flex"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao20" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao08" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui21" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				fangyuanmingcheng : false,
				dizhi : false,
				fangyuanleixing : false,
				fangyuanchengshi : false,
				fengmian : false,
				mianji : false,
				yuezu : false,
				yajin : false,
				dingjin : false,
				zongjine : false,
				zuhuzhanghao : false,
				zuhuxingming : false,
				shouji : false,
				qiandingshijian : false,
				ispay : false,
			},
			
			
			ruleForm: {
				fangyuanmingcheng: '',
				dizhi: '',
				fangyuanleixing: '',
				fangyuanchengshi: '',
				fengmian: '',
				mianji: '',
				yuezu: '',
				yajin: '',
				dingjin: '',
				zongjine: '',
				zuhuzhanghao: '',
				zuhuxingming: '',
				shouji: '',
				qiandingshijian: '',
			},
		

			
			rules: {
				fangyuanmingcheng: [
				],
				dizhi: [
				],
				fangyuanleixing: [
				],
				fangyuanchengshi: [
				],
				fengmian: [
				],
				mianji: [
				],
				yuezu: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				yajin: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				dingjin: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				zongjine: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				zuhuzhanghao: [
				],
				zuhuxingming: [
				],
				shouji: [
				],
				qiandingshijian: [
				],
				ispay: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {
		zongjine: {
			get: function () {
				return 0+parseFloat(this.ruleForm.yuezu==""?0:this.ruleForm.yuezu)+parseFloat(this.ruleForm.yajin==""?0:this.ruleForm.yajin)+parseFloat(this.ruleForm.dingjin==""?0:this.ruleForm.dingjin) || 0
			}
		},



	},
    components: {
    },
	created() {
		this.ruleForm.qiandingshijian = this.getCurDateTime()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='fangyuanmingcheng'){
							this.ruleForm.fangyuanmingcheng = obj[o];
							this.ro.fangyuanmingcheng = true;
							continue;
						}
						if(o=='dizhi'){
							this.ruleForm.dizhi = obj[o];
							this.ro.dizhi = true;
							continue;
						}
						if(o=='fangyuanleixing'){
							this.ruleForm.fangyuanleixing = obj[o];
							this.ro.fangyuanleixing = true;
							continue;
						}
						if(o=='fangyuanchengshi'){
							this.ruleForm.fangyuanchengshi = obj[o];
							this.ro.fangyuanchengshi = true;
							continue;
						}
						if(o=='fengmian'){
							this.ruleForm.fengmian = obj[o];
							this.ro.fengmian = true;
							continue;
						}
						if(o=='mianji'){
							this.ruleForm.mianji = obj[o];
							this.ro.mianji = true;
							continue;
						}
						if(o=='yuezu'){
							this.ruleForm.yuezu = obj[o];
							this.ro.yuezu = true;
							continue;
						}
						if(o=='yajin'){
							this.ruleForm.yajin = obj[o];
							this.ro.yajin = true;
							continue;
						}
						if(o=='dingjin'){
							this.ruleForm.dingjin = obj[o];
							this.ro.dingjin = true;
							continue;
						}
						if(o=='zongjine'){
							this.ruleForm.zongjine = obj[o];
							this.ro.zongjine = true;
							continue;
						}
						if(o=='zuhuzhanghao'){
							this.ruleForm.zuhuzhanghao = obj[o];
							this.ro.zuhuzhanghao = true;
							continue;
						}
						if(o=='zuhuxingming'){
							this.ruleForm.zuhuxingming = obj[o];
							this.ro.zuhuxingming = true;
							continue;
						}
						if(o=='shouji'){
							this.ruleForm.shouji = obj[o];
							this.ro.shouji = true;
							continue;
						}
						if(o=='qiandingshijian'){
							this.ruleForm.qiandingshijian = obj[o];
							this.ro.qiandingshijian = true;
							continue;
						}
				}
				















			}
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.zuhuzhanghao!=''&&json.zuhuzhanghao) || json.zuhuzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.zuhuzhanghao = json.zuhuzhanghao
						this.ro.zuhuzhanghao = true;
					}
					if(((json.zuhuxingming!=''&&json.zuhuxingming) || json.zuhuxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.zuhuxingming = json.zuhuxingming
						this.ro.zuhuxingming = true;
					}
					if(((json.shouji!=''&&json.shouji) || json.shouji==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shouji = json.shouji
						this.ro.shouji = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `zulinxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
        this.ruleForm.zongjine = this.zongjine





	if(this.ruleForm.fengmian!=null) {
		this.ruleForm.fengmian = this.ruleForm.fengmian.replace(new RegExp(this.$base.url,"g"),"");
	}











var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "zulinxinxi/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `zulinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.zulinxinxiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `zulinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.zulinxinxiCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.zulinxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    fengmianUploadChange(fileUrls) {
	    this.ruleForm.fengmian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #9E9E9E;
	  	  font-weight: 500;
	  	  width: 160px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 160px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #C8C8C8;
	  	  border-radius: 0;
	  	  padding: 0 12px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border: 2px solid #C8C8C8;
	  	  border-radius: 0;
	  	  padding: 0 12px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #C8C8C8;
	  	  border-radius: 0;
	  	  padding: 0 10px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #C8C8C8;
	  	  border-radius: 0;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 2px solid #C8C8C8;
	  	  cursor: pointer;
	  	  border-radius: 0;
	  	  color: #000;
	  	  width: 100px;
	  	  font-size: 60px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px solid #C8C8C8;
	  	  cursor: pointer;
	  	  border-radius: 0;
	  	  color: #000;
	  	  width: 100px;
	  	  font-size: 60px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px solid #C8C8C8;
	  	  cursor: pointer;
	  	  border-radius: 0;
	  	  color: #000;
	  	  width: 100px;
	  	  font-size: 60px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #C8C8C8;
	  	  border-radius: 0;
	  	  padding: 12px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #46372E;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.5;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #46372E;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.5;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #46372E;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.5;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #46372E;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.5;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #46372E;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.5;
			}
</style>
