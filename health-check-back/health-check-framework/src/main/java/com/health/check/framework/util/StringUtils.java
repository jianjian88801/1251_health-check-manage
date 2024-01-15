package com.health.check.framework.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类（基于Apache Commons StringUtils扩展）
 *
 * @author xiao.xl 2022/3/9 15:36
 */
public abstract class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 字符串转换为字节数组（utf-8编码）
     *
     * @param str 字符串值
     * @return 字节数组
     * @modify xiao.xl 2021/10/11 18:41
     */
    public static byte[] getBytes(String str) {
        if (str == null) { return null; }
        return str.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 字符串转驼峰命名（首字母小写）
     *
     * @param s 待转换字符串
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * @modify xiao.xl 2021/10/11 18:42
     */
    public static String toCamelCase(String s) {
        if (s == null) { return null; }
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == StringPools.UNDER_LINE) { upperCase = true; }
            else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 字符串转驼峰命名（首字母大写）
     *
     * @return toCapitalizeCamelCase(" hello_world ") == "HelloWorld"
     * @modify xiao.xl 2021/10/11 18:43
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) { return null; }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 驼峰命名转字符串
     *
     * @return toUnderScoreCase(" helloWorld ") = "hello_world"
     * @modify xiao.xl 2021/10/11 18:45
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) { return null; }
        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean nextUpperCase = true;
            if (i < (s.length() - 1)) { nextUpperCase = Character.isUpperCase(s.charAt(i + 1)); }
            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) { sb.append(StringPools.UNDER_LINE); }
                upperCase = true;
            }
            else { upperCase = false; }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    /**
     * 字符串首字母小写转换方法
     *
     * @param str 待转换字符串
     * @return 转换后字符串
     * @author Jason 2019-08-29 18:30
     * @modify xiao.xl 2021/10/11 18:46
     */
    public static String toLowerCaseFirstOne(String str) {
        return Character.isLowerCase(str.charAt(0))
                ? str : Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 判断字符串是否全为中文
     *
     * @param str 待判断字符串值
     * @return true：全为中文
     * @author yuanhang 2019/3/13 15:51
     * @modify xiao.xl 2021/10/11 18:47
     */
    public static boolean isChinese(String str) {
        if (isBlank(str)) { return false; }
        return ValidateUtils.isAllChinese(str);
    }

    /**
     * 判断字符串是否包含中文
     *
     * @param str 待判断字符串值
     * @return true：包含中文
     * @author yuanhang 2019-09-12 11:06
     */
    public static boolean isContainChinese(String str) {
        if (isBlank(str)) { return false; }
        return ValidateUtils.isContainChinese(str);
    }

    /**
     * 判断是否包含特殊字符
     *
     * @param str 待判断字符串值
     * @return true：包含特殊字符
     * @author yuanhang 2019/3/13 15:52
     * @modify xiao.xl 2021/10/11 19:04
     */
    public static boolean isContainSpecialChar(String str) {
        if (isBlank(str)) { return false; }
        return ValidateUtils.getContainSpecialCharPattern().matcher(str).find();
    }

    /**
     * 移除字符串中特殊字符
     *
     * @param str 待移除特殊字符字符串值
     * @return 已移除特殊字符字符串
     * @author yuanhang 2020/3/5 20:20
     * @modify xiao.xl 2021/10/11 19:08
     */
    public static String removeSpecialChar(String str) {
        if (isBlank(str)) { return str; }
        return str.replaceAll(ValidateUtils.CONTAIN_SPECIAL_CHAR_PATTERN, StringPools.EMPTY);
    }

    /**
     * 获取jdbc like类型的字符串
     *
     * @param str 待处理字符串值
     * @return jdbc like类型字符串
     * @author yuanhang 2019/5/6 18:11
     * @modify xiao.xl 2021/10/11 19:10
     */
    public static String getLikeStr(String str) {
        // 处理模糊匹配中存在通配符的情况，如 _50%
        if (isNotBlank(str)) {
            str = str.replace(StringPools.PERCENT, StringPools.BACK_SLASH_PERCENT)
                    .replace(StringPools.UNDERSCORE, StringPools.BACK_SLASH_UNDERSCORE);
        }
        return StringPools.PERCENT + str + StringPools.PERCENT;
    }

    /**
     * 获取左边jdbc like类型字符串
     *
     * @param str 待处理字符串值
     * @return 左边jdbc like类型字符串
     * @modify xiao.xl 2021/10/11 19:14
     */
    public static String getLikeLeftStr(String str) {
        return StringPools.PERCENT + str;
    }

    /**
     * 获取右边jdbc like类型字符串
     *
     * @param str 待处理字符串值
     * @return 左边jdbc like类型字符串
     * @modify xiao.xl 2021/10/11 19:14
     */
    public static String getLikeRightStr(String str) {
        return str + StringPools.PERCENT;
    }

    /**
     * 集合字符串拼接
     *
     * @param list      集合值
     * @param separator 分隔符
     * @return 拼接字符串
     * @author xiao.xl 2019/6/28 17:01
     * @modify xiao.xl 2021/10/11 19:18
     */
    @SuppressWarnings("rawtypes")
    public static String listToString(List list, char separator) {
        return join(list, separator);
    }

    /**
     * 校验字符串是否为json串
     *
     * @param jsonStr 待校验字符串
     * @return true：是json字符串
     * @author yuanhang 2019/7/3 10:36
     * @modify xiao.xl 2021/10/11 19:20
     */
    public static boolean isJsonStr(String jsonStr) {
        try {
            JSONObject.parseObject(jsonStr);
        }
        catch (JSONException ex) {
            try {
                JSONObject.parseArray(jsonStr);
            }
            catch (JSONException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取整数或小数值
     *
     * @param str 待处理字符串值
     * @return 获取的值
     * @author yuanhang 2019-09-12 10:50
     */
    public static String getIntegerAndDecimal(String str) {
        if (StringUtils.isBlank(str)) { return null; }
        // 控制正则表达式的匹配行为的参数(小数)
        Pattern p = Pattern.compile("(\\d+\\.\\d+)");
        Matcher m = p.matcher(str);
        //m.find用来判断该字符串中是否含有与"(\\d+\\.\\d+)"相匹配的子串
        if (m.find()) {
            //如果有相匹配的,则判断是否为null操作
            //group()中的参数：0表示匹配整个正则，1表示匹配第一个括号的正则,2表示匹配第二个正则,在这只有一个括号,即1和0是一样的
            str = m.group(1) == null ? StringPools.EMPTY : m.group(1);
        }
        else {
            //如果匹配不到小数，就进行整数匹配
            p = Pattern.compile("(\\d+)");
            m = p.matcher(str);
            //如果有整数相匹配
            if (m.find()) { str = m.group(1) == null ? StringPools.EMPTY : m.group(1); }
            // 如果没有小数和整数相匹配,即字符串中没有整数和小数，就设为空
            else { str = StringPools.EMPTY; }
        }
        return str;
    }

    /**
     * 获取汉字或者英文
     *
     * @param str 待处理字符串值
     * @return 获取值
     * @author yuanhang 2019-09-12 10:56
     * @modify xiao.xl 2021/10/11 19:22
     */
    public static String getChineseOrEnglish(String str) {
        if (StringUtils.isBlank(str)) { return null; }
        boolean containChinese = isContainChinese(str);
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (containChinese) {
                // 获得中文
                // Java判断一个字符串是否有中文是利用Unicode编码来判断，因为中文的编码区间为：0x4e00--0x9fbb
                if ((c >= 0x4e00) && (c <= 0x9fbb)) { sb.append(c); }
            }
            else {
                // 获取英文
                // Java判断一个字符串是否有英文是利用Unicode编码来判断，因为英文的编码区间为：65--122
                if ((c >= 65) && (c <= 122)) { sb.append(c); }
                //μ
                if (c == 956) { sb.append(c); }
            }
        }
        return sb.toString();
    }

    /**
     * 将集数据装成字符串，并用"|"对数据进程拼接。数据库查询时可以使用 like %|String|% 匹配到数据
     * 例：["1","2","3"]
     * 转换后：|1|2|3|
     *
     * @param list 待转换值
     * @return 转换结果
     * @author liu.zr 2019/11/28 18:18
     * @modify xiao.xl 2021/10/11 19:25
     */
    public static String toStringJoinBySingleBar(List<String> list) {
        if (list == null || list.size() == 0) { return null; }
        String value = StringUtils.join(list, StringPools.PIPE);
        if (StringUtils.isNotBlank(value)) { value = StringPools.PIPE + value + StringPools.PIPE; }
        return value;
    }

    /**
     * 以"|"分割字符串转成list
     *
     * @param s 待分割字符串
     * @return 分割结果集
     * @author liu.zr 2019/11/28 18:39
     * @modify xiao.xl 2021/10/11 19:27
     */
    public static List<String> toArraySpiltBySingleBar(String s) {
        List<String> list = new ArrayList<>();
        if (StringUtils.isBlank(s)) { return list; }
        String[] value = s.split(StringPools.BACK_SLASH_PIPE);
        for (String v : value) {
            if (StringUtils.isNotBlank(v)) { list.add(v); }
        }
        return list;
    }

    /**
     * 1.可以是中文英文混合
     * 2.可以是英文，允许输入点（英文名字中的那种点），允许输入空格
     * 3.长度在20个字符以内
     *
     * @param name 真实姓名
     * @return true：符合真实姓名命名
     * @author xiao.xl 2021/10/11 19:31
     */
    public static boolean validateName(String name) {
        if (isBlank(name)) { return false; }
        return ValidateUtils.isMatchRealName(name);
    }

    /**
     * 手机号脱敏
     *
     * @param telPhone 手机号字符串值
     * @return 脱敏后字符串值
     * @author xiao.xl 2020/11/16 9:34
     */
    public static String mobileEncrypt(String telPhone) {
        if (isBlank(telPhone) || telPhone.length() != 11) { return telPhone; }
        return telPhone.replaceAll(ValidateUtils.TEL_PHONE_PATTERN, ValidateUtils.TEL_PHONE_REPLACE);
    }

    /**
     * 身份证脱敏处理
     *
     * @param idCard 身份证号码
     * @return 脱敏身份证号码值
     * @author xiao.xl 2020/11/16 9:37
     * @modify xiao.xl 2021/10/11 19:37
     */
    public static String idCardEncrypt(String idCard) {
        if (isBlank(idCard) || (idCard.length() != 18 && idCard.length() != 15)) { return idCard; }
        return idCard.replaceAll(ValidateUtils.IDCARD_PHONE_PATTERN, StringPools.ASTERISK);
    }


    /**
     * 转换为url参数值
     *
     * @param objectMap map对象
     * @return url参数值
     * @author xiao.xl 2021/11/5 10:33
     */
    public static String toUrlParameter(Map<String, Object> objectMap) {
        if (CollectionUtil.isEmpty(objectMap)) { return StringPools.EMPTY; }
        StringBuilder sb = new StringBuilder(StringPools.QUESTION_MARK);
        Set<String> keys = objectMap.keySet();
        for (String key : keys) {
            Object value = objectMap.get(key);
            if (value != null && StringUtils.isNotBlank(value.toString())) {
                sb.append(key).append(StringPools.EQUALS).append(urlEncode(value.toString())).append(StringPools.AMPERSAND);
            }
        }
        String result = sb.toString();
        return result.endsWith(StringPools.AMPERSAND) ? result.substring(0, result.length() - 1) : result;
    }

    /**
     * url encode
     *
     * @param text 待编码文本值
     * @return 编码后文本值
     * @author xiao.xl 2021/11/5 10:39
     */
    public static String urlEncode(String text) {
        return urlEncode(text, StringPools.UTF_8);
    }

    /**
     * url encode
     *
     * @param text 待编码文本值
     * @param enc  编码
     * @return 编码后文本值
     * @author xiao.xl 2021/11/5 10:39
     */
    public static String urlEncode(String text, String enc) {
        try {
            return URLEncoder.encode(text, enc);
        }
        catch (Exception e) {
            // quiet process
        }
        return text;
    }

    /**
     * 是否手机号校验
     *
     * @param phone 待校验字符串
     * @return true：是手机号
     * @author xiao.xl 2021/11/8 13:12
     */
    public static boolean isPhoneNumber(String phone) {
        return ValidateUtils.TEL_PHONE.matcher(phone).find();
    }

    /**
     * 将整数转换为指定长度字符串，不足位数左补零，超过位数直接返回
     *
     * @param value 整数值
     * @param size  the size to pad to
     * @return 转换后字符串值
     * @author xiao.xl 2021/12/14 13:54
     */
    public static String leftPadZero(int value, int size) {
        String result = String.valueOf(value);
        if (result.length() >= size) { return result; }
        return leftPad(result, size, StringPools.ZERO);
    }

}
