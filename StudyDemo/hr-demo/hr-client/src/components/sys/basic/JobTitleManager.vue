<template>
    <div>
        <div>
            <el-input placeholder="添加职称..." size="mini" style="width: 200px"
                      prefix-icon="el-icon-plus" v-model="jobTitle.name" @keydown.enter.native="addJobTitle">
            </el-input>
            <el-select v-model="jobTitle.titleLevel" style="margin-left: 10px"  placeholder="请选择职称等级" size="mini">
                <el-option
                        v-for="item in titleLevels"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
            <el-button type="primary" size="mini"
                       icon="el-icon-plus" style="margin-left: 10px" @click="addJobTitle">添加
            </el-button>
        </div>
        <div style="margin-top: 10px">
            <el-table :data="jobTitleData" size="mini" class="component-table"
                      border stripe style="width: 65%"
                      :header-cell-style="getTableStyle"
                      :cell-style="getTableStyle"
                      @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="40"></el-table-column>
                <el-table-column prop="id" label="编号" width="60"></el-table-column>
                <el-table-column prop="name" label="职称名称" width="100"></el-table-column>
                <el-table-column prop="titleLevel" label="职称等级" width="100"></el-table-column>
                <el-table-column label="创建日期" width="130">
                    <template slot-scope="scope">
                        <i class="el-icon-time"></i>
                        <span style="margin-left: 10px">{{ scope.row.createDate }}</span>
                    </template>
                </el-table-column>
                <el-table-column prop="enabled" label="是否启用" width="80">
                    <template slot-scope="scope">
                        <el-switch
                                v-model="scope.row.enabled"
                                active-color="#13ce66"
                                inactive-color="#ff4949"
                                :active-value="true"
                                :inactive-value="false"
                                @change="handleEnabledChange(scope.row)">
                        </el-switch>
                    </template>
                </el-table-column>
                <el-table-column prop="opera" label="操作">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-button size="mini" type="danger" :disabled="batchBtnDisabled" style="margin-top:10px" @click="batchDelete">批量删除</el-button>
        </div>
        <el-dialog title="编辑职位" :visible.sync="dialogFormVisible">
            <el-form v-model="jobTitleForm" style="text-align: center">
                <el-form-item>
                    <el-tag type="info">职位编号</el-tag>
                    <el-input class="jobTitleInput" size="mini" v-model="jobTitleForm.id" disabled></el-input>
                </el-form-item>
                <el-form-item>
                    <el-tag>职称名称</el-tag>
                    <el-input class="jobTitleInput" size="mini" v-model="jobTitleForm.name"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-tag>职称等级</el-tag>
                    <el-select v-model="jobTitleForm.titleLevel" class="jobTitleInput" placeholder="请选择职称等级" size="mini">
                        <el-option
                                v-for="item in titleLevels"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-tag type="info">创建时间</el-tag>
                    <el-input class="jobTitleInput" size="mini" v-model="jobTitleForm.createDate" disabled></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button size="mini" @click="dialogFormVisible = false">取 消</el-button>
                <el-button size="mini" type="primary" @click="updateJobTitle">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "JobTitleManager",
        data(){
            return {
                jobTitle:{
                    name : ""
                },
                dialogFormVisible: false,
                jobTitleData:[],
                jobTitleForm:{
                    id : "",
                    name : "",
                    titleLevel : "",
                    enabled: "",
                    createDate : ""
                },
                batchBtnDisabled: true,
                multipleSelection: [],
                titleLevels:[{
                    value: '员级',
                    label: '员级'
                },{
                    value: '初级',
                    label: '初级'
                }, {
                    value: '中级',
                    label: '中级'
                }, {
                    value: '副高级',
                    label: '副高级'
                }, {
                    value: '正高级',
                    label: '正高级'
                }]
            }
        },
        methods:{
            initJobTitleTable(){
                this.getRequest("/system/basic/jobTitle/").then(res=>{
                    if(res){
                        this.jobTitleData = res.result;
                    }
                })
            },
            addJobTitle(){
                if(this.jobTitle.name && this.jobTitle.titleLevel){
                    this.postRequest("/system/basic/jobTitle/",this.jobTitle).then(()=>{
                        this.initJobTitleTable();
                        this.jobTitle.name = "";
                        this.jobTitle.titleLevel = "";
                    });
                }else{
                    this.$message.error("职称名称或职称等级不能为空!");
                }
            },
            updateJobTitle(){
                this.putRequest("/system/basic/jobTitle/",this.jobTitleForm).then(()=>{
                    this.dialogFormVisible = false;
                    this.initJobTitleTable();
                })
            },
            handleEdit(index,row){
                Object.assign(this.jobTitleForm,row);
                this.dialogFormVisible = true;
            },
            handleDelete(index,row){
                this.$confirm('此操作将永久删除【'+ row.name +'】职称, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/system/basic/jobTitle/" + row.id).then(()=>{
                        this.initJobTitleTable();
                    });
                });
            },
            handleSelectionChange(val){
                this.multipleSelection = val;
                if(this.multipleSelection.length > 0){
                    this.batchBtnDisabled = false;
                }else{
                    this.batchBtnDisabled = true;
                }
            },
            batchDelete(){
                this.$confirm('此操作将永久删除所有所选职位, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/system/basic/jobTitle/deleteMore",this.multipleSelection).then(()=>{
                        this.initJobTitleTable();
                    });
                });
            },
            handleEnabledChange(row){
                this.putRequest("/system/basic/jobTitle/" + row.id + "/" + row.enabled);
            },
            getTableStyle(){
                return 'text-align:center';
            }
        },
        mounted() {
            this.initJobTitleTable();
        }
    }
</script>

<style scoped>
    .jobTitleInput{
        width: 300px;
        margin-left: 10px;
    }
</style>