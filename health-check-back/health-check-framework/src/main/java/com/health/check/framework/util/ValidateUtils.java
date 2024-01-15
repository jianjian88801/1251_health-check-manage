package com.health.check.framework.util;

import java.util.regex.Pattern;

/**
 * 校验器工具类
 * 1、正则校验
 *
 * @author xiao.xl 2022/3/9 15:35
 */
public abstract class ValidateUtils {

    /**
     * 是否包含特殊字符正则表达式
     */
    public static final String CONTAIN_SPECIAL_CHAR_PATTERN = "[_`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

    /**
     * 换行正则表达式
     */
    public static final String NEW_LINE_PATTERN = "\\r\\n";

    /**
     * 空格正则表达式
     */
    public static final String SPACE_PATTERN = "\\s*";

    /**
     * 手机号码匹配正则表达式
     */
    public static final String TEL_PHONE_PATTERN = "(\\d{3})\\d{4}(\\d{4})";

    /**
     * 手机号码匹配正则表达式预编译
     */
    public static final Pattern TEL_PHONE = Pattern.compile(TEL_PHONE_PATTERN);

    /**
     * 身份证号码脱敏处理正则表达式
     */
    public static final String IDCARD_PHONE_PATTERN = "(?<=\\w{4})\\w(?=\\w{3})";

    /**
     * 手机号脱敏替换值
     */
    public static final String TEL_PHONE_REPLACE = "$1****$2";

    /**
     * 是否包含特殊字符正则表达式预编译
     */
    private static final Pattern CONTAIN_SPECIAL_CHAR = Pattern.compile(CONTAIN_SPECIAL_CHAR_PATTERN);

    /**
     * 都是正文判断正则表达式
     */
    private static final String ALL_CHINESE_PATTERN = "[\\u4e00-\\u9fa5]+";

    /**
     * 是否包含中文判断正则表达式
     */
    private static final String CONTAIN_CHINESE_PATTERN = "[\u4e00-\u9fa5]";

    /**
     * 是否包含中文正则表达式预编译
     */
    private static final Pattern CONTAIN_CHINESE = Pattern.compile(CONTAIN_CHINESE_PATTERN);

    /**
     * 真实姓名是否正确正则表达式
     */
    public static final String REAL_NAME_PATTERN = "^([\\u4e00-\\u9fa5a-zA-Z]{1,20}|[a-zA-Z\\.\\s]{1,20})$";

    /**
     * 最新手机号段
     * 移动号：134/135/136/137,138,139；147/148(物联卡号)；150/151/152/157/158/159；165（虚拟运营商）；1703/1705/1706（虚拟运营商）、178；182/183/184/187/188；198
     * 联通号：130/131；145；155/156；166/167(虚拟运营商)；1704/1707/1708/1709、171；186/186；
     * 电信号： 133；153；162(虚拟运营商)；1700/1701/1702(虚拟运营商)；180/181/189；191/199
     */
    public static final String PHONE_PATTERN = "^((13[0-9])|(14[5,7])|(15[^4,\\D])|(16[2,5,6,7])|(17[0,1,3,6-8])|(18[0-9])|(19[1,8,9]))[0-9]{8}$";

    /**
     * 手机号正则表达式预编译
     */
    private static final Pattern PHONE = Pattern.compile(PHONE_PATTERN);

    /**
     * 身份证校验正则表达式
     * 支持18/15位身份证校验
     */
    public static final String IDCARD_PATTERN = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

    /**
     * 身份证正则表达式预编译
     */
    private static final Pattern IDCARD = Pattern.compile(IDCARD_PATTERN);

    /**
     * 是否URL
     */
    public static final String URL_PATTERN = "([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://|[wW]{3}.|[wW][aA][pP].|[fF][tT][pP].|[fF][iI][lL][eE].)[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";

    /**
     * 是否变量，取值方式为：${value}
     */
    public static final String VARIABLE_PATTERN = "\\$\\{(.*?)\\}";

    /**
     * 变量正则表达式预编译
     */
    public static final Pattern VARIABLE = Pattern.compile(VARIABLE_PATTERN);

    /**
     * 获取是否包含特殊字符正则表达式预编译对象
     *
     * @return 是否包含特殊字符正则表达式预编译对象
     * @author xiao.xl 2021/10/11 19:03
     */
    public static Pattern getContainSpecialCharPattern() {
        return CONTAIN_SPECIAL_CHAR;
    }

    /**
     * 是否全部为中文字符
     *
     * @param chineseStr 待判断字符串值
     * @return true：全部为中文字符
     * @author xiao.xl 2021/10/11 18:59
     */
    public static boolean isAllChinese(String chineseStr) {
        return chineseStr.matches(ALL_CHINESE_PATTERN);
    }

    /**
     * 是否包含中文字符串
     *
     * @param chineseStr 字符串值
     * @return true：包含中文
     * @author xiao.xl 2021/10/11 18:55
     */
    public static boolean isContainChinese(String chineseStr) {
        return CONTAIN_CHINESE.matcher(chineseStr).find();
    }

    /**
     * 值正则校验
     *
     * @param object  待校验值
     * @param pattern 正则表达式
     * @return 校验是否通过
     * @author xiao.xl 2021/10/11 11:00
     */
    public static boolean validate(Object object, String pattern) {
        if (null == object) { return false; }
        if (StringUtils.isBlank(pattern)) { return true; }
        return matchPattern(pattern).matcher(String.valueOf(object)).matches();
    }

    /**
     * 匹配正则表达式预编译
     *
     * @param pattern 正则表达式
     * @author xiao.xl 2021/10/11 11:07
     */
    private static Pattern matchPattern(String pattern) {
        if (IDCARD_PATTERN.equals(pattern)) { return IDCARD; }
        if (PHONE_PATTERN.equals(pattern)) { return PHONE; }
        return Pattern.compile(pattern);
    }

    /**
     * 判断字符串是否符合真实姓名命名规则
     *
     * @param name 真实姓名
     * @return true：匹配
     * @author xiao.xl 2021/10/11 19:32
     */
    public static boolean isMatchRealName(String name) {
        return name.matches(ValidateUtils.REAL_NAME_PATTERN);
    }
}
