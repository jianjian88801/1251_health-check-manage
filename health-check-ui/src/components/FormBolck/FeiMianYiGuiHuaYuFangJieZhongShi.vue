<template>
  <el-form :model="form" ref="form" label-width="0">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold">非免疫规划<br/>预防接种史</el-col>
      <el-col :span="18" class="right-col">
        <el-form-item label-width="0" label="" prop="fmyghyfjzs_yw">
          <el-radio-group v-model="form.fmyghyfjzs_yw">
            <el-radio label="无">无</el-radio>
            <el-radio label="有">有</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="">
          <el-table :data="tableData" border style="width: 100%">
            <el-table-column prop="date" label="名称" width="180">
              <template slot-scope="scope">
                <el-input
                  type="text"
                  v-model="form['fmyghyfjzs_jzmc' + (scope.$index + 1)]"
                  :disabled="form.fmyghyfjzs_yw == '无'"
                ></el-input>
              </template>
            </el-table-column>
            <el-table-column prop="name" label="接种日期">
              <template slot-scope="scope">
                <el-date-picker
                  :disabled="form.fmyghyfjzs_yw == '无'"
                  v-model="form['fmyghyfjzs_jzrq' + (scope.$index + 1)]"
                  type="date"
                  placeholder="选择日期"
                  value-format="yyyy-MM-dd"
                  :picker-options="pickerOptions"
                >
                </el-date-picker>
              </template>
            </el-table-column>
            <el-table-column prop="address" label="接种机构">
              <template slot-scope="scope">
                <el-input
                  type="text"
                  v-model="form['fmyghyfjzs_jzjg' + (scope.$index + 1)]"
                  :disabled="form.fmyghyfjzs_yw == '无'"
                ></el-input>
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
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
      form: {
        fmyghyfjzs_yw: "",
        fmyghyfjzs_jzmc1: "",
        fmyghyfjzs_jzrq1: "",
        fmyghyfjzs_jzjg1: "",
        fmyghyfjzs_jzmc2: "",
        fmyghyfjzs_jzrq2: "",
        fmyghyfjzs_jzjg2: "",
        fmyghyfjzs_jzmc3: "",
        fmyghyfjzs_jzrq3: "",
        fmyghyfjzs_jzjg3: "",
      },
      tableData: [
        {},{},{},
      ],
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

<style lang="scss">
</style>
