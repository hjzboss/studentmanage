import Vue from 'vue'   //引入vue.js
import App from './App' //引入App.vue
import router from './router' //引入router目录下的所有js
import axios from 'axios' //引入axios

Vue.prototype.$http = axios
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
