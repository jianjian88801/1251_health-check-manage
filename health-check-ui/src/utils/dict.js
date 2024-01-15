//体检类型
export const tjlx = {
  mftj: "免费体检",
  jktj: "健康体检",
  jknj: "健康年检",
  cjdwtj: "参加单位体检",
  dxtj: "单项体检",
  bftj: "部分体检",
  jjtj: "拒绝体检",
};

export const jctj = {
  jkda: "健康档案",
  lnr: "老年人",
  gxy: "高血压",
  jsb: "精神病",
  chfs: "产后访视",
  tytj: "托幼体检",
  xxtj: "学校体检",
  gctj: "工厂体检",
  qttsrqsmsf: "其他特殊人群上门随访",
  mz: "门诊",
  jkctj: "健康村体检",
};

export const zhengzhuang = {
  wzz: "无症状",
  tt: "头痛",
  ty: "头晕",
  xj: "心悸",
  xm: "胸闷",
  xt: "胸痛",
  mxks: "慢性咳嗽",
  kt: "咳痰",
  hxkn: "呼吸困难",
  dy: "多饮",
  dn: "多尿",
  tzxj: "体重下降",
  fl: "乏力",
  gjzt: "关节肿痛",
  slmh: "视力模糊",
  sjmm: "手脚麻木",
  nj: "尿急",
  nt: "尿痛",
  bm: "便秘",
  fx: "腹泻",
  exot: "恶心呕吐",
  yh: "眼花",
  rm: "耳鸣",
  rfzt: "乳房胀痛",
  frdh: "发热盗汗",
  kxxt: "咳血、血痰",
  qt: "其他",
};

// 一般状态
export const yibanzhuangkuang = {
  jkzt: { // 健康状态
    mz: '满意',
    jbmy: '基本满意',
    sbqc: '说不清楚',
    btmy: '不太满意',
    bmy: '不满意',
  },
  shzlnl: { // 生活自理能力
    mz: '可自理',
    qdyl: '轻度依赖',
    zdyl: '中度依赖',
    bnzl: '不能自理',
  },
  rzgn: { // 老年人认知功能
    csyinx: '初筛阴性',
    csyangx: '初筛阳性',
  },
  qgzt: { // 老年人情感状态
    csyinx: '初筛阴性',
    csyangx: '初筛阳性',
  },
};

export const ShengHuoFangShi = {
  dlpl: { // 锻练频率
    mt: '每天',
    mzycys: '每周一次以上',
    oe: '偶尔',
    bdl: '不锻炼',
  },
  dlfs: { // 锻炼方式
    sb: '散步',
    zchqg: '做操或气功',
    tjq: '太极拳',
    pb: '跑步',
    tw: '跳舞',
    ql: '球类',
    qt: '其他',
  },
  ysxg: { // 饮食习惯
    hsjh: '荤素均衡',
    hswz: '荤食为主',
    sswz: '素食为主',
    sy: '嗜盐',
    syou: '嗜油',
    st: '嗜糖',
  },
  xyqk: { // 吸烟状况
    cbxy: '从不吸烟',
    yjy: '已戒烟',
    xy: '吸烟',
    bdxy: '被动吸烟',
  },
  yjpl: { // 饮酒频率
    cb: '从不',
    oe: '偶尔',
    jc: '经常',
    mt: '每天',
  },
  sfjj: { // 饮酒频率
    wjj: '未戒酒',
    yjj: '已戒酒',
  },
  yjzl: { // 饮酒频率
    bj: '白酒',
    pj: '啤酒',
    hongj: '红酒',
    huangj: '黄酒',
    qt: '其他',
  },
};

export const zangqigongneng = {
  kouchun: { // 口唇
    hr: '红润',
    cb: '苍白',
    fg: '发绀',
    jl: '皲裂',
    pz: '疱疹',
  },
  chilie: { // 齿列
    mt: '正常',
    cb: '缺齿',
    fg: '龋齿',
    jl: '义齿(假牙)',
  },
  yanbu: { // 咽部
    wcx: '无充血',
    cx: '充血',
    lblbzs: '淋巴滤胞增生',
  },
  tingli: { // 
    tj: '听见',
    tbq: '听不清',
    wftj: '无法听见',
  },
  yundonggongneng: { // 
    slwc: '可顺利完成',
    wfwc: '无法独立完成任何一个动作',
  }
};

export const xuanti = {
  yandi: {
    zhengcheng: '正常',
    yichang: '异常'
  },
  pifu: {
    zc: '正常',
    ch: '潮红',
    cb: '苍白',
    fg: '发绀',
    hr: '黄染',
    sscz: '色素沉着',
    qt: '其他',
  },
  gongmo: {
    zc: '正常',
    hr: '黄染',
    ch: '充血',
    qt: '其他',
  },
  linbajie: {
    wxj: '未触及',
    sgs: '锁骨上',
    qt: '其他',
  },
}

export const boolean = {
  true: '是',
  false: '否',
}