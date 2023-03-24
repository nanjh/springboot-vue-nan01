import { createApp } from 'vue';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import './assets/global.css';
import App from './App.vue';
import * as ElementPlusIconsVue from '@element-plus/icons-vue';
import axios from 'axios'
import VueRouter from  'vue-router'
import router from './router/index.js'
import store from './store'

const app = createApp(App)
app.config.globalProperties.$axios = axios
app.config.globalProperties.$url = 'http://localhost:8090'

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }
app.use(router)
app.use(store)
app.use(ElementPlus,{size:'small'})
app.mount('#app')