<template>
    <div>
        <div style="margin-top: 10px">
            <el-table :data="empSalaryData.list" size="mini" class="component-table"
                      border stripe
                      style="width: 100%;height: 100%"
                      max-height="500"
                      v-loading="loading"
                      element-loading-text="正在加载..."
                      :header-cell-style="getTableStyle"
                      :cell-style="getTableStyle">
                <el-table-column prop="id" width="0" v-if="false"></el-table-column>
                <el-table-column prop="empName" label="姓名" width="150"></el-table-column>
                <el-table-column prop="workId" label="工号" width="150"></el-table-column>
                <el-table-column prop="email" label="电子邮件" width="150"></el-table-column>
                <el-table-column prop="phone" label="电话号码" width="150"></el-table-column>
                <el-table-column prop="departmentName" label="所属部门" width="150"></el-table-column>
                <el-table-column prop="salaryName" label="工资账套" width="150">
                    <template slot-scope="scope">
                        <el-popover
                                placement="left-start"
                                :title="scope.row.salaryName"
                                width="100"
                                trigger="hover">
                                <div class="innerDiv">基本工资:<el-tag size="mini" type="success" disable-transitions>{{scope.row.basicSalary == null ? "暂未设置" : scope.row.basicSalary}}</el-tag></div>
                                <div class="innerDiv">交通补助:<el-tag size="mini" type="success" disable-transitions>{{scope.row.trafficSalary == null ? "暂未设置" : scope.row.trafficSalary}}</el-tag></div>
                                <div class="innerDiv">午餐补助:<el-tag size="mini" type="success" disable-transitions>{{scope.row.lunchSalary == null ? "暂未设置" : scope.row.lunchSalary}}</el-tag></div>
                                <div class="innerDiv">奖金:<el-tag size="mini" type="success" disable-transitions>{{scope.row.bonus == null ? "暂未设置" : scope.row.bonus}}</el-tag></div>
                                <div class="innerDiv">养老金比率:<el-tag size="mini" type="success" disable-transitions>{{scope.row.pensionPer == null ? "暂未设置" : scope.row.pensionPer}}</el-tag></div>
                                <div class="innerDiv">养老金基数:<el-tag size="mini" type="success" disable-transitions>{{scope.row.pensionBase == null ? "暂未设置" : scope.row.pensionBase}}</el-tag></div>
                                <div class="innerDiv">医疗保险比率:<el-tag size="mini" type="success" disable-transitions>{{scope.row.medicalPer == null ? "暂未设置" : scope.row.medicalPer}}</el-tag></div>
                                <div class="innerDiv">医疗保险基数:<el-tag size="mini" type="success" disable-transitions>{{scope.row.medicalBase == null ? "暂未设置" : scope.row.medicalBase}}</el-tag></div>
                                <div class="innerDiv">公积金比率:<el-tag size="mini" type="success" disable-transitions>{{scope.row.accumulationFundPer == null ? "暂未设置" : scope.row.accumulationFundPer}}</el-tag></div>
                                <div class="innerDiv">公积金基数:<el-tag size="mini" type="success" disable-transitions>{{scope.row.accumulationFundBase == null ? "暂未设置" : scope.row.accumulationFundBase}}</el-tag></div>
                            <el-tag size="mini" slot="reference" disable-transitions>{{scope.row.salaryName == null ? "暂未设置" : scope.row.salaryName}}</el-tag>
                        </el-popover>
                    </template>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleEdit(scope.$index, scope.row)">修改工资账套</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <div style="margin-top: 10px">
            <el-pagination style="float: right"
                           @size-change="handleSizeChange"
                           @current-change="handleCurrentChange"
                           :current-page="pageNum"
                           :page-sizes="[10,20,30,50]"
                           :page-size="pageSize"
                           layout="total, sizes, prev, pager, next, jumper"
                           :total="empSalaryData.total">
            </el-pagination>
        </div>
        <el-dialog title="修改工资账套" :visible.sync="dialogFormVisible">
            <div style="height: 120px">
                <div style="text-align: center">
                    选择工资账套:
                    <el-select size="mini" v-model="salaryValue"
                               placeholder="请选择工资账套"
                                @change="changeSalary">
                        <el-option
                                v-for="(salary,index) in this.salSobData.list"
                                :key="index"
                                :label="salary.name"
                                :value="salary.id">
                        </el-option>
                    </el-select>
                </div>
                <div style="margin-top: 10px;">
                    <el-row>
                        <el-col :span="8">
                            基本工资:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.basicSalary == null ? "暂未设置" : salary.basicSalary}}</el-tag>
                        </el-col>
                        <el-col :span="8">
                            交通补助:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.trafficSalary == null ? "暂未设置" : salary.trafficSalary}}</el-tag>
                        </el-col>
                        <el-col :span="8">
                            午餐补助:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.lunchSalary == null ? "暂未设置" : salary.lunchSalary}}</el-tag>
                        </el-col>
                    </el-row>
                    <el-row style="margin-top: 5px">
                        <el-col :span="8">
                            奖金:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.bonus == null ? "暂未设置" : salary.bonus}}</el-tag>
                        </el-col>
                        <el-col :span="8">
                            养老金比率:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.pensionPer == null ? "暂未设置" : salary.pensionPer}}</el-tag>
                        </el-col>
                        <el-col :span="8">
                            养老金基数:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.pensionBase == null ? "暂未设置" : salary.pensionBase}}</el-tag>
                        </el-col>
                    </el-row>
                    <el-row style="margin-top: 5px">
                        <el-col :span="8">
                            医疗保险比率:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.medicalPer == null ? "暂未设置" : salary.medicalPer}}</el-tag>
                        </el-col>
                        <el-col :span="8">
                            医疗保险基数:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.medicalBase == null ? "暂未设置" : salary.medicalBase}}</el-tag>
                        </el-col>
                        <el-col :span="8">
                            公积金比率:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.accumulationFundPer == null ? "暂未设置" : salary.accumulationFundPer}}</el-tag>
                        </el-col>
                    </el-row>
                    <el-row style="margin-top: 5px">
                        <el-col :span="8">
                            公积金基数:<el-tag size="mini" style="margin-left: 10px" type="success">{{salary.accumulationFundBase == null ? "暂未设置" : salary.accumulationFundBase}}</el-tag>
                        </el-col>
                    </el-row>
                </div>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button size="mini" @click="cancel">取消</el-button>
                <el-button size="mini" type="primary" @click="updateEmpSalary">确定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "SalSobCfg",
        data(){
            return {
                loading:false,
                pageNum: 1,
                pageSize: 10,
                orderField:'',
                sortType:'',
                dialogFormVisible: false,
                empSalaryData: Object,
                salSobData: Object,
                salaryValue: '',
                salEmpId: '',
                empId: '',
                salary: Object
            }
        },
        methods:{
            initEmpSalaryTable(){
                let formData = new FormData();
                formData.append("pageNum",this.pageNum);
                formData.append("pageSize",this.pageSize);
                formData.append("orderField",this.orderField);
                formData.append("sortType",this.sortType);
                this.loading = true;
                this.postRequest("/salary/employee/",formData).then(res=>{
                    if(res){
                        this.empSalaryData = res.result;
                    }
                    this.loading = false;
                })
            },
            initSalSobTable(){
                let formData = new FormData();
                formData.append("pageNum",1);
                formData.append("pageSize",999999);
                this.postRequest("/salary/sob/getAll").then(res=>{
                    if(res){
                        this.salSobData = res.result;
                    }
                })
            },
            cancel(){
                this.dialogFormVisible = false;
            },
            handleEdit(index,row){
                this.salEmpId = row.id;
                this.salaryValue = row.salaryId;
                this.empId = row.empId;
                this.changeSalary(this.salaryValue);
                this.dialogFormVisible = true;
            },
            changeSalary(id){
                for(let i = 0; i < this.salSobData.list.length;i++){
                    if(id == this.salSobData.list[i].id){
                        this.salary = this.salSobData.list[i];
                        return;
                    }
                }
                this.salary = Object;
            },
            updateEmpSalary(){
                if(this.salEmpId == null || this.salEmpId == undefined){
                    this.postRequest('/salary/employee/' + this.empId + '/' + this.salaryValue).then((res)=>{
                        if(res){
                            this.initEmpSalaryTable();
                            this.dialogFormVisible = false;
                        }
                    })
                }
                this.putRequest('/salary/employee/' + this.salEmpId + '/' + this.salaryValue).then((res)=>{
                    if(res){
                        this.initEmpSalaryTable();
                        this.dialogFormVisible = false;
                    }
                });
            },
            handleSizeChange(val){
                this.pageSize = val;
                this.pageNum = 1;
                this.initEmpSalaryTable();
            },
            handleCurrentChange(val){
                this.pageNum = val;
                this.initEmpSalaryTable();
            },
            getTableStyle(){
                return 'text-align:center';
            }
        },
        mounted() {
            this.initEmpSalaryTable();
            this.initSalSobTable();
        }
    }
</script>
<style>
    .innerDiv{
        margin-bottom: 5px;
        font-size: 8px;
        margin-right: 10px;
    }
</style>