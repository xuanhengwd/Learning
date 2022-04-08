<template>
  <el-row class="mb-4">

    <el-button type="success" @click="loginbu">登录</el-button>

  </el-row>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Login",
  methods:{
    loginbu(){
      alert("登录成功");

      this.$router.push({name:'School',path:'/school'});
    }
  }
}
</script>

<style scoped>

</style>