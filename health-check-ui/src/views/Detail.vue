<template>
  <div class="health-check-page flex" v-loading="loading">
    <transition name="slide-fade-x">
    <el-button class="pa fs16" style="left: 0; top: 16px; z-index: 2"
      v-show="!showTab"
      @click="setshowTab">
      <i class="el-icon-arrow-right"></i>
    </el-button>
    </transition>
    <transition name="slide-fade-left">
      <div class="p16  pr" v-if="showTab" style="width: 220px; padding-right: 0; z-index: 2">
        <el-button class="pa fs16" style="left: 16px; top: 16px; z-index: 2 "
          @click="setshowTab">
          <i class="el-icon-arrow-left"></i>
        </el-button>
        <el-card class="pr" style="z-index: 1">
          <el-tabs v-model="activeTab" tab-position="left" @tab-click="scrollTo" style="max-height: 100vh">
            <el-tab-pane v-for="item in menus" :name="item.name" :key="item.name" :label="item.label"></el-tab-pane>
          </el-tabs>
        </el-card>
      </div>
    </transition>
    <div  ref="container" class="p16 container" @scroll="onScroll" style=" width: 100%">
      <el-card ref="form" shadow="always" style="margin-bottom: 600px">
        <!-- 基础信息 -->
        <Base ref="Base" name="Base"></Base>
        <!-- 体检类型 -->
        <BodyCheckType name="BodyCheckType"></BodyCheckType>
        <!-- 检查途径 -->
        <JianChaTujing name="JianChaTujing"></JianChaTujing>
        <!-- 症状 -->
        <Zhengzhuang name="Zhengzhuang"></Zhengzhuang>
        <!-- 一般状况 -->
        <YiBanZhuangKuang name="YiBanZhuangKuang"></YiBanZhuangKuang>
        <!-- 生活状态 -->
        <ShengHuoFangShi name="ShengHuoFangShi"></ShengHuoFangShi>
        <!-- 脏器功能 -->
        <ZhangQiGongNeng name="ZhangQiGongNeng"></ZhangQiGongNeng>
        <!-- 宣体 -->
        <XuanTi name="XuanTi"></XuanTi>
        <!-- 辅助检查 -->
        <FuZhuJianCha name="FuZhuJianCha"></FuZhuJianCha>
        <!-- 现存主要健康问题 -->
        <XianCunZhuYaoJianKangWenTi name="XianCunZhuYaoJianKangWenTi" ></XianCunZhuYaoJianKangWenTi>
        <!-- 住院治疗情况 -->
        <ZhuYuanZhiLiaoQingKuang name="ZhuYuanZhiLiaoQingKuang" ></ZhuYuanZhiLiaoQingKuang>
        <!-- 主要用药情况 -->
        <ZhuYaoYongYaoQingKuang name="ZhuYaoYongYaoQingKuang" ></ZhuYaoYongYaoQingKuang>
        <!-- 非免疫规划预防接种史 -->
        <FeiMianYiGuiHuaYuFangJieZhongShi name="FeiMianYiGuiHuaYuFangJieZhongShi" ></FeiMianYiGuiHuaYuFangJieZhongShi>
        <!-- 健康评价 -->
        <JianKangPingJia name="JianKangPingJia" :get-all-form-data="()=> { return getFormData ()}"></JianKangPingJia>
        <!-- 健康指导 -->
        <JianKangZhiDao name="JianKangZhiDao"></JianKangZhiDao>
        <!-- 危险控制因素 -->
        <WeiXianYinSuKongZhi name="WeiXianYinSuKongZhi"></WeiXianYinSuKongZhi>
        <!--生活方面-->
        <ShengHuoFangMian name="ShengHuoFangMian"></ShengHuoFangMian>
        <div class="border_bottom"></div>
      </el-card>
    </div>

    <div class="bottom_toobar border_top">
      <el-button
        type=""
        size="large"
        @click="$router.back()"
        class="w200px mr16"
        ><span class="fs18 bold">返 回</span></el-button
      >
      <el-button type="primary" size="large" @click="submitForm" class="w200px"
        ><span class="fs18 bold">提 交</span></el-button
      >
    </div>
  </div>
</template>
<script>
import Base from "@/components/FormBolck/Base.vue";
import BodyCheckType from "@/components/FormBolck/BodyCheckType.vue";
import JianChaTujing from "@/components/FormBolck/JianChaTujing.vue";
import Zhengzhuang from "@/components/FormBolck/Zhengzhuang.vue";
import YiBanZhuangKuang from "@/components/FormBolck/YiBanZhuangKuang.vue";
import ShengHuoFangShi from "@/components/FormBolck/ShengHuoFangShi.vue";
import ZhangQiGongNeng from "@/components/FormBolck/ZhangQiGongNeng.vue";
import XuanTi from "@/components/FormBolck/XuanTi.vue";
import FuZhuJianCha from "@/components/FormBolck/FuZhuJianCha.vue";
import XianCunZhuYaoJianKangWenTi from "@/components/FormBolck/XianCunZhuYaoJianKangWenTi.vue";
import ZhuYuanZhiLiaoQingKuang from "@/components/FormBolck/ZhuYuanZhiLiaoQingKuang.vue";
import ZhuYaoYongYaoQingKuang from "@/components/FormBolck/ZhuYaoYongYaoQingKuang.vue";
import FeiMianYiGuiHuaYuFangJieZhongShi from "@/components/FormBolck/FeiMianYiGuiHuaYuFangJieZhongShi.vue";
import JianKangPingJia from "@/components/FormBolck/JianKangPingJia.vue";
import JianKangZhiDao from "@/components/FormBolck/JianKangZhiDao.vue";
import WeiXianYinSuKongZhi from "@/components/FormBolck/WeiXianYinSuKongZhi.vue";
import ShengHuoFangMian from "@/components/FormBolck/ShengHuoFangMian.vue";

import { saveBodyCheckForm, getBodyCheck } from "@/http/detail";
import { _toCamel } from "@/utils/index";
import { Array_Prefix } from "@/constant";
import lodash from "lodash";
import moment from "moment";

window.lodash = lodash;

export default {
  components: {
    Base,
    BodyCheckType,
    JianChaTujing,
    Zhengzhuang,
    YiBanZhuangKuang,
    ShengHuoFangShi,
    ZhangQiGongNeng,
    XuanTi,
    FuZhuJianCha,
    XianCunZhuYaoJianKangWenTi,
    ZhuYuanZhiLiaoQingKuang,
    ZhuYaoYongYaoQingKuang,
    FeiMianYiGuiHuaYuFangJieZhongShi,
    JianKangPingJia,
    JianKangZhiDao,
    WeiXianYinSuKongZhi,
    ShengHuoFangMian,
  },
  data() {
    return {
      loading: false,
      baskForm: {},
      showTab: false,
      arrayPrefix: Array_Prefix,

      activeTab: 'Base',
      menus: [
        { name: "Base", label: "基础信息" },
        { name: "BodyCheckType", label: "体检类型" },
        { name: "JianChaTujing", label: "检查途径" },
        { name: "Zhengzhuang", label: "症状" },
        { name: "YiBanZhuangKuang", label: "一般状况" },
        { name: "ShengHuoFangShi", label: "生活方式" },
        { name: "ZhangQiGongNeng", label: "脏器功能" },
        { name: "XuanTi", label: "宣体" },
        { name: "FuZhuJianCha", label: "辅助检查" },
        { name: "XianCunZhuYaoJianKangWenTi", label: "现存主要健康问题" },
        { name: "ZhuYuanZhiLiaoQingKuang", label: "住院治疗情况" },
        { name: "ZhuYaoYongYaoQingKuang", label: "主要用药情况" },
        { name: "FeiMianYiGuiHuaYuFangJieZhongShi", label: "非免疫规划预防接种史"},
        { name: "JianKangPingJia", label: "健康评价" },
        { name: "JianKangZhiDao", label: "健康指导" },
        { name: "WeiXianYinSuKongZhi", label: "危险控制因素" },
        { name: "ShengHuoFangMian", label: "生活方面" },
      ],

      scrollOffset: 100
    };
  },
  mounted() {
    if (this.$route.query.id) {
      this.getDetail(this.$route.query.id)
    } else {
      this.$refs.Base.reset();
    }
      this.showTab = !!localStorage.showTab
  },
  methods: {
    setshowTab() {
      this.showTab = !this.showTab
      localStorage.showTab = this.showTab ? 'true' : ''
    },
    async getDetail(id) {
      this.loading = true;
      const res = await getBodyCheck({ id });
      this.loading = false;
      if (res.success) {
        this.result = res.result || {}
        this.restoreData(this.result);
      }
    },
    restoreData(result) {
      const forms = this.$refs.form.$children;

      // 循环每个表单
      forms.forEach((item) => {
        // 循环每个表单下的字段
        for (const _key in item.form) {
          // 下划线 转 驼峰
          const key = _toCamel(_key);
          // 取值
          const value = result[key];
          if (value !== undefined) {
            if (value && value.indexOf(this.arrayPrefix) !== -1) {
              item.form[_key] = value.replace(this.arrayPrefix, "").split(",");
            } else {
              item.form[_key] = value === null ? "" : value;
            }
          } else {
            // 不存在的字段 打印出来
            console.log(_key, key, value);
          }
        }
      });
    },
    getFormData() {
      const forms = this.$refs.form.$children;
      const data = {};
      forms.forEach((item) => {
        let form = item.getFormData ? item.getFormData() : item.form;
        for (const key in form) {
          const value = form[key];
          // 数组类型
          if (lodash.isArray(value)) {
            data[key] = this.arrayPrefix + value.filter(item =>{ return item !== '' }).join(",");
            // 日期类型
          } else if (lodash.isDate(value)) {
            const format = "YYYY-MM-DD hh:mm:ss";
            data[key] = moment(value).format(format);

            // 对象
          } else if (typeof value === "object" && value !== null) {
            data[key] = value;

            // 原始值
          } else {
            data[key] = value === null ? '' : value;
          }
        }
      });

      if (this.$route.query.id) {
        data.id = this.$route.query.id
      }
      return data;
    },
    validate() {
      this.loading = true;
      const forms = this.$refs.form.$children;
      const list = [];
      forms.forEach((item) => {
        list.push(item.$refs.form.validate());
      });
      return Promise.all(list)
        .then((results) => {
          return results;
        })
        .finally(() => {
          this.loading = false;
        });
    },
    async submitForm() {
      try {
        await this.validate();
        this.loading = true;
        const res = await saveBodyCheckForm(this.getFormData());
        this.loading = false;
        if (res.success) {
          this.$message.success("提交成功");
          this.$router.replace({ name: "list" });
        }
      } catch (error) {
        console.log(error);
      }
    },
    scrollTo() {
      const forms = this.$refs.form.$children;
      forms.forEach(item => {
        if(item.$el.getAttribute('name') === this.activeTab) {
          this.$refs.container.scrollTop = item.$el.offsetTop - this.scrollOffset
        }
      })
    },
    onScroll(e) {
      const forms = this.$refs.form.$children;
      const top = e.target.scrollTop
      forms.forEach(item => {
        if((item.$el.offsetTop - top) < (this.scrollOffset + 10)) {
          this.activeTab = item.$el.getAttribute('name')
        }
      })
    }
  },
};
</script>

<style lang="less">
.el-date-editor.el-input {
  width: 100%;
}
.health-check-page {
  height: 100%;
  position: absolute;
  left: 0;
  right: 0;
  .container {
    height: calc(100% - 60px);
    overflow: auto;
    scroll-behavior: smooth;
  }

  .row-index {
    display: flex;
    align-items: center;
    border: 1px solid #eee;
    border-bottom: 0;
  }

  .el-tabs__item {
    height: 32px;
    padding-left: 0;
  }

  .el-col {
    .el-form-item {
      margin: 8px 12px;
    }
  }

  .left-col {
    text-align: center;
  }
  .right-col {
    border-left: 1px solid #eee;
  }
  .el-form-item {
    margin-bottom: 0;
  }

  .el-radio,
  .el-checkbox {
    margin: 0px 12px 0px 0px;
  }

  .el-radio__label,
  .el-checkbox__label {
    padding-left: 4px;
  }

  .el-form-item__label {
    display: inline-flex;
    align-items: center;
    font-size: 14px;
    line-height: 1;
    min-height: 32px;
    font-weight: bold;
    vertical-align: middle;
    justify-content: flex-end;
  }

  .el-form-item__content {
    line-height: 32px;
  }

  .el-input-group__append,
  .el-input-group__prepend {
    padding: 0 10px;
  }
}

.bottom_toobar {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100vw;
  padding: 12px 32px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #fff;
  opacity: 0.8;
  z-index: 100;
  box-shadow: 0 0 12px rgba(0,0,0, 0.2);
}
</style>
