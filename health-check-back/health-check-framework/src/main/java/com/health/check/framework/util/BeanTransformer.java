package com.health.check.framework.util;

import org.dozer.DozerBeanMapper;

import java.util.List;

/**
 * JavaBean转换器
 *
 * @author xiao.xl 2021/10/15 15:32
 */
public abstract class BeanTransformer {
	/**
	 * 单例对象实例
	 */
	private static final DozerBeanMapper MAPPER = new DozerBeanMapper();
	
	/**
	 * Returns list of provided mapping file URLs
	 *
	 * @return unmodifiable list of mapping files
	 */
	public List<String> getMappingFiles() {
		return MAPPER.getMappingFiles();
	}
	
	/**
	 * Sets list of URLs for custom XML mapping files, which are loaded when mapper gets initialized.
	 * It is possible to load files from file system via file: prefix. If no prefix is given mapping files are
	 * loaded from classpath and can be packaged along with the application.
	 *
	 * @param files URLs referencing custom mapping files
	 * @see java.net.URL
	 */
	public void setMappingFiles(List<String> files) {
		if (files != null) {
			List<String> exists = MAPPER.getMappingFiles();
			if (exists != null) {
				files.addAll(exists);
			}
			MAPPER.setMappingFiles(files);
		}
	}
	
	/**
	 * 创建一个目标类型的实例并把source对象的值设置到目标对象中
	 *
	 * @param source    源对象
	 * @param destClass 目标对象的类型
	 * @return 返回目标对象
	 * @author xiao.xl 2021/10/15 15:37
	 */
	public static <T> T transform(Object source, Class<T> destClass) {
		return MAPPER.map(source, destClass);
	}
	
	/**
	 * 创建一个目标类型的实例并把source对象的值设置到目标对象中
	 *
	 * @param source    源对象
	 * @param destClass 目标对象的类型
	 * @param mapId     对象映射定义id
	 * @return 返回目标对象
	 * @author xiao.xl 2021/10/15 15:37
	 */
	public static <T> T transform(Object source, Class<T> destClass, String mapId) {
		return MAPPER.map(source, destClass, mapId);
	}
	
	/**
	 * 把source对象的值设置到dest对象中
	 *
	 * @param source 源对象
	 * @param dest   目标对象
	 * @return 返回目标对象
	 * @author xiao.xl 2021/10/15 15:37
	 */
	public static void transform(Object source, Object dest) {
		MAPPER.map(source, dest);
	}
	
	/**
	 * 创建一个目标类型的实例并把source对象的值设置到目标对象中
	 *
	 * @param source 源对象
	 * @param dest   目标对象
	 * @param mapId  对象映射定义id
	 * @return 返回目标对象
	 * @author xiao.xl 2021/10/15 15:37
	 */
	public static void transform(Object source, Object dest, String mapId) {
		MAPPER.map(source, dest, mapId);
	}
}
