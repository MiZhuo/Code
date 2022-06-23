<template>
  <div>
    <el-menu>
      <div style="float: right;margin-top: 10px;">
      <el-dropdown trigger="hover" style="margin-right:15px;cursor: pointer">
        <i class="el-icon-document-copy" style="font-size: 28px;"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item @click.native="copyContent('yesterday')">
            复制昨日的内容
          </el-dropdown-item>
          <el-dropdown-item @click.native="copyContent('thisWeek')">
            复制本周的内容
          </el-dropdown-item>
          <el-dropdown-item @click.native="copyContent('lastWeek')">
            复制上周的内容
          </el-dropdown-item>
          <el-dropdown-item @click.native="copyContent('currentPage')">
            复制当前页的内容
          </el-dropdown-item>
          <el-dropdown-item @click.native="copyContent('searchContent')">
            复制当前查询的全部内容
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <el-dropdown trigger="hover"  style="margin-right:15px;cursor: pointer">
        <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="loginOut">
              登出
            </el-dropdown-item>
          </el-dropdown-menu>
      </el-dropdown>
      </div>
    </el-menu>
    <div id="worklog" style="margin-top: 15px;">
      <el-form ref="searchForm" :model="searchForm" label-width="80px">
        <el-row>
          <el-col :span="8" style="margin-left: 40px">
            <el-form-item label="工作日期:">
            <el-date-picker v-model="searchForm.dateValue" size="small" type="datetimerange" :picker-options="pickerOptions" range-separator="至"
                            start-placeholder="开始日期" end-placeholder="结束日期" align="right"
                            @change="chooseDateTime" value-format="yyyy-MM-dd" format="yyyy-MM-dd" style="width: 80%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="5">
            <el-form-item label="审核状态:">
            <el-select v-model="searchForm.statusValue" size="small" placeholder="请选择" value="all">
              <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
            </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="10">
            <el-form-item label="关键字:">
            <el-input placeholder="输入关键字查询" prefix-icon="el-icon-search" size="small" style="width: 300px;margin-right: 10px"
                      v-model="searchForm.keyword" @keyup.enter.native="searchClick" ></el-input>
            <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">查询</el-button>
            <el-button size="small" type="info" icon="el-icon-refresh-left" @click="clearAllCondition">重置</el-button>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <div style="margin-top: 30px">
        <el-table :data="worklogItemVos" border style="width: 100%;" :header-cell-style="{background:'#f0f9eb',color:'#606266'}"  :row-class-name="tableRowClassName" height="730">
        <el-table-column prop="worklogItemsId" label="ID" v-if="false"></el-table-column>
        <el-table-column prop="workDate" label="日期" min-width="10%" align="center">
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span>{{ scope.row.workDate }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="projectOrTaskName" label="项目名称" width="140" align="center" v-if="false"></el-table-column>
        <el-table-column prop="manager" label="项目负责人简称" v-if="false"></el-table-column>
        <el-table-column prop="managerName" label="项目负责人" width="100" align="center" v-if="false"></el-table-column>
        <el-table-column prop="address" label="工作地点" min-width="10%" align="center"></el-table-column>
        <el-table-column prop="workType" label="工作类型" min-width="5%" align="center" :formatter="formatWorkType"></el-table-column>
        <el-table-column prop="workload" label="工时(h)" min-width="5%" align="center"></el-table-column>
        <el-table-column prop="completeContent" label="完成度(%)" min-width="10%" align="center"></el-table-column>
        <el-table-column prop="content" label="内容" min-width="40%" align="center">
          <template slot-scope="scope">
            <p v-html="scope.row.content"></p>
          </template>
        </el-table-column>
        <el-table-column prop="status" label="审核状态" min-width="7%" align="center"
         :filters="[{ text: '待审核', value: 'unaudited' },{ text: '通过', value: 'pass'},{ text: '驳回',value: 'reject'}]"
         :filter-method="filterTag" filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.status === 'pass' ? 'success' : scope.row.status === 'unaudited' ?'warning' : 'danger'"
              disable-transitions>{{scope.row.status === 'draft' ? '草稿' : scope.row.status === 'pass' ? '通过' : scope.row.status === 'unaudited' ?'待审核' : '驳回'}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column fixed="right" label="操作" min-width="13%" align="center">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div style="margin-top:30px;display: flex;justify-content: center;align-items: center">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync='currentPage'
        :page-sizes="[10, 30, 50 , 100]" :page-size='pageSize' layout="total, sizes, prev, pager, next, jumper" :total='total'>
      </el-pagination>
    </div>
    <el-tooltip class="item" effect="dark" content="新建工作日志" placement="top">
      <i class="el-icon-edit-outline suspensionIcon" @click="openDialog"></i>
    </el-tooltip>
    <div>
      <el-dialog title="新建工作日志" :visible.sync="dialogFormVisible" width="70%" destroy-on-close="true">
        <el-form :rules="rules" :model="workLogForm" ref="workLogForm" v-loading="loading" label-width="100px"  size="small">
          <el-row>
            <el-col :span="6">
              <el-form-item label="工作日期">
                <el-date-picker v-model="workLogForm.workDate" align="right" type="date"
                                placeholder="选择日期" :picker-options="pickerOptions2" style="width: 188px;"
                                value-format="yyyy-MM-dd" format="yyyy-MM-dd" :clearable = "false"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="0">
              <el-form-item label="项目编号" v-if="false">
                <el-input v-model="workLogForm.projectOrTaskCode" autocomplete="off" disabled="disabled"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="项目名称">
                <el-input v-model="workLogForm.projectOrTaskName" autocomplete="off" disabled="disabled"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="0">
              <el-form-item label="项目负责人简称" v-if="false">
                <el-input v-model="workLogForm.manager" autocomplete="off" disabled="disabled"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="项目负责人">
                <el-input v-model="workLogForm.managerName" autocomplete="off" disabled="disabled"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="项目阶段">
                <el-input v-model="workLogForm.projectStage" autocomplete="off" disabled="disabled"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="工作类型" prop="workType">
                <el-select v-model="workLogForm.workType" placeholder="请选择">
                  <el-option v-for="item in options2" :key="item.value" :label="item.label" :value="item.value"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="工作地点" prop="address">
                <el-input v-model="workLogForm.address" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="工作时长(h)" prop="workload">
                <el-input v-model="workLogForm.workload" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="完成度(%)" prop="completeContent">
                <el-input v-model="workLogForm.completeContent" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="19">
              <el-form-item label="工作内容" prop="content">
                <el-input type="textarea" v-model="workLogForm.content" autocomplete="off" :autosize="{ minRows: 3, maxRows: 3}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-button type="primary" @click="saveWorkLog" size="small" style="margin-left: 10px;margin-top: 40px">保 存</el-button>
              <el-button size="small" type="info" @click="resetWorkLog">重 置</el-button>
            </el-col>
          </el-row>
        </el-form>
        <div style="width: 100%;justify-content: center;align-items: center;margin-top: 20px">
          <span>当日工作内容</span>
          <el-table :data="todayWorkContent" size="small" style="margin-top: 10px;margin-left: 20px" height="360">
            <el-table-column prop="worklogItemsId" label="ID" v-if="false"></el-table-column>
            <el-table-column prop="workDate" label="日期" width="120" align="center">
              <template slot-scope="scope">
                <i class="el-icon-time"></i>
                <span>{{ scope.row.workDate }}</span>
              </template>
            </el-table-column>
            <el-table-column prop="projectOrTaskName" label="项目名称" width="100" align="center"></el-table-column>
            <el-table-column prop="address" label="工作地点" width="100" align="center"></el-table-column>
            <el-table-column prop="workType" label="工作类型" width="80" align="center" :formatter="formatWorkType"></el-table-column>
            <el-table-column prop="workload" label="工时(h)" width="70" align="center"></el-table-column>
            <el-table-column prop="completeContent" label="完成度(%)" width="80" align="center"></el-table-column>
            <el-table-column prop="content" label="内容" width="390" align="center">
            </el-table-column>
            <el-table-column prop="status" label="状态" width="80" align="center"
                             :filter-method="filterTag" filter-placement="bottom-end">
              <template slot-scope="scope">
                <el-tag
                  :type="scope.row.status === 'draft' ? 'primary' : scope.row.status === 'pass' ? 'success' : scope.row.status === 'unaudited' ?'warning' : 'danger'"
                  disable-transitions>{{scope.row.status === 'draft' ? '草稿' : scope.row.status === 'pass' ? '通过' : scope.row.status === 'unaudited' ?'待审核' : '驳回'}}</el-tag>
              </template>
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="150" align="center">
              <template slot-scope="scope">
                <el-button size="mini" @click="handleEdit2(scope.$index, scope.row)">编辑</el-button>
                <el-button size="mini" type="danger" @click="handleDelete2(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <div style="height: 20px">
          <span slot="footer" class="dialog-footer" style="float: right;margin-top: 10px">
            <el-button type="primary" @click="submitWorkLog" size="small">交日志</el-button>
          </span>
        </div>
      </el-dialog>
    </div>
  </div>

</template>
<script>
  import {searchWorklogs,getWorkLog,addWorkLog,updateWorklog,getAllWorkLogs,deleteWorkLog,submitWorkLog} from "../../api/worklog";
  import {getToken} from "../../utils/auth";

  export default {
      data() {
            const validateWorkType = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请选择工作类型!'))
                } else {
                    callback()
                }
            };
            const validateAddress = (rule, value, callback) => {
                if (value.trim() === '') {
                    callback(new Error('工作地点不能为空!'))
                } else {
                    callback()
                }
            };
            const validateWorkLoad = (rule, value, callback) => {
                let regx = /^(([1-9])|(1\d)|(2[0-4]))$/;
                if(!regx.test(value)){
                    callback(new Error('工作时长在1-24小时!'))
                } else {
                    callback()
                }
            };
            const validateCompleteContent = (rule, value, callback) => {
                let regx = /^([0-9]\d?|100)$/;
                if(!regx.test(value)){
                    callback(new Error('完成度在0-100之间!'))
                } else {
                    callback()
                }
            };
            const validateContent = (rule, value, callback) => {
                if (value.trim() === '') {
                    callback(new Error('请输入工作内容!'))
                } else {
                    callback()
                }
            };
            return {
                rules: {
                    workType: [{required: true,trigger:'blur',validator: validateWorkType}],
                    address: [{required: true,trigger:'blur',validator: validateAddress}],
                    workload: [{required: true,trigger:'blur',validator: validateWorkLoad}],
                    completeContent: [{required: true,trigger:'blur',validator: validateCompleteContent}],
                    content: [{required: true,trigger:'blur',validator: validateContent}]
                },
                worklogItemVos: [],
                worklogItemVosTemp: [],
                pickerOptions: {
                    shortcuts: [{
                        text: '今天',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime());
                            picker.$emit('pick', [start, end]);
                        }
                    },{
                        text: '最近一周',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近一个月',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近三个月',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
                            picker.$emit('pick', [start, end]);
                        }
                    }]
                },
                pickerOptions2: {
                    shortcuts: [{
                        text: '今天',
                        onClick(picker) {
                            picker.$emit('pick', new Date());
                        }
                    }, {
                        text: '昨天',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24);
                            picker.$emit('pick', date);
                        }
                    }, {
                        text: '两天前',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24 * 2);
                            picker.$emit('pick', date);
                        }
                    }],
                    disabledDate(time) {
                        return time.getTime() > Date.now();
                    },
                },
                options: [{
                    value: 'all',
                    label: '全部'
                }, {
                    value: 'unaudited',
                    label: '待审核'
                }, {
                    value: 'pass',
                    label: '通过'
                }, {
                    value: 'reject',
                    label: '驳回'
                }],
                options2: [{
                    value: 'coding',
                    label: '编码'
                }, {
                    value: 'bugFix',
                    label: 'Bug修复'
                }, {
                    value: 'other',
                    label: '其它'
                }, {
                    value: 'testExecution',
                    label: '测试执行'
                },{
                    value: 'demandAnalysis',
                    label: '需求分析'
                },{
                    value: 'unitTest',
                    label: '单元测试'
                },{
                    value: 'businessModeling',
                    label: '业务建模'
                },{
                    value: 'technicalRoute',
                    label: '技术路线/方案'
                },{
                    value: 'UIDesign',
                    label: 'UI设计'
                },{
                    value: 'outlineDesign',
                    label: '概要设计'
                },{
                    value: 'detailedDesign',
                    label: '详细设计'
                },{
                    value: 'databaseDesign',
                    label: '数据库设计'
                },{
                    value: 'testCase/scenarioWriting',
                    label: '测试用例/方案编写'
                },{
                    value: 'projectTracking/Management',
                    label: '项目跟踪/管理'
                },{
                    value: 'projectPlanning',
                    label: '项目策划'
                },{
                    value: 'qacm',
                    label: '质量保证配置管理'
                },{
                    value: 'training',
                    label: '培训'
                },{
                    value: 'maintain',
                    label: '维护'
                },{
                    value: 'acceptance',
                    label: '验收'
                }],
                searchForm: {
                    dateValue: '',
                    offset: 0,
                    pageNum: 1,
                    pageSize: 20,
                    statusValue: 'all',
                    keyword: '',
                    startDate: '',
                    endDate: '',
                    creator: '',
                    creatorName: ''
                },
                currentPage: 1,
                pageSize: 10,
                total: 0,
                loading: false,
                worklogId: '',
                dialogFormVisible: false,
                workLogForm: {
                    worklogItemsId: '',
                    workDate: '',
                    projectOrTaskCode: 'JRRJ2019003P',
                    projectOrTaskName: '联合银行外包项目',
                    manager: 'guoflu',
                    contentType: 'today_log',
                    itemType: 'project',
                    managerName: '陆国锋',
                    projectStage: '其他',
                    workType: '',
                    address: '杭州联合银行后督中心',
                    workload: '',
                    completeContent: '',
                    content: ''
                },
                todayWorkContent: [],
                editTempIndex: 0,
                editTempArr: []
            }
        },
      created(){
          let loginName = getToken();
          if(loginName === ''){
              this.$router.push('/login');
          }
          getAllWorkLogs(1,9999,'asc',loginName,'','','','this','').then(response => {
              let res = response.data.result;
              let _this = this;
              for(let i = 0;i < res.length;i++){
                  for(let j = 0;j < res[i].worklogItemVos.length;j++) {
                      res[i].worklogItemVos[j].workDate = _this.transferTime(res[i].workDate);
                      _this.worklogItemVosTemp.push(res[i].worklogItemVos[j]);
                  }
              }
              _this.total = _this.worklogItemVosTemp.length;
              if(_this.total < _this.pageSize){
                  _this.worklogItemVos = _this.worklogItemVosTemp.slice(0,_this.total);
              }else{
                  _this.worklogItemVos = _this.worklogItemVosTemp.slice(0,_this.pageSize);
              }

          }).catch(() => {
              this.$router.push({path: '/login'})
          })
      },
      watch:{
          'workLogForm.workDate':{
              handler(newVal,oldVal){
                  if(newVal === '' || newVal === null){
                      return;
                  }
                  this.getWorkLogsByDate(newVal);
              }
          },
          'searchForm.dateValue':{
              handler(newVal,oldVal){
                  if(newVal === '' || newVal === null){
                      this.searchForm.startDate = '';
                      this.searchForm.endDate = '';
                  }
              }
          }
      },
      methods: {
          tableRowClassName({row, rowIndex}) {
              if (rowIndex % 2 === 1) {
                  return 'success-row';
              }
              return '';
          },
          filterTag(value, row){
              return row.status === value;
          },
          clearAllCondition(){
              let _this = this;
              _this.searchForm.dateValue = '';
              _this.searchForm.statusValue = 'all';
              _this.searchForm.keyword = '';
          },
          chooseDateTime(){
              let _this = this;
              let dt = _this.searchForm.dateValue.toString();
              _this.searchForm.startDate = dt.substring(0,10);
              _this.searchForm.endDate = dt.substring(11,21);
          },
          handleEdit(index,row){
              let _this = this;
              if(row.status === 'pass'){
                  _this.$message({
                      message: '已通过审核的日志无法进行编辑!',
                      type: 'warning'
                  });
              }else{
                  _this.dialogFormVisible = true;
                  _this.workLogForm.workDate = row.workDate;
                  _this.workLogForm.worklogItemsId = row.worklogItemsId;
                  _this.workLogForm.completeContent = row.completeContent;
                  _this.workLogForm.workload = row.workload;
                  _this.workLogForm.workType = row.workType;
                  _this.workLogForm.content = row.content;
                  _this.flag = true;
              }
          },
          handleDelete(index,row){
              let _this = this;
              if(row.status === 'pass'){
                  _this.$message.error('已通过审核的日志无法删除!');
              }else{
                  _this.$confirm('确定删除该条记录吗?', '提示', {
                      confirmButtonText: '删删删',
                      cancelButtonText: '点错了',
                      type: 'warning'
                  }).then(()=>{
                      let itemId = row.worklogItemsId;
                      deleteWorkLog(itemId).then(response=>{
                          _this.$message({
                              message: '删除成功!',
                              type: 'success'
                          });
                          _this.getWorkLogsByDate(_this.workLogForm.workDate);
                      })
                  })
              }
          },
          handleEdit2(index,row){
              let _this = this;
              if(row.status === 'pass'){
                  _this.$message({
                      message: '已通过审核的日志无法进行编辑!',
                      type: 'warning'
                  });
              }else{
                  _this.workLogForm.worklogItemsId = row.worklogItemsId;
                  _this.workLogForm.completeContent = row.completeContent;
                  _this.workLogForm.workload = row.workload;
                  _this.workLogForm.workType = row.workType;
                  _this.workLogForm.content = row.content;
              }
          },
          handleDelete2(index,row){
              let _this = this;
              if(row.status === 'pass'){
                  _this.$message.error('已通过审核的日志无法删除!');
              }else{
                  _this.$confirm('确定删除该条记录吗?', '提示', {
                      confirmButtonText: '删删删',
                      cancelButtonText: '点错了',
                      type: 'warning'
                  }).then(()=>{
                      let itemId = row.worklogItemsId;
                      deleteWorkLog(itemId).then(response=>{
                          _this.$message({
                              message: '删除成功!',
                              type: 'success'
                          });
                          _this.getWorkLogsByDate(_this.workLogForm.workDate);
                      })
                  })
              }
          },
          searchClick(){
              let _this = this;
              let searchForm = _this.searchForm;
              let status = searchForm.statusValue;
              if(status === 'unaudited'){
                  status = '待审核';
              }else if(status === 'pass'){
                  status = '通过';
              }else if(status === 'reject'){
                  status = '驳回';
              }else{
                  status = '';
              }
              searchWorklogs(0, 1,9999,
                  searchForm.startDate,searchForm.endDate,status,
                  searchForm.creator,searchForm.creatorName,searchForm.keyword).then(response=>{
                  let _this = this;
                  let res = response.data.result;
                  _this.worklogItemVosTemp = [];
                  for(let i = 0;i < res.length;i++){
                      let log = res[i].worklogItemInfo;
                      let arr = _this.parseSearchWorkLog(res[i].workDate,log);
                      for(let i = 0;i < arr.length;i++) {
                          _this.worklogItemVosTemp.push(arr[i]);
                      }
                  }
                  _this.total = _this.worklogItemVosTemp.length;
                  _this.currentPage = 1;
                  _this.pageSize = 10;
                  if(_this.total < _this.pageSize){
                      _this.worklogItemVos = _this.worklogItemVosTemp.slice(0,_this.total);
                  }else{
                      _this.worklogItemVos = _this.worklogItemVosTemp.slice(0,_this.pageSize);
                  }
              })
          },
          transferTime(dateTime){
              let dt;
              if(dateTime === ''){
                  dt = new Date();
              }else{
                  dt = new Date(dateTime);
              }
              let year = dt.getFullYear();
              let month = dt.getMonth()+1;
              let day = dt.getDate();
              return year + '-' + month + '-' + day;
          },
          formatWorkType(row, column){
              switch (row.workType) {
                  case 'coding': {
                      return '编码';
                  }
                  case 'bugFix': {
                      return 'Bug修复';
                  }
                  case 'other': {
                      return '其它';
                  }
                  case 'testExecution': {
                      return '测试执行';
                  }
                  case 'demandAnalysis': {
                      return '需求分析';
                  }
                  case 'unitTest':{
                      return '单元测试';
                  }
                  case 'businessModeling':{
                      return '业务建模';
                  }
                  case 'technicalRoute':{
                      return '技术路线/方案';
                  }
                  case 'UIDesign':{
                      return 'UI设计';
                  }
                  case 'outlineDesign':{
                      return '概要设计';
                  }
                  case 'detailedDesign':{
                      return '详细设计';
                  }
                  case 'databaseDesign':{
                      return '数据库设计';
                  }
                  case 'testCase/scenarioWriting':{
                      return '测试用例/方案编写';
                  }
                  case '"projectTracking/Management':{
                      return '项目跟踪/管理';
                  }
                  case 'projectPlanning':{
                      return '项目策划';
                  }
                  case 'qacm':{
                      return '质量保证配置管理';
                  }
                  case 'training':{
                      return '培训';
                  }
                  case 'maintain':{
                      return '维护';
                  }
                  case 'acceptance':{
                      return '验收';
                  }
                  default: {
                      return row.workType;
                  }
              }
          },
          handleSizeChange(val) {
              let _this =this;
              _this.pageSize = val;
              _this.currentPage = 1;
              if(_this.total < _this.pageSize){
                  _this.worklogItemVos = _this.worklogItemVosTemp.slice(0,_this.total);
              }else{
                  _this.worklogItemVos = _this.worklogItemVosTemp.slice(0,_this.pageSize);
              }
          },
          handleCurrentChange(val) {
              let start =  (val - 1)  * this.pageSize;
              let end = val * this.pageSize;
              this.worklogItemVos = this.worklogItemVosTemp.slice(start,end);
          },
          parseSearchWorkLog(wdt,str){
              str = str.substring(4,str.length - 4);
              var arr = str.split('</p> <p>');
              let json = {};
              let a = [];
              for(let i = 0;i < arr.length;i++){
                  var arr2 = arr[i].split('&nbsp;');
                  for(let j = 0;j < arr2.length;j++){
                      let arr3 = arr2[j].split('：');
                      arr3[0] = arr3[0].replace(new RegExp('<font color=\'red\'>',"gm"),'').replace(new RegExp('</font>',"gm"),'');
                      arr3[1] = arr3[1].replace(new RegExp('<font color=\'red\'>',"gm"),'').replace(new RegExp('</font>',"gm"),'');
                      arr3[0] = (arr3[0].indexOf('项目名称') !== -1) ? '项目名称' : arr3[0];
                      arr3[1] = arr3[1].trim();
                      switch (arr3[0].trim()) {
                          case '项目名称':{
                              json.projectOrTaskName = arr3[1];
                              break;
                          }
                          case '项目经理':{
                              json.managerName = arr3[1];
                              break;
                          }
                          case '工作类型':{
                              json.workType = arr3[1];
                              break;
                          }
                          case '工作地点':{
                              json.address = arr3[1];
                              break;
                          }
                          case '工时':{
                              json.workload = arr3[1].substring(0,arr3[1].length - 1).replace('.0','');
                              break;
                          }
                          case '完成度':{
                              json.completeContent = arr3[1].substring(0,arr3[1].length - 1);
                              break;
                          }
                          case '工作内容':{
                              json.content = arr3[1];
                              break;
                          }
                          case '审核状态':{
                              if(arr3[1] === '待审核'){
                                  json.status = 'unaudited';
                              }else if(arr3[1] === '通过'){
                                  json.status = 'pass';
                              }else if(arr3[1] === '驳回'){
                                  json.status = 'reject';
                              }else{
                                  json.status = '';
                              }
                              break;
                          }
                      }
                  }
                  if(JSON.stringify(json) !== "{}") {
                      json.workDate = this.transferTime(wdt);
                      a.push(json);
                      json = {};
                  }
              }
              return a;
          },
          openDialog(){
              let _this = this;
              if(_this.dialogFormVisible === true){
                  _this.dialogFormVisible = false;
              }else {
                  _this.dialogFormVisible = true;
                  if(_this.workLogForm.workDate === ''){
                      _this.workLogForm.workDate = _this.transferTime('');
                  }
              }
          },
          getWorkLogsByDate(workDate){
              getWorkLog(workDate).then(response=>{
                  let _result = response.data.result;
                  let _this = this;
                  _this.todayWorkContent = _result.worklogItemVos;
                  if(_this.todayWorkContent !== undefined) {
                      _this.todayWorkContent.forEach(item => {
                          item.workDate = _this.transferTime(_result.workDate);
                      });
                  }
                  if(_this.flag === false) {
                      _this.resetWorkLog();
                  }
                  _this.flag = false;
                  _this.worklogId = _result.worklogId;
              })
          },
          saveWorkLog(){
              let _this = this;
              _this.$refs.workLogForm.validate(valid=>{
                  if(valid){
                      _this.loading = true;
                      if(_this.todayWorkContent === [] || _this.todayWorkContent === undefined){
                          let data = {
                              'worklogItemVos': [{
                                  'projectOrTaskCode': _this.workLogForm.projectOrTaskCode,
                                  'projectOrTaskName': _this.workLogForm.projectOrTaskName,
                                  'manager': _this.workLogForm.manager,
                                  'contentType': _this.workLogForm.contentType,
                                  'itemType': _this.workLogForm.itemType,
                                  'managerName': _this.workLogForm.managerName,
                                  'projectStage': _this.workLogForm.projectStage,
                                  'workType': _this.workLogForm.workType,
                                  'address': _this.workLogForm.address,
                                  'workload': _this.workLogForm.workload,
                                  'completeContent': _this.workLogForm.completeContent,
                                  'content': _this.workLogForm.content
                              }],
                              'projectName': "联合银行外包项目",
                              'workload': _this.workLogForm.workload,
                              'quadvices': "",
                              'workDate': _this.workLogForm.workDate
                          };
                          addWorkLog(data).then(response=>{
                              let status = response.data.success;
                              if(status === true){
                                  _this.loading = false;
                                  _this.$message({
                                      message: response.data.message,
                                      type: 'success'
                                  });
                                  _this.resetWorkLog();
                                  _this.getWorkLogsByDate(this.workLogForm.workDate);
                              }else {
                                  _this.loading = false;
                                  _this.$message.error(response.data.message);
                              }
                          })
                      }else {
                          let worklogItemsId =  _this.workLogForm.worklogItemsId;
                          let val ={
                              'worklogItemsId': worklogItemsId,
                              'projectOrTaskCode': _this.workLogForm.projectOrTaskCode,
                              'projectOrTaskName': _this.workLogForm.projectOrTaskName,
                              'manager': _this.workLogForm.manager,
                              'contentType': _this.workLogForm.contentType,
                              'itemType': _this.workLogForm.itemType,
                              'managerName': _this.workLogForm.managerName,
                              'projectStage': _this.workLogForm.projectStage,
                              'workType': _this.workLogForm.workType,
                              'address': _this.workLogForm.address,
                              'workload': _this.workLogForm.workload,
                              'completeContent': _this.workLogForm.completeContent,
                              'content': _this.workLogForm.content,
                          };
                          let tempArr = JSON.parse(JSON.stringify(_this.todayWorkContent));
                          if(worklogItemsId !== ''){
                              for(let i = 0;i < tempArr.length;i++){
                                  if(tempArr[i].worklogItemsId === worklogItemsId){
                                      tempArr[i] = val;
                                  }
                              }
                          }else {
                              tempArr.push(val);
                          }
                          let load = 0;
                          tempArr.forEach(item=>{
                              load += parseFloat(item.workload);
                          });
                          let data = {
                              'worklogId': _this.worklogId,
                              'worklogItemVos': tempArr,
                              'projectName': "联合银行外包项目",
                              'workload': load,
                              'quadvices': "",
                              "rejectReason": "",
                              "status": "draft",
                              'workDate': _this.workLogForm.workDate
                          };
                          if(load > 8){
                              _this.$confirm('当前总工作时长超过8小时, 是否加班?', '提示', {
                                  confirmButtonText: '确定',
                                  cancelButtonText: '取消',
                                  type: 'warning'
                              }).then(()=>{
                                  _this.updateWorkLog(data);
                              })
                          }else{
                              _this.updateWorkLog(data);
                          }
                      }
                  }else {
                      console.log('参数验证不合法！');
                      return false
                  }
              });
          },
          resetWorkLog(){
              let _this = this;
              _this.workLogForm.worklogId = '';
              _this.workLogForm.workType = '';
              _this.workLogForm.workload = '';
              _this.workLogForm.completeContent = '';
              _this.workLogForm.content = '';
          },
          updateWorkLog(data){
              let _this = this;
              updateWorklog(data).then(response=>{
                  let status = response.data.success;
                  if(status === true){
                      _this.loading = false;
                      _this.$message({
                          message: response.data.message,
                          type: 'success'
                      });
                      _this.resetWorkLog();
                      _this.getWorkLogsByDate(this.workLogForm.workDate);
                  }else {
                      _this.loading = false;
                      _this.$message.error(response.data.message);
                  }
              })
          },
          submitWorkLog(){
              let _this = this;
              let tempArr = [];
              if(_this.todayWorkContent === undefined || _this.todayWorkContent.length === 0){
                  _this.$refs.workLogForm.validate(valid=>{
                    if(valid){
                        _this.loading = true;
                        tempArr.push(_this.workLogForm);
                        _this.worklogId = '';
                    }else{
                        _this.$message.error('啥都没有,交什么交!');
                        return '';
                    }
                  })
              }else {
                  tempArr = JSON.parse(JSON.stringify(_this.todayWorkContent));
              }
              let load = 0;
              if(tempArr !== undefined) {
                  tempArr.forEach(item => {
                      load += parseFloat(item.workload);
                  });
              }
              let data = {
                  'worklogId': _this.worklogId,
                  'worklogItemVos': tempArr,
                  'projectName': "联合银行外包项目",
                  'workload': load,
                  'quadvices': "",
                  "rejectReason": "",
                  "status": "",
                  'workDate': _this.workLogForm.workDate
              };
              _this.$confirm('提交的是' + _this.workLogForm.workDate + '的日志,Are you sure?', '提示', {
                  confirmButtonText: '确定',
                  cancelButtonText: '取消',
                  type: 'warning'
              }).then(()=>{
                  submitWorkLog(data).then(response => {
                      let status = response.data.success;
                      if (status === true) {
                          _this.$message({
                              message: response.data.message,
                              type: 'success'
                          });
                          _this.loading = false;
                          _this.getWorkLogsByDate(this.workLogForm.workDate);
                      } else {
                          _this.loading = false;
                          _this.$message.error(response.data.message);
                      }
                  })
              })
          },
          loginOut(){
              this.$store.dispatch('LogOut').then(() => {
                  this.$router.push('/login');
              })
          },
          copyContent(val){
              const input = document.createElement("input");
              input.setAttribute("readonly", "readonly");
              let _this = this;
              let value = '',startDate,endDate = _this.transferTime('');
              if(val === 'yesterday'){
                  let date = new Date();
                  startDate = _this.transferTime(date.getTime() - 3600 * 1000 * 24);
                  searchWorklogs(0, 1,9999,
                      startDate,endDate,'',
                      '','','').then(response=>{
                      let res = response.data.result;
                      for(let i = 0;i < res.length;i++){
                          let log = res[i].worklogItemInfo;
                          let arr = _this.parseSearchWorkLog(res[i].workDate,log);
                          for(let i = 0;i < arr.length;i++) {
                              value += arr[i].workDate;
                              value += ':';
                              value += arr[i].content;
                              value += '\n';
                          }
                      }
                      if(value.length === 0){
                          _this.$message.error('复制啥呀,你昨天都没有写日志!');
                          return;
                      }
                      input.setAttribute("value", value);
                      document.body.appendChild(input);
                      input.select();
                      input.setSelectionRange(0, 9999);
                      if (document.execCommand("copy")) {
                          document.execCommand("copy");
                          _this.$message({
                              message: '复制成功!',
                              type: 'success'
                          });
                      }else{
                          _this.$message.error('什么都没有复制到,嘿嘿');
                      }
                      document.body.removeChild(input);
                  });
              }else if(val === 'thisWeek'){
                  let new_Date = new Date();
                  let timesStamp = new_Date.getTime();
                  let currentDay = new_Date.getDay();
                  startDate = (new Date(timesStamp + 24 * 60 * 60 * 1000 * (0 - (currentDay + 6) % 7)).toLocaleDateString().replace(/[年月]/g, '-').replace(/[日上下午]/g, ''));
                  startDate = startDate.replace(new RegExp('/',"gm"),'-');
                  searchWorklogs(0, 1,9999,
                      startDate,endDate,'',
                      '','','').then(response=>{
                      let res = response.data.result;
                      for(let i = 0;i < res.length;i++){
                          let log = res[i].worklogItemInfo;
                          let arr = _this.parseSearchWorkLog(res[i].workDate,log);
                          for(let i = 0;i < arr.length;i++) {
                              value += arr[i].workDate;
                              value += ':';
                              value += arr[i].content;
                              value += '\n';
                          }
                      }
                      if(value.length === 0){
                          _this.$message.error('复制啥呀,你这周有写日志吗!');
                          return;
                      }
                      input.setAttribute("value", value);
                      document.body.appendChild(input);
                      input.select();
                      input.setSelectionRange(0, 9999);
                      if (document.execCommand("copy")) {
                          document.execCommand("copy");
                          _this.$message({
                              message: '复制成功!',
                              type: 'success'
                          });
                      }else{
                          _this.$message.error('什么都没有复制到,嘿嘿');
                      }
                      document.body.removeChild(input);
                  });
              }else if(val === 'lastWeek'){
                  let new_Date = new Date();
                  let timesStamp = new_Date.getTime();
                  let currentDay = new_Date.getDay();
                  startDate = (new Date(timesStamp + 24 * 60 * 60 * 1000 * (-7 - (currentDay + 6) % 7)).toLocaleDateString().replace(/[年月]/g, '-').replace(/[日上下午]/g, ''));
                  startDate = startDate.replace(new RegExp('/',"gm"),'-');
                  endDate = (new Date(timesStamp + 24 * 60 * 60 * 1000 * (-1 - (currentDay + 6) % 7)).toLocaleDateString().replace(/[年月]/g, '-').replace(/[日上下午]/g, ''));
                  endDate = endDate.replace(new RegExp('/',"gm"),'-');
                  searchWorklogs(0, 1,9999,
                      startDate,endDate,'',
                      '','','').then(response=>{
                      let res = response.data.result;
                      for(let i = 0;i < res.length;i++){
                          let log = res[i].worklogItemInfo;
                          let arr = _this.parseSearchWorkLog(res[i].workDate,log);
                          for(let i = 0;i < arr.length;i++) {
                              value += arr[i].workDate;
                              value += ':';
                              value += arr[i].content;
                              value += '\n';
                          }
                      }
                      if(value.length === 0){
                          _this.$message.error('复制啥呀,你上周都没有写日志!');
                          return;
                      }
                      input.setAttribute("value", value);
                      document.body.appendChild(input);
                      input.select();
                      input.setSelectionRange(0, 9999);
                      if (document.execCommand("copy")) {
                          document.execCommand("copy");
                          _this.$message({
                              message: '复制成功!',
                              type: 'success'
                          });
                      }else{
                          _this.$message.error('什么都没有复制到,嘿嘿');
                      }
                      document.body.removeChild(input);
                  });
              }else if(val === 'currentPage'){
                  for(let i = 0;i < _this.worklogItemVos.length;i++){
                      value += _this.worklogItemVos[i].workDate;
                      value += ':';
                      value += _this.worklogItemVos[i].content;
                      value += '\n';
                  }
                  if(value.length === 0){
                      _this.$message.error('复制啥呀,当前页都是空的!');
                      return;
                  }
                  input.setAttribute("value", value);
                  document.body.appendChild(input);
                  input.select();
                  input.setSelectionRange(0, 9999);
                  if (document.execCommand("copy")) {
                      document.execCommand("copy");
                      _this.$message({
                          message: '复制成功!',
                          type: 'success'
                      });
                  }else{
                      _this.$message.error('什么都没有复制到,嘿嘿');
                  }
                  document.body.removeChild(input);
              }else if(val === 'searchContent'){
                  for(let i = 0;i < _this.worklogItemVosTemp.length;i++){
                      value += _this.worklogItemVosTemp[i].workDate;
                      value += ':';
                      value += _this.worklogItemVosTemp[i].content;
                      value += '\n';
                  }
                  if(value.length === 0){
                      _this.$message.error('复制啥呀,你都没查到数据!');
                      return;
                  }
                  input.setAttribute("value", value);
                  document.body.appendChild(input);
                  input.select();
                  input.setSelectionRange(0, 9999);
                  if (document.execCommand("copy")) {
                      document.execCommand("copy");
                      _this.$message({
                          message: '复制成功!',
                          type: 'success'
                      });
                  }else{
                      _this.$message.error('什么都没有复制到,嘿嘿');
                  }
                  document.body.removeChild(input);
              }else{
                  _this.$message.error('什么都没有复制到,嘿嘿!');
              }
          }
        }
    }
</script>

<style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
  .el-table__header tr,
  .el-table__header th {
    padding: 0;
    height: 60px;
  }
  .el-table__body tr,
  .el-table__body td {
    padding: 0;
    height: 60px;
  }
  .suspensionIcon {
    width: 8rem;
    height: 6rem;
    position: fixed;
    bottom: 2rem;
    right: 0.5rem;
    z-index: 9999;
    font-size: 80px;
    cursor:pointer;
    color: #409EFF;
  }
  .suspensionIcon:hover{
    color: #8cc5ff;
  }
</style>
