<template>
  <div class="page_login">
    <div class="login_bg">
      <div v-loading="loading" class="form_content">
        <div class="login_main pr">
          <div class="login_title">
            <h1>{{ title }}</h1>
          </div>
          <div class="pa step_item">
            <el-form
              ref="loginForm"
              :model="loginForm"
              :rules="loginRules"
              class="login_form"
              auto-complete="on"
              label-position="left"
            >
              <el-form-item prop="userName">
                <div class="login_form_item">
                  <span class="svg-container">
                    <i class="el-icon-user"></i>
                  </span>
                  <el-input
                    ref="userName"
                    v-model="loginForm.userName"
                    placeholder="请输入账号"
                    name="userName"
                    type="text"
                    tabindex="1"
                    auto-complete="on"
                  />
                </div>
              </el-form-item>
              <el-form-item prop="password">
                <div class="login_form_item">
                  <span class="svg-container">
                    <i class="el-icon-lock"></i>
                  </span>
                  <el-input
                    :key="passwordType"
                    ref="password"
                    v-model="loginForm.password"
                    :type="passwordType"
                    placeholder="请输入密码"
                    name="password"
                    tabindex="2"
                    auto-complete="on"
                  />
                </div>
              </el-form-item>
              <el-form-item>
                <el-button
                  class="login-form-button"
                  :loading="loading"
                  type="primary"
                  :disabled="!loginForm.userName || !loginForm.password"
                  @click.native.prevent="submitLogin"
                  >登 录</el-button
                >
              </el-form-item>
            </el-form>
          </div>
        </div>
      </div>
    </div>
    <div class="waveWrapper">
      <svg
        class="editorial"
        xmlns="http://www.w3.org/2000/svg"
        xmlns:xlink="http://www.w3.org/1999/xlink"
        viewBox="0 24 150 28"
        preserveAspectRatio="none"
      >
        <defs>
          <path
            id="gentle-wave"
            d="M-160 44c30 0
              58-18 88-18s
              58 18 88 18
              58-18 88-18
              58 18 88 18
              v44h-352z"
          />
        </defs>
        <g class="parallax">
          <use xlink:href="#gentle-wave" x="50" y="0" fill="#fff" />
          <use xlink:href="#gentle-wave" x="50" y="3" fill="#fff" />
          <use xlink:href="#gentle-wave" x="50" y="6" fill="#fff" />
        </g>
      </svg>
    </div>
  </div>
</template>

<script>
import { Login } from "@/http/login";
import { setAuthority } from "@/utils/authority";

export default {
  name: "Login",
  data() {
    return {
      title: "体检录入系统",
      loginForm: {
        userName: "",
        password: "",
      },
      loginRules: {
        userName: [{ required: true, trigger: "blur" }],
        password: [{ required: true, trigger: "blur" }],
      },
      loading: false,
      passwordType: "password",
    };
  },
  created() {},
  methods: {
    submitLogin() {
      this.loading = true;

      Login(this.loginForm)
        .then((res) => { 
          if (res.success) {
            setAuthority(res.result.token);
            const userInfo = res.result.userInfo || "";
            this.$store.commit("SET_USER_INFO", userInfo);

            this.$router.push({
              path: "/list",
            });
          }
        })
        .finally(() => {
          this.loading = false;
        });
    },
  },
};
</script>

<style lang="less">
.page_login {
  width: 100%;
  height: 100vh;
  overflow: hidden;
  min-width: 1130px;
  position: relative;
  .login_bg {
    background-repeat: no-repeat;
    background-size: cover;
    height: 100%;
    font-size: 40px;
    padding: 60px 60px 0;
    color: #fff;
    position: relative;
    z-index: 2;
  }
  .left_title {
    font-size: 20px;
    .title_text {
      padding-left: 18px;
    }
  }
  .big_content {
    padding-top: 74px;
    padding-left: 10%;
    line-height: 60px;
    font-size: 40px;
    .bottom {
      line-height: 34px;
      font-size: 24px;
    }
  }
  .small_content {
    padding-top: 40px;
    padding-left: 10%;
    font-size: 20px;
    line-height: 50px;
  }
  .copy_right {
    width: 100%;
    text-align: center;
    font-size: 12px;
    position: absolute;
    left: 0;
    bottom: 30px;
    color: #666;
    a {
      color: #666;
      text-decoration: underline;
    }
  }
  .form_content {
    position: absolute;
    box-sizing: border-box;
    right: 50%;
    top: 180px;
    background: #fff;
    height: 460px;
    width: 440px;
    padding: 30px 40px 40px;
    color: #000;
    box-shadow: 0px 4px 13px 0px rgba(158, 158, 158, 0.38);
    border-radius: 8px;
    overflow: hidden;
    transform: translateX(50%);

    .form_title {
      position: absolute;
      width: 440px;
      text-align: center;
      color: #fff;
      font-size: 24px;
      font-weight: 500;
      line-height: 44px;
      top: -74px;
      left: 0;
    }

    .step_item {
      width: 360px;
      transition: 0.3s;
    }
  }
  .login_title {
    font-size: 24px;
    font-weight: 440;
    line-height: 40px;
    color: #419fff;
    padding-bottom: 30px;
    text-align: center;
  }
  .login_form {
    width: 360px;
    color: rgba(0, 0, 0, 0.65);
    .login_form_item {
      height: 50px;
      box-sizing: border-box;
      border-radius: 4px;
      line-height: 50px;
      border: 1px solid #dcdfe6;
      display: flex;
      overflow: hidden;
    }
    .svg-container {
      padding-left: 15px;
      font-size: 20px;
      i {
        color: #ccc;
      }
    }
    .show-pwd {
      padding-right: 15px;
    }
    .el-input {
      flex: 1;
    }
    .el-form-item {
      margin-bottom: 28px;
    }
    .el-input__inner {
      height: 50px;
      line-height: 50px;
      border: 0 none;
      font-size: 14px;
      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px #fff inset !important;
        -webkit-text-fill-color: rgba(0, 0, 0, 0.65) !important;
      }
      &::-ms-clear,
      &::-ms-reveal {
        display: none;
      }
    }
    .el-checkbox__label {
      word-break: break-word;
      width: 98%;
      white-space: initial;
      vertical-align: middle;
    }
  }
  .login-form-forgot {
    float: right;
  }
  .login-form-button {
    margin-top: 40px;
    width: 100%;
    height: 48px;
    box-shadow: 0px 4px 13px 0px rgba(158, 158, 158, 0.38);
    font-size: 16px;
    background-color: "#11D2B2";

    &.is-disabled {
      opacity: 0.5;
    }
  }
  .img_code {
    height: 36px;
    margin-right: 6px;
    margin-top: 6px;
  }
  .other_way {
    text-align: center;
  }
}
</style>

<style lang="less">
.waveWrapper {
  overflow: hidden;
  position: absolute;
  left: 0;
  right: 0;
  bottom: 0;
  top: 0;
  margin: auto;
  z-index: 1;
  animation: gradient 40s;
  animation-iteration-count: infinite;
  animation-timing-function: linear;
  background: linear-gradient(
    -45deg,
    #e6a23c,
    #ee7752,
    #f56c6c,
    #e73c7e,
    #23a6d5,
    #67c23a
  );
  background-size: 8000% 100%;
  background-position: 0% 0%;
}

@keyframes gradient {
  0% {
    background-position: 0% 0%;
  }
  50% {
    background-position: 100% 0%;
  }
  100% {
    background-position: 0% 0%;
  }
}

.parallax > use {
  opacity: 0.3;
  animation: move-forever 10s linear infinite;
}
.parallax > use:nth-child(1) {
  animation-delay: 0s;
}
.parallax > use:nth-child(2) {
  animation-delay: -1s;
  animation-duration: 30s;
  transform: translate(-20px, 0%);
}
.parallax > use:nth-child(3) {
  animation-delay: -3s;
  animation-duration: 40s;
  transform: translate(-40px, 0%);
}

@keyframes move-forever {
  0% {
    transform: translate(-90px, 0%);
  }
  100% {
    transform: translate(85px, 0%);
  }
}
.editorial {
  display: block;
  width: 100%;
  height: 300px;
  margin: 0;
  bottom: 0;
  position: absolute;
  left: 0;
  right: 0;
}
</style>
