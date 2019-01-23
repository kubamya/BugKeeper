<template>
    <div class="projectManage">
        <!-- 整体使用页签 -->
        <div class="projectManageMain">
            <el-tabs type="border-card" style="height: 100%;">
                <el-tab-pane label="我的项目">
                    <div class="myProject">
                        <div class="lockedProject">
                            <span>当前锁定的项目：</span>
                            <el-input v-model="lockedProjectMc" disabled></el-input>
                            <el-input v-model="lockedProjectBh" disabled></el-input>
                        </div>
                        <div class="myProjectList">
                            <div class="myProjectListTitle">我的执行中项目</div>
                            <div class="myProjectTable">
                                <el-table :data="myProjectTable" border style="text-align: center;" highlight-current-row tooltip-effect="dark">
                                    <el-table-column prop="bh" label="项目编号"></el-table-column>
                                    <el-table-column prop="mc" label="项目名称"></el-table-column>
                                    <el-table-column prop="xmjl" label="项目经理"></el-table-column>
                                    <el-table-column prop="cjrq" label="创建日期"></el-table-column>
                                    <el-table-column label="操作">
                                        <template slot-scope="scope">
                                            <el-button type="success" icon="el-icon-check" circle @click="lockProject"></el-button>
                                            <el-button type="danger" icon="el-icon-delete" circle @click="delProject"></el-button>
                                        </template>
                                    </el-table-column>
                                </el-table>
                            </div>
                        </div>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="新建项目">
                    <div class="newProject">
                        <el-form ref="form" :rules="newProjectRules" :model="newProjectForm" label-width="80px">
                            <el-form-item label="项目编号" prop="xmbh">
                                <el-input v-model="newProjectForm.xmbh"></el-input>
                            </el-form-item>
                            <el-form-item label="项目名称" prop="xmmc">
                                <el-input v-model="newProjectForm.xmmc"></el-input>
                            </el-form-item>
                            <el-form-item label="项目经理" prop="xmjl">
                                <el-input v-model="newProjectForm.xmjl"></el-input>
                            </el-form-item>
                            <el-form-item label="是否有效">
                                <el-switch v-model="newProjectForm.yx"></el-switch>
                            </el-form-item>
                            <el-form-item label="备注">
                                <el-input type="textarea" v-model="newProjectForm.bz"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="createNewProject">创建项目</el-button>
                                <el-button @click="resetNewProjectForm">重置</el-button>
                            </el-form-item>
                        </el-form>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="变更项目">暂未开放</el-tab-pane>
                <el-tab-pane label="结束项目">暂未开放</el-tab-pane>
            </el-tabs>
        </div>        
    </div>
</template>
<script>
export default {
    data(){
        return{
            //我的项目数据
            myProjectTable:[],//我的执行中项目表格数据
            lockedProjectMc:'',//当前锁定的项目名称
            lockedProjectBh:'',//当前锁定的项目编号

            //新建项目数据
            newProjectForm:{
                xmbh:'',
                xmmc:'',
                xmjl:'',
                yx: false,
                bz:''
            },//表单
            newProjectRules:{
                xmbh:[
                    { required: true, message: '请输入项目编号', trigger: 'blur' }
                ],
                xmmc:[
                    { required: true, message: '请输入项目名称', trigger: 'blur' }
                ],
                xmjl:[
                    { required: true, message: '请输入项目经理姓名', trigger: 'blur' }
                ]
            },//表单验证规则

        }
    },
    methods: {
        //锁定执行项目
        lockProject(){
            this.$confirm('确认锁定执行项目为此项目？').then();
        },
        //删除执行项目
        delProject(){
            this.$confirm('确认删除执行项目？删除后可重新添加').then();
        },
        //创建新项目
        createNewProject(){
            this.$confirm('是否立即创建？创建成功之后可更改项目信息。').then(_ => {
                    console.log("ok")
                }               
            );
        },
        //重置新建表单
        resetNewProjectForm(){
            this.newProjectForm.xmbh = '';
            this.newProjectForm.xmmc = '';
            this.newProjectForm.xmjl = '';
            this.newProjectForm.yx = false;
            this.newProjectForm.bz = '';
        }
    },
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
    .myProject{
        width: 100%;
        height: 100%;
        border: 1px solid #ccc;
        border-radius: 10px;
    }
    .lockedProject{
        width: 95%;
        height: 50px;
        margin: auto;
        margin-top: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
        line-height: 50px;
        padding-left: 10px;
        font-size: 14px;
	    color: #666;
    }
    .myProjectList{
        width: 95%;
        margin: auto;
        margin-top: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
        padding-left: 10px;
        margin-bottom: 20px;
    }
    .myProjectListTitle{
        margin-top: 10px;
        color: #666;
        font-size: 14px;
        height: 30px;
        line-height: 30px;
    }
    .myProjectTable{
        width: 97%;
        margin: auto;
        margin-top: 10px;
        margin-bottom: 10px;
    }
</style>