<template>
  <div id="app">
    <img src="./assets/logo.png"><br>
    <el-link type="primary" href="#/home">主页</el-link>
<!--    <router-link to="/home" tag="button">主页</router-link>-->
<!--    <router-link to="/student" tag="button">学生页面</router-link>-->
    <el-link type="primary" href="#/student">学生页面</el-link>
    <router-view/>
  </div>
</template>

<script>
export default {  //暴露当前组件对象
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
