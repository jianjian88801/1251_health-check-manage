<template>
  <el-form :model="form" ref="form" label-width="0">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold"> 体检类型</el-col>
      <el-col :span="18" class="right-col">
        <el-form-item label="" prop="tjlx">
          <el-radio-group v-model="form.tjlx">
            <el-radio
              v-for="label in tjlx"
              :key="label"
              :label="label"
              >{{ label }}</el-radio
            >
          </el-radio-group>
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
import { tjlx } from "@/utils/dict";

export default {
  name: "",
  components: {},
  props: {},
  data() {
    return {
      form: {
        tjlx: "",
      },
      tjlx,
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
