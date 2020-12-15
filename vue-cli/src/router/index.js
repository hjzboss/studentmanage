import Vue from 'vue' //引入vue.js
import Router from 'vue-router'
import Student from "../components/Student";
import Home from "../components/Home";
import AddStudent from "../components/AddStudent";
import ChangeStudent from "../components/ChangeStudent";


const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/student',
      component: Student,
      children: [
        {path: 'add', component: AddStudent},
        {path: 'change',component: ChangeStudent}
      ]
    },
  ]
})
