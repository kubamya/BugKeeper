<template>
    <div class="app">
        <div class="header">
            <el-button type="primary" @click="dialogFormVisible = true" style="margin-right:50px;">新建</el-button>
            <el-input v-model="name" style="margin-right:5px;" placeholder="请输入姓名"></el-input><el-button type="primary" @click="getTableData">查询</el-button>
        </div>
        <div class="table">
            <el-table :data="tableData" style="width: 100%">
                <el-table-column type="index" width="50" label="序号"></el-table-column>
                <el-table-column prop="loginid" label="账号"></el-table-column>
                <el-table-column prop="name" label="姓名"></el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button type="danger" icon="el-icon-delete" circle @click="delUser(scope.row)"></el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        
        <el-dialog title="新建人员" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item>
                    <el-input v-model="form.loginid" placeholder="请输入账号"></el-input>
                    <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
                </el-form-item>
                
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="save()">确 定</el-button>
            </div>
            </el-dialog>
    </div>
</template>
<script>
export default {
    data() {
        return {
            name:"",
            tableData:[],
            dialogFormVisible:false,
            form:{
                loginid:'',
                name:''
            }
        }
    },
    mounted() {
        this.getTableData();
    },
    methods: {
        getTableData(){
            //初始化和查询走一套后台
            //组装查询参数
            var params = new URLSearchParams();
            params.append('name', this.name);
            //发送后台请求
            this.$axios({method:'post',url: 'http://localhost:8082/demo/getUserInfo', data: params}).then(response =>{
                if(response.status == 200){
                    //请求成功
                    this.tableData = response.data;
                }else{
                    //请求失败
                    this.$message({
                        message: '列表查询失败！请联系关系员！',
                        type: 'warning'
                        });
                }
            });
        },
        save(){
            //组装查询参数
            var params = new URLSearchParams();
            params.append('name', this.form.name);
            params.append('loginid', this.form.loginid);
            //发送后台请求
            this.$axios({method:'post',url: 'http://localhost:8082/demo/addUser', data: params}).then(response =>{
                if(response.status == 200 && response.data.result == 'success'){
                    //请求成功
                    this.$message({
                        message: '添加成功！',
                        type: 'success'
                    });
                    this.dialogFormVisible = false;
                    this.getTableData();
                }else{
                    //请求失败
                    this.$message({
                        message: '添加失败！请联系关系员！',
                        type: 'warning'
                        });
                }
            });
        },
        excuteDel(row){
            //组装查询参数
            var params = new URLSearchParams();
            params.append('bh', row.bh);
            //发送后台请求
            this.$axios({method:'post',url: 'http://localhost:8082/demo/delUser', data: params}).then(response =>{
                 if(response.status == 200 && response.data.result == 'success'){
                    //请求成功
                    this.$message({
                        message: '删除成功！',
                        type: 'success'
                    });
                    this.dialogFormVisible = false;
                    this.getTableData();
                }else{
                    //请求失败
                    this.$message({
                        message: '删除失败！请联系关系员！',
                        type: 'warning'
                        });
                }
            });
        },
        delUser(row){
            this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(()=>{
                this.excuteDel(row);
            });
        }
    },
}
</script>
<style>
    .app{
        width:55%;
        margin:0 auto;
        margin-top: 100px;
        border-radius: 20px;
        box-shadow: 0 0 10px #ccc;
        padding: 20px;
    }
    .header{
        width:90%;
        height: 100px;
        line-height: 100px;
        margin:0 auto;
        border-radius: 20px;
	    border:  1px solid #ccc;
        padding: 0 20px;
        margin-bottom: 20px;
    }
    .header .el-input{
        width:120px;
    }
</style>