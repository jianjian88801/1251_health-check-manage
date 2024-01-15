<template>
  <el-form :model="form" ref="form" label-width="0">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold">脏器功能</el-col>
      <el-col :span="21" class="right-col">
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            口腔
          </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="flex_center bold" type="flex">口唇</el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="zqgn_kq_kc">
                  <el-radio-group v-model="form.zqgn_kq_kc">
                    <el-radio
                      v-for="label in kouchun"
                      :key="label"
                      :label="label"
                      >{{ label }}</el-radio
                    >
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="flex_center bold" type="flex">齿列</el-col>
              <el-col :span="21" class="border_left flex">
                <div class="w120px flex_none">
                  <el-form-item label="" prop="zqgn_kq_cl_zt" style="margin: 0">
                    <el-checkbox-group class="w100 block mt4" v-model="form.zqgn_kq_cl_zt">
                      <div class="inb" v-for="label in chilie" :key="label" >
                        <el-checkbox style="margin: 8px 12px" class="block" :label="label"></el-checkbox>
                      </div>
                    </el-checkbox-group>
                  </el-form-item>
                </div>
                <div class="flex_auto" >
                  <!-- 脏器功能-口腔-缺齿 -->
                  <div class="flex_center" style="margin-top: 48px">
                    <el-form-item class="inb flex_auto" label="左上" prop="zqgn_kq_qc_zs" label-width="60px">
                      <el-input v-model="form.zqgn_kq_qc_zs"></el-input>
                    </el-form-item>
                    <el-form-item class="inb flex_auto" label="左下" prop="zqgn_kq_qc_zx" label-width="60px">
                      <el-input v-model="form.zqgn_kq_qc_zx"></el-input>
                    </el-form-item>
                    <div class="flex_auto fs16" style="width: 20px">/</div>
                    <el-form-item class="inb flex_auto" label="右上" prop="zqgn_kq_qc_ys" label-width="60px">
                      <el-input v-model="form.zqgn_kq_qc_ys"></el-input>
                    </el-form-item>
                    <el-form-item class="inb flex_auto" label="右下" prop="zqgn_kq_qc_yx" label-width="60px">
                      <el-input v-model="form.zqgn_kq_qc_yx"></el-input>
                    </el-form-item>
                  </div>
                  <!-- 脏器功能-口腔-龋齿 -->
                  <div class="flex_center">
                    <el-form-item class="inb flex_auto" label="左上" prop="zqgn_kq_quchi_zs" label-width="60px">
                      <el-input v-model="form.zqgn_kq_quchi_zs"></el-input>
                    </el-form-item>
                    <el-form-item class="inb flex_auto" label="左下" prop="zqgn_kq_quchi_zx" label-width="60px">
                      <el-input v-model="form.zqgn_kq_quchi_zx"></el-input>
                    </el-form-item>
                    <div class="flex_auto fs16" style="width: 20px">/</div>
                    <el-form-item class="inb flex_auto" label="右上" prop="zqgn_kq_quchi_ys" label-width="60px">
                      <el-input v-model="form.zqgn_kq_quchi_ys"></el-input>
                    </el-form-item>
                    <el-form-item class="inb zqgn_kq_quchi_yx" label="右下" prop="zqgn_kq_quchi_yx" label-width="60px">
                      <el-input v-model="form.zqgn_kq_quchi_yx"></el-input>
                    </el-form-item>
                  </div>
                  <!-- 脏器功能-口腔-义齿 -->
                  <div class="flex_center">
                    <el-form-item class="inb flex_auto" label="左上" prop="zqgn_kq_yc_jy_zs" label-width="60px">
                      <el-input v-model="form.zqgn_kq_yc_jy_zs"></el-input>
                    </el-form-item>
                    <el-form-item class="inb flex_auto" label="左下" prop="zqgn_kq_yc_jy_zx" label-width="60px">
                      <el-input v-model="form.zqgn_kq_yc_jy_zx"></el-input>
                    </el-form-item>
                    <div class="flex_auto fs16" style="width: 20px">/</div>
                    <el-form-item class="inb flex_auto" label="右上" prop="zqgn_kq_yc_jy_ys" label-width="60px">
                      <el-input v-model="form.zqgn_kq_yc_jy_ys"></el-input>
                    </el-form-item>
                    <el-form-item class="inb flex_auto" label="右下" prop="zqgn_kq_yc_jy_yx" label-width="60px">
                      <el-input v-model="form.zqgn_kq_yc_jy_yx"></el-input>
                    </el-form-item>
                  </div>
                </div>
              </el-col>
            </el-row>

            <el-row class="" align="middle" type="flex">
              <el-col :span="2" class="flex_center bold" type="flex">咽部</el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="zqgn_kq_yb">
                  <el-radio-group v-model="form.zqgn_kq_yb">
                    <el-radio
                      v-for="label in yanbu"
                      :key="label"
                      :label="label"
                      >{{ label }}</el-radio
                    >
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>

        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            视力
          </el-col>
          <el-col :span="21" class="border_left ">
            <div class="">
              <el-form-item class="w200px inb" style="margin-left: 110px" label="左眼" prop="zqgn_sl_zy" label-width="50px">
                  <el-input v-model="form.zqgn_sl_zy"></el-input>
              </el-form-item>
              <el-form-item class="w200px inb" label="右眼" prop="zqgn_sl_yy" inline label-width="50px">
                  <el-input v-model="form.zqgn_sl_yy"></el-input>
            </el-form-item>
            </div>
            <div class="">
              <div class="flex_none fs14 bold inb tc w100px">（矫正视力</div>
              <el-form-item class="w200px inb" label="左眼" prop="zqgn_sl_jzsl_zy" inline label-width="50px">
                  <el-input v-model="form.zqgn_sl_jzsl_zy"></el-input>
              </el-form-item>
              <el-form-item class="w200px inb" label="右眼" prop="zqgn_sl_jzsl_yy" inline label-width="50px">
                  <el-input v-model="form.zqgn_sl_jzsl_yy"></el-input>
              </el-form-item>
              <div class="inb">）</div>
            </div>
            <el-form-item class="" label="其他视力描述" prop="zqgn_sl_qtslms" inline label-width="100px">
                <el-input v-model="form.zqgn_sl_qtslms"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            听力
          </el-col>
          <el-col :span="21" class="border_left ">
            <el-form-item label="" prop="zqgn_tl_zt">
              <el-radio-group v-model="form.zqgn_tl_zt">
                <el-radio
                  v-for="label in tingli"
                  :key="label"
                  :label="label"
                  >{{ label }}</el-radio
                >
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row class="" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            运动功能
          </el-col>
          <el-col :span="21" class="border_left ">
            <el-form-item label="" prop="zqgn_ydgnzt">
              <el-radio-group v-model="form.zqgn_ydgnzt">
                <el-radio
                  v-for="label in yundonggongneng"
                  :key="label"
                  :label="label"
                  >{{ label }}</el-radio
                >
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>

      </el-col>
    </el-row>
  </el-form>
</template>

<script>
import { zangqigongneng } from "@/utils/dict";

export default {
  name: "",
  components: {},
  props: {},
  data() {
    return {
      form: {
        // 口腔-口唇
        zqgn_kq_kc: "",
        zqgn_kq_cl_zt: [], // 脏器功能-口腔-齿列-状态
        //脏器功能-口腔-缺齿
        zqgn_kq_qc_zs: "",
        zqgn_kq_qc_zx: "",
        zqgn_kq_qc_ys: "",
        zqgn_kq_qc_yx: "",
        // 脏器功能-口腔-龋齿
        zqgn_kq_quchi_zs: "",
        zqgn_kq_quchi_zx: "",
        zqgn_kq_quchi_ys: "",
        zqgn_kq_quchi_yx: "",
        // 脏器功能-口腔-义齿
        zqgn_kq_yc_jy_zs: "",
        zqgn_kq_yc_jy_zx: "",
        zqgn_kq_yc_jy_ys: "",
        zqgn_kq_yc_jy_yx: "",

        zqgn_kq_yb: "", // 咽部

        zqgn_sl_zy: "", // 脏器功能-视力-左
        zqgn_sl_yy: "", // 脏器功能-视力-右眼
        zqgn_sl_jzsl_zy: "", // 脏器功能-视力-矫正视力-左眼
        zqgn_sl_jzsl_yy: "", // 脏器功能-视力-矫正视力-右眼
        zqgn_sl_qtslms: "", // 脏器功能-视力-其他视力描述
        zqgn_tl_zt: "", // 脏器功能-听力-状态
        zqgn_ydgnzt: "", // 脏器功能-运动功能状态
      },
      kouchun: zangqigongneng.kouchun,
      chilie: zangqigongneng.chilie,
      yanbu: zangqigongneng.yanbu,
      yundonggongneng: zangqigongneng.yundonggongneng,
      tingli: zangqigongneng.tingli,
    };
  },
  computed: {},
  watch: {},
  mounted() {},
  methods: {},
};
</script>

<style lang="scss">
</style>
