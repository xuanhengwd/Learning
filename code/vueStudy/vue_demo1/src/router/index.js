import {createRouter, createWebHistory} from 'vue-router'
import School from "@/components/School";
// eslint-disable-next-line no-unused-vars
import Login from "@/components/Login";
// eslint-disable-next-line no-unused-vars
import Layout from "@/components/Layout";


const routes = [

    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect:'/login',
        children: [
            {
                path: '/school',
                name: 'School',
                component: School

            },

            {
                path: '/login',
                name: 'Login',
                component: Login

            },

        ]

    },

    /*    {
            path:'/login',
            component:Login
        },*/

]
const routerHistory = createWebHistory()
const router = createRouter({
    history: routerHistory,
    routes
})
export default router


// import { createRouter, createWebHistory } from 'vue-router'
// const routes = [
//     {
//         path: '/',
//         name: 'index',
//         component: () => import('../App.vue'),
//         children: [
//             {
//                 path: 'home',
//                 name: 'Home',
//                 component: () => import('../views/home.vue')
//             }
//         ]
//     }
// ]
// const routerHistory = createWebHistory()
// const router = createRouter({
//     history: routerHistory,
//     routes
// })
// export default router
