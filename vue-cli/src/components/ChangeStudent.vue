<template>
  <div align="center">
    <h2>修改学生信息</h2>
    <form action="">
      <table>
        <tr>
          <td>姓名：</td>
          <td><input type="text" v-model="stu.name"></td>
        </tr>
        <tr>
          <td>年龄：</td>
          <td><input type="text" v-model="stu.age"></td>
        </tr>
        <tr>
          <td>生日：</td>
          <td><input type="text" v-model="stu.bir"></td>
        </tr>
      </table>
      <input type="button" value="提交" @click="change">
    </form>
  </div>
</template>

<script>
export default {
  name: "ChangeStudent",
  data() {
    return {
      stu: {}
    }
  },
  methods: {
    change() {
      this.$http.patch("http://localhost:8080/student/" + this.stu.id, this.stu)
        .then(res => {
          alert(res.data.msg);
          if (res.data.success == false) {
            this.$router.push("/student/change");
          }
          else{
            this.$router.push("/student")
          }
        })
    }
  },
  created() {
    this.$http.get("http://localhost:8080/student/"
      + this.$route.query.id)
      .then(res => {
        if (res.data.success == false) {
          alert(res.data.msg);
          this.$router.push("/student/change");
        }
        console.log(res.data.msg)
        this.stu = res.data.entity;
      }).catch(err=>{
        console.log(err);
    })
  }
}
</script>

<style scoped>

</style>
