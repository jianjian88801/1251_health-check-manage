<template>
  <el-form :model="form" ref="form" label-width="0">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold"> 宣体</el-col>
      <el-col :span="21" class="right-col">
        <!-- 眼底 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            眼底
          </el-col>
          <el-col :span="21" class="border_left">
            <el-form-item label="" prop="xt_ydzt">
              <el-radio-group v-model="form.xt_ydzt">
                <el-radio
                  v-for="(label) in yandi"
                  :key="label"
                  :label="label"
                  ></el-radio>
                <el-input v-if="form.xt_ydzt === '异常'" v-model="form.xt_ydyc" placeholder="请输入内容" size="small" style="width: 200px; display: inline-block"></el-input>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 皮肤 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            皮肤
          </el-col>
          <el-col :span="21" class="border_left">
            <el-form-item label="" prop="xt_pfzt">
              <el-radio-group v-model="form.xt_pfzt">
                <el-radio
                  v-for="(label) in pifu"
                  :key="label"
                  :label="label"
                  ></el-radio>
                <el-input v-if="form.xt_pfzt === '其他'" v-model="form.xt_pf_qt" placeholder="请输入内容" size="small" style="width: 200px; display: inline-block"></el-input>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 巩膜 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            巩膜
          </el-col>
          <el-col :span="21" class="border_left">
            <el-form-item label="" prop="xt_gmzt">
              <el-radio-group v-model="form.xt_gmzt">
                <el-radio
                  v-for="(label) in gongmo"
                  :key="label"
                  :label="label"
                  ></el-radio>
                <el-input v-if="form.xt_gmzt === '其他'" v-model="form.xt_gm_qt" placeholder="请输入内容" size="small" style="width: 200px; display: inline-block"></el-input>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 淋巴结 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            淋巴结
          </el-col>
          <el-col :span="21" class="border_left">
            <el-form-item label="" prop="xt_lbjzt">
              <el-radio-group v-model="form.xt_lbjzt">
                <el-radio
                  v-for="(label) in linbajie"
                  :key="label"
                  :label="label"
                  ></el-radio>
                <el-input v-if="form.xt_lbjzt === '其他'" v-model="form.xt_lbj_qt" placeholder="请输入内容" size="small" style="width: 200px; display: inline-block"></el-input>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 肺 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            肺
          </el-col>
          <el-col :span="21" class="border_left">

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                桶状胸
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_f_tzx">
                  <el-radio-group v-model="form.xt_f_tzx">
                    <el-radio label="否"></el-radio>
                    <el-radio label="是"></el-radio>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                呼吸音
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_f_hxy">
                  <el-radio-group v-model="form.xt_f_hxy">
                    <el-radio label="正常"></el-radio>
                    <el-radio label="异常"></el-radio>
                    <el-input v-if="form.xt_f_hxy === '异常'" v-model="form.xt_f_hxyms" placeholder="请输入内容" size="small" style="width: 200px; display: inline-block"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                啰音
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_f_ly">
                  <el-checkbox-group v-model="form.xt_f_ly">
                    <el-checkbox label="无"></el-checkbox>
                    <el-checkbox label="干啰音"></el-checkbox>
                    <el-checkbox label="湿啰音"></el-checkbox>
                    <el-checkbox label="其他"></el-checkbox>
                    <el-input v-model="form.xt_f_ly_qt" placeholder="请输入内容" size="small" style="width: 200px; display: inline-block"></el-input>
                  </el-checkbox-group>
                </el-form-item>
              </el-col>
            </el-row>

          </el-col>
        </el-row>
        <!-- 心脏 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            心脏
          </el-col>
          <el-col :span="21" class="border_left">

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                心率
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_xz_xl_1">
                  <el-input v-model="form.xt_xz_xl_1" placeholder="请输入内容" size="small"
                  style="width: 100px; display: inline-block"></el-input>
                  <span class="fs14"> 次/每分钟</span>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                心律
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_xz_xl_2">
                  <el-radio-group v-model="form.xt_xz_xl_2">
                    <el-radio label="齐"></el-radio>
                    <el-radio label="不齐"></el-radio>
                    <el-radio label="绝对不齐"></el-radio>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                杂音
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_xz_zyyw">
                  <el-radio-group v-model="form.xt_xz_zyyw">
                    <el-radio label="无"></el-radio>
                    <el-radio label="有"></el-radio>
                    <el-input v-model="form.xt_xz_zyms  " placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

          </el-col>
        </el-row>
        <!-- 腹部 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            腹部
          </el-col>
          <el-col :span="21" class="border_left">

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                压痛
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fb_ytyw">
                  <el-radio-group v-model="form.xt_fb_ytyw">
                    <el-radio label="无"></el-radio>
                    <el-radio label="有"></el-radio>
                    <el-input v-model="form.xt_fb_ytms" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                包块
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fb_bkyw">
                  <el-radio-group v-model="form.xt_fb_bkyw">
                    <el-radio label="无"></el-radio>
                    <el-radio label="有"></el-radio>
                    <el-input v-model="form.xt_fb_bkms" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                肝大
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fb_gdyw">
                  <el-radio-group v-model="form.xt_fb_gdyw">
                    <el-radio label="无"></el-radio>
                    <el-radio label="有"></el-radio>
                    <el-input v-model="form.xt_fb_gdms" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                脾大
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fb_pdyw">
                  <el-radio-group v-model="form.xt_fb_pdyw">
                    <el-radio label="无"></el-radio>
                    <el-radio label="有"></el-radio>
                    <el-input v-model="form.xt_fb_pdms" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                移动性浊音
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fb_ydxzyyw">
                  <el-radio-group v-model="form.xt_fb_ydxzyyw">
                    <el-radio label="无"></el-radio>
                    <el-radio label="有"></el-radio>
                    <el-input v-model="form.xt_fb_ydxzyms" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

          </el-col>
        </el-row>
        <!-- 下肢水肿 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            下肢水肿
          </el-col>
          <el-col :span="21" class="border_left">
            <el-form-item label="" prop="xt_xzsz">
              <el-radio-group v-model="form.xt_xzsz">
                <el-radio label="无"></el-radio>
                <el-radio label="单侧"></el-radio>
                <el-radio label="双侧不对称"></el-radio>
                <el-radio label="双侧对称"></el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 足背静脉搏动 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            足背静脉搏动*
          </el-col>
          <el-col :span="21" class="border_left">
            <el-form-item label="" prop="xt_zbdmbd">
              <el-radio-group v-model="form.xt_zbdmbd">
                <el-radio label="未触及"></el-radio>
                <el-radio label="触及双侧对称"></el-radio>
                <el-radio label="触及左侧弱或消失"></el-radio>
                <el-radio label="触及右侧弱或消失"></el-radio>
                <el-radio label="触及双侧弱或消失"></el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 肛门指诊 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            肛门指诊
          </el-col>
          <el-col :span="21" class="border_left">
            <el-form-item label="" prop="xt_gmzz">
              <el-radio-group v-model="form.xt_gmzz">
                <el-radio label="未见异常"></el-radio>
                <el-radio label="触及"></el-radio>
                <el-radio label="包块"></el-radio>
                <el-radio label="前列腺异常"></el-radio>
                <el-radio label="其他"></el-radio>
                <el-input v-model="form.xt_gmzz_qt" placeholder="请输入内容" size="small"
                style="width: 300px;"></el-input>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 乳腺 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            乳腺
          </el-col>
          <el-col :span="21" class="border_left">
            <el-form-item label="" prop="xt_rx">
              <el-checkbox-group v-model="form.xt_rx">
                <el-checkbox label="未见异常"></el-checkbox>
                <el-checkbox label="乳房切除"></el-checkbox>
                <el-checkbox label="异常泌乳"></el-checkbox>
                <el-checkbox label="乳腺包块"></el-checkbox>
                <el-checkbox label="其他"></el-checkbox>
                <el-input v-model="form.xt_rx_qt" placeholder="请输入内容" size="small"
                style="width: 300px;"></el-input>
              </el-checkbox-group>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 妇科 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            妇科
          </el-col>
          <el-col :span="21" class="border_left">

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                外阴
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fk_wy">
                  <el-radio-group v-model="form.xt_fk_wy">
                    <el-radio label="未见异常"></el-radio>
                    <el-radio label="异常"></el-radio>
                    <el-input v-model="form.xt_fk_wyyc" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                阴道
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fk_yd">
                  <el-radio-group v-model="form.xt_fk_yd">
                    <el-radio label="未见异常"></el-radio>
                    <el-radio label="异常"></el-radio>
                    <el-input v-model="form.xt_fk_ydyc" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                宫颈
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fk_gj">
                  <el-radio-group v-model="form.xt_fk_gj">
                    <el-radio label="未见异常"></el-radio>
                    <el-radio label="异常"></el-radio>
                    <el-input v-model="form.xt_fk_gjyc" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="border_bottom" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                宫体
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fk_gt">
                  <el-radio-group v-model="form.xt_fk_gt">
                    <el-radio label="未见异常"></el-radio>
                    <el-radio label="异常"></el-radio>
                    <el-input v-model="form.xt_fk_gtyc" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row class="" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                附件
              </el-col>
              <el-col :span="21" class="border_left">
                <el-form-item label="" prop="xt_fk_fj">
                  <el-radio-group v-model="form.xt_fk_fj">
                    <el-radio label="未见异常"></el-radio>
                    <el-radio label="异常"></el-radio>
                    <el-input v-model="form.xt_fk_fjyc" placeholder="请输入内容" size="small"
                    style="width: 300px;"></el-input>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

          </el-col>
        </el-row>
        <!-- 其他* -->
        <el-row class="" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center">
            其他*
          </el-col>
          <el-col :span="21" class="border_left">
            <el-form-item label="" prop="xt_qt">
                <el-input v-model="form.xt_qt" placeholder="请输入内容" size="small"
                style="width: 80%"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

      </el-col>
    </el-row>
  </el-form>
</template>

<script>
import { xuanti } from "@/utils/dict";

export default {
  name: "",
  components: {},
  props: {},
  data() {
    return {
      form: { xt_ydzt: '', // 宣体-眼底状态
        xt_ydyc: '', // 宣体-眼底异常
        xt_pfzt: '', // 宣体-皮肤状态
        xt_pf_qt: '', // 宣体-皮肤-其他
        xt_gmzt: '', // 宣体-巩膜状态
        xt_gm_qt: '', // 宣体-巩膜-其他
        xt_lbjzt: '', // 宣体-淋巴结状态
        xt_lbj_qt: '', // 宣体-淋巴结-其他
        xt_f_tzx: '', // 宣体-肺-桶状胸
        xt_f_hxy: '', // 宣体-肺-呼吸音
        xt_f_hxyms: '', // 宣体-肺-呼吸音描述
        xt_f_ly: [], // 宣体-肺-罗音
        xt_f_ly_qt: '', // 宣体-肺-罗音-其他
        xt_xz_xl_1: '', // 宣体-心脏-心率-1
        xt_xz_xl_2: '', // 宣体-心脏-心律-2
        xt_xz_zyyw: '', // 宣体-心脏-杂音有无
        xt_xz_zyms: '', // 宣体-心脏-杂音描述
        xt_fb_ytyw: '', // 宣体-腹部-压痛有无
        xt_fb_ytms: '', // 宣体-腹部-压痛描述
        xt_fb_bkyw: '', // 宣体-腹部-包块有无
        xt_fb_bkms: '', // 宣体-腹部-包块描述
        xt_fb_gdyw: '', // 宣体-腹部-肝大有无
        xt_fb_gdms: '', // 宣体-腹部-肝大描述
        xt_fb_pdyw: '', // 宣体-腹部-脾大有无
        xt_fb_pdms: '', // 宣体-腹部-脾大描述
        xt_fb_ydxzyyw: '', // 宣体-腹部-移动性浊音有无
        xt_fb_ydxzyms: '', // 宣体-腹部-移动性浊音描述
        xt_xzsz: '', // 宣体-下肢水肿
        xt_zbdmbd: '', // 宣体-足背动脉搏动
        xt_gmzz: '', // 宣体-肛门指诊
        xt_gmzz_qt: '', // 宣体-肛门指诊-其他
        xt_rx: [], // 宣体-乳腺
        xt_rx_qt: '', // 宣体-乳腺-其他
        xt_fk_wy: '', // 宣体-妇科-外阴
        xt_fk_wyyc: '', // 宣体-妇科-外阴异常
        xt_fk_yd: '', // 宣体-妇科-阴道
        xt_fk_ydyc: '', // 宣体-妇科-阴道异常
        xt_fk_gj: '', // 宣体-妇科-宫颈
        xt_fk_gjyc: '', // 宣体-妇科-宫颈异常
        xt_fk_gt: '', // 宣体-妇科-宫体
        xt_fk_gtyc: '', // 宣体-妇科-宫体异常
        xt_fk_fj: '', // 宣体-妇科-附件
        xt_fk_fjyc: '', // 宣体-妇科-附件异常
        xt_qt: '', // 宣体-其他
      },
      yandi: xuanti.yandi,
      pifu: xuanti.pifu,
      gongmo: xuanti.gongmo,
      linbajie: xuanti.linbajie,
    };
  },
  computed: {

  },
  watch: {},
  mounted() {

  },
  methods: {},
};
</script>

<style lang="scss">
</style>
