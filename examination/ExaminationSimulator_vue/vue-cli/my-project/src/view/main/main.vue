<template>
    <div class="content">
        <!-- 顶部公用 -->
        <div class="top">
            <div class="title">ExaminationSimulator - V1.0.0.Build</div>
            <div class="userInfo">
                <el-row>
                    <el-col :span="12">Welcom：{{userXm}}</el-col>
                    <el-col :span="12" class="exitBtn">Exit</el-col>
                </el-row>
            </div>
        </div>
        <!-- 整体 -->
        <div class="main">
            
            
            <!-- 居中公用 -->
            <div class="container">
                <div class="menu">
                    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
                        <el-menu-item index="1" @click="goStart">Start</el-menu-item>
                        <el-menu-item index="2" @click="goEdit">Edit Test Question</el-menu-item>
                    </el-menu>
                </div>
                <keep-alive>
                    <router-view/>
                </keep-alive>
            </div>
        </div>
        
    </div>
</template>
<script>
export default {
    data(){
        return {
            userXm:"",
            userBh:"",
            activeIndex:'1'
        }
    },
    mounted() {
        //取得路由传递的参数并设置对应的数据
        this.userXm = this.$route.params.xm;
        this.userBh = this.$route.params.userBh;
        console.log(this.$route.params);
        // 进入菜案页面
        this.$router.push({
            name:'start',
            params:{
                userBh: this.userBh
            }
        });
    },
     methods: {
         goStart(){
             this.$router.push({
                name:'start',
                params:{
                    userBh: this.userBh
                }
            });
         },
         goEdit(){
             this.$router.push({
                name:'edit',
                params:{
                    userBh: this.userBh
                }
            });
         }
    }
}
</script>
<style scope>
    .content{
        width: 100%;
        height:100%;
        background-color:#ccc;
    }
    .top{
        width: 100%;
        height: 80px;
        background-color:#409EFF;
    }
    .title{
        width:400px;
        height:80px;
        text-align: center;
        line-height: 80px;
        font-size: 20px;
        color: #fff;
    }
    .userInfo{
        width: 300px;
        height: 80px;
        text-align: center;
        line-height: 80px;
        position: fixed;
        top: 0px;
        right: 0px;
        font-size: 14px;
        color: #fff;
    }
    .main{
        width: 100%;
        height: calc(100% - 80px);
    }
    .leftNav{
        width: 150px;
        height: 100%;
        background-color: #fff;
        text-align: center;
    }
    .container{
        width: 100%;
        height: calc(100% - 80px);
        background-color: #fff;
        border-left: 1px solid #409EFF;
        box-sizing: border-box;
        position: fixed;
        top: 80px;
        right: 0px;
    }
    .exitBtn{
        cursor: pointer;
    }
</style>