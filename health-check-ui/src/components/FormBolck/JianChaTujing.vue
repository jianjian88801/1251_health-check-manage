<template>
  <el-form :model="form" ref="form" label-width="0">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold"> 检查途径</el-col>
      <el-col :span="21" class="right-col">
        <el-form-item label="" prop="jctj">
          <el-checkbox-group v-model="form.jctj">
            <el-checkbox
              v-for="(label) in jctj"
              :key="label"
              :label="label"
              >{{ label }}</el-checkbox
            >
          </el-checkbox-group>
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
import { jctj } from "@/utils/dict";

export default {
  name: "",
  components: {},
  props: {},
  data() {
    return {
      form: {
        jctj: [],
      },
      jctj,
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
