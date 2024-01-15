<template>
  <el-form :model="form" ref="form" label-width="0">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold">住院治疗情况</el-col>
      <el-col :span="21" class="right-col">
        <el-row class="border-b-1">
          <el-form-item label-width="0" label="" prop="zyzlqk_zysyw">
            <el-radio-group v-model="form.zyzlqk_zysyw">
              <el-radio label="无">无</el-radio>
              <el-radio label="有">有</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-row>
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">住院史</el-col>
          <el-col :span="21" class="border_left">
            <el-table :data="zyzlqk_zysy" border style="width: 100%; border: none">
              <el-table-column prop="date" label="入院日期">
                <!-- row, column, $index -->
                <template slot-scope="scope">
                  <el-date-picker
                    :disabled="form.zyzlqk_zysyw == '无'"
                    v-model="form['zyzlqk_ryrq' + (scope.$index + 1)]"
                    type="date"
                    placeholder="选择入院日期"
                    value-format="yyyy-MM-dd"
                    :picker-options="pickerOptions"
                  ></el-date-picker>
                </template>
              </el-table-column>
              <el-table-column prop="zyzlqk_ryrq" label="出院日期">
                <template slot-scope="scope">
                  <el-date-picker
                    :disabled="form.zyzlqk_zysyw == '无'"
                    v-model="form['zyzlqk_cyrq' + (scope.$index + 1)]"
                    type="date"
                    placeholder="选择出院日期"
                    value-format="yyyy-MM-dd"
                    :picker-options="pickerOptions"
                  ></el-date-picker>
                </template>
              </el-table-column>
              <el-table-column prop="zyzlqk_zyyy" label="原因">
                <template slot-scope="scope">
                  <el-input
                    :disabled="form.zyzlqk_zysyw == '无'"
                    v-model="form['zyzlqk_zyyy' + (scope.$index + 1)]"
                  ></el-input>
                </template>
              </el-table-column>
              <el-table-column prop="zyzlqk_zyyljgmc" label="医疗机构名称">
                <template slot-scope="scope">
                  <el-input
                    :disabled="form.zyzlqk_zysyw == '无'"
                    v-model="form['zyzlqk_zyyljgmc' + (scope.$index + 1)]"
                  ></el-input>
                </template>
              </el-table-column>
              <el-table-column prop="date" label="病案号">
                <template slot-scope="scope">
                  <el-input
                    :disabled="form.zyzlqk_zysyw == '无'"
                    v-model="form['zyzlqk_zyblh' + (scope.$index + 1)]"
                  ></el-input>
                </template>
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
        <el-row class="border-b-1">
          <el-form-item label-width="0" label="" prop="zyzlqk_jcyw">
            <el-radio-group v-model="form.zyzlqk_jcyw">
              <el-radio label="无">无</el-radio>
              <el-radio label="有">有</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-row>
        <el-row class="" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">家庭病床史</el-col>
          <el-col :span="21" class="border_left">
            <el-table :data="zyzlqk_jzbcsy" border style="width: 100%; border: none" >
              <el-table-column prop="date" label="建床日期">
                <template slot-scope="scope">
                  <el-date-picker
                    :disabled="form.zyzlqk_jcyw == '无'"
                    v-model="form['zyzlqk_jcrq' + (scope.$index + 1)]"
                    type="date"
                    placeholder="选择入院日期"
                    value-format="yyyy-MM-dd"
                    :picker-options="pickerOptions"
                  ></el-date-picker>
                </template>
              </el-table-column>

              <el-table-column prop="date" label="撤床日期">
                <template slot-scope="scope">
                  <el-date-picker
                    :disabled="form.zyzlqk_jcyw == '无'"
                    v-model="form['zyzlqk_ccrq' + (scope.$index + 1)]"
                    type="date"
                    placeholder="选择出院日期"
                    value-format="yyyy-MM-dd"
                    :picker-options="pickerOptions"
                  ></el-date-picker>
                </template>
              </el-table-column>

              <el-table-column prop="date" label="原因">
                <template slot-scope="scope">
                  <el-input
                    :disabled="form.zyzlqk_jcyw == '无'"
                    v-model="form['zyzlqk_jcyy' + (scope.$index + 1)]"
                  ></el-input>
                </template>
              </el-table-column>

              <el-table-column prop="date" label="医疗机构名称">
                <template slot-scope="scope">
                  <el-input
                    :disabled="form.zyzlqk_jcyw == '无'"
                    v-model="form['zyzlqk_jcyljgmc' + (scope.$index + 1)]"
                  ></el-input>
                </template>
              </el-table-column>

              <el-table-column prop="date" label="病案号">
                <template slot-scope="scope">
                  <el-input
                    :disabled="form.zyzlqk_jcyw == '无'"
                    v-model="form['zyzlqk_jcblh' + (scope.$index + 1)]"
                  ></el-input>
                </template>
              </el-table-column>

            </el-table>
          </el-col>
        </el-row>
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
        zyzlqk_zysyw: "",

        zyzlqk_ryrq1: "",
        zyzlqk_cyrq1: "",
        zyzlqk_zyyy1: "",
        zyzlqk_zyyljgmc1: "",
        zyzlqk_zyblh1: "",

        zyzlqk_ryrq2: "",
        zyzlqk_cyrq2: "",
        zyzlqk_zyyy2: "",
        zyzlqk_zyyljgmc2: "",
        zyzlqk_zyblh2: "",

        zyzlqk_jcyw: "",

        zyzlqk_jcrq1: "",
        zyzlqk_ccrq1: "",
        zyzlqk_jcyy1: "",
        zyzlqk_jcyljgmc1: "",
        zyzlqk_jcblh1: "",

        zyzlqk_jcrq2: "",
        zyzlqk_ccrq2: "",
        zyzlqk_jcyy2: "",
        zyzlqk_jcyljgmc2: "",
        zyzlqk_jcblh2: "",
      },
      zyzlqk_zysy: [
        {
          zyzlqk_ryrq: "",
          zyzlqk_cyrq: "",
          zyzlqk_zyyy: "",
          zyzlqk_zyyljgmc: "",
          zyzlqk_zyblh: "",
        },
        {
          zyzlqk_ryrq: "",
          zyzlqk_cyrq: "",
          zyzlqk_zyyy: "",
          zyzlqk_zyyljgmc: "",
          zyzlqk_zyblh: "",
        },
      ],
      zyzlqk_jzbcsy: [
        {
          zyzlqk_jcrq: "",
          zyzlqk_ccrq: "",
          zyzlqk_jcyy: "",
          zyzlqk_jcyljgmc: "",
          zyzlqk_jcblh: "",
        },
        {
          zyzlqk_jcrq: "",
          zyzlqk_ccrq: "",
          zyzlqk_jcyy: "",
          zyzlqk_jcyljgmc: "",
          zyzlqk_jcblh: "",
        },
      ],
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
    };
  },
  computed: {},
  watch: {},
  mounted() {},
  methods: {
    getFormData() {
      return Object.assign({}, this.form)
    }
  },
};
</script>

<style>
.border-b-1 {
  border-bottom: 1px solid #eee;
}
</style>
