import { createApp } from 'vue'
import App from './App.vue'
import Vue from "@vue/cli-plugin-eslint/eslintOptions";
import router from './router'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

//关闭生产提示
Vue.config.productionTip = false

createApp(App).use(router).use(ElementPlus).mount('#app')
