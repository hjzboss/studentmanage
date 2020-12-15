<template>
  <div>
    <h1>学生页面</h1>

    <table border="1" align="center">
      <tr>
        <td>id</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>生日</td>
        <td>设置</td>
      </tr>
      <tr v-for="user in users">
        <td>{{ user.id }}</td>
        <td>{{ user.name }}</td>
        <td>{{ user.age }}</td>
        <td>{{ user.bir }}</td>
        <td><a :href="'#/student/change?id=' + user.id">修改</a><a href="#" @click.prevent="del(user.id)">删除</a></td>
      </tr>
    </table>
    <router-link to="/student/add" tag="button">添加学生</router-link>
    <router-view></router-view>
    <Footer></Footer>
  </div>
</template>

<script>
import Footer from "./Footer";

export default {
  name: "Student",
  data() {
    return {
      users: []
    }
  },
  methods: {
    findAll() {
      this.$http.get("http://localhost:8080/student").then(res => {
        this.users = res.data.students;
      }).catch(err => {
        console.log(err);
      });
    },
    del(id) {
      this.$http.delete("http://localhost:8080/student/" + id)
      .then(res=>{
        alert(res.data.msg);
        this.findAll();
      })
    }
  },
  created() {
    this.findAll();
  },
  components: {
    Footer
  },
  // 监听,当路由发生变化的时候执行
  watch: {
    $route: {
      handler: function (val, oldVal) {
        this.findAll();
      },
      // 深度观察监听
      deep: true
    }
  }
}
</script>

<style scoped>

</style>
