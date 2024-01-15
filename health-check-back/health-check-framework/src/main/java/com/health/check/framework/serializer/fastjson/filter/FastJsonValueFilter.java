package com.health.check.framework.serializer.fastjson.filter;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.health.check.framework.util.ReflectionUtils;
import com.health.check.framework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

/**
 * FastJson转换序列化过滤器
 *
 * @author xiao.xl 2021/10/15 14:16
 */
@Slf4j
public class FastJsonValueFilter implements ValueFilter {
	
	@Override
	public Object process(Object object, String name, Object value) {
		if (object instanceof Map) {
			if (value instanceof Date) {
				return DateUtil.format((Date) value, DatePattern.NORM_DATETIME_PATTERN);
			} else if (value instanceof Long && (Long) value > Integer.MAX_VALUE) {
				return value.toString();
			}
			return value;
		}
		Field field = null;
		try {
			field = ReflectionUtils.getField(object.getClass(), name);
		} catch (Exception e) {
			log.error("json获取反射字段属性异常", e);
		}
		if (field != null && field.getType() == Long.class) {
		    // Long类型转化为String防止前端精度丢失
			return value == null ? null : value.toString();
		} else if (value instanceof String && StringUtils.isBlank(((String) value))) {
		    // 空字符串转化为null
		    return null;
        }
		return value;
	}
	
}
