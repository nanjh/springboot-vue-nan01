<template>
    <div style="display:flex;line-height: 60px;">
        <div>
            <el-icon style="font-size: 20px;" @click="collapse">
                <Fold />
            </el-icon>
        </div>
        <div style="flex: 1; text-align: center; font-size: 34px">
            <span>欢迎来到仓库管理系统</span>
        </div>
        <span>{{ user.name }}</span>
        <el-dropdown>
            <el-icon style="margin-left: 5px;margin-right: 15px;height: 100%; ">
                <ArrowDown />
            </el-icon>
            <template #dropdown>
                <el-dropdown-menu>
                    <el-dropdown-item @click.native="toUser">个人中心</el-dropdown-item>
                    <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
            </template>
        </el-dropdown>
    </div>
</template>

<script>
export default {
    name: "Header",
    data(){
        return {
            user: JSON.parse(sessionStorage.getItem('CurUser'))
        }
    },
    methods: {
        toUser() {
            console.log('to_user')
        },
        logout() {
            console.log('logout')

            this.$confirm('您确定要退出登陆吗?', '提示',{
                confirmButtonText: '确定',
                type: 'warning',
                center: true,
            }).then(() => {
                this.$message({
                    type:'success',
                    message:'退出登录成功'
                })
                this.$router.push("/")
                sessionStorage.clear()
            }).catch(() => {
                this.$message({
                    type:'info',
                    message:'已取消退出登录'
                })
            })

            
        },
        collapse() {
            // 传递给父组件
            this.$emit('doCollapse')
        }
    }
}
</script>

<style scoped></style>