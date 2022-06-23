<template>
    <div>
        <el-container>
            <el-header class="homeHeader">
                <div class="title">微人事</div>
                <div style="display:flex;justify-content: space-between">
                    <div>
                        <el-button icon="el-icon-bell" type="text" style="margin-right: 20px;font-size: 20px;color: #000000"
                            @click="openChat"></el-button>
                    </div>
                    <div>
                    <el-dropdown class="userInfo" @command="commandHandler">
                      <span class="el-dropdown-link">
                          <img :src="user.userFace">{{user.name}}
                          <i class="el-icon-arrow-down el-icon--right"></i>
                      </span>
                      <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="userInfo"><i class="el-icon-user-solid"></i>个人中心</el-dropdown-item>
                        <el-dropdown-item command="setting"><i class="el-icon-s-tools"></i>设置</el-dropdown-item>
                        <el-dropdown-item command="logout" divided><i class="el-icon-s-fold"></i>注销登录</el-dropdown-item>
                      </el-dropdown-menu>
                    </el-dropdown>
                </div>
                </div>
            </el-header>
        </el-container>
        <el-container>
            <el-aside width="200px">
                <el-menu router unique-opened>
                    <el-submenu :index="index + ''" v-for="(item,index) in routes" :key="index">  <!-- v-if="!item.hidden"-->
                        <template slot="title">
                            <i style="color: #409eff;margin-right: 5px" :class="item.iconCls"></i>
                            <span slot="title">{{item.name}}</span>
                        </template>
                        <el-menu-item :index="child.path" v-for="(child,indexj) in item.children" :key="indexj">{{child.name}}</el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-main>
                <el-breadcrumb separator-class="el-icon-arrow-right" v-if="this.$router.currentRoute.path!='/home'">
                    <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item>{{this.$router.currentRoute.name}}</el-breadcrumb-item>
                </el-breadcrumb>
                <div v-if="this.$router.currentRoute.path=='/home'">Welcome to hr!</div>
                <router-view class="homeRouterView"/>
            </el-main>
        </el-container>
        <el-dialog id="chatDialog" :visible.sync="dialogFormVisible">
            <div style="height: 100px">
                <Chat></Chat>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import Chat from "../components/common/Chat";

export default {
    name : "Home",
    components: {Chat},
    data(){
        return {
            user : JSON.parse(window.sessionStorage.getItem("user")),
            collapse : true,
            dialogFormVisible : false
        }
    },
    methods:{
        commandHandler(cmd){
            switch (cmd) {
                case "userInfo" : {
                    break;
                }
                case "setting" : {
                    break;
                }
                case "logout" : {
                    this.$confirm('是否退出登录?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        this.getRequest("/logout");
                        window.sessionStorage.removeItem("user");
                        this.$store.commit('initRoutes',[]);
                        this.$router.replace("/");
                    });
                    break;
                }
                default : {

                }
            }
        },
        menuClick(index){
            // this.$router.push(index);
            console.log(index);
        },
        openChat(){
            this.dialogFormVisible = true;
        }
    },
    computed:{
        routes(){
            return this.$store.state.routes;
        }
    },
    mounted:function() {
        this.$store.dispatch('connect');
    }
}
</script>

<style>
.homeRouterView{
    margin-top: 10px;
}
.homeHeader{
    background-color: #409eff;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0px 15px;
    box-sizing: border-box;
}

.homeHeader .title{
    font-size: 30px;
    font-family: 微软雅黑;
    color: white;
}

.homeHeader .userInfo{
    cursor: pointer;
}

.el-dropdown-link img{
    width : 38px;
    height: 38px;
    border-radius: 20px;
    margin-right: 8px;
}

.el-dropdown-link{
    display: flex;
    align-items: center;
}

#chatDialog .el-dialog__header{
    padding: 0;
}

#chatDialog .el-dialog__body{
    padding: 0;
}

</style>