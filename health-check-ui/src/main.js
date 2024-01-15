require('promise.prototype.finally').shim();

import Vue from 'vue';
import App from './App.vue';
import './registerServiceWorker';
import router from './router';
import store from './store';
import ElementUI from "element-ui";
import 'element-ui/lib/theme-chalk/index.css';


import "./style/default.less";
import "./style/simplify.less";
import "./style/animation.less";

Vue.config.productionTip = false;

Vue.use(ElementUI, { size: 'small', zIndex: 3000 });

import { getRequireRule } from "@/utils/index";
Vue.prototype.$getRequireRule = getRequireRule

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
