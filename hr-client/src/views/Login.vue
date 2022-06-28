<template>
  <div>
      <el-form :rules="rules" :model="loginForm" ref="loginForm" class="loginContainer">
          <h3 class="loginTitle">系统登录</h3>
          <el-form-item prop="username">
              <el-input type="text" v-model="loginForm.username" placeholder="请输入用户名" prefix-icon="el-icon-user" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item prop="password">
              <el-input type="password" v-model="loginForm.password" placeholder="请输入密码" prefix-icon="el-icon-lock" auto-complete="off"
                    @keydown.enter.native="submitLogin"></el-input>
          </el-form-item>
          <el-form-item prop="captcha">
              <img :src="captchaImg" width="100px" height="30px" @click="initCaptcha"/>
              <el-input type="text" v-model="loginForm.captcha" placeholder="请输入验证码" prefix-icon="el-icon-view" auto-complete="off" style="width: 130px;float: right"></el-input>
          </el-form-item>
          <el-checkbox class="loginRemember" v-model="checked">记住密码</el-checkbox>
          <el-button type="primary" style="width:100%" :loading="this.loading" @click="submitLogin">{{loginBtnText}}</el-button>
      </el-form>r
  </div>
</template> 

<script>
    export default {
        name : "Login",
        data(){
            return{
                loginForm:{
                    username:'admin',
                    password:'123',
                    captcha:'',
                    captchaKey:''
                },
                checked:true,
                rules:{
                    username:[{required:true,message:'请输入用户名',trigger:'blur'}],
                    password:[{required:true,message:'请输入密码',trigger:'blur'}],
                    captcha:[{required:true,message:'请输入验证码',trigger:'blur'}]
                },
                loading: false,
                loginBtnText: '登录',
                captchaImg:""
            }
        },
        methods:{
            submitLogin(){
                this.$refs.loginForm.validate((valid)=>{
                    if(valid){
                        this.loading = true;
                        this.loginBtnText = '正在登录...';
                        this.postKeyValueRequest('/doLogin',this.loginForm).then(resp=>{
                            if(resp){
                                this.$store.commit('INIT_CURRENT_HR',resp.result);
                                window.sessionStorage.setItem("user",JSON.stringify(resp.result));
                                let path = this.$route.query.redirect;
                                this.$router.replace((path == '/' || path == undefined) ? '/home' : path);
                            }else{
                                this.loading = false;
                                this.loginBtnText = '登录';
                                this.loginForm.captcha = '';
                                this.initCaptcha();
                            }
                        });
                    }else{
                        return false;
                    }
                });
            },
            initCaptcha(){
                this.getRequest("/auth/captcha").then((resp)=>{
                    if(resp){
                        this.captchaImg = resp.result.img;
                        this.loginForm.captchaKey = resp.result.captchaKey;
                    }
                });
            }
        },
        created() {
            this.initCaptcha();
        }
    }
</script>

<style>
    .loginContainer{
        border-radius: 15px;
        background-clip: padding-box;
        margin: 180px auto;
        width: 250px;
        padding: 25px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    .loginTitle{
        margin: 0px auto 20px auto;
        text-align: center;
        color: #505458;
    }
    .loginRemember{
        text-align: left;
        margin: 0px 0px 15px 0px;
    }
</style>