import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from './store'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import {initMenu} from "./utils/menu";
import 'font-awesome/css/font-awesome.min.css'

import { postRequest } from "./utils/api"
import { putRequest } from "./utils/api"
import { getRequest } from "./utils/api"
import { deleteRequest } from "./utils/api"
import { postKeyValueRequest } from "./utils/api"

Vue.prototype.postRequest = postRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.getRequest = getRequest;
Vue.prototype.deleteRequest = deleteRequest;
Vue.prototype.postKeyValueRequest = postKeyValueRequest;

Vue.config.productionTip = false

Vue.use(ElementUI);
NProgress.configure({ ease: 'ease', speed: 500 })

router.beforeEach((to,from,next)=>{
  // NProgress开始进度条
  NProgress.start();
  if(to.path == '/'){
    next();
  }else{
    if(window.sessionStorage.getItem("user")){
      initMenu(router,store);
      next();
    }else{
      next('/?redirect=' + to.path);
    }
  }
})

router.afterEach(transition => {
  // NProgress结束进度条
  NProgress.done();
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
