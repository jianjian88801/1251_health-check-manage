package com.health.check.framework.serializer.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.*;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.check.framework.serializer.fastjson.filter.FastJsonValueFilter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * JSON构造工具
 *
 * @author xiao.xl 2021/10/15 14:23
 */
@SuppressWarnings("ALL")
public class JSONBuilder {
	
	/**
	 * 对象转JSON字符串
	 *
	 * @param source 源对象
	 * @return json字符串
	 * @author xiao.xl 2021/10/15 14:26
	 */
	public static <T> String toJSONString(T source) {
		return JSON.toJSONString(source, new FastJsonValueFilter(), SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
	}
	
	/**
	 * json转JSONObject对象
	 *
	 * @param source json字符串值
	 * @return JSONObject对象
	 * @author xiao.xl 2021/10/15 14:27
	 */
	public static JSONObject parseObject(String source) {
		return JSON.parseObject(source, Feature.DisableCircularReferenceDetect, Feature.IgnoreNotMatch);
	}
	
	/**
	 * JSON字符串转对象
	 *
	 * @param source json字符串值
	 * @param clazz  对象Class实例
	 * @return 实例对象
	 * @author xiao.xl 2021/10/15 14:28
	 */
	public static <T> T parseObject(String source, Class<T> clazz) {
		return JSON.parseObject(source, clazz, Feature.DisableCircularReferenceDetect, Feature.IgnoreNotMatch);
	}
	
	/**
	 * JSON字符串转对象
	 *
	 * @param source json字符串值
	 * @param type   转换对象类型
	 * @return 实例对象
	 * @author xiao.xl 2021/10/15 14:29
	 */
	public static <T> T parseObject(String source, Type type) {
		return JSON.parseObject(source, type, Feature.DisableCircularReferenceDetect, Feature.IgnoreNotMatch);
	}
	
	/**
	 * JSON字符串转对象
	 *
	 * @param source json字符串值
	 * @param type   转换对象类型
	 * @return 实例对象
	 * @author xiao.xl 2021/10/15 14:30
	 */
	public static <T> T parseObject(String source, TypeReference<T> type) {
		return JSON.parseObject(source, type, Feature.DisableCircularReferenceDetect, Feature.IgnoreNotMatch);
	}
	
	/**
	 * JSON字符串转集合
	 *
	 * @param source json字符串值
	 * @param clazz  转换list对象类型
	 * @return list对象<T>集合
	 * @author xiao.xl 2021/10/15 14:31
	 */
	public static <T> List<T> parseArray(String source, Class<T> clazz) {
		if (source == null) {
			return null;
		}
		List<T> list = null;
		int featureValues = JSON.DEFAULT_PARSER_FEATURE;
		featureValues = Feature.config(featureValues, Feature.DisableCircularReferenceDetect, true);
		featureValues = Feature.config(featureValues, Feature.IgnoreNotMatch, true);
		DefaultJSONParser parser = new DefaultJSONParser(source, ParserConfig.getGlobalInstance(), featureValues);
		JSONLexer lexer = parser.lexer;
		int token = lexer.token();
		if (token == JSONToken.NULL) {
			lexer.nextToken();
		} else if (token == JSONToken.EOF && lexer.isBlankInput()) {
			// no process
		} else {
			list = new ArrayList<T>();
			parser.parseArray(clazz, list);
			parser.handleResovleTask(list);
		}
		parser.close();
		return list;
	}
	
}
