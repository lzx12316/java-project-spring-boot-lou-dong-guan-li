<template>
<div :style='{"width":"100%","padding":"20px 10%","margin":"20px auto","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"width":"100%","position":"relative"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="150px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="房源名称" prop="fangyuanmingcheng">
            <el-input v-model="ruleForm.fangyuanmingcheng" 
                placeholder="房源名称" clearable :disabled=" false  ||ro.fangyuanmingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="地址" prop="dizhi">
            <el-input v-model="ruleForm.dizhi" 
                placeholder="地址" clearable :disabled=" false  ||ro.dizhi"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="房源城市" prop="fangyuanchengshi">
            <el-select v-model="ruleForm.fangyuanchengshi" placeholder="请选择房源城市" :disabled=" false  ||ro.fangyuanchengshi" >
              <el-option
                  v-for="(item,index) in fangyuanchengshiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="状态" prop="zhuangtai">
            <el-select v-model="ruleForm.zhuangtai" placeholder="请选择状态" :disabled=" false  ||ro.zhuangtai" >
              <el-option
                  v-for="(item,index) in zhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="面积/㎡" prop="mianji">
            <el-input v-model="ruleForm.mianji" 
                placeholder="面积/㎡" clearable :disabled=" false  ||ro.mianji"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="月租/元" prop="yuezu">
			<el-input-number v-model="ruleForm.yuezu" placeholder="月租/元" :readonly="ro.yuezu"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="定金/元" prop="dingjin">
			<el-input-number v-model="ruleForm.dingjin" placeholder="定金/元" :readonly="ro.dingjin"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="押金/元" prop="yajin">
			<el-input-number v-model="ruleForm.yajin" placeholder="押金/元" :readonly="ro.yajin"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="朝向" prop="chaoxiang">
            <el-input v-model="ruleForm.chaoxiang" 
                placeholder="朝向" clearable :disabled=" false  ||ro.chaoxiang"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="封面" v-if="type!='cross' || (type=='cross' && !ro.fengmian)" prop="fengmian">
            <file-upload
            tip="点击上传封面"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
            @change="fengmianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' class="upload" v-else label="封面" prop="fengmian">
                <img v-if="ruleForm.fengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fengmian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fengmian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="房源类型" prop="fangyuanleixing">
            <el-select v-model="ruleForm.fangyuanleixing" placeholder="请选择房源类型" :disabled=" false  ||ro.fangyuanleixing" >
              <el-option
                  v-for="(item,index) in fangyuanleixingOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="联系电话" prop="lianxidianhua">
            <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" clearable :disabled=" false  ||ro.lianxidianhua"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="配套详情" prop="peitaoxiangqing">
            <editor 
                :style='{"minHeight":"300px","padding":"0","boxShadow":"0 0 6px #E2E3E5","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.peitaoxiangqing" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#75664D","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #75664D","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#75664D","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				fangyuanmingcheng : false,
				dizhi : false,
				fangyuanchengshi : false,
				zhuangtai : false,
				mianji : false,
				yuezu : false,
				dingjin : false,
				yajin : false,
				chaoxiang : false,
				fengmian : false,
				fangyuanleixing : false,
				lianxidianhua : false,
				peitaoxiangqing : false,
				clicktime : false,
				clicknum : false,
				discussnum : false,
				storeupnum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          fangyuanmingcheng: '',
          dizhi: '',
          fangyuanchengshi: '',
          zhuangtai: '待租' ,
          mianji: '',
          yuezu: '',
          dingjin: '',
          yajin: '',
          chaoxiang: '',
          fengmian: '',
          fangyuanleixing: '',
          lianxidianhua: '',
          peitaoxiangqing: '',
          clicktime: '',
          clicknum: '',
          discussnum: '',
          storeupnum: '',
        },
        fangyuanchengshiOptions: [],
        zhuangtaiOptions: [],
        fangyuanleixingOptions: [],


        rules: {
          fangyuanmingcheng: [
          ],
          dizhi: [
          ],
          fangyuanchengshi: [
          ],
          zhuangtai: [
          ],
          mianji: [
          ],
          yuezu: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          dingjin: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          yajin: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          chaoxiang: [
          ],
          fengmian: [
          ],
          fangyuanleixing: [
          ],
          lianxidianhua: [
          ],
          peitaoxiangqing: [
          ],
          clicktime: [
          ],
          clicknum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          discussnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          storeupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
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
            if(o=='fangyuanchengshi'){
              this.ruleForm.fangyuanchengshi = obj[o];
              this.ro.fangyuanchengshi = true;
              continue;
            }
            if(o=='zhuangtai'){
              this.ruleForm.zhuangtai = obj[o];
              this.ro.zhuangtai = true;
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
            if(o=='dingjin'){
              this.ruleForm.dingjin = obj[o];
              this.ro.dingjin = true;
              continue;
            }
            if(o=='yajin'){
              this.ruleForm.yajin = obj[o];
              this.ro.yajin = true;
              continue;
            }
            if(o=='chaoxiang'){
              this.ruleForm.chaoxiang = obj[o];
              this.ro.chaoxiang = true;
              continue;
            }
            if(o=='fengmian'){
              this.ruleForm.fengmian = obj[o].split(",")[0];
              this.ro.fengmian = true;
              continue;
            }
            if(o=='fangyuanleixing'){
              this.ruleForm.fangyuanleixing = obj[o];
              this.ro.fangyuanleixing = true;
              continue;
            }
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              this.ro.lianxidianhua = true;
              continue;
            }
            if(o=='peitaoxiangqing'){
              this.ruleForm.peitaoxiangqing = obj[o];
              this.ro.peitaoxiangqing = true;
              continue;
            }
            if(o=='clicktime'){
              this.ruleForm.clicktime = obj[o];
              this.ro.clicktime = true;
              continue;
            }
            if(o=='clicknum'){
              this.ruleForm.clicknum = obj[o];
              this.ro.clicknum = true;
              continue;
            }
            if(o=='discussnum'){
              this.ruleForm.discussnum = obj[o];
              this.ro.discussnum = true;
              continue;
            }
            if(o=='storeupnum'){
              this.ruleForm.storeupnum = obj[o];
              this.ro.storeupnum = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.lianxidianhua!=''&&json.lianxidianhua) || json.lianxidianhua==0){
                this.ruleForm.lianxidianhua = json.lianxidianhua            }
          }
        });
        this.$http.get('option/fangyuanchengshi/fangyuanchengshi', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.fangyuanchengshiOptions = res.data.data;
          }
        });
        this.zhuangtaiOptions = "已租,待租".split(',')
        this.$http.get('option/fangyuanleixing/fangyuanleixing', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.fangyuanleixingOptions = res.data.data;
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`fangyuanxinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('fangyuanxinxi/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`fangyuanxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`fangyuanxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
			this.$router.go(-1);
		},
      fengmianUploadChange(fileUrls) {
          this.ruleForm.fengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 150px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #75664D;
	  width: 220px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border: 1px solid #E2E3E5;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #75664D;
	  width: 220px;
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
	  border: 1px solid #E2E3E5;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #75664D;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #75664D;
	  width: 200px;
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
	  border: 1px solid #E2E3E5;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #75664D;
	  width: 80px;
	  font-size: 32px;
	  line-height: 80px;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #E2E3E5;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #75664D;
	  width: 80px;
	  font-size: 32px;
	  line-height: 80px;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #E2E3E5;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #75664D;
	  width: 80px;
	  font-size: 32px;
	  line-height: 80px;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #E2E3E5;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #75664D;
	  width: 400px;
	  font-size: 14px;
	  height: 150px;
	}
</style>
