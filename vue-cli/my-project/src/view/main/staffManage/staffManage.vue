<template>
    <div class="staffManage">
        <!-- 整体使用页签 -->
        <div class="staffManageMain">
            <el-tabs type="border-card" style="height: 100%;">
                <el-tab-pane label="个人资料">
                    <div class="staffInfo">
                        <el-form ref="form" label-width="80px">
                            <el-form-item label="姓名">
                                <el-input disabled></el-input>
                            </el-form-item>
                            <el-form-item label="公司">
                                <el-input disabled></el-input>
                            </el-form-item>
                            <el-form-item label="部门">
                                <el-input disabled></el-input>
                            </el-form-item>
                            <el-form-item label="账号">
                                <el-input disabled></el-input>
                            </el-form-item>
                            <el-form-item >
                                <el-button type="text" @click="dialogFormVisible = true">修改密码</el-button>
                            </el-form-item>
                        </el-form>
                        <!-- 修改密码弹出层 -->
                        <el-dialog title="修改密码" :visible.sync="dialogFormVisible">
                            <el-form :model="changePasswordForm">
                                <el-form-item label="原密码" :label-width="formLabelWidth">
                                    <el-input v-model="changePasswordForm.oldPass" autocomplete="off"></el-input>
                                </el-form-item>
                                <el-form-item label="新密码" :label-width="formLabelWidth">
                                    <el-input v-model="changePasswordForm.newPass" autocomplete="off"></el-input>
                                </el-form-item>
                                <el-form-item label="确认密码" :label-width="formLabelWidth">
                                    <el-input v-model="changePasswordForm.confirmPass" autocomplete="off"></el-input>
                                </el-form-item>
                                </el-form-item>
                            </el-form>
                            <div slot="footer" class="dialog-footer">
                                <el-button @click="dialogFormVisible = false">取 消</el-button>
                                <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
                            </div>
                        </el-dialog>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="项目人员管理">暂未开放</el-tab-pane>
                <el-tab-pane label="部门人员管理">暂未开放</el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return {
            //修改密码需要
            dialogFormVisible: false,
            changePasswordForm:{
                oldPass:'',
                newPass:'',
                confirmPass:''
            },
            formLabelWidth: '120px'
        }
    }
}
</script>
<style>
    .staffManage{
        width: 100%;
        height: 100%;
    }
    .staffManageMain{
        width: 98%;
        height: calc(100% - 50px);
        margin: auto;
        margin-top: 20px;
    }
</style>