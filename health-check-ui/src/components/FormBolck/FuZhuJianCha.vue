<template>
  <el-form :model="form" ref="form" label-width="120px">
    <el-row class="row-index">
      <el-col :span="2" class="left-col bold">辅助检查</el-col>
      <el-col :span="21" class="right-col">
        <!-- 血常规 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 血常规 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <el-form-item class="inb" label="血红蛋白" prop="fzjc_xcg_xhdb">
                  <el-input v-model="form.fzjc_xcg_xhdb" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">g/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="白细胞" prop="fzjc_xcg_bxb">
                  <el-input v-model="form.fzjc_xcg_bxb" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">×10⁹/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="血小板" prop="fzjc_xcg_xxb">
                  <el-input v-model="form.fzjc_xcg_xxb" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">×10⁹/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="红细胞" prop="fzjc_xcg_hxb">
                  <el-input v-model="form.fzjc_xcg_hxb" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">×10¹²/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="中性粒细胞绝对值" prop="fzjc_xcg_zxlxbjdz">
                  <el-input v-model="form.fzjc_xcg_zxlxbjdz" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">×10⁹/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="淋巴细胞绝对值" prop="fzjc_xcg_lbxbjdz">
                  <el-input v-model="form.fzjc_xcg_lbxbjdz" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">×10⁹/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="单核细胞数" prop="fzjc_xcg_dhxbs">
                  <el-input v-model="form.fzjc_xcg_dhxbs" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">×10⁹/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="嗜酸性粒细胞数" prop="fzjc_xcg_ssxlxbs">
                  <el-input v-model="form.fzjc_xcg_ssxlxbs" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">×10⁹/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="嗜碱性粒细胞数" prop="fzjc_xcg_sjxlxbs">
                  <el-input v-model="form.fzjc_xcg_sjxlxbs" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">×10⁹/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="其他" prop="fzjc_xcg_qt">
                  <el-input v-model="form.fzjc_xcg_qt" placeholder="请输入内容" size="small"
                  style="width: 400px">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 尿常规 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 尿常规 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <el-form-item class="inb" label="尿蛋白" prop="fzjc_ncg_ndb">
                  <el-input v-model="form.fzjc_ncg_ndb" placeholder="请输入内容" size="small"
                  style="width: 180px">
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="尿糖" prop="fzjc_ncg_nt">
                  <el-input v-model="form.fzjc_ncg_nt" placeholder="请输入内容" size="small"
                  style="width: 180px">
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="尿酮体" prop="fzjc_ncg_ntt">
                  <el-input v-model="form.fzjc_ncg_ntt" placeholder="请输入内容" size="small"
                  style="width: 180px">
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="尿潜血" prop="fzjc_ncg_nqx">
                  <el-input v-model="form.fzjc_ncg_nqx" placeholder="请输入内容" size="small"
                  style="width: 180px">
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="尿白细胞" prop="fzjc_ncg_nbxb">
                  <el-input v-model="form.fzjc_ncg_nbxb" placeholder="请输入内容" size="small"
                  style="width: 180px">
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="尿胆红素" prop="fzjc_ncg_ndhs">
                  <el-input v-model="form.fzjc_ncg_ndhs" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">μmol/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="尿亚硝酸盐" prop="fzjc_ncg_nyxsy">
                  <el-input v-model="form.fzjc_ncg_nyxsy" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">μmol/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="其他" prop="fzjc_ncg_qt">
                  <el-input v-model="form.fzjc_ncg_qt" placeholder="请输入内容" size="small"
                  style="width: 400px">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 血糖 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 血糖 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="2" class="bold flex_center">
                空腹血糖
              </el-col>
              <el-col :span="21" class="">
                <el-form-item class="inb" label="" prop="fzjc_kfxtmmoll" label-width="0">
                  <el-input v-model="form.fzjc_kfxtmmoll" placeholder="请输入内容" size="small"
                  style="width: 200px">
                    <template slot="append">mmol/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="或" prop="fzjc_kfxtmgdl" label-width="20px">
                  <el-input v-model="form.fzjc_kfxtmgdl" placeholder="请输入内容" size="small"
                  style="width: 200px">
                    <template slot="append">mg/dL </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="餐后血糖" prop="fzjc_chxt" label-width="100px">
                  <el-input v-model="form.fzjc_chxt" placeholder="请输入内容" size="small"
                  style="width: 200px">
                    <template slot="append">mmol/L </template>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 心电图 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 心电图 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <div>
                  <el-form-item class="inb" label="状态" prop="fzjc_xdt_zt">
                    <el-radio-group v-model="form.fzjc_xdt_zt">
                      <el-radio label="正常"></el-radio>
                      <el-radio label="临界ECG"></el-radio>
                      <el-radio label="异常"></el-radio>
                    </el-radio-group>
                  </el-form-item>
                  <el-form-item class="inb" label="异常描述" prop="fzjc_xdt_ycms" label-width="68px">
                    <el-input v-model="form.fzjc_xdt_ycms" placeholder="请输入内容" size="small"
                    style="width: 300px">
                    </el-input>
                  </el-form-item>
                </div>
                <el-form-item class="inb" label="心电图心律" prop="fzjc_xdt_xdtxl">
                  <el-input v-model="form.fzjc_xdt_xdtxl" placeholder="请输入内容" size="small"
                  style="width: 180px">
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="心房率" prop="fzjc_xdt_xfl">
                  <el-input v-model="form.fzjc_xdt_xfl" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">bmp</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="bpm心室率" prop="fzjc_xdt_bpmxsl">
                  <el-input v-model="form.fzjc_xdt_bpmxsl" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">bmp</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="电轴" prop="fzjc_xdt_dz">
                  <el-input v-model="form.fzjc_xdt_dz" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">bmp</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="P-R间期" prop="fzjc_xdt_prjq">
                  <el-input v-model="form.fzjc_xdt_prjq" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">ms</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="QRS时限" prop="fzjc_xdt_qrssx">
                  <el-input v-model="form.fzjc_xdt_qrssx" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">ms</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="QT间期" prop="fzjc_xdt_qtjq">
                  <el-input v-model="form.fzjc_xdt_qtjq" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">ms</template>
                  </el-input>
                </el-form-item>
                <el-form-item label="描述" prop="fzjc_xdt_ms">
                  <el-input v-model="form.fzjc_xdt_ms" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
                <el-form-item label="提示" prop="fzjc_xdt_ts">
                  <el-input v-model="form.fzjc_xdt_ts" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
                <el-form-item label="心电图报告医生" prop="fzjc_xdt_xdtbgys">
                  <el-input v-model="form.fzjc_xdt_xdtbgys" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
                <el-form-item label="其他心电图报告医生" prop="fzjc_xdt_qtxdtbgys">
                  <el-input v-model="form.fzjc_xdt_qtxdtbgys" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 尿微量白蛋白 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 尿微量白蛋白 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">

              </el-col>
              <el-col :span="21" class="">
                <el-form-item class="inb" label="" prop="fzjc_nwlbdb" label-width="0">
                  <el-input v-model="form.fzjc_nwlbdb" placeholder="请输入内容" size="small"
                  style="width: 200px">
                    <template slot="append">mg/dL</template>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 大便潜血 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 大便潜血 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">

              </el-col>
              <el-col :span="21" class="">
                  <el-form-item class="inb" label="" prop="fzjc_dbqx" label-width="0">
                    <el-radio-group v-model="form.fzjc_dbqx">
                      <el-radio label="阴性"></el-radio>
                      <el-radio label="阳性"></el-radio>
                    </el-radio-group>
                  </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 糖化血红蛋白 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 糖化血红蛋白 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">

              </el-col>
              <el-col :span="21" class="">
                <el-form-item class="inb" label="" prop="fzjc_thxhdb" label-width="0">
                  <el-input v-model="form.fzjc_thxhdb" placeholder="请输入内容" size="small"
                  style="width: 200px">
                    <template slot="append">%</template>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 乙型肝炎表面抗原 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 乙型肝炎<br/>表面抗原 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">

              </el-col>
              <el-col :span="21" class="">
                  <el-form-item class="inb" label="" prop="fzjc_yxgybmky" label-width="0">
                    <el-radio-group v-model="form.fzjc_yxgybmky">
                      <el-radio label="阴性"></el-radio>
                      <el-radio label="阳性"></el-radio>
                    </el-radio-group>
                  </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!--肝吸虫-->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 肝吸虫 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">

              </el-col>
              <el-col :span="21" class="">
                <el-form-item class="inb" label="肝吸虫抗体" prop="fzjc_gxckt">
                  <el-radio-group v-model="form.fzjc_gxckt" style="width: 180px">
                    <el-radio label="无">无</el-radio>
                    <el-radio label="有">有</el-radio>
                  </el-radio-group>
                </el-form-item>
                <template v-if="form.fzjc_gxckt === '有'">
                  <el-form-item class="inb" label="肝吸虫抗体-定量" prop="fzjc_gxcktdl">
                    <el-input v-model="form.fzjc_gxcktdl" placeholder="请输入内容" size="small"
                              style="width: 180px">
                      <template slot="append">lgM</template>
                    </el-input>
                  </el-form-item>
                </template>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!--骨源性碱性磷酸酶-->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 骨源性碱<br/>性磷酸酶 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">

              </el-col>
              <el-col :span="21" class="">
                <el-form-item class="inb" label="" prop="fzjc_gyxjxlsm" label-width="0">
                  <el-input v-model="form.fzjc_gyxjxlsm" placeholder="请输入内容" size="small"
                            style="width: 200px">
                    <template slot="append">IU/L</template>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 肝功能 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 肝功能 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <el-form-item class="inb" label="血清谷丙转氨酶" prop="fzjc_ggn_xqgbzam">
                  <el-input v-model="form.fzjc_ggn_xqgbzam" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">U/L</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="血清谷草转氨酶" prop="fzjc_ggn_xqgczam">
                  <el-input v-model="form.fzjc_ggn_xqgczam" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">U/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="白蛋白" prop="fzjc_ggn_bdb">
                  <el-input v-model="form.fzjc_ggn_bdb" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">g/L </template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="总胆红素" prop="fzjc_ggn_zdhs">
                  <el-input v-model="form.fzjc_ggn_zdhs" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">μmol/L</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="结合胆红素" prop="fzjc_ggn_jhdhs">
                  <el-input v-model="form.fzjc_ggn_jhdhs" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">μmol/L</template>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 肾功能 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 肾功能 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <el-form-item class="inb" label="血清肌酐" prop="fzjc_sgn_xqjg">
                  <el-input v-model="form.fzjc_sgn_xqjg" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">μmol/L</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="尿酸" prop="fzjc_sgn_ns">
                  <el-input v-model="form.fzjc_sgn_ns" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">μmol/L</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="血尿素" prop="fzjc_sgn_xns">
                  <el-input v-model="form.fzjc_sgn_xns" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">mmol/L</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="血钾浓度" prop="fzjc_sgn_xjnd">
                  <el-input v-model="form.fzjc_sgn_xjnd" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">mmol/L</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="血钠浓度" prop="fzjc_sgn_xnnd">
                  <el-input v-model="form.fzjc_sgn_xnnd" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">mmol/L</template>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 血脂 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 血脂 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <el-form-item class="inb" label="总胆固醇" prop="fzjc_xz_zdgc">
                  <el-input v-model="form.fzjc_xz_zdgc" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">mmol/L</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="甘油三酯" prop="fzjc_xz_gysz">
                  <el-input v-model="form.fzjc_xz_gysz" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">mmol/L</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="血清低密度脂蛋白胆固醇" prop="fzjc_xz_xqdmdzdbdgc">
                  <el-input v-model="form.fzjc_xz_xqdmdzdbdgc" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">mmol/L</template>
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="血清高密度脂蛋白胆固醇" prop="fzjc_xz_xqgmdzdbdgc">
                  <el-input v-model="form.fzjc_xz_xqgmdzdbdgc" placeholder="请输入内容" size="small"
                  style="width: 180px">
                    <template slot="append">mmol/L</template>
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 胸部X线片 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 胸部X线片 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <el-form-item class="inb" label="状态" prop="fzjc_xbxxp_zt">
                  <el-radio-group v-model="form.fzjc_xbxxp_zt">
                    <el-radio label="正常"></el-radio>
                    <el-radio label="异常"></el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item v-if="form.fzjc_xbxxp_zt === '异常'" class="inb" label="" prop="fzjc_xbxxp_ztyc" label-width="0">
                  <el-input v-model="form.fzjc_xbxxp_ztyc" placeholder="请输入内容" size="small"
                    style="width: 455px">
                  </el-input>
                </el-form-item>
                <el-form-item label="检查情况描述" prop="fzjc_xbxxp_jcqkms">
                  <el-input v-model="form.fzjc_xbxxp_jcqkms" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
                <el-form-item label="诊断意见" prop="fzjc_xbxxp_zdyj">
                  <el-input v-model="form.fzjc_xbxxp_zdyj" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
                <el-form-item label="X光报告医生" prop="fzjc_xbxxp_Xgbgys">
                  <el-input v-model="form.fzjc_xbxxp_Xgbgys" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
                <el-form-item label="其他X光报告医生" prop="fzjc_xbxxp_qtxgbgys">
                  <el-input v-model="form.fzjc_xbxxp_qtxgbgys" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- B超 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> B超 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <div class="border_bottom">
                <el-form-item class="inb" label="状态" prop="fzjc_yxgybmky">
                  <el-radio-group v-model="form.fzjc_bc_zt">
                    <el-radio label="正常"></el-radio>
                    <el-radio label="异常"></el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item v-if="form.fzjc_bc_zt === '异常'" class="inb" label="" prop="fzjcBcZtyc" label-width="0">
                  <el-input v-model="form.fzjcBcZtyc" placeholder="请输入内容" size="small"
                    style="width: 455px">
                  </el-input>
                </el-form-item>
                </div>
                <div class="border_bottom">
                  <el-form-item label="检查部位" prop="fzjc_bc_jcbw">
                    <el-checkbox-group v-model="form.fzjc_bc_jcbw">
                      <el-checkbox label="胸部（肺、胸腔、纵隔）"></el-checkbox>
                      <el-checkbox label="腹部（肝、胆、胰、脾）"></el-checkbox>
                      <el-checkbox label="泌尿（双肾、输尿管、膀胱、前列腺）"></el-checkbox>
                      <el-checkbox label="妇科（含子宫、附件、膀胱及周围组织）"></el-checkbox>
                      <el-checkbox label="其他"></el-checkbox>
                    </el-checkbox-group>
                  </el-form-item>
                  <el-form-item v-if="form.fzjc_bc_jcbw.indexOf('其他') !== -1"
                    label="其他描述" prop="fzjc_bc_jcbw_qt">
                    <el-input v-model="form.fzjc_bc_jcbw_qt" placeholder="请输入内容" size="small"
                      style="width: 80%">
                    </el-input>
                  </el-form-item>
                </div>
                <el-form-item label="描述" prop="fzjc_bc_ms">
                  <el-input v-model="form.fzjc_bc_ms" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
                <el-form-item label="提示" prop="fzjc_bc_ts">
                  <el-input v-model="form.fzjc_bc_ts" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
                <el-form-item label="B超报告医生" prop="fzjc_bc_Bcbgys">
                  <el-input v-model="form.fzjc_bc_Bcbgys" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
                <el-form-item label="其他B超报告医生" prop="fzjc_bc_qtbcbgys">
                  <el-input v-model="form.fzjc_bc_qtbcbgys" placeholder="请输入内容" size="small"
                  style="width: 80%">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 宫颈涂片 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 宫颈涂片 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <div class="">
                  <el-form-item class="inb" label="状态" prop="fzjc_gjtp_zt">
                    <el-radio-group v-model="form.fzjc_gjtp_zt">
                      <el-radio label="正常"></el-radio>
                      <el-radio label="异常"></el-radio>
                    </el-radio-group>
                  </el-form-item>
                  <el-form-item v-if="form.fzjc_gjtp_zt === '异常'" class="inb" label="" prop="fzjc_gjtp_ztyc" label-width="0">
                    <el-input v-model="form.fzjc_gjtp_ztyc" placeholder="请输入内容" size="small"
                      style="width: 455px">
                    </el-input>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 白带常规 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 白带常规 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <el-form-item class="inb" label="清洁度" prop="fzjc_bdcg_qjd">
                  <el-input v-model="form.fzjc_bdcg_qjd" placeholder="请输入内容" size="small"
                    style="width: 200px">
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="滴虫" prop="fzjc_bdcg_dc">
                  <el-input v-model="form.fzjc_bdcg_dc" placeholder="请输入内容" size="small"
                    style="width: 200px">
                  </el-input>
                </el-form-item>
                <el-form-item class="inb" label="念球菌" prop="fzjc_bdcg_nqj">
                  <el-input v-model="form.fzjc_bdcg_nqj" placeholder="请输入内容" size="small"
                    style="width: 200px">
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- 肿瘤三项 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 肿瘤三项 </el-col>
          <el-col :span="21" class="border_left">
            <el-row class="" align="middle" type="flex">
              <el-col :span="0" class="bold flex_center">
              </el-col>
              <el-col :span="24" class="">
                <div class="border_bottom">
                  <el-form-item class="inb" label="甲胎蛋白" prop="fzjc_zlsx_jtdbzt">
                    <el-radio-group v-model="form.fzjc_zlsx_jtdbzt">
                      <el-radio label="阴性"></el-radio>
                      <el-radio label="阳性"></el-radio>
                    </el-radio-group>
                  </el-form-item>
                  <el-form-item v-if="form.fzjc_zlsx_jtdbzt === '阳性'" class="inb" label=""
                    prop="fzjc_zlsx_jtdbyxz" label-width="0">
                    <el-input v-model="form.fzjc_zlsx_jtdbyxz" placeholder="请输入内容" size="small"
                      style="width: 500px">
                    </el-input>
                  </el-form-item>
                </div>
                <div class="border_bottom">
                  <el-form-item class="inb" label="癌胚抗原" prop="fzjc_zlsx_apkyzt">
                    <el-radio-group v-model="form.fzjc_zlsx_apkyzt">
                      <el-radio label="阴性"></el-radio>
                      <el-radio label="阳性"></el-radio>
                    </el-radio-group>
                  </el-form-item>
                  <el-form-item v-if="form.fzjc_zlsx_apkyzt === '阳性'" class="inb" label=""
                  prop="fzjc_zlsx_apkyyxz" label-width="0">
                    <el-input v-model="form.fzjc_zlsx_apkyyxz" placeholder="请输入内容" size="small"
                      style="width: 500px">
                    </el-input>
                  </el-form-item>
                </div>
                <div class="">
                  <el-form-item class="inb" label="癌抗原50" prop="fzjc_zlsx_aky50zt">
                    <el-radio-group v-model="form.fzjc_zlsx_aky50zt">
                      <el-radio label="阴性"></el-radio>
                      <el-radio label="阳性"></el-radio>
                    </el-radio-group>
                  </el-form-item>
                  <el-form-item v-if="form.fzjc_zlsx_aky50zt === '阳性'" class="inb" label=""
                    prop="fzjc_zlsx_aky50yxz" label-width="0">
                    <el-input v-model="form.fzjc_zlsx_aky50yxz" placeholder="请输入内容" size="small"
                      style="width: 500px">
                    </el-input>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <!-- EB病毒抗体 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> EB病毒抗体 </el-col>
          <el-col :span="21" class="border_left">
              <el-form-item class="inb" label="状态" prop="fzjc_ebbdktzt">
                <el-radio-group v-model="form.fzjc_ebbdktzt">
                  <el-radio label="阴性"></el-radio>
                  <el-radio label="阳性"></el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item v-if="form.fzjc_ebbdktzt === '阳性'" class="inb" label="" prop="fzjc_gjtp_ztyc" label-width="0">
                <el-input v-model="form.fzjc_ebbdktyxz" placeholder="请输入内容" size="small"
                  style="width: 500px">
                </el-input>
              </el-form-item>
          </el-col>
        </el-row>
        <!-- EB病毒抗体 -->
        <el-row class="border_bottom" align="middle" type="flex">
          <el-col :span="2" class="bold flex_center"> 其他 </el-col>
          <el-col :span="21" class="border_left">
              <el-form-item class="inb" label="" prop="fzjc_qt" label-width="0">
                <el-input v-model="form.fzjc_qt" placeholder="请输入内容" size="small"
                  style="width: 500px">
                </el-input>
              </el-form-item>
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
        fzjc_xcg_xhdb: '', // 辅助检查-血常规-血红蛋白
        fzjc_xcg_bxb: '', // 辅助检查-血常规-白细胞
        fzjc_xcg_xxb: '', // 辅助检查-血常规-血小板
        fzjc_xcg_hxb: '', // 辅助检查-血常规-红细胞
        fzjc_xcg_zxlxbjdz: '', // 辅助检查-血常规-中性粒细胞绝对值
        fzjc_xcg_lbxbjdz: '', // 辅助检查-血常规-淋巴细胞绝对值
        fzjc_xcg_dhxbs: '', // 辅助检查-血常规-单核细胞数
        fzjc_xcg_ssxlxbs: '', // 辅助检查-血常规-嗜酸性粒细胞数
        fzjc_xcg_sjxlxbs: '', // 辅助检查-血常规-嗜碱性粒细胞数
        fzjc_xcg_qt: '', // 辅助检查-血常规-其他
        fzjc_ncg_ndb: '', // 辅助检查-尿常规-尿蛋白
        fzjc_ncg_nt: '', // 辅助检查-尿常规-尿糖
        fzjc_ncg_ntt: '', // 辅助检查-尿常规-尿酮体
        fzjc_ncg_nqx: '', // 辅助检查-尿常规-尿潜血
        fzjc_ncg_nbxb: '', // 辅助检查-尿常规-尿白细胞
        fzjc_ncg_ndhs: '', // 辅助检查-尿常规-尿胆红素
        fzjc_ncg_nyxsy: '', // 辅助检查-尿常规-尿亚硝酸盐
        fzjc_ncg_qt: '', // 辅助检查-尿常规-其他
        fzjc_kfxtmmoll: '', // 辅助检查-空腹血糖mmol/L
        fzjc_kfxtmgdl: '', // 辅助检查-空腹血糖mg/dL
        fzjc_chxt: '', // 辅助检查-餐后血糖
        fzjc_xdt_zt: '', // 辅助检查-心电图-状态
        fzjc_xdt_ycms: '', // 辅助检查-心电图-异常描述
        fzjc_xdt_xdtxl: '', // 辅助检查-心电图-心电图心律
        fzjc_xdt_xfl: '', // 辅助检查-心电图-心房率
        fzjc_xdt_bpmxsl: '', // 辅助检查-心电图-bpm心室率
        fzjc_xdt_prjq: '', // 辅助检查-心电图-PR间期
        fzjc_xdt_qrssx: '', // 辅助检查-心电图-QRS时限
        fzjc_xdt_qtjq: '', // 辅助检查-心电图-QT间期
        fzjc_xdt_ms: '', // 辅助检查-心电图-描述
        fzjc_xdt_ts: '', // 辅助检查-心电图-提示
        fzjc_xdt_xdtbgys: '', // 辅助检查-心电图-心电图报告医生
        fzjc_xdt_qtxdtbgys: '', // 辅助检查-心电图-其他心电图报告医生
        fzjc_nwlbdb: '', // 辅助检查-尿微量白蛋白
        fzjc_dbqx: '', // 辅助检查-大便潜血
        fzjc_thxhdb: '', // 辅助检查-糖化血红蛋白
        fzjc_yxgybmky: '', // 辅助检查-乙型肝炎表面抗原
        fzjc_ggn_xqgbzam: '', // 辅助检查-肝功能-血清谷丙转氨酶
        fzjc_ggn_xqgczam: '', // 辅助检查-肝功能-血清谷草转氨酶
        fzjc_ggn_bdb: '', // 辅助检查-肝功能-白蛋白
        fzjc_ggn_zdhs: '', // 辅助检查-肝功能-总胆红素
        fzjc_ggn_jhdhs: '', // 辅助检查-肝功能-结合胆红素
        fzjc_gxckt: '', // 肝吸虫抗体
        fzjc_gxcktdl: '', // 肝吸虫抗体-定量
        fzjc_gyxjxlsm: '', // 骨源性碱性磷酸酶(IU/L)
        fzjc_sgn_xqjg: '', // 辅助检查-肾功能-血清肌酐
        fzjc_sgn_ns: '', // 辅助检查-肾功能-尿酸
        fzjc_sgn_xns: '', // 辅助检查-肾功能-血尿素
        fzjc_sgn_xjnd: '', // 辅助检查-肾功能-血钾浓度
        fzjc_sgn_xnnd: '', // 辅助检查-肾功能-血钠浓度
        fzjc_xz_zdgc: '', // 辅助检查-血脂-总胆固醇
        fzjc_xz_gysz: '', // 辅助检查-血脂-甘油三酯
        fzjc_xz_xqdmdzdbdgc: '', // 辅助检查-血脂-血清低密度脂蛋白胆固醇
        fzjc_xz_xqgmdzdbdgc: '', // 辅助检查-血脂-血清高密度脂蛋白胆固醇
        fzjc_xbxxp_zt: '', // 辅助检查-胸部X线片-状态
        fzjc_xbxxp_ztyc: '', // 辅助检查-胸部X线片-状态异常
        fzjc_xbxxp_jcqkms: '', // 辅助检查-胸部X线片-检查情况描述
        fzjc_xbxxp_zdyj: '', // 辅助检查-胸部X线片-诊断意见
        fzjc_xbxxp_Xgbgys: '', // 辅助检查-胸部X线片-X光报告医生
        fzjc_xbxxp_qtxgbgys: '', // 辅助检查-胸部X线片-其他X光报告医生
        fzjc_bc_zt: '', // 辅助检查-B超-状态
        fzjcBcZtyc: '', // 辅助检查-B超-状态异常
        fzjc_bc_jcbw: [], // 辅助检查-B超-检查部位
        fzjc_bc_jcbw_qt: '', // 辅助检查-B超-检查部位-其他
        fzjc_bc_ms: '', // 辅助检查-B超-描述
        fzjc_bc_ts: '', // 辅助检查-B超-提示
        fzjc_bc_Bcbgys: '', // 辅助检查-B超-B超报告医生
        fzjc_bc_qtbcbgys: '', // 辅助检查-B超-其他B超报告医生
        fzjc_gjtp_zt: '', // 辅助检查-宫颈涂片-状态
        fzjc_gjtp_ztyc: '', // 辅助检查-宫颈涂片-状态异常
        fzjc_bdcg_qjd: '', // 辅助检查-白带常规-清洁度
        fzjc_bdcg_dc: '', // 辅助检查-白带常规-滴虫
        fzjc_bdcg_nqj: '', // 辅助检查-白带常规-念球菌
        fzjc_zlsx_jtdbzt: '', // 辅助检查-肿瘤三项-甲胎蛋白状态
        fzjc_zlsx_jtdbyxz: '', // 辅助检查-肿瘤三项-甲胎蛋白阳性值
        fzjc_zlsx_apkyzt: '', // 辅助检查-肿瘤三项-癌胚抗原状态
        fzjc_zlsx_apkyyxz: '', // 辅助检查-肿瘤三项-癌胚抗原阳性值
        fzjc_zlsx_aky50zt: '', // 辅助检查-肿瘤三项-癌抗原50状态
        fzjc_zlsx_aky50yxz: '', // 辅助检查-肿瘤三项-癌抗原50阳性值
        fzjc_ebbdktzt: '', // 辅助检查-EB病毒抗体状态
        fzjc_ebbdktyxz: '', // 辅助检查-EB病毒抗体阳性值
        fzjc_qt: '', // 辅助检查-其他
      },
    };
  },
  computed: {},
  watch: {},
  mounted() {

  },
  methods: {},
};
</script>

<style lang="scss">
</style>
