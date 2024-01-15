package com.health.check.framework.util;

/**
 * Copy to jodd.util
 * <p>
 * Pool of <code>String</code> constants to prevent repeating of
 * hard-coded <code>String</code> literals in the code.
 * Due to fact that these are <code>public static final</code>
 * they will be inlined by java compiler and
 * reference to this class will be dropped.
 * There is <b>no</b> performance gain of using this pool.
 * Read: https://java.sun.com/docs/books/jls/third_edition/html/lexical.html#3.10.5
 * <ul>
 * <li>Literal strings within the same class in the same package represent references to the same <code>String</code> object.</li>
 * <li>Literal strings within different classes in the same package represent references to the same <code>String</code> object.</li>
 * <li>Literal strings within different classes in different packages likewise represent references to the same <code>String</code> object.</li>
 * <li>Strings computed by constant expressions are computed at compile time and then treated as if they were literals.</li>
 * <li>Strings computed by concatenation at run time are newly created and therefore distinct.</li>
 * </ul>
 *
 * @author xiao 2021/10/11 12:41
 */
public interface StringPools {
    /**
     * &
     */
    String AMPERSAND = "&";
    /**
     * and
     */
    String AND = "and";
    /**
     * @
     */
    String AT = "@";
    /**
     * *
     */
    String ASTERISK = "*";
    /**
     * *
     */
    String STAR = ASTERISK;
    /**
     * \
     */
    String BACK_SLASH = "\\";
    /**
     * :
     */
    String COLON = ":";
    /**
     * ,
     */
    String COMMA = ",";
    /**
     * 中文逗号
     */
    String CHINESE_COMMA = "，";
    /**
     * -（中划线）
     */
    String DASH = "-";
    /**
     * $
     */
    String DOLLAR = "$";
    /**
     * $$
     */
    String CGLIB_CLASS_SEPARATOR = "$$";
    /**
     * .
     */
    String DOT = ".";
    /**
     * ..
     */
    String DOT_DOT = "..";
    /**
     * .class
     */
    String DOT_CLASS = ".class";
    /**
     * .java
     */
    String DOT_JAVA = ".java";
    /**
     * .xml
     */
    String DOT_XML = ".xml";
    /**
     * 空串
     */
    String EMPTY = "";
    /**
     * =
     */
    String EQUALS = "=";
    /**
     * false
     */
    String FALSE = "false";
    /**
     * true
     */
    String TRUE = "true";
    /**
     * NaN
     */
    String NAN = "NaN";
    /**
     * /
     */
    String SLASH = "/";
    /**
     * #
     */
    String HASH = "#";
    /**
     * ^
     */
    String HAT = "^";
    /**
     * {
     */
    String LEFT_BRACE = "{";
    /**
     * }
     */
    String RIGHT_BRACE = "}";
    /**
     * (
     */
    String LEFT_BRACKET = "(";
    /**
     * )
     */
    String RIGHT_BRACKET = ")";
    /**
     * <
     */
    String LEFT_CHEV = "<";
    /**
     * >
     */
    String RIGHT_CHEV = ">";
    /**
     * \n 换行
     */
    String NEWLINE = "\n";
    /**
     * \r
     */
    String RETURN = "\r";
    /**
     * \t
     */
    String TAB = "\t";
    /**
     * n
     */
    String N = "n";
    /**
     * no
     */
    String NO = "no";
    /**
     * null
     */
    String NULL = "null";
    /**
     * off
     */
    String OFF = "off";
    /**
     * on
     */
    String ON = "on";
    /**
     * %
     */
    String PERCENT = "%";
    /**
     * \\%
     */
    String BACK_SLASH_PERCENT = "\\%";
    /**
     * |
     */
    String PIPE = "|";
    /**
     * \\|
     */
    String BACK_SLASH_PIPE = "\\|";
    /**
     * +
     */
    String PLUS = "+";
    /**
     * ?
     */
    String QUESTION_MARK = "?";
    /**
     * !
     */
    String EXCLAMATION_MARK = "!";
    /**
     * "
     */
    String QUOTE = "\"";
    /**
     * '
     */
    String SINGLE_QUOTE = "'";
    /**
     * ;
     */
    String SEMICOLON = ";";
    /**
     * `
     */
    String BACKTICK = "`";
    /**
     * 空格
     */
    String SPACE = " ";
    /**
     * ~
     */
    String TILDA = "~";
    /**
     * [
     */
    String LEFT_SQ_BRACKET = "[";
    /**
     * ]
     */
    String RIGHT_SQ_BRACKET = "]";
    /**
     * _
     */
    String UNDERSCORE = "_";
    /**
     * \\_
     */
    String BACK_SLASH_UNDERSCORE = "\\_";
    /**
     * UTF-8
     */
    String UTF_8 = "UTF-8";
    /**
     * US-ASCII
     */
    String US_ASCII = "US-ASCII";
    /**
     * ISO-8859-1
     */
    String ISO_8859_1 = "ISO-8859-1";
    /**
     * y
     */
    String Y = "y";
    /**
     * yes
     */
    String YES = "yes";
    /**
     * 1
     */
    String ONE = "1";
    /**
     * 0
     */
    String ZERO = "0";
    /**
     * ${
     */
    String DOLLAR_LEFT_BRACE = "${";
    /**
     * #{
     */
    String HASH_LEFT_BRACE = "#{";
    /**
     * \r\n
     */
    String CRLF = "\r\n";
    /**
     * &nbsp;
     */
    String HTML_NBSP = "&nbsp;";
    /**
     * &amp
     */
    String HTML_AMP = "&amp";
    /**
     * &quot;
     */
    String HTML_QUOTE = "&quot;";
    /**
     * &lt;
     */
    String HTML_LT = "&lt;";
    /**
     * &gt;
     */
    String HTML_GT = "&gt;";
    /**
     * http
     */
    String HTTP = "http";
    /**
     * https
     */
    String HTTPS = "https";
    /**
     * 人民币
     */
    String CNY = "CNY";
    /**
     * unknown
     */
    String UNKNOWN = "unknown";

    /**
     * 日期格式 yyyy-MM-dd
     */
    String YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * 日期格式 yyyyMM
     */
    String YYYYMM = "yyyyMM";
    /**
     * 日期格式 yyyyMMdd
     */
    String YYYYMMDD = "yyyyMMdd";
    /**
     * 日期格式 yyyy-MM-dd HH:mm:ss
     */
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式 yyyyMMddHHmmssSSS
     */
    String YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMddHHmmssSSS";
    /**
     * 时分格式 HH:mm
     */
    String HH_MM = "HH:mm";
    /**
     * 0点
     */
    String HOUR_00_00_00 = "00:00:00";
    /**
     * 0点
     */
    String HOUR_00_00 = "00:00";
    /**
     * 24点
     */
    String HOUR_24_00_00 = "24:00:00";
    /**
     * 24点
     */
    String HOUR_24_00 = "24:00";
    /**
     * 0秒
     */
    String SECOND_00 = ":00";

    /**
     * open
     */
    String OPEN = "open";

    /**
     * closed
     */
    String CLOSED = "closed";

    /**
     * api
     */
    String API = "api";

    /**
     * insert
     */
    String INSERT = "insert";

    /**
     * update
     */
    String UPDATE = "update";

    /**
     * select
     */
    String SELECT = "select";

    /**
     * lb scheme
     */
    String LB_SCHEME = "lb";

    /**
     * 中文：年
     */
    String CHINESE_YEAR = "年";

    /**
     * 中文：岁
     */
    String CHINESE_AGE = "岁";

    /**
     * 中文：月
     */
    String CHINESE_MONTH = "月";

    /**
     * 中文：个月
     */
    String CHINESE_NUM_MONTH = "个月";

    /**
     * 中文：天
     */
    String CHINESE_DAY = "天";

    /**
     * a（小写）
     */
    char A = 'a';
    /**
     * A（大写）
     */
    char A_UPPER = 'A';
    /**
     * z（小写）
     */
    char Z = 'z';
    /**
     * Z（大写）
     */
    char Z_UPPER = 'Z';
    /**
     * _（下划线）
     */
    char UNDER_LINE = '_';
    /**
     * 0
     */
    char CHAR_ZERO = '0';

    /**
     * 空字符串数组
     */
    String[] EMPTY_ARRAY = new String[0];
    /**
     * 新行字节数组
     */
    byte[] BYTES_NEW_LINE = StringPools.NEWLINE.getBytes();
    /**
     * 26个小写字母字符串数组
     */
    String[] CHARACTERS = new String[]{"a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z"};
    /**
     * 26个小写字母+0~9数字字符串数组
     */
    String[] CHARACTER_NUMBERS = new String[]{"a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
            "9"};
    /**
     * 日期转换格式
     */
    String[] DATE_PATTERNS = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
            "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy.MM.dd HH:mm", "yyyy.MM"};
}
