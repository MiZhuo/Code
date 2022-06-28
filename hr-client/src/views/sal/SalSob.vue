<template>
    <div>
        <div>
            <div style="display:flex;justify-content: space-between">
                <el-button type="primary" size="mini"
                           icon="el-icon-plus" style="margin-left: 10px" @click="toAddSalSob">添加工资账套
                </el-button>
                <el-button type="success" size="mini"
                           icon="el-icon-refresh" style="margin-left: 10px" @click="refreshSalSob">
                </el-button>
            </div>
        </div>
        <div style="margin-top: 10px">
            <el-table :data="salSobData.list" size="mini" class="component-table"
                      border stripe
                      style="width: 100%;height: 100%"
                      max-height="500"
                      v-loading="loading"
                      element-loading-text="正在加载..."
                      :header-cell-style="getTableStyle"
                      :cell-style="getTableStyle"
                      @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="40"></el-table-column>
                <el-table-column prop="id" width="0" v-if="false"></el-table-column>
                <el-table-column prop="name" label="账套名称" width="120"></el-table-column>
                <el-table-column prop="basicSalary" label="基本工资" width="70"></el-table-column>
                <el-table-column prop="trafficSalary" label="交通补助" width="70"></el-table-column>
                <el-table-column prop="lunchSalary" label="午餐补助" width="70"></el-table-column>
                <el-table-column prop="bonus" label="奖金" width="70"></el-table-column>
                <el-table-column label="启用时间" width="120">
                    <template slot-scope="scope">
                        <i class="el-icon-time" ></i>
                        <span style="margin-left: 10px">{{ scope.row.createDate }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="养老金" align="center">
                    <el-table-column prop="pensionPer" label="比率" width="60"></el-table-column>
                    <el-table-column prop="pensionBase" label="基数" width="60"></el-table-column>
                </el-table-column>
                <el-table-column label="医疗保险" align="center">
                    <el-table-column prop="medicalPer" label="比率" width="60"></el-table-column>
                    <el-table-column prop="medicalBase" label="基数" width="60"></el-table-column>
                </el-table-column>
                <el-table-column label="公积金" align="center">
                    <el-table-column prop="accumulationFundPer" label="比率" width="60"></el-table-column>
                    <el-table-column prop="accumulationFundBase" label="基数" width="60"></el-table-column>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                style="padding: 3px"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                style="padding: 3px"
                                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <div style="margin-top: 10px">
            <el-button size="mini" type="danger" :disabled="batchBtnDisabled" style="margin-top:10px" @click="batchDelete">批量删除</el-button>
            <el-pagination style="float: right"
                           @size-change="handleSizeChange"
                           @current-change="handleCurrentChange"
                           :current-page="pageNum"
                           :page-sizes="[10,20,30,50]"
                           :page-size="pageSize"
                           layout="total, sizes, prev, pager, next, jumper"
                           :total="salSobData.total">
            </el-pagination>
        </div>
        <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible">
            <div style="height: 120px">
                <el-steps :active="activeStepIndex" align-center>
                    <el-step :title="obj.desc" v-for="obj in stepNames"></el-step>
                </el-steps>
                <div v-for="(obj,index) in stepNames" style="margin-top: 20px;text-align: center">
                    <div v-for="input in obj.input" style="margin-top: 10px;">
                        <span v-show="activeStepIndex == index">{{input.name}} :  </span>
                        <el-input size="mini" style="width: 250px" v-model="input.value" :placeholder="'请输入' + input.name + '...'"
                                  :key="index" v-show="activeStepIndex == index" ></el-input>
                    </div>
                </div>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button size="mini" @click="previousStep">{{activeStepIndex == 0 ? "取消" : "上一步"}}</el-button>
                <el-button size="mini" type="primary" @click="nextStep">{{activeStepIndex == 7 ? "完成" : "下一步"}}</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "SalSob",
        data(){
            return {
                dialogTitle : '添加工资账套',
                dialogFormVisible: false,
                salSobData: Object,
                loading:false,
                pageNum: 1,
                pageSize: 10,
                orderField:'',
                sortType:'',
                salary:{
                    id : '',
                    name : '',
                    basicSalary : 0,
                    trafficSalary : 0,
                    lunchSalary : 0,
                    bonus : 0,
                    pensionPer : 0,
                    pensionBase : 0,
                    medicalPer : 0,
                    medicalBase : 0,
                    accumulationFundPer : 0,
                    accumulationFundBase : 0
                },
                stepNames:[
                    {
                        desc : "基本工资",
                        input : [{ name : "基本工资", value : ''}]
                    },
                    {
                        desc : "交通补助",
                        input : [{ name : "交通补助", value : ''}]
                    },
                    {
                        desc : "午餐补助",
                        input : [{ name : "午餐补助", value : ''}]
                    },
                    {
                        desc : "奖金",
                        input : [{ name : "奖金", value : ''}]
                    },
                    {
                        desc : "养老金",
                        input : [
                                    { name : "养老金比率", value : ''},
                                    { name : "养老金基数", value : ''}
                                ]
                    },
                    {
                        desc : "医疗保险",
                        input : [
                                    { name : "医疗保险比率", value : ''},
                                    { name : "医疗保险基数", value : ''}
                                ]
                    },
                    {
                        desc : "公积金",
                        input : [
                                    { name : "公积金比率", value : ''},
                                    { name : "公积金基数", value : ''}
                                ]
                    },
                    {
                        desc : "账套名称",
                        input : [
                                    { name : "账套名称", value : ''}
                                ]
                    }
                ],
                activeStepIndex: 0,
                batchBtnDisabled: true,
                multipleSelection: []
            }
        },
        methods:{
            initSalSobTable(){
                let formData = new FormData();
                formData.append("pageNum",this.pageNum);
                formData.append("pageSize",this.pageSize);
                formData.append("orderField",this.orderField);
                formData.append("sortType",this.sortType);
                this.loading = true;
                this.postRequest("/salary/sob/getAll",formData).then(res=>{
                    if(res){
                        this.salSobData = res.result;
                    }
                    this.loading = false;
                })
            },
            toAddSalSob(){
                this.initSalary();
                this.dialogTitle = "添加工资账套";
                this.activeStepIndex = 0;
                this.stepNames[0].input[0].value = '';
                this.stepNames[1].input[0].value = '';
                this.stepNames[2].input[0].value = '';
                this.stepNames[3].input[0].value = '';
                this.stepNames[4].input[0].value = '';
                this.stepNames[4].input[1].value = '';
                this.stepNames[5].input[0].value = '';
                this.stepNames[5].input[1].value = '';
                this.stepNames[6].input[0].value = '';
                this.stepNames[6].input[1].value = '';
                this.stepNames[7].input[0].value = '';
                this.dialogFormVisible = true;
            },
            refreshSalSob(){
                this.initSalSobTable();
            },
            previousStep(){
                if(this.activeStepIndex == 0){
                    this.dialogFormVisible = false;
                    this.initSalary();
                    return;
                }
                this.activeStepIndex --;
            },
            nextStep(){
                if(this.activeStepIndex == 7){
                    this.salary.basicSalary = this.stepNames[0].input[0].value;
                    this.salary.trafficSalary = this.stepNames[1].input[0].value;
                    this.salary.lunchSalary = this.stepNames[2].input[0].value;
                    this.salary.bonus = this.stepNames[3].input[0].value;
                    this.salary.pensionPer = this.stepNames[4].input[0].value;
                    this.salary.pensionBase = this.stepNames[4].input[1].value;
                    this.salary.medicalPer = this.stepNames[5].input[0].value;
                    this.salary.medicalBase = this.stepNames[5].input[1].value;
                    this.salary.accumulationFundPer = this.stepNames[6].input[0].value;
                    this.salary.accumulationFundBase = this.stepNames[6].input[1].value;
                    this.salary.name = this.stepNames[7].input[0].value;
                    this.postRequest('/salary/sob/',this.salary).then((res)=>{
                        if(res){
                            this.initSalary();
                            this.dialogFormVisible = false;
                            this.initSalSobTable();
                        }
                    });
                    return;
                }
                this.activeStepIndex ++;
            },
            initSalary(){
                this.salary = {
                    id : '',
                    name : '',
                    basicSalary : 0,
                    trafficSalary : 0,
                    lunchSalary : 0,
                    bonus : 0,
                    pensionPer : 0,
                    pensionBase : 0,
                    medicalPer : 0,
                    medicalBase : 0,
                    accumulationFundPer : 0,
                    accumulationFundBase : 0
                };
            },
            handleEdit(index,row){
                this.dialogTitle = "修改工资账套";
                this.activeStepIndex = 0;
                this.salary.id = row.id;
                this.stepNames[0].input[0].value = row.basicSalary;
                this.stepNames[1].input[0].value = row.trafficSalary;
                this.stepNames[2].input[0].value = row.lunchSalary;
                this.stepNames[3].input[0].value = row.bonus;
                this.stepNames[4].input[0].value = row.pensionPer;
                this.stepNames[4].input[1].value = row.pensionBase;
                this.stepNames[5].input[0].value = row.medicalPer;
                this.stepNames[5].input[1].value = row.medicalBase;
                this.stepNames[6].input[0].value = row.accumulationFundPer;
                this.stepNames[6].input[1].value = row.accumulationFundBase;
                this.stepNames[7].input[0].value = row.name;
                this.dialogFormVisible = true;
            },
            handleDelete(index,row){
                this.$confirm('此操作将永久删除【'+ row.name +'】账套, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/salary/sob/" + row.id).then(()=>{
                        this.initSalSobTable();
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
            handleSizeChange(val){
                this.pageSize = val;
                this.pageNum = 1;
                this.initSalSobTable();
            },
            handleCurrentChange(val){
                this.pageNum = val;
                this.initSalSobTable();
            },
            batchDelete(){
                this.$confirm('此操作将永久删除所有所选账套, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/salary/sob/",this.multipleSelection).then(()=>{
                        this.initSalSobTable();
                    });
                });
            },
            getTableStyle(){
                return 'text-align:center';
            }
        },
        mounted() {
            this.initSalSobTable();
        }
    }
</script>