<template>
    <div class="userSign" style="background:#999">
        <img src="../../assets/imgs/loginBg.jpg">
       
       <div class="formArea">
       <el-tabs type="border-card" style="height:100%;">
            <el-tab-pane label="用户登录">
                <el-form :model="loginRuleForm" :rules="loginRules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="loginRuleForm.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model="loginRuleForm.password"></el-input>
                    </el-form-item>
                    <el-button type="primary" @click="login">登录</el-button>
                </el-form>
            </el-tab-pane>
            <el-tab-pane label="注册账号">
                <el-form :model="registerRuleForm" :rules="registerRules" ref="registerRuleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="registerRuleForm.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model="registerRuleForm.password"></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="passwordConfirm">
                        <el-input type="password" v-model="registerRuleForm.passwordConfirm"></el-input>
                    </el-form-item>
                    <el-button type="primary">注册</el-button>
                </el-form>
            </el-tab-pane>
        </el-tabs>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.registerRuleForm.passwordConfirm !== '') {
            this.$refs.ruleForm2.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm2.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
        return{
            loginRuleForm:{
                username:'',
                password:''
            },
            registerRuleForm:{
                username:'',
                password:'',
                passwordConfirm:''
            },
            loginRules:{
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' }
                ],  
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' }
                ]
            },
            registerRules:{
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' }
                ],  
                password: [
                    { validator: validatePass, trigger: 'blur' }
                ],
                passwordConfirm: [
                    { validator: validatePass2, trigger: 'blur' }
                ]
            },
            
        };
    },
    methods:{
        //用户登录
        login(){
            //组装参数
            // var params = {
            //     loginid : this.loginRuleForm.username,
            //     password : this.loginRuleForm.password
            // };
            var params = new URLSearchParams();
            params.append('loginid', this.loginRuleForm.username);
            params.append('password', this.loginRuleForm.password);
            //发送后台请求
             this.$axios({method:'post',url: 'http://localhost:8082/user/login', data: params}).then(
                 response =>{
                     if(response.status == 200){
                         //请求成功
                         var xm_temp = response.data[0].xm;
                         var userBh_temp = response.data[0].bh;
                         this.$router.push({
                             name:'main',
                             params:{
                                 xm: xm_temp,
                                 userBh: userBh_temp
                             }
                        });//跳转到主页

                     }else{
                         //请求失败
                     }
                 }
             );
        }
    }
}
</script>
<style scope>
    .userSign{
			width: 100%;
			height: 100%;
			overflow: hidden;
		}
        .formArea{
			width: 500px;
			height: 300px;
			position: fixed;
			top: 200px;
			right: 200px;
            background-color: rgba(255,255,255,0.6);
			/*border-radius: 20px;*/
		}
        .toggle{
			width: 100%;
			height: 50px;
			border-bottom: 1px solid #ccc;
			border-collapse: collapse;
			box-sizing: border-box;
		}
		.toggle ul{
			width: 100%;
			height: 50px;
		}
		.toggle li{
			display: block;
			width: 50%;
			list-style: none;
			float: left;
			text-align: center;
			height: 50px;
            line-height: 50px;
		}
        .loginArea{
			width: 100%;
			margin-top: 10px;
            text-align: center;	
		}
        .loginArea input{
			border:none;
			outline: none;
			width: 80%;
			height: 30px;
			border:1px solid #ccc;
			border-radius: 5px;
			margin-top: 10px;
            padding-left:10px;
		}
        .registerArea{
            width: 100%;
			margin-top: 10px;
            text-align: center;
        }
        .registerArea input{
            border:none;
			outline: none;
			width: 80%;
			height: 30px;
			border:1px solid #ccc;
			border-radius: 5px;
			margin-top: 10px;
            padding-left:10px;
        }
        .btn{
			width: 150px;
			height: 30px;
			background-color: #fc0;
			border-radius: 5px;
			text-align: center;
			line-height: 30px;
			cursor: pointer;
			color: #fff;
            margin:auto;
			margin-top: 20px;
		}
</style>
