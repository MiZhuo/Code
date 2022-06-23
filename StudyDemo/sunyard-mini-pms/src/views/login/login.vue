<template>
    <el-form :rules = "rules" class="login_content" :model="loginForm" ref="loginForm" label-width="0px" v-loading="loading" style="align-items: center">
      <h3 class="login_title">sunyard-项目管理系统</h3>
      <el-form-item prop="loginName">
        <el-input type="text" v-model="loginForm.loginName" auto-complete="off" placeholder="请输入用户名">
          <span slot="prefix">
            <svg-icon icon-class="user" class="color-main" style="color: #409EFF;"></svg-icon>
          </span>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input :type="pwdType" @keyup.enter.native="submitClick" v-model="loginForm.password" auto-complete="off" placeholder="请输入密码">
          <span slot="prefix">
            <svg-icon icon-class="password" class="color-main" style="color: #409EFF;"></svg-icon>
          </span>
          <span slot="suffix" @click="showPwd">
            <svg-icon icon-class="eye" class="color-main" style="color: #409EFF;"></svg-icon>
          </span>
        </el-input>
      </el-form-item>
      <el-checkbox class="login_remember" v-model="checked" label-position="left">记住密码</el-checkbox>
      <el-form-item style="margin-bottom: 60px;text-align: center">
        <el-button type="primary" style="width: 100%" @click="submitClick">立即登录</el-button>
      </el-form-item>
    </el-form>
</template>
<script>
  import {isvalidUsername} from '@/utils/validate';
  import {getCookie, setCookie} from "../../utils/support";
  export default{
      data() {
          const validateUsername = (rule, value, callback) => {
              /*if (!isvalidUsername(value)) {
                  callback(new Error('请输入正确的用户名'))
              } else {
                  callback()
              }*/
          };
          const validatePass = (rule, value, callback) => {
              if (value.length < 3) {
                  callback(new Error('密码不能小于3位'))
              } else {
                  callback()
              }
          };
          return {
             rules: {
                 loginName: [{required: true,trigger:'blur',validator: validateUsername}],
                 password: [{required: true,trigger:'blur',validator: validatePass}]
             },
              loginForm:{
                 loginName: '',
                 password: ''
              },
              checked: true,
              loading: false,
              pwdType: 'password'
          }
      },
      created() {
          this.loginForm.loginName = getCookie("loginName");
          this.loginForm.password = getCookie("password");
          if(this.loginForm.loginName === undefined||this.loginForm.loginName==null||this.loginForm.loginName===''){
              this.loginForm.loginName = '';
          }
          if(this.loginForm.password === undefined||this.loginForm.password==null){
              this.loginForm.password = '';
          }
      },
      methods:{
          showPwd: function(){
              let _this = this;
              if (_this.pwdType === 'password') {
                  _this.pwdType = ''
              } else {
                  _this.pwdType = 'password'
              }
          },
          submitClick: function () {
              let _this = this;
              _this.$refs.loginForm.validate(valid=>{
                  if(valid){
                      _this.loading = true;
                      _this.$store.dispatch('Login', _this.loginForm).then(() => {
                          _this.loading = false;
                          setCookie("loginName",_this.loginForm.loginName,15);
                          setCookie("password",_this.loginForm.password,15);
                          _this.$router.push({path: ''})
                      }).catch(() => {
                          _this.loading = false;
                          _this.$router.push({path: '/home'})
                      })
                  } else {
                      console.log('参数验证不合法！');
                      return false
                  }
              })
          }
      }
  }
</script>

<style>
  .login_content {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    position: absolute;
    left: 0;
    right: 0;
    width: 280px;
    border-top: 10px solid #409EFF;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .login_remember {
    margin: 0px 0px 20px 100px;
    text-align: left;
  }
</style>
