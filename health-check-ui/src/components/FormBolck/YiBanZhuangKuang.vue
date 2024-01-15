<template>
  <el-form :model="form" ref="form" label-width="110px">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold">一般状况</el-col>
      <el-col :span="21" class="border_left">
        <el-row class="border_bottom">
          <el-col :span="12">
            <el-form-item label="体 温" prop="ybzt_tw">
              <el-input
                v-model="form.ybzt_tw"
                placeholder="请输入内容"
                size="small"
              ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="脉 率" prop="ybzt_ml">
              <el-input
                v-model="form.ybzt_ml"
                placeholder="请输入内容"
                size="small"
              ></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row class="border_bottom">
          <el-col :span="24">
            <el-row>
              <el-col :span="12">
                <el-form-item label="血压左侧收缩" prop="ybzt_xyzcssy">
                  <el-input
                    v-model="form.ybzt_xyzcssy"
                    placeholder="请输入内容"
                    size="small"
                  >
                    <template slot="append">mmhg </template>
                  </el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="血压左侧舒张" prop="ybzt_xyzcszy">
                  <el-input
                    v-model="form.ybzt_xyzcszy"
                    placeholder="请输入内容"
                    size="small"
                  >
                    <template slot="append">mmhg </template>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="血压右侧收缩" prop="ybzt_xyycssy">
                  <el-input
                    v-model="form.ybzt_xyycssy"
                    placeholder="请输入内容"
                    size="small"
                  >
                    <template slot="append">mmhg </template>
                  </el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="血压右侧舒张" prop="ybzt_xyycszy">
                  <el-input
                    v-model="form.ybzt_xyycszy"
                    placeholder="请输入内容"
                    size="small"
                  >
                    <template slot="append">mmhg </template>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>

        <el-row class="border_bottom">
          <el-col :span="12">
            <el-form-item
              label="呼吸频率"
              prop="ybzt_hxpl"
            >
              <el-input
                v-model="form.ybzt_hxpl"
                placeholder="请输入内容"
                size="small"
              >
                <template slot="append">次/每分钟</template>
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="身 高" prop="ybzt_sg">
              <el-input
                v-model="form.ybzt_sg"
                placeholder="请输入内容"
                size="small"
              >
                <template slot="append">cm </template>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row class="border_bottom">
          <el-col :span="12">
            <el-form-item label="体 重" prop="ybzt_tz">
              <el-input
                v-model="form.ybzt_tz"
                placeholder="请输入内容"
                size="small"
              >
                <template slot="append">kg </template>
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="腰 围" prop="ybzt_yw">
              <el-input
                v-model="form.ybzt_yw"
                placeholder="请输入内容"
                size="small"
              >
                <template slot="append">cm </template>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row class="border_bottom">
          <el-col :span="12">
            <el-form-item label="臀围" prop="ybzt_tunwei">
              <el-input
                v-model="form.ybzt_tunwei"
                placeholder="请输入内容"
                size="small"
              >
                <template slot="append">cm </template>
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="体质指数(BMI)" prop="ybzt_tzzs_bmi">
              <el-input
                v-model="form.ybzt_tzzs_bmi"
                placeholder="请输入内容"
                size="small"
              >
                <template slot="append">kg/m2 </template>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row class="border_bottom">
          <el-col :span="24">
            <el-form-item
              label="老年人健康状态自我评估"
              prop="ybzt_lnrjkztzwpg"
            >
              <el-radio-group v-model="form.ybzt_lnrjkztzwpg">
                <el-radio v-for="label in jkzt" :key="label" :label="label">{{
                  label
                }}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row class="border_bottom">
          <el-col :span="24">
            <el-form-item
              label="老年人生活自理能力自我评估"
              prop="ybzt_lnrshzlnlzwpg"
            >
              <el-radio-group v-model="form.ybzt_lnrshzlnlzwpg">
                <el-radio v-for="label in shzlnl" :key="label" :label="label">{{
                  label
                }}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row class="border_bottom">
          <el-col :span="24">
            <el-form-item label="老年人认知功能" prop="ybzt_lnrrzgn">
              <el-radio-group v-model="form.ybzt_lnrrzgn">
                <el-radio v-for="label in rzgn" :key="label" :label="label">{{
                  label
                }}</el-radio>
                <span>，老年人抑郁评分检查</span>
                <span style="font-size: 12px">，总分：</span>
                <el-input
                  v-model="form.ybzt_jyzlztjc_zf"
                  placeholder="请输入内容"
                  size="small"
                  style="width: 200px; display: inline-block"
                >
                </el-input>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row class="">
          <el-col :span="24">
            <el-form-item label="老年人情感状态" prop="ybzt_lnrqgzt">
              <el-radio-group v-model="form.ybzt_lnrqgzt">
                <el-radio v-for="label in qgzt" :key="label" :label="label">{{
                  label
                }}</el-radio>
                <span>，老年人抑郁评分检查</span>
                <span style="font-size: 12px">，总分：</span>
                <el-input
                  v-model="form.ybzt_lnryypfjc_zf"
                  placeholder="请输入内容"
                  size="small"
                  style="width: 200px; display: inline-block"
                >
                </el-input>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
import { yibanzhuangkuang } from "@/utils/dict";

export default {
  name: "",
  components: {},
  props: {},
  data() {
    return {
      form: {
        ybzt_tw: "", // 一般状态-体温
        ybzt_ml: "", // 一般状态-脉率
        ybzt_hxpl: "", // 一般状态-呼吸频率
        ybzt_xyzcssy: "", // 一般状态-血压左侧
        ybzt_xyycssy: "", // 一般状态-血压右侧
        ybzt_xyzcszy: "", // 一般状态-血压左侧
        ybzt_xyycszy: "", // 一般状态-血压右侧
        ybzt_sg: "", // 一般状态-身高
        ybzt_tz: "", // 一般状态-体重
        ybzt_yw: "", // 一般状态-腰围
        ybzt_tzzs_bmi: "", // 一般状态-体质指数(BMI)
        ybzt_tunwei: "", // 一般状态-臀围
        ybzt_lnrjkztzwpg: "", // 一般状态-老年人健康状态自我评估
        ybzt_lnrshzlnlzwpg: "", // 一般状态-老年人生活自理能力自我评估
        ybzt_lnrrzgn: "", // 一般状态-老年人认知功能
        ybzt_jyzlztjc_zf: "", // 一般状态-简易智力状态检查-总分
        ybzt_lnrqgzt: "", // 一般状态-老年人情感状态
        ybzt_lnryypfjc_zf: "", // 一般状态-老年人抑郁评分检查-总分
      },
      jkzt: yibanzhuangkuang.jkzt, // 健康状态
      shzlnl: yibanzhuangkuang.shzlnl, // 生活自理能力
      rzgn: yibanzhuangkuang.rzgn, // 老年人认知功能
      qgzt: yibanzhuangkuang.qgzt, // 老年人情感状态
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
