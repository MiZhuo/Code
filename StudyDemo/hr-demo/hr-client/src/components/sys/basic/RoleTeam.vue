<template>
    <div>
        <div class="role_input_div">
            <el-input size="mini" placeholder="请输入角色英文名" v-model="role.name">
                <template slot="prepend">ROLE_</template>
            </el-input>
            <el-input size="mini" placeholder="请输入角色中文名" v-model="role.nameZh"
                @keydown.enter.native="addRole"></el-input>
            <el-button type="primary" size="mini"
                       icon="el-icon-plus" style="margin-left: 10px" @click="addRole">添加角色
            </el-button>
        </div>
        <div class="role_info_div">
            <el-collapse v-model="activeName" accordion @change="changeRoleMenu">
                <el-collapse-item :title="role.nameZh" :name="role.id" v-for="(role,index) in roles">
                    <el-card class="box-card" shadow="hover">
                        <div slot="header" class="clearfix">
                            <span>可访问资源</span>
                            <el-button style="float: right; padding: 3px 0;color:red"
                                       icon="el-icon-delete" type="text" @click="deleteRole(role.id,role.nameZh)"></el-button>
                        </div>
                        <div>
                            <el-tree
                                :data="menuTreeData"
                                show-checkbox
                                node-key="id"
                                :key="index"
                                :default-checked-keys="checkedMenu"
                                ref="menuTree"
                                :props="menuTreeProps">
                            </el-tree>
                            <div class="treeBtnClass">
                                <el-button size="mini" @click="cancelUpdate">取消修改</el-button>
                                <el-button type="primary" size="mini" @click="updateRoleMenu(role.id,index)">确认修改</el-button>
                            </div>
                        </div>
                    </el-card>
                </el-collapse-item>
            </el-collapse>
        </div>
    </div>
</template>

<script>
    export default {
        name: "RoleTeam",
        data(){
            return{
                role:{},
                roles:[],
                activeName: -1,
                menuTreeData:[],
                menuTreeProps: {
                    children: 'children',
                    label: 'name'
                },
                checkedMenu:[]
            }
        },
        methods:{
            initRoles(){
                this.getRequest("/system/basic/roleTeam/").then(res=>{
                    if(res) {
                        this.roles = res.result;
                    }
                });
            },
            initMenuTreeData(){
                this.getRequest("/system/basic/roleTeam/menuTree").then(res=>{
                    if(res) {
                        this.menuTreeData = res.result;
                    }
                });
            },
            initMenuTreeChecked(roleId){
                this.getRequest("/system/basic/roleTeam/menuTree/checked/" + roleId).then(res=>{
                    if(res) {
                        this.checkedMenu = res.result;
                    }
                });
            },
            addRole(){
                if(this.role.name && this.role.nameZh){
                    this.postRequest("/system/basic/roleTeam/",this.role).then(res => {
                        if (res) {
                            this.initRoles();
                            this.role = {};
                        }
                    })
                }else {
                    this.$message.error("角色中文名或英文名不能为空!");
                }
            },
            deleteRole(roleId,roleNameZh){
                this.$confirm('此操作将永久删除【'+ roleNameZh +'】权限, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(()=>{
                    this.deleteRequest("/system/basic/roleTeam/" + roleId).then(res=>{
                        if(res){
                            this.initRoles();
                        }
                    });
                });
            },
            changeRoleMenu(roleId){
                if(roleId){
                    this.initMenuTreeData();
                    this.initMenuTreeChecked(roleId);
                }
            },
            cancelUpdate(){
                this.activeName = -1;
            },
            updateRoleMenu(roleId,index){
                let chooseTree = this.$refs.menuTree[index];
                //true 则只返回被选中的叶子节点，false会返回所有被选中的节点，默认false
                let checkedMenu = chooseTree.getCheckedKeys(true);
                console.log(checkedMenu);
                if(!checkedMenu.length){
                    this.$confirm('是否取消该角色所有访问资源权限?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(()=>{
                        this.putRequest("/system/basic/roleTeam/modify/menu/" + roleId,checkedMenu).then(res=>{
                            this.activeName = -1;
                        });
                    });
                }else{
                    this.putRequest("/system/basic/roleTeam/modify/menu/" + roleId,checkedMenu).then(res=>{
                        this.activeName = -1;
                    });
                }
            }
        },
        mounted() {
            this.initRoles();
        }
    }
</script>

<style>
.role_input_div .el-input{
    width: 250px;
    margin-right: 7px;
}

.role_info_div{
    margin-top: 10px;
    width: 600px
}
.treeBtnClass{
    /*float: right;*/
    /*margin-bottom: 8px;*/
    display: flex;
    justify-content: flex-end;
}
</style>