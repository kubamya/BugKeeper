<template>
    <div class="projectManage">
        <!-- 整体使用页签 -->
        <div class="projectManageMain">
            <el-tabs type="border-card" style="height: 100%;">
                <el-tab-pane label="我的项目">我的项目</el-tab-pane>
                <el-tab-pane label="新建项目">新建项目</el-tab-pane>
                <el-tab-pane label="变更项目">变更项目</el-tab-pane>
                <el-tab-pane label="结束项目">结束项目</el-tab-pane>
            </el-tabs>
        </div>        
    </div>
</template>
<script>
export default {
    
}
</script>
<style>
    .projectManage{
        width: 100%;
        height: 100%;
    }
    .projectManageMain{
        width: 98%;
        height: calc(100% - 50px);
        margin: auto;
        margin-top: 20px;
    }
</style>