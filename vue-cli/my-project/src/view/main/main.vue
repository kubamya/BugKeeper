<template>
    <div class="content">
        <!-- 顶部公用 -->
        <div class="top">
            <div class="title">BUGKEEPER - 缺陷管理系统</div>
            <div class="userInfo">
                <el-row>
                    <el-col :span="12">欢迎您：</el-col>
                    <el-col :span="12">退出系统</el-col>
                </el-row>
            </div>
        </div>
        <!-- 整体 -->
        <div class="main">
            <!-- 左侧公用 -->
            <div class="leftNav">
                <el-menu
                    default-active="1"
                    class="el-menu-vertical-demo">
                    <el-menu-item index="1" @click="goBugManage">
                        <span>缺陷管理</span>
                    </el-menu-item>      
                    <el-menu-item index="2" @click="goProjectManage">
                        <span>项目管理</span>
                    </el-menu-item>
                    <el-menu-item index="3" @click="goStaffManage">
                        <span>人员管理</span>
                    </el-menu-item>
                    <el-menu-item index="4" @click="goSystemSetting">
                        <span>系统设置</span>
                    </el-menu-item>
                </el-menu>
            </div>
            <!-- 居中公用 -->
            <div class="container">
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

        }
    },
    mounted() {
        //默认进入缺陷管理页面
        this.$router.push({path:'/bugManage'});
    },
     methods: {
         //跳转到缺陷管理
      goBugManage(){
          this.$router.push({path:'/bugManage'});
      },
      //跳转到项目管理
      goProjectManage(){
          this.$router.push({path:'/projectManage'});
      },
      //跳转到人员管理
      goStaffManage(){
          this.$router.push({path:'/staffManage'});
      },
      //跳转到系统设置
      goSystemSetting(){
          this.$router.push({path:'/systemSetting'});
      }
    }
}
</script>
<style>
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
        width:300px;
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
        background-color: red;
    }
    .leftNav{
        width: 150px;
        height: 100%;
        background-color: #fff;
        text-align: center;
    }
    .container{
        width: calc(100% - 150px);
        height: calc(100% - 80px);
        background-color: #fff;
        border-left: 1px solid #409EFF;
        box-sizing: border-box;
        position: fixed;
        top: 80px;
        right: 0px;
    }
</style>