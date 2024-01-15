package com.health.check.framework.util;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.List;
import java.util.Set;

/**
 * @author hoda
 */
public class PathMatcherUtils {

	private static final PathMatcher matcher = new AntPathMatcher();

	/**
	 * 只要其中一个匹配则返回true
	 * @param path
	 * @param patterns
	 * @return
	 */
	public static boolean matchAny(String path, Set<String> patterns){
		if(patterns == null)
			return true;
		for(String pattern : patterns){
			if(matcher.match(pattern, path))return true;
		}
		return false;
	}

	public static boolean matchAny(String path, List<String> patterns){
		if(patterns == null)
			return true;
		for(String pattern : patterns){
			if(matcher.match(pattern, path))return true;
		}
		return false;
	}

	/**
	 * 只有匹配所有规则才返回true
	 * @param path
	 * @param patterns
	 * @return
	 */
	public static boolean matchAll(String path,Set<String> patterns){
		if(patterns == null)
			return true;
		for(String pattern : patterns){
			if(!matcher.match(pattern, path))return false;
		}
		return true;
	}
	/**
	 * 只要其中一个匹配则返回true
	 * @param path
	 * @param patterns
	 * @return
	 */
	public static boolean matchAny(String path,String... patterns){
		if(patterns == null)
			return true;
		for(String pattern : patterns){
			if(matcher.match(pattern, path))return true;
		}
		return false;
	}
	/**
	 * @param path
	 * @param pattern
	 * @return
	 */
	public static boolean match(String path,String pattern){
		return matcher.match(pattern, path);
	}
	/**
	 * 只有匹配所有规则才返回true
	 * @param path
	 * @param patterns
	 * @return
	 */
	public static boolean matchAll(String path,String... patterns){
		if(patterns == null)
			return true;
		for(String pattern : patterns){
			if(!matcher.match(pattern, path))return false;
		}
		return true;
	}
	public static PathMatcher getMatcher() {
		return matcher;
	}
}
