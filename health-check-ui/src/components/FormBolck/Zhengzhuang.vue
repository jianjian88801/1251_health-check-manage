<template>
  <el-form :model="form" ref="form" label-width="0">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold"> 症状</el-col>
      <el-col :span="18" class="right-col">
        <el-form-item label="" prop="zz">
          <el-checkbox-group v-model="form.zz">
            <el-checkbox
              v-for="(item, index) in zhengzhuang"
              :key="item.label"
              :label="item.label"
              >{{ (index + 1) + item.label }}</el-checkbox
            >
            <el-input v-if="form.zz.indexOf('其他') !== -1" v-model="form.zz_qt" 
            placeholder="请输入其他内容" size="small" class="w200px inb"></el-input>
          </el-checkbox-group>
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
import { zhengzhuang } from "@/utils/dict";

export default {
  name: "",
  components: {},
  props: {},
  data() {
    return {
      form: {
        zz: [],
        zz_qt: ''
      },
      other: '',
      zhengzhuang: [],
    };
  },
  computed: {

  },
  watch: {},
  mounted() {
    for (var key in zhengzhuang) {
      this.zhengzhuang.push({
        label: zhengzhuang[key],
        value: key
      })
    }
  },
  methods: {},
};
</script>

<style lang="scss">
</style>
