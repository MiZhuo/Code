<template>
    <div>
        <div>
            <div style="display:flex;justify-content: space-between">
                <div>
                    <el-input size="mini" placeholder="通过员工姓名搜索员工" v-model="keyWord"
                              style="width: 300px" prefix-icon="el-icon-search" clearable
                              @clear="initEmployeeTable"
                              @keydown.enter.native="initEmployeeTable"></el-input>
                    <el-button type="primary" size="mini" :disabled="advDisabled"
                               icon="el-icon-search" style="margin-left: 10px" @click="initEmployeeTable">搜索
                    </el-button>
                    <el-button type="primary" size="mini"  style="margin-left: 10px" @click="showAdvSearch" :disabled="advDisabled">
                               <i :class="advSearchIcon" aria-hidden="true" style="margin-right: 5px"/>高级搜索
                    </el-button>
                </div>
                <div>
                    <el-button type="text" size="mini" style="margin-right: 8px;text-decoration:underline" @click="downloadFileTemplate">下载导入文件模板</el-button>
                    <el-upload style="display: inline-flex;margin-right: 8px"
                            action="/employee/basic/import"
                            :before-upload = "beforeUpload"
                            :on-success="uploadSuccess"
                            :on-error="uploadError"
                            :disabled="uploadDisabled"
                            accept=".xls,.xlsx"
                            :show-file-list="false">
                        <el-button type="success" size="mini" :disabled="uploadDisabled"
                                   :icon="uploadIcon"> {{uploadTitle}}
                        </el-button>
                    </el-upload>
                    <el-button type="success" size="mini"
                               icon="el-icon-download" @click="exportEmployee"> 导出数据
                    </el-button>
                    <el-button type="primary" size="mini"
                               icon="el-icon-plus" @click="toAddEmployee">员工建档
                    </el-button>
                </div>
            </div>
            <el-collapse-transition>
                <div style="border: 1px solid #409eff;border-radius: 5px;box-sizing: border-box;padding: 5px;margin: 10px 0px;" v-show="showDiv">
                    <el-form :model="advSearchCondition" size="mini" ref="advSearchForm">
                        <el-row style="margin-left: 20px">
                            <el-col :span="5">
                                政治面貌:
                                <el-select style="width: 120px"  v-model="advSearchCondition.politicId"
                                           size="mini" placeholder="政治面貌">
                                    <el-option
                                            v-for="item in this.dropDowns.get('politicsstatus')"
                                            :key="item.id"
                                            :label="item.name"
                                            :value="item.id">
                                    </el-option>
                                </el-select>
                            </el-col>
                            <el-col :span="4">
                               民族:
                                <el-select style="width: 120px" v-model="advSearchCondition.nationId"
                                           size="mini" placeholder="选择民族">
                                    <el-option
                                            v-for="item in this.dropDowns.get('nation')"
                                            :key="item.id"
                                            :label="item.name"
                                            :value="item.id">
                                    </el-option>
                                </el-select>
                            </el-col>
                            <el-col :span="4">
                                职位:
                                <el-select style="width: 120px" v-model="advSearchCondition.posId"
                                           size="mini" placeholder="选择职位">
                                    <el-option
                                            v-for="item in this.dropDowns.get('position')"
                                            :key="item.id"
                                            :label="item.name"
                                            :value="item.id">
                                    </el-option>
                                </el-select>
                            </el-col>
                            <el-col :span="4">
                                职称:
                                <el-select style="width: 120px" v-model="advSearchCondition.jobLevelId"
                                           size="mini" placeholder="选择职称">
                                    <el-option
                                            v-for="item in this.dropDowns.get('joblevel')"
                                            :key="item.id"
                                            :label="item.name"
                                            :value="item.id">
                                    </el-option>
                                </el-select>
                            </el-col>
                            <el-col :span="7">
                                聘用形式:
                                <el-radio-group v-model="advSearchCondition.engageForm" size="mini">
                                    <el-radio label="劳动合同">劳动合同</el-radio>
                                    <el-radio label="劳务合同" style="margin-left: -10px">劳务合同</el-radio>
                                </el-radio-group>
                            </el-col>
                        </el-row>
                        <el-row style="margin-left: 20px;margin-top: 10px">
                        <el-col :span="5">
                           所属部门:
                            <el-popover
                                    placement="right"
                                    title="选择部门"
                                    trigger="manual"
                                    v-model="departTreeVisible2"
                                    width="200">
                                <el-tree :data="deptTreeData" :expand-on-click-node="false"
                                         style="font-size: 10px"
                                         :default-expand-all="true" :props="defaultProps"
                                         :highlight-current="true"
                                         @node-click="handleNodeClick2"></el-tree>
                                <div style="width: 120px;display:inline-flex;
                                    border:1px solid #dedede;height: 26px;
                                    border-radius: 5px;
                                    cursor: pointer"
                                     slot="reference" placeholder="选择部门"
                                     @click="showDepTree2"><span style="margin-left: 18px;height: 18px;font-size:10px;">{{advSearchCondition.departmentName}}</span></div>
                            </el-popover>
                        </el-col>
                        <el-col :span="14">
                            入职日期:
                            <el-date-picker
                                    size="mini"
                                    v-model="advSearchCondition.entryDate"
                                    type="daterange"
                                    align="right"
                                    unlink-panels
                                    range-separator="至"
                                    start-placeholder="开始日期"
                                    end-placeholder="结束日期"
                                    style="width: 445px;"
                                    value-format="yyyy-MM-dd"
                                    format="yyyy-MM-dd"
                                    :picker-options="pickerOptions">
                            </el-date-picker>
                        </el-col>
                        <el-col :span="5">
                            <el-button size="mini" style="margin-left: 10px" @click="cancelShowDiv">取消
                            </el-button>
                            <el-button size="mini" type="primary" style="margin-left: 10px" @click="resetBtn">重置
                            </el-button>
                            <el-button type="primary" size="mini"
                                       icon="el-icon-search" style="margin-left: 10px" @click="advSearch">搜索
                            </el-button>
                        </el-col>
                    </el-row>
                    </el-form>
                </div>
            </el-collapse-transition>
        </div>
        <div style="margin-top: 10px">
            <el-table :data="employeeTableData.list" size="mini"
                      class="component-table"
                      border stripe
                      style="width: 100%;height: 100%"
                      max-height="500"
                      :header-cell-style="getTableStyle"
                      :cell-style="getTableStyle"
                      v-loading="loading"
                      element-loading-text="正在加载..."
                      @selection-change="handleSelectionChange"
                      @sort-change="handleSortChange">
                <el-table-column type="selection" width="40" fixed></el-table-column>
                <el-table-column prop="id" label="编号" width="0" v-if="false"></el-table-column>
                <el-table-column prop="workId" label="工号" width="100" fixed></el-table-column>
                <el-table-column prop="name" label="员工姓名" width="100" fixed></el-table-column>
                <el-table-column prop="gender" label="性别" width="60"></el-table-column>
                <el-table-column prop="birthday" label="出生年月" width="100" sortable="custom"></el-table-column>
                <el-table-column prop="idCard" label="身份证号" width="150"></el-table-column>
                <el-table-column prop="wedlock" label="婚姻状况" width="80"></el-table-column>
                <el-table-column prop="nationId" label="民族" width="100">
                    <template slot-scope="scope">
                        {{getTableValueByKey('nation',scope.row.nationId)}}
                    </template>
                </el-table-column>
                <el-table-column prop="nativePlace" label="籍贯" width="70"></el-table-column>
                <el-table-column prop="politicId" label="政治面貌" width="100">
                    <template slot-scope="scope">
                        {{getTableValueByKey('politicsstatus',scope.row.politicId)}}
                    </template>
                </el-table-column>
                <el-table-column prop="email" label="邮箱" width="140"></el-table-column>
                <el-table-column prop="phone" label="电话号码" width="100"></el-table-column>
                <el-table-column prop="address" label="联系地址" width="200"></el-table-column>
                <el-table-column prop="departmentId" label="所属部门" width="100">
                    <template slot-scope="scope">
                        {{getTableValueByKey('department',scope.row.departmentId)}}
                    </template>
                </el-table-column>
                <el-table-column prop="jobLevelId" label="职称" width="90">
                    <template slot-scope="scope">
                        {{getTableValueByKey('joblevel',scope.row.jobLevelId)}}
                    </template>
                </el-table-column>
                <el-table-column prop="posId" label="职位" width="90">
                    <template slot-scope="scope">
                        {{getTableValueByKey('position',scope.row.posId)}}
                    </template>
                </el-table-column>
                <el-table-column prop="engageForm" label="聘用形式" width="80"></el-table-column>
                <el-table-column prop="tipTopDegree" label="最高学历" width="100" sortable="custom"></el-table-column>
                <el-table-column prop="specialty" label="所属专业" width="140"></el-table-column>
                <el-table-column prop="school" label="毕业院校" width="120"></el-table-column>
                <el-table-column prop="workState" label="在职状态" width="100" sortable="custom">
                    <template slot-scope="scope">
                        <el-tag :type="scope.row.workState === '在职' ? 'success' : 'danger'"
                                disable-transitions>{{scope.row.workState}}</el-tag>
                    </template>
                </el-table-column>
                <el-table-column prop="workAge" label="工龄" width="90" sortable="custom">
                    <template slot-scope="scope">
                        <el-tag size="medium">{{ scope.row.workAge }}年</el-tag>
                    </template>
                </el-table-column>
                <el-table-column label="入职日期" width="130">
                    <template slot-scope="scope">
                        <i class="el-icon-time" v-show="scope.row.beginDate != undefined"></i>
                        <span style="margin-left: 10px">{{ scope.row.beginDate == undefined ? '-' : scope.row.beginDate }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="转正日期" width="120">
                    <template slot-scope="scope">
                        <i class="el-icon-time" v-show="scope.row.conversionTime != undefined"></i>
                        <span style="margin-left: 10px">{{ scope.row.conversionTime == undefined ? '-' : scope.row.conversionTime }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="离职日期" width="120">
                    <template slot-scope="scope">
                        <i class="el-icon-time" v-show="scope.row.notWorkDate != undefined"></i>
                        <span style="margin-left: 10px">{{ scope.row.notWorkDate == undefined ? '-' : scope.row.notWorkDate }}</span>
                    </template>
                </el-table-column>
                <el-table-column prop="contractTerm" label="合同期限" width="90">
                    <template slot-scope="scope">
                        <el-tag size="medium" :type="scope.row.contractTerm > 5 ? 'success' : 'warning'">
                            {{ scope.row.contractTerm }}年</el-tag>
                    </template>
                </el-table-column>
                <el-table-column label="合同起始日期" width="120">
                    <template slot-scope="scope">
                        <i class="el-icon-time"></i>
                        <span style="margin-left: 10px">{{ scope.row.beginContract }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="合同终止日期" width="120">
                    <template slot-scope="scope">
                        <i class="el-icon-time"></i>
                        <span style="margin-left: 10px">{{ scope.row.endContract }}</span>
                    </template>
                </el-table-column>
                <el-table-column prop="opera" label="操作" width="200" fixed="right">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                style="padding: 3px"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                                size="mini"
                                type="primary"
                                style="padding: 3px"
                                @click="seeEmpAdv(scope.$index, scope.row)">查看高级资料</el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                style="padding: 3px"
                                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <div >
            <el-button 
                    size="mini"
                    type="danger"
                    :disabled="handleDisabled"
                    style="padding: 3px;margin-top: 10px;"
                    @click="handleBatchDelete">批量删除</el-button>
            <el-pagination style="float: right"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[10,20,30,50]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="employeeTableData.total">
            </el-pagination>
        </div>
        <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible" width="85%">
            <el-form :model="employee" :rules="rules" size="mini" ref="employeeForm">
                <el-row>
                    <el-col :span="6">
                        <el-form-item label="工号:" prop="workId" size="mini" class="form-item-class">
                            <el-input style="width: 170px" prefix-icon="fa fa-vcard" v-model="employee.workId" disabled></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="姓名:" prop="name" size="mini" class="form-item-class">
                            <el-input style="width: 170px" prefix-icon="fa fa-user-circle" v-model="employee.name" placeholder="请输入员工姓名"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="性别:" prop="gender" size="mini" class="form-item-class">
                            <el-radio-group style="width: 170px"  v-model="employee.gender" size="mini">
                                <el-radio label="男">男</el-radio>
                                <el-radio label="女">女</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="出生年月:" prop="birthday" size="mini">
                            <el-date-picker
                                    v-model="employee.birthday"
                                    size="mini"
                                    style="width: 180px"
                                    type="date"
                                    value-format="yyyy-MM-dd"
                                    format="yyyy-MM-dd"
                                    placeholder="选择日期">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="6">
                        <el-form-item label="籍贯:" prop="nativePlace" size="mini" class="form-item-class">
                            <el-input style="width: 170px"  prefix-icon="el-icon-office-building" v-model="employee.nativePlace" placeholder="请输入员工籍贯"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="电话号码:" prop="phone" size="mini">
                            <el-input style="width: 170px" prefix-icon="el-icon-phone" v-model="employee.phone" placeholder="电话号码"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="电子邮箱:" prop="email" size="mini">
                            <el-input style="width: 170px"  prefix-icon="el-icon-message" v-model="employee.email" placeholder="电子邮箱地址"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="联系地址:" prop="address" size="mini">
                            <el-input style="width: 180px"  prefix-icon="el-icon-s-home" v-model="employee.address" placeholder="联系地址"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="6">
                        <el-form-item label="民族:" prop="nationId" size="mini" class="form-item-class">
                            <el-select style="width: 170px" v-model="employee.nationId"
                                       size="mini" placeholder="选择民族">
                                <el-option
                                        v-for="item in this.dropDowns.get('nation')"
                                        :key="item.id"
                                        :label="item.name"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="所属部门:" prop="departmentId" size="mini">
                            <el-popover
                                    placement="right"
                                    title="选择部门"
                                    trigger="manual"
                                    v-model="departTreeVisible"
                                    width="200">
                                    <el-tree :data="deptTreeData" :expand-on-click-node="false"
                                             style="font-size: 10px"
                                             :default-expand-all="true" :props="defaultProps"
                                             :highlight-current="true"
                                             @node-click="handleNodeClick"></el-tree>
                                <div style="width: 170px;display:inline-flex;
                                        border:1px solid #dedede;height: 26px;
                                        border-radius: 5px;
                                        cursor: pointer"
                                          slot="reference" placeholder="选择部门"
                                     @click="showDepTree"><span style="margin-left: 18px;height: 18px;font-size:10px;">{{employee.departmentName}}</span></div>
                            </el-popover>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="职位:" prop="posId" size="mini" class="form-item-class">
                            <el-select style="width: 170px" v-model="employee.posId"
                                       size="mini" placeholder="选择职位">
                                <el-option
                                        v-for="item in this.dropDowns.get('position')"
                                        :key="item.id"
                                        :label="item.name"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="职称:" prop="posId" size="mini" class="form-item-class">
                            <el-select style="width: 180px" v-model="employee.jobLevelId"
                                       size="mini" placeholder="选择职称">
                                <el-option
                                        v-for="item in this.dropDowns.get('joblevel')"
                                        :key="item.id"
                                        :label="item.name"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="6">
                        <el-form-item label="政治面貌:" prop="politicId" size="mini">
                            <el-select style="width: 170px"  v-model="employee.politicId"
                                       size="mini" placeholder="政治面貌">
                                <el-option
                                        v-for="item in this.dropDowns.get('politicsstatus')"
                                        :key="item.id"
                                        :label="item.name"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="毕业院校:" prop="school" size="mini">
                            <el-input style="width: 170px"  prefix-icon="fa fa-university" v-model="employee.school" placeholder="毕业院校"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="专业名称:" prop="specialty" size="mini">
                            <el-input style="width: 170px"  prefix-icon="fa fa-language" v-model="employee.specialty" placeholder="专业名称"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="学历:" prop="tipTopDegree" size="mini" class="form-item-class">
                            <el-select style="width: 180px" v-model="employee.tipTopDegree"
                                       size="mini" placeholder="最高学历">
                                <el-option key="博士" label="博士" value="博士"></el-option>
                                <el-option key="硕士" label="硕士" value="硕士"></el-option>
                                <el-option key="本科" label="本科" value="本科"></el-option>
                                <el-option key="大专" label="大专" value="大专"></el-option>
                                <el-option key="高中" label="高中" value="高中"></el-option>
                                <el-option key="初中" label="初中" value="初中"></el-option>
                                <el-option key="小学" label="小学" value="小学"></el-option>
                                <el-option key="其他" label="其他" value="其他"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="6">
                        <el-form-item label="入职日期:" prop="beginDate" size="mini">
                            <el-date-picker
                                    v-model="employee.beginDate"
                                    size="mini"
                                    style="width: 170px"
                                    type="date"
                                    value-format="yyyy-MM-dd"
                                    format="yyyy-MM-dd"
                                    placeholder="选择日期">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="转正日期:" prop="conversionTime" size="mini">
                            <el-date-picker
                                    v-model="employee.conversionTime"
                                    size="mini"
                                    style="width: 170px"
                                    type="date"
                                    value-format="yyyy-MM-dd"
                                    format="yyyy-MM-dd"
                                    placeholder="选择日期">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="婚姻状况:" prop="wedlock" size="mini">
                            <el-select style="width: 170px" v-model="employee.wedlock"
                                       size="mini" placeholder="婚姻状况">
                                <el-option key="已婚" label="已婚" value="已婚"></el-option>
                                <el-option key="未婚" label="未婚" value="未婚"></el-option>
                                <el-option key="离异" label="离异" value="离异"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="6">
                        <el-form-item label="证件号码:" prop="idCard" size="mini">
                            <el-input style="width: 180px"  prefix-icon="fa fa-id-card" v-model="employee.idCard" placeholder="请输入身份证号码"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="6">
                        <el-form-item label="聘用形式:" prop="engageForm" size="mini">
                            <el-radio-group v-model="employee.engageForm" size="mini">
                                <el-radio label="劳动合同">劳动合同</el-radio>
                                <el-radio label="劳务合同" style="margin-left: -20px">劳务合同</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </el-col>
                    <el-col :span="18">
                        <el-form-item label="合同日期:" prop="contract" size="mini">
                            <el-date-picker
                                    v-model="employee.contract"
                                    type="daterange"
                                    align="right"
                                    unlink-panels
                                    range-separator="至"
                                    start-placeholder="开始日期"
                                    end-placeholder="结束日期"
                                    style="width: 430px"
                                    value-format="yyyy-MM-dd"
                                    format="yyyy-MM-dd"
                                    :picker-options="pickerOptions">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button size="mini" @click="cancelAddEmployee">取 消</el-button>
                <el-button size="mini" type="primary" @click="addEmployee">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import {Message} from "element-ui";

    export default {
        name: "EmpBasic",
        data(){
            let validateDate = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请选择日期'));
                } else {
                    let date1 = new Date(this.employee.beginDate);
                    let date2 = new Date(this.employee.conversionTime);
                    if( date1 > date2){
                        callback(new Error('转正日期不能早于入职日期'));
                    }
                    callback();
                }
            };
            return{
                keyWord:'',
                loading:false,
                employeeTableData: Object,
                dropDowns: new Map(),
                pageNum: 1,
                pageSize: 10,
                orderField:'',
                sortType:'',
                dialogFormVisible: false,
                employee:{
                    workId:'',
                    name:'',
                    gender: '',
                    birthday:'',
                    nativePlace:'',
                    email:'',
                    phone:'',
                    address:'',
                    engageForm:'',
                    nationId:'',
                    departmentId:'',
                    jobLevelId:'',
                    posId:'',
                    politicId:'',
                    school:'',
                    specialty:'',
                    tipTopDegree:'',
                    beginDate:'',
                    conversionTime:'',
                    wedlock:'',
                    idCard:'',
                    contract:'',
                    beginContract:'',
                    endContract:''
                },
                rules:{
                    workId: [
                        { required: true, message: '员工号不能为空', trigger: 'change' }
                    ],
                    name: [
                        { required: true, message: '请输入员工姓名', trigger: 'blur' },
                        { min: 2, max: 10, message: '长度在2到10个字符', trigger: 'blur' }
                    ],
                    gender: [
                        { required: true, message: '请选择员工性别', trigger: 'change' }
                    ],
                    birthday: [
                        { required: true, message: '请选择日期', trigger: 'change' }
                    ],
                    nativePlace: [
                        { required: true, message: '请输入员工籍贯', trigger: 'blur' }
                    ],
                    email: [
                        { required: true, message: '请输入员工邮箱', trigger: 'blur' },
                        { pattern: /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/, message: '邮箱格式错误', trigger: 'blur' }
                    ],
                    phone: [
                        { required: true, message: '请输入员工联系电话', trigger: 'blur' },
                        { pattern: /^1[34578]\d{9}$/, message: '目前只支持中国大陆的手机号码', trigger: 'blur' }
                    ],
                    address: [
                        { required: true, message: '请输入员工联系地址', trigger: 'blur' },
                    ],
                    engageForm: [
                        { required: true, message: '请选择聘用形式', trigger: 'change' }
                    ],
                    nationId: [
                        { required: true, message: '请选择一项', trigger: 'change' }
                    ],
                    departmentId: [
                        { required: true, message: '请选择一项', trigger: 'change' }
                    ],
                    jobLevelId: [
                        { required: true, message: '请选择一项', trigger: 'change' }
                    ],
                    posId: [
                        { required: true, message: '请选择一项', trigger: 'change' }
                    ],
                    politicId: [
                        { required: true, message: '请选择一项', trigger: 'change' }
                    ],
                    school: [
                        { required: true, message: '请输入毕业院校', trigger: 'blur' },
                        { min: 2, max: 10, message: '长度在2到10个字符', trigger: 'blur' }
                    ],
                    specialty: [
                        { required: true, message: '请输入员工专业名称', trigger: 'blur' },
                        { min: 2, max: 10, message: '长度在2到10个字符', trigger: 'blur' }
                    ],
                    tipTopDegree: [
                        { required: true, message: '请选择一项', trigger: 'change' }
                    ],
                    beginDate: [
                        { validator:validateDate,required: true, trigger: 'change' }
                    ],
                    conversionTime: [
                        { validator:validateDate,required: true, trigger: 'change' }
                    ],
                    wedlock: [
                        { required: true, message: '请选择一项', trigger: 'change' }
                    ],
                    idCard: [
                        { required: true, message: '请输入员工证件号码', trigger: 'blur' },
                        { pattern: /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/, message: '证件号码格式错误', trigger: 'blur' }
                    ],
                    contract: [
                        { required: true, message: '请填写合同日期', trigger: 'change' }
                    ]
                },
                pickerOptions: {
                    shortcuts: [{
                        text: '一年',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            end.setTime(start.getTime() + 3600 * 1000 * 24 * 365);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '两年',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            end.setTime(start.getTime() + 3600 * 1000 * 24 * 365 * 2);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '五年',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 365 * 5);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '十年',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            end.setTime(start.getTime() + 3600 * 1000 * 24 * 365 * 10);
                            picker.$emit('pick', [start, end]);
                        }
                    }]
                },
                deptTreeData:[],
                defaultProps:{
                    children: 'children',
                    label: 'name'
                },
                departTreeVisible:false,
                departTreeVisible2:false,
                dialogTitle:'员工建档',
                uploadDisabled:false,
                uploadTitle:'导入数据',
                uploadIcon: 'el-icon-upload2',
                advSearchCondition:{
                    nationId:'',
                    departmentId:'',
                    departmentName:'',
                    jobLevelId:'',
                    posId:'',
                    politicId:'',
                    entryDate:'',
                    beginDate:'',
                    endDate:'',
                    pageNum: 1,
                    pageSize: 10,
                    orderField:'',
                    sortType:'',
                },
                showDiv:false,
                advDisabled:false,
                advSearchIcon:"fa fa-angle-double-down",
                searchType:'0',
                handleDisabled: true,
                multipleSelection: []
            }
        },
        methods:{
            initEmployeeTable(){
                this.searchType = '0';
                let formData = new FormData();
                formData.append("pageNum",this.pageNum);
                formData.append("pageSize",this.pageSize);
                formData.append("keyWord",this.keyWord);
                formData.append("orderField",this.orderField);
                formData.append("sortType",this.sortType);
                this.loading = true;
                this.postRequest('/employee/basic/getAll',formData).then((res)=>{
                    if(res){
                        this.employeeTableData = res.result;
                    }
                    this.loading = false;
                });
            },
            initDropDown(arr){
                this.getRequest('/common/dropDown/' + arr).then((res)=>{
                    if(res){
                        let obj = res.result;
                        for(let code in obj){
                           this.dropDowns.set(code,obj[code]);
                        }
                    }
                });
            },
            getTableValueByKey(code,key) {
                let list = this.dropDowns.get(code);
                for (let i = 0; i < list.length; i++) {
                    if (list[i].id == key) {
                        return list[i].name;
                    }
                }
            },
            handleSelectionChange(val){
                this.multipleSelection = val;
                if(this.multipleSelection.length > 0){
                    this.handleDisabled = false;
                }else{
                    this.handleDisabled = true;
                }
            },
            handleBatchDelete(){
                this.$confirm('此操作将永久删除所有所选员工, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/employee/basic/deleteMore",this.multipleSelection).then(()=>{
                        this.initEmployeeTable();
                    });
                });
            },
            handleSortChange(column){
                this.orderField = column.prop;
                if(column.order == "ascending"){
                    this.sortType = "asc";
                }else if(column.order == "descending"){
                    this.sortType = "desc";
                }else{
                    this.sortType = "";
                }
                if(this.searchType == '0'){
                    this.initEmployeeTable();
                }else{
                    this.advSearch();
                }
            },
            handleSizeChange(val){
                this.pageSize = val;
                this.pageNum = 1;
                if(this.searchType == '0'){
                    this.initEmployeeTable();
                }else{
                    this.advSearch();
                }
            },
            handleCurrentChange(val){
                this.pageNum = val;
                if(this.searchType == '0'){
                    this.initEmployeeTable();
                }else{
                    this.advSearch();
                }
            },
            toAddEmployee(){
                this.employee = {
                    workId:'',
                        name:'',
                        gender: '',
                        birthday:'',
                        nativePlace:'',
                        email:'',
                        phone:'',
                        address:'',
                        engageForm:'',
                        nationId:'',
                        departmentId:'',
                        jobLevelId:'',
                        posId:'',
                        politicId:'',
                        school:'',
                        specialty:'',
                        tipTopDegree:'',
                        beginDate:'',
                        conversionTime:'',
                        wedlock:'',
                        idCard:'',
                        contract:'',
                        beginContract:'',
                        endContract:''
                };
                this.getRequest('/employee/basic/getWorkId').then((res)=>{
                    if(res){
                        this.employee.workId = res.result;
                        this.dialogTitle = '员工建档';
                        this.dialogFormVisible = true;
                    }
                });
            },
            addEmployee(){
                this.$refs['employeeForm'].validate((valid) => {
                    if (valid) {
                        this.employee.beginContract = this.employee.contract[0];
                        this.employee.endContract = this.employee.contract[1];
                        this.postRequest('/employee/basic/',this.employee).then((res)=>{
                            if(res){
                                this.$refs['employeeForm'].resetFields();
                                this.dialogFormVisible = false;
                                this.initEmployeeTable();
                            }
                        });
                    } else {
                        return false;
                    }
                });
            },
            cancelAddEmployee(){
                this.dialogFormVisible = false;
                this.departTreeVisible = false;
                this.employee.departmentId = '';
                this.employee.departmentName = '';
                this.$refs['employeeForm'].resetFields();
            },
            handleEdit(index,row){
                Object.assign(this.employee,row);
                let array = [];
                array.push( this.employee.beginContract );
                array.push( this.employee.endContract );
                this.employee.contract = array;
                this.getDepartNameInTree(this.deptTreeData);
                this.dialogTitle = '更新员工资料';
                this.dialogFormVisible = true;
            },
            handleDelete(index,row){
                this.$confirm('此操作将永久删除员工【'+ row.name +'】, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest('/employee/basic/' + row.id).then(res=>{
                        if(res){
                            this.initEmployeeTable();
                        }
                    });
                });
            },
            handleNodeClick(node){
                this.employee.departmentId = node.id;
                this.employee.departmentName = node.name;
                this.departTreeVisible = false;
            },
            handleNodeClick2(node){
                this.advSearchCondition.departmentId = node.id;
                this.advSearchCondition.departmentName = node.name;
                this.departTreeVisible2 = false;
            },
            showDepTree(){
                this.departTreeVisible = true;
            },
            showDepTree2(){
                this.departTreeVisible2 = true;
            },
            initDepTree(){
                this.getRequest("/system/basic/dept/deptTree").then(res=>{
                    if(res){
                        this.deptTreeData = res.result;
                    }
                });
            },
            getTableStyle(){
                return 'text-align:center';
            },
            getDepartNameInTree(data){
                for(let i = 0 ;i < data.length;i++){
                    if(data[i].id == this.employee.departmentId){
                        this.employee.departmentName = data[i].name;
                        return;
                    }
                    if(data[i].children){
                        this.getDepartNameInTree(data[i].children);
                    }
                }
            },
            exportEmployee(){
                window.open("/employee/basic/export");
            },
            beforeUpload(file){
                this.uploadTitle = '正在导入';
                this.uploadDisabled = true;
                this.uploadIcon = 'el-icon-loading';
            },
            uploadSuccess(response, file, fileList){
                this.uploadTitle = '导入数据';
                this.uploadDisabled = false;
                this.uploadIcon = 'el-icon-upload2';
                if(response){
                    Message.success({message : response.msg});
                    this.initEmployeeTable();
                }
            },
            uploadError(err, file, fileList){
                this.uploadTitle = '导入数据';
                this.uploadDisabled = false;
                this.uploadIcon = 'el-icon-upload2';
                if(err){
                    Message.error({message : err.msg});
                }
            },
            downloadFileTemplate(){
                window.open("/common/downloadFile/0001");
            },
            showAdvSearch(){
                this.showDiv = true;
                this.advDisabled = true;
                this.advSearchIcon = "fa fa-angle-double-up";
            },
            cancelShowDiv(){
                this.showDiv = false;
                this.advDisabled = false;
                this.advSearchIcon = "fa fa-angle-double-down";
                this.advSearchCondition.departmentId = '';
                this.advSearchCondition.departmentName = '';
                this.advSearchCondition = {
                    nationId:'',
                    departmentId:'',
                    departmentName:'',
                    jobLevelId:'',
                    posId:'',
                    politicId:'',
                    entryDate:'',
                    beginDate:'',
                    endDate:'',
                    pageNum: 1,
                    pageSize: 10,
                    orderField:'',
                    sortType:'',
                };
                this.$refs['advSearchForm'].resetFields();
            },
            advSearch(){
                this.loading = true;
                this.searchType = '1';
                if(this.advSearchCondition.entryDate.length > 0){
                    this.advSearchCondition.beginContract = this.advSearchCondition.entryDate[0];
                    this.advSearchCondition.endContract = this.advSearchCondition.entryDate[1];
                }
                this.advSearchCondition.pageNum = this.pageNum;
                this.advSearchCondition.pageSize = this.pageSize;
                this.advSearchCondition.orderField = this.orderField;
                this.advSearchCondition.sortType = this.sortType;
                this.postRequest('/employee/basic/advSearch',this.advSearchCondition).then((res)=>{
                    if(res){
                        this.employeeTableData = res.result;
                    }
                    this.loading = false;
                });
            },
            resetBtn(){
                this.advSearchCondition = {
                    nationId:'',
                    departmentId:'',
                    departmentName:'',
                    jobLevelId:'',
                    posId:'',
                    politicId:'',
                    entryDate:'',
                    beginDate:'',
                    endDate:'',
                    pageNum: 1,
                    pageSize: 10,
                    orderField:'',
                    sortType:'',
                };
                this.initEmployeeTable();
            }
        },
        created() {
            let arr = [];
            arr.push("nation");
            arr.push("politicsstatus");
            arr.push("department");
            arr.push("joblevel");
            arr.push("position");
            this.initDropDown(arr);
            this.initDepTree();
        },
        mounted() {
            this.initEmployeeTable();
        }
    }
</script>

<style>
    .el-form-item__label{
        font-size: 5px;
    }
    .el-radio__label{
        font-size: 5px;
    }
    .form-item-class{
        margin-left: 25px;
    }
    .el-form-item__error{
        margin-left: 100px;
    }
    .el-tree-node__label{
        font-size: 10px;
    }
</style>