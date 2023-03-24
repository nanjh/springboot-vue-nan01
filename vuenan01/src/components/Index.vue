<template>
  <el-container class="layout-container-demo" style="100%">
    <el-aside :width="aside_width">
      <Aside :isCollapse="isCollapse"></Aside>
    </el-aside>

    <el-container style="height: 100%">
      <el-header style="text-align: right; font-size: 12px; border-bottom: darkgray 1px solid;">
        <Header @doCollapse="doCollapse"></Header>
      </el-header>

      <el-main style="height: 100%">
        <!-- <Main></Main> -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>


<style>
.el-header {
  color: #333;
  line-height: 60px;
}

.el-main {
  padding: 5px;
}

.el-aside {
  color: #333;
}
</style>

<script>
import Aside from './Aside.vue';
import Header from './Header.vue';
import Main from './Main.vue';
export default {
  name: "Index",
  components: { Aside, Header, Main },
  data() {
    return {
      isCollapse:false,
      aside_width:'200px',
      icon:''
    }
  },
  methods:{
    doCollapse(){
      //console.log(111)
      this.isCollapse = !this.isCollapse
      if(!this.isCollapse){
        this.aside_width='200px'
      }else{
        this.aside_width='64px'
      }
    }
  }
};
</script>