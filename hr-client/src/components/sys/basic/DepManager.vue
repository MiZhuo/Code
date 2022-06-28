<template>
    <div>
        <div>
            <el-input placeholder="输入部门名称搜索部门..." size="mini" style="width: 450px"  v-model="filterText"
                      prefix-icon="el-icon-search">
            </el-input>
        </div>
        <div style="margin-top: 10px">
            <el-tree class="filter-tree" :data="deptTreeData" :props="deptTreeProps" :expand-on-click-node="false"
                     :filter-node-method="filterNode" ref="deptTree" style="width: 450px">
                    <span class="custom-tree-node" slot-scope="{ node, data }"
                        style="display: flex;justify-content: space-between;width: 100%">
                        <span>{{ node.label }}</span>
                        <span>
                          <el-button
                                  type="primary"
                                  size="mini"
                                  class="deptTreeBtn"
                                  @click="() => toAddDept(data)">
                            添加部门
                          </el-button>
                          <el-button
                                  type="danger"
                                  size="mini"
                                  class="deptTreeBtn"
                                  @click="() => deleteDept(data)">
                            删除部门
                          </el-button>
                        </span>
                    </span>
            </el-tree>
        </div>
        <el-dialog title="添加部门" :visible.sync="dialogFormVisible">
            <el-form v-model="dept" style="text-align: center">
                <el-form-item>
                    <el-tag type="info">上级部门编号</el-tag>
                    <el-input class="deptInput" size="mini" v-model="dept.parentId" disabled></el-input>
                </el-form-item>
                <el-form-item>
                    <el-tag>上级部门名称</el-tag>
                    <el-input class="deptInput" size="mini" v-model="dept.parentName" disabled></el-input>
                </el-form-item>
                <el-form-item>
                    <el-tag>新增部门名称</el-tag>
                    <el-input class="deptInput" size="mini" v-model="dept.name"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button size="mini" @click="dialogFormVisible = false">取 消</el-button>
                <el-button size="mini" type="primary" @click="addDept">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "DepManager",
        data(){
            return {
                deptTreeData:[],
                deptTreeProps: {
                    children: 'children',
                    label: 'name'
                },
                filterText: '',
                dialogFormVisible: false,
                dept:{
                    'parentId' : '',
                    'parentName' : '',
                    'name' : ''
                }
            }
        },
        methods:{
            initDepTree(){
                this.getRequest("/system/basic/dept/deptTree").then(res=>{
                    if(res){
                        this.deptTreeData = res.result;
                    }
                });
            },
            filterNode(value, data) {
                if (!value) return true;
                return data.name.indexOf(value) !== -1;
            },
            toAddDept(data){
                this.dept.parentId = data.id;
                this.dept.parentName = data.name;
                this.dialogFormVisible = true;
            },
            addDept(){
                this.postRequest("/system/basic/dept/",this.dept).then(res=>{
                    if(res){
                        this.dept.parentId = '';
                        this.dept.parentName = '';
                        this.dept.name = '';
                        this.dept2Depts(this.deptTreeData,res.result);
                        this.dialogFormVisible = false;
                    }
                });
            },
            dept2Depts(depts,dept){
                for(let i = 0;i < depts.length;i++){
                    let d = depts[i];
                    if(d.id == dept.parentId){
                        d.children = d.children.concat(dept);
                        return;
                    }else{
                        this.dept2Depts(d.children,dept);
                    }
                }
            },
            deleteDept(data){
                if(data.children.length){
                    this.$message.error("不能删除父部门");
                    return;
                }
                this.$confirm('此操作将永久删除【'+ data.name +'】部门, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/system/basic/dept/" + data.id).then(res=>{
                        if(res){
                            this.removeDept(this.deptTreeData,data);
                        }
                    });
                });
            },
            removeDept(depts,dept){
                for(let i = 0;i < depts.length;i++){
                    let d = depts[i];
                    if(d.id == dept.id){
                        depts = depts.splice(i,1);
                        return;
                    }else{
                        this.removeDept(d.children,dept);
                    }
                }
            }
        },
        watch: {
            filterText(val) {
                this.$refs.deptTree.filter(val);
            }
        },
        mounted() {
            this.initDepTree();
        }
    }
</script>

<style>
.deptTreeBtn{
    padding: 2px;
}
.deptInput{
    width: 200px;
    margin-left: 10px;
}
</style>