<template>
  <div class="school">
    <h1>{{msg}}</h1>
    <h1>学校名称：{{name}}</h1>
    <h1>学校地址：{{address}}</h1>
  </div>

</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "School",
  data(){
    return{
      name:"北化",
      address:"朝阳",
      msg:"欢迎进入！！"
    }
  },
}
</script>

<style scoped>
  .school{
    background-color: #2c3e50;
  }

</style>