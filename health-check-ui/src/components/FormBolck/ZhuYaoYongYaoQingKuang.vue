<template>
  <el-form :model="form" ref="form" label-width="0">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold">主要用药情况</el-col>
      <el-col :span="20" class="right-col">
        <el-form-item label-width="0" label="" prop="zyyyqk_yw">
          <el-radio-group v-model="form.zyyyqk_yw">
            <el-radio label="无">无</el-radio>
            <el-radio label="有">有</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="">
          <el-table :data="tableData" border style="width: 100%">
            <el-table-column prop="date" label="药物名称">
              <template slot-scope="scope">
                <el-input
                  type="text"
                  v-model="form['zyyyqk_ywmc' + (scope.$index + 1)]"
                  :disabled="form.zyyyqk_yw == '无'"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column prop="date" label="用法">
              <template slot-scope="scope">
                <el-input
                  type="text"
                  v-model="form['zyyyqk_yf' + (scope.$index + 1)]"
                  :disabled="form.zyyyqk_yw == '无'"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column prop="date" label="其他用法">
              <template slot-scope="scope">
                <el-input
                        type="text"
                        v-model="form['zyyyqk_qtyf' + (scope.$index + 1)]"
                        :disabled="form.zyyyqk_yw == '无'"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column prop="date" label="用量">
              <template slot-scope="scope">
                <el-input
                  type="text"
                  v-model="form['zyyyqk_yl' + (scope.$index + 1)]"
                  :disabled="form.zyyyqk_yw == '无'"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column prop="date" label="剂量单位">
              <template slot-scope="scope">
                <el-input
                  type="text"
                  v-model="form['zyyyqk_jldw' + (scope.$index + 1)]"
                  :disabled="form.zyyyqk_yw == '无'"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column prop="date" label="用药时间" width="160">
              <template slot-scope="scope">
                <el-date-picker
                  type="date"
                  v-model="form['zyyyqk_yysj' + (scope.$index + 1)]"
                  :disabled="form.zyyyqk_yw == '无'"
                  placeholder="选择日期"
                  value-format="yyyy-MM-dd"
                ></el-date-picker>
              </template>
            </el-table-column>

            <el-table-column prop="date" label="用药单位">
              <template slot-scope="scope">
                <el-input
                  type="text"
                  v-model="form['zyyyqk_yydw' + (scope.$index + 1)]"
                  :disabled="form.zyyyqk_yw == '无'"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column prop="date" width="220" label="服药依从性">
              <template slot-scope="scope">
                <el-radio-group v-model="form['zyyyqk_fycyx' + (scope.$index + 1)]"
                  :disabled="form.zyyyqk_yw == '无'">
                  <el-radio label="规律">规律</el-radio>
                  <el-radio label="间断">间断</el-radio>
                  <el-radio label="不服药">不服药</el-radio>
                </el-radio-group>
              </template>
            </el-table-column>
          </el-table>
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
export default {
  name: "",
  components: {},
  props: {},
  data() {
    return {
      form: {
        zyyyqk_yw: "",

        zyyyqk_ywmc1: "",
        zyyyqk_yf1: "",
        zyyyqk_qtyf1: "",
        zyyyqk_yl1: "",
        zyyyqk_jldw1: "",
        zyyyqk_yysj1: "",
        zyyyqk_yydw1: "",
        zyyyqk_fycyx1: "",

        zyyyqk_ywmc2: "",
        zyyyqk_yf2: "",
        zyyyqk_qtyf2: "",
        zyyyqk_yl2: "",
        zyyyqk_jldw2: "",
        zyyyqk_yysj2: "",
        zyyyqk_yydw2: "",
        zyyyqk_fycyx2: "",

        zyyyqk_ywmc3: "",
        zyyyqk_yf3: "",
        zyyyqk_qtyf3: "",
        zyyyqk_yl3: "",
        zyyyqk_jldw3: "",
        zyyyqk_yysj3: "",
        zyyyqk_yydw3: "",
        zyyyqk_fycyx3: "",

        zyyyqk_ywmc4: "",
        zyyyqk_yf4: "",
        zyyyqk_qtyf4: "",
        zyyyqk_yl4: "",
        zyyyqk_jldw4: "",
        zyyyqk_yysj4: "",
        zyyyqk_yydw4: "",
        zyyyqk_fycyx4: "",

        zyyyqk_ywmc5: "",
        zyyyqk_yf5: "",
        zyyyqk_qtyf5: "",
        zyyyqk_yl5: "",
        zyyyqk_jldw5: "",
        zyyyqk_yysj5: "",
        zyyyqk_yydw5: "",
        zyyyqk_fycyx5: "",

        zyyyqk_ywmc6: "",
        zyyyqk_yf6: "",
        zyyyqk_qtyf6: "",
        zyyyqk_yl6: "",
        zyyyqk_jldw6: "",
        zyyyqk_yysj6: "",
        zyyyqk_yydw6: "",
        zyyyqk_fycyx6: "",
      },
      tableData: [
        {},{},{},{},{},{},
      ],
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
