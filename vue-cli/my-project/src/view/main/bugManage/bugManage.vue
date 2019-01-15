<template>
    <div class="bugManage">
        <!-- 条件查询表单 -->
        <div class="queryParams">
            <el-row>
                <el-col :span="6">
                    <span>缺陷编号</span>
                    <el-input v-model="qxbh"></el-input>
                </el-col>
                <el-col :span="6">
                    <span>缺陷名称</span>
                    <el-input v-model="qxmc"></el-input>
                </el-col>
                <el-col :span="6">
                    <span>缺陷状态</span>
                    <el-select v-model="qxzt" placeholder="请选择">
                        <el-option label="新提起" value="1"></el-option>
                        <el-option label="已解决" value="2"></el-option>
                        <el-option label="关闭" value="3"></el-option>
                        <el-option label="未解决" value="4"></el-option>
                        <el-option label="挂起" value="5"></el-option>
                    </el-select>
                </el-col>
                <el-col :span="6">
                    <span>提出人</span>
                    <el-input v-model="tcr"></el-input>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="6">
                    <span>修改人</span>
                    <el-input v-model="xgr" style="margin-left: 12px;"></el-input>
                </el-col>
                <el-col :span="6">
                    <span>提出日期</span>
                    <el-date-picker
                        v-model="tcrq" 
                        value-format="yyyy-MM-dd" 
                        type="daterange" 
                        range-separator="至" 
                        start-placeholder="开始日期" 
                        end-placeholder="结束日期">
                    </el-date-picker>
                </el-col>
                <el-col :span="6">
                    <span>修改日期</span>
                    <el-date-picker
                        v-model="xgrq" 
                        value-format="yyyy-MM-dd" 
                        type="daterange" 
                        range-separator="至" 
                        start-placeholder="开始日期" 
                        end-placeholder="结束日期">
                    </el-date-picker>
                </el-col>
                <el-col :span="6">
                    <el-button icon="el-icon-search" type="primary">查询</el-button>
                    <el-button icon="el-icon-edit" type="primary">新建缺陷</el-button>
                    <el-button icon="el-icon-download" type="primary">导出表格</el-button>
                </el-col>
            </el-row>
        </div>
        <!-- 缺陷列表 -->
        <div class="table">
            <el-table :data="tableData" border style="text-align: center;" highlight-current-row tooltip-effect="dark">
                <el-table-column prop="bh" label="缺陷编号"></el-table-column>
                <el-table-column prop="mc" label="缺陷名称"></el-table-column>
                <el-table-column prop="zt" label="状态"></el-table-column>
                <el-table-column prop="yrr" label="引入人"></el-table-column>
                <el-table-column prop="tcr" label="提出人"></el-table-column>
                <el-table-column prop="tcsj" label="提出时间"></el-table-column>
                <el-table-column prop="bb" label="版本"></el-table-column>
            </el-table>
        </div>
        <!-- 分页栏 -->
        <div class="footer">
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="this.pageNo"
                :page-sizes="[15, 30, 45, 60]"
                :page-size="this.pageSize"
                background
                layout="prev, pager,next,jumper,total, sizes"
                :total="this.total">
                </el-pagination>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            //查询参数
            qxbh:'',//缺陷编号
            qxmc:'',//缺陷名称
            qxzt:'',//缺陷状态
            tcr:'',//提出人
            xgr:'',//修改人
            tcrq:'',//提出日期
            xgrq:'',//修改日期

            //表格数据
            tableData:[],

            //分页
            total:1,
            allpages:1,
            pageNo:1,
            pageSize:15,
            everyPageNum: 15, //分页组件每页条数显示
        }
    },
    methods: {
        handleCurrentChange(val) {
            //获取每页数据
            console.log(`当前页: ${val}`);
            this.pageNo = val;
            var params = {
                pageNo: val,
                pageNum: this.everyPageNum
            };
            //请求后台
        },
        handleSizeChange(val) {
        //翻页
        this.everyPageNum = val;
        this.handleCurrentChange(1);
        },
    },
}
</script>
<style>
    .queryParams{
        width: 100%;
        height: 80px;
        margin: auto;
        box-shadow: 0px 3px 3px 0px #ccc;
        padding: 10px;
    }
    .el-input{
        width: 250px;
    }
    .el-row{
        margin-bottom: 10px;
    }
    .el-date-editor--daterange.el-input__inner{
        width: 250px;
    }
    .queryParams span{
        font-size: 12px;
    }
    .table{
        width: 98%;
        height: calc(100% - 200px);
        margin: auto;
        margin-top:10px;
        text-align: center;
        overflow: auto;
    }
    .footer{
        width: 100%;
        height: 45px;
        background-color: #EBEEF5;
        position: fixed;
        bottom: 0px;
        text-align: center;
        padding-top: 10px;
    }
</style>