<template>
    <div>
        <div class="hrDivClass">
            <el-input size="mini" placeholder="搜索用户" v-model="keyWord"
                      style="width: 300px" prefix-icon="el-icon-search"
                      @keydown.enter.native="searchHr"></el-input>
            <el-button type="primary" size="mini"
                       icon="el-icon-search" style="margin-left: 10px" @click="searchHr">搜索
            </el-button>
        </div>
        <div v-loading="loading" element-loading-text="加载中...">
            <el-row v-for="(item,index1) in hrs">
                <el-col :span="8" v-for="(hr,index2) in item" :key="index1">
                    <el-card class="box-card" :key="index2">
                        <div slot="header" class="clearfix">
                            <span>{{hr.name}}</span>
                            <el-button style="float: right; padding: 3px 0;color: red" type="text"
                                       icon="el-icon-delete" @click="deleteHr(hr.id,index1,index2)"></el-button>
                        </div>
                        <div class="hrDivClass">
                            <el-avatar :size="70" :src="hr.userFace"></el-avatar>
                        </div>
                        <div class="hrContent">
                           <table>
                               <tr>
                                   <td>
                                       <span>用户名: {{hr.name}}</span>
                                   </td>
                               </tr>
                               <tr>
                                   <td>
                                       <span>电话号码: {{hr.telephone}}</span>
                                   </td>
                               </tr>
                               <tr>
                                   <td>
                                       <span>手机号码: {{hr.phone}}</span>
                                   </td>
                               </tr>
                               <tr>
                                   <td>
                                       <span>地址: {{hr.address}}</span>
                                   </td>
                               </tr>
                               <tr>
                                   <td>
                                       <span>用户状态:
                                           <el-switch
                                                   v-model="hr.enabled"
                                                   active-text="启用"
                                                   inactive-text="禁用"
                                                   active-color="#13ce66"
                                                   inactive-color="#ff4949"
                                                   @change="handleEnabledChange(hr.id,hr.enabled)">
                                            </el-switch>
                                       </span>
                                   </td>
                               </tr>
                               <tr>
                                   <td>
                                       <span>用户角色:
                                           <el-tag size="mini"
                                                   v-for="(role,index3) in hr.roles"
                                                   v-if="index3 <= 1"
                                                   style="margin-right: 4px"
                                                   type="success">{{role.nameZh}}
                                           </el-tag>
                                           <el-popover
                                                   v-if="hr.roles.length > 2"
                                                   placement="bottom-start"
                                                   title=""
                                                   width="200"
                                                   trigger="hover">
                                               <el-tag size="mini"
                                                       v-for="(role,index4) in hr.roles.slice(2,hr.roles.length)"
                                                       style="margin-right: 4px;margin-bottom: 4px"
                                                       type="success">{{role.nameZh}}
                                                    </el-tag>
                                                <el-button slot="reference" icon="el-icon-more"
                                                           type="text" size="mini"></el-button>
                                           </el-popover>
                                           <el-popover
                                                   placement="bottom"
                                                   title="角色列表"
                                                   width="250"
                                                   trigger="click"
                                                   @hide="updateRolesById(hr.id,index1,index2)">
                                                <el-select v-model="chooseRoles" multiple placeholder="请选择" style="width: 250px">
                                                    <el-option
                                                            v-for="item in roleList"
                                                            :key="item.id"
                                                            :label="item.nameZh"
                                                            :value="item.id">
                                                    </el-option>
                                                </el-select>
                                                <el-button slot="reference" icon="el-icon-edit" style="margin-left: 10px"
                                                           type="text" size="mini" @click="toChooseRoles(hr.roles)"></el-button>
                                           </el-popover>
                                       </span>
                                   </td>
                               </tr>
                               <tr>
                                   <td>
                                       <span>备注: {{hr.remark}}</span>
                                   </td>
                               </tr>
                           </table>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
    export default {
        name: "SysHr",
        data(){
            return{
                keyWord:'',
                hrs:[],
                chooseRoles:[],
                chooseRolesTmp: [],
                roleList:[],
                loading: true
            }
        },
        methods:{
            initHrs(){
                this.getRequest('/system/hr/').then(res=>{
                    if(res){
                        this.loading = false;
                        let hrRes = res.result;
                        this.hrs2hrsArr(hrRes);
                    }
                });
            },
            hrs2hrsArr(hrRes){
                this.hrs = [];
                let index =0;
                let count = 3;
                for(let i = 0;i < hrRes.length;i++){
                    index = parseInt(i/count);
                    if (this.hrs.length <= index) {
                        this.hrs.push([]);
                    }
                    this.hrs[index].push(hrRes[i])
                }
            },
            initRoleList(){
                this.getRequest('/system/hr/roleList').then(res=>{
                    if(res){
                        this.roleList = res.result;
                    }
                });
            },
            toChooseRoles(roles){
                this.chooseRoles = [];
                roles.forEach(r=>{
                    this.chooseRoles.push(r.id);
                })
                this.chooseRolesTmp = this.chooseRoles;
            },
            handleEnabledChange(id,enabled){
                this.putRequest('/system/hr/' + id + '/' + enabled);
            },
            updateRolesById(id,index1,index2){
                if(this.chooseRolesTmp != this.chooseRoles) {
                    this.putRequest('/system/hr/' + id, this.chooseRoles).then(res => {
                        if (res) {
                            this.hrs[index1][index2].roles = res.result;
                        }
                    });
                }
            },
            searchHr(){
                this.getRequest('/system/hr/' + this.keyWord).then(res=>{
                    if(res){
                        let hrRes = res.result;
                        this.hrs2hrsArr(hrRes);
                    }
                });
            },
            deleteHr(id,index1,index2){
                this.$confirm('此操作将永久删除操作员【'+ this.hrs[index1][index2].name +'】, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/system/hr/" + id).then(res=>{
                        if(res){
                            this.hrs = [];
                            this.initHrs();
                        }
                    });
                });
            }
        },
        mounted() {
            this.initHrs();
            this.initRoleList();
        }
    }
</script>

<style>
.hrDivClass{
    text-align: center;
    margin-bottom: 10px;
}
.box-card{
    margin-right: 25px;
    margin-bottom: 20px;
    height: 350px;
}
.hrContent{
    font-size: 8px;
    color: coral;
}
.el-switch__label *{
    font-size: 5px;
}
.el-popover__title{
    font-size: 5px;
}
</style>