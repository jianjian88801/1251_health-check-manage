<template>
  <div id="app" class="flex flex_column">
    <div v-if="$route.name !== 'login'" class="top_bar flex_center flex_none">
      <div class="flex_auto p16 " style="line-height: 50px">
        <router-link to="/list" style="text-decoration: none;">
          <h2 class="inb" style="color: #419fff">体检录入系统</h2>
        </router-link>
        <el-link v-if="$route.name !== 'list'"
         :underline="false" class="inb fs24 pr pl16" style="top: -3px">
          <i
          class="el-icon-arrow-left"
          @click="$router.back()"></i>
        </el-link>
      </div>
      <div class="w200px flex_none tr">
        <el-button class="mr16" @click="logout">退 出</el-button>
      </div>
    </div>
    <div class="flex_auto pr" style="height: 200px">
      <router-view />
    </div>
  </div>
</template>

<script>
import { removeAuthority } from "@/utils/authority";

export default {
  mounted() {
    const userInfo = localStorage.getItem("USER_INFO") || "";
    this.$store.commit(
      "SET_USER_INFO",
      userInfo ? JSON.parse(userInfo) : userInfo
    );
  },
  methods: {
    logout() {
      this.$confirm("是否退出登录?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          removeAuthority();
          this.$store.commit("SET_USER_INFO", {});
          this.$router.push({ name: "login" });
        })
        .catch(() => {});
    },
  },
};
</script>

<style lang="less">
@import "./style/default.less";
.top_bar {
  height: 50px;
  box-shadow: 0 0 12px rgba(0,0,0, 0.2);
  position: relative;
  z-index: 100;
}
</style>
