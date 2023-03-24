import { createRouter, createWebHistory }  from 'vue-router';

const routes = [
    {
        path:'/',
        name:'login',
        component:()=>import('../components/Login')
    },
    {
        path:'/index',
        name:'Index',
        
        component:()=>import('../components/Index'),
        children:[
            // {
            //     path:'/admin',
            //     name:'Admin',
            //     meta:{
            //         title:'管理员管理'
            //     },
            //     component:()=>import('../components/admin/AdminManage.vue')
            // },
            // {
            //     path:'/user',
            //     name:'User',
            //     meta:{
            //         title:'用户管理'
            //     },
            //     component:()=>import('../components/user/UserManage.vue')
            // },
            {
                path:'/main',
                name:'Main',
                meta:{
                    title:'主页面'
                },
                component:()=>import('../components/Main.vue')
            },
        ]
    }
]

const router  = createRouter(
    {
        history: createWebHistory("/"),
        routes
    }
)

export default router;