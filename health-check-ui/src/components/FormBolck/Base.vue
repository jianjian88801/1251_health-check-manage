<template>
  <el-form :model="form" ref="form" label-width="110px">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold"> 基础信息</el-col>
      <el-col :span="18" class="right-col">
        <el-row>
          <el-col :span="12">
            <el-form-item
              label="体检日期"
              prop="tjrq"
              :rules="$getRequireRule()"
            >
              <el-date-picker
                v-model="form.tjrq"
                type="datetime"
                size="small"
                placeholder="选择日期"
                :picker-options="pickerOptions"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item
              label="录入医生"
              prop="lrys"
              :rules="$getRequireRule()"
            >
              <el-input v-model="form.lrys" size="small" disabled></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item
              label="录入单位"
              prop="lrdw"
              :rules="$getRequireRule()"
            >
              <el-input v-model="form.lrdw" size="small" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item
              label="患者名称"
              prop="hzmc"
              :rules="$getRequireRule()"
            >
              <el-input v-model="form.hzmc" size="small"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item
              label="患者身份证"
              prop="hzsfz"
              :rules="$getRequireRule()"
            >
              <el-input v-model="form.hzsfz" size="small"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item
              label="患者性别"
              prop="hzxb"
              :rules="$getRequireRule()"
            >
              <el-radio-group v-model="form.hzxb" size="small">
                <el-radio label="男"></el-radio>
                <el-radio label="女"></el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item
              label="检查项目"
              prop="jcxm"
              :rules="$getRequireRule()"
            >
              <el-input v-model="form.jcxm" size="small"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="内容" prop="nr">
              <el-input v-model="form.nr" size="small"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item
              label="自定义编号"
              prop="zdytjbh"
              :rules="$getRequireRule()"
            >
              <el-input v-model="form.zdytjbh" size="small"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="备注" prop="bz">
              <el-input size="small" v-model="form.bz"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
// import * from ''
export default {
  name: "",
  components: {},
  props: {},
  data() {
    return {
      form: {
        tjrq: "",
        lrys: "",
        lrdw: "",
        nr: "",
        jcxm: "",
        hzmc: "",
        hzsfz: "",
        hzxb: "",
        zdytjbh: "",
        bz: "",
      },
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
    };
  },
  computed: {},
  watch: {},
  mounted() {

  },
  methods: {
    reset() {
      !this.form.lrys && (this.form.lrys = this.$store.state.userInfo.name);
      !this.form.lrdw && (this.form.lrdw = this.$store.state.userInfo.chain);
      !this.form.tjrq && (this.form.tjrq = new Date());
    },
  },
};
</script>

<style lang="scss">
</style>
