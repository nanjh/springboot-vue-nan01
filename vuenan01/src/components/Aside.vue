<template v-slot:title="title">
    <el-scrollbar>
        <el-menu 
        active-text-color="#ffd04b"
        background-color="#545c64"
        text-color="#fff"
        default-active="/index/main"
        :collapse="isCollapse"
        :collapse-transition="false"
        style="height: 100vh;"
        router
        >
            
            <el-menu-item index="/main" >
                <el-icon><HomeFilled /></el-icon>
                <span>首页</span>
            </el-menu-item>

            <el-menu-item :index="item.menuclick" v-for="(item,i) in menu" :key="i">
                <el-icon><Flag /></el-icon>
                <span>{{item.menuname}}</span>
            </el-menu-item>

        </el-menu>
    </el-scrollbar>
</template>

<script>
export default {
    name: "Aside",
    data(){
        return{
            //iscollapse:false
            // menu:[
            //     {
            //         menuClick:'/index/admin',
            //         menuName:'管理员管理',
            //     },
            //     {
            //         menuClick:'/index/user',
            //         menuName:'用户管理',
            //     },
            // ]
        }
    },

    computed:{
        "menu":{
            get(){
                return this.$store.state.menu;
            }
        }
    },
    props:{
        isCollapse:Boolean
    }
}
</script>

<style scoped></style>