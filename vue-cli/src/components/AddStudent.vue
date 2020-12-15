<template>
<div align="center">
  <h2>添加学生</h2>
  <form action="">
    <table>
      <tr>
        <td>姓名</td>
        <td><input type="text" v-model="student.name"></td>
      </tr>
      <tr>
        <td>年龄</td>
        <td><input type="text" v-model="student.age"></td>
      </tr>
      <tr>
        <td>生日</td>
        <td><input type="text" v-model="student.bir"></td>
      </tr>
    </table>
    <input type="submit" @click.prevent="add">
  </form>
</div>
</template>

<script>
export default {
  name: "AddStudent",
  data(){
    return{
      student:{}
    }
  },
  methods:{
    add(){
      this.$http.post("http://localhost:8080/student",this.student)
      .then(res=>{
        if(res.data.success == true){
          alert(res.data.msg + "按确定返回");
          console.log(res.data.entity);
        }
        else{
          alert(res.data.msg + " 请重新输入");
        }
        this.$router.push("/student");

      }).catch(err=>{
        console.log(err);
      })
    }
  }
}
</script>

<style scoped>

</style>
