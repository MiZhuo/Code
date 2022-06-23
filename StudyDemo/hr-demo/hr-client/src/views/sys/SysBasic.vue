<template>
    <div>
        <el-tabs v-model="activeName" type="card">
            <el-tab-pane label="部门管理" name="first">
                <DepManager></DepManager>
            </el-tab-pane>
            <el-tab-pane label="职位管理" name="second">
                <PositionManager></PositionManager>
            </el-tab-pane>
            <el-tab-pane label="职称管理" name="third">
                <JobTitleManager></JobTitleManager>
            </el-tab-pane>
            <el-tab-pane label="奖惩规则" name="fourth">
                <ReAndPubManager></ReAndPubManager>
            </el-tab-pane>
            <el-tab-pane label="权限组" name="fifth">
                <RoleTeam></RoleTeam>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    import DepManager from "../../components/sys/basic/DepManager";
    import PositionManager from "../../components/sys/basic/PositionManager";
    import JobTitleManager from "../../components/sys/basic/JobTitleManager";
    import ReAndPubManager from "../../components/sys/basic/ReAndPubManager";
    import RoleTeam from "../../components/sys/basic/RoleTeam";
    export default {
        name: "SysBasic",
        data(){
            return {
                activeName: 'first'
            }
        },
        components:{
            DepManager,
            PositionManager,
            JobTitleManager,
            ReAndPubManager,
            RoleTeam
        }
    }
</script>

<style scoped>

</style>