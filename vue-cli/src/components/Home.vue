<template>
<div>
  <h1 align="center">学生管理系统</h1>
  <Footer></Footer>
</div>
</template>

<script>
import Footer from "./Footer";  //引用Footer组件,组件复用
export default {//暴露该组件，可以被import
  name: "Home",
  data(){
    return{}
  },
  methods:{

  },
  components:{
    Footer
  }
}
</script>

<style scoped>

</style>
