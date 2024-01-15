package com.health.check.framework.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

/**
 * 反射实现对象间转换工具类
 *
 * @author xiao.xl 2022/6/17 23:32
 */
@Slf4j
public abstract class TransformUtils {
    /**
     * 创建一个目标类型的实例并把source对象的值设置到目标对象中
     *
     * @param source    源对象
     * @param destClass 目标对象的类型
     * @return 返回目标对象
     * @modify xiao.xl 2021/10/11 13:20
     */
    public static <T> T transform(Object source, Class<T> destClass) {
        if (source == null) { return null; }
        return BeanTransformer.transform(source, destClass);
    }

    /**
     * 创建一个目标类型的实例并把source对象的值设置到目标对象中
     *
     * @param source    源对象
     * @param destClass 目标对象的类型
     * @param mapId     对象映射定义id
     * @return 返回目标对象
     * @modify xiao.xl 2021/10/11 13:20
     */
    public static <T> T transform(Object source, Class<T> destClass, String mapId) {
        if (source == null) { return null; }
        return BeanTransformer.transform(source, destClass, mapId);
    }

    /**
     * 把source对象的值设置到dest对象中
     *
     * @param source 源对象
     * @param dest   目标对象
     * @modify xiao.xl 2021/10/11 13:21
     */
    public static void transform(Object source, Object dest) {
        Assert.notNull(source, "source can not be null");
        Assert.notNull(dest, "dest can not be null");
        BeanTransformer.transform(source, dest);
    }

    /**
     * 创建一个目标类型的实例并把source对象的值设置到目标对象中
     *
     * @param source 源对象
     * @param dest   目标对象
     * @param mapId  对象映射定义id
     * @modify xiao.xl 2021/10/11 13:21
     */
    public static void transform(Object source, Object dest, String mapId) {
        Assert.notNull(source, "source can not be null");
        Assert.notNull(dest, "dest can not be null");
        BeanTransformer.transform(source, dest, mapId);
    }

    /**
     * 把源集合数据转换成目标类型的集合数据
     *
     * @param source    源集合数据
     * @param destClass 目标集合元素的类型
     * @return 返回新的集合
     * @modify xiao.xl 2021/10/11 13:21
     */
    public static <T> Collection<T> transformCollection(Collection<?> source, Class<T> destClass) {
        List<T> destList = new ArrayList<>();
        if (source == null) { return destList; }
        source.forEach(o -> destList.add(transform(o, destClass)));
        return destList;
    }

    /**
     * 把源集合数据转换成目标类型的集合数据
     *
     * @param source    源集合数据
     * @param destClass 目标集合元素的类型
     * @param mapId     对象映射定义id
     * @return 返回新的集合
     * @modify xiao.xl 2021/10/11 13:21
     */
    public static <T> Collection<T> transformCollection(Collection<?> source, Class<T> destClass, String mapId) {
        List<T> destList = new ArrayList<>();
        if (source == null) { return destList; }
        source.forEach(o -> destList.add(transform(o, destClass, mapId)));
        return destList;
    }

    /**
     * 把源集合数据转换成目标类型的集合数据
     *
     * @param source    源集合数据
     * @param destClass 目标集合元素的类型
     * @return 返回新的集合
     * @modify xiao.xl 2021/10/11 13:22
     */
    public static <T> List<T> transformList(List<?> source, Class<T> destClass) {
        List<T> destList = new ArrayList<>();
        if (source == null) { return destList; }
        source.forEach(o -> destList.add(transform(o, destClass)));
        return destList;
    }

    /**
     * 把源集合数据转换成目标类型的集合数据
     *
     * @param source    源集合数据
     * @param destClass 目标集合元素的类型
     * @param mapId     对象映射定义id
     * @return 返回新的集合
     * @modify xiao.xl 2021/10/11 13:22
     */
    public static <T> List<T> transformList(List<?> source, Class<T> destClass, String mapId) {
        List<T> destList = new ArrayList<>();
        if (source == null) { return destList; }
        source.forEach(o -> destList.add(transform(o, destClass, mapId)));
        return destList;
    }

    /**
     * 把源集合数据转换成目标类型的集合数据
     *
     * @param source    源集合数据
     * @param destClass 目标集合元素的类型
     * @return 返回新的集合
     * @modify xiao.xl 2021/10/11 13:23
     */
    public static <T> Set<T> transformSet(Set<?> source, Class<T> destClass) {
        Set<T> destSet = new LinkedHashSet<>();
        if (source == null) { return destSet; }
        source.forEach(o -> destSet.add(transform(o, destClass)));
        return destSet;
    }

    /**
     * 把源集合数据转换成目标类型的集合数据
     *
     * @param source    源集合数据
     * @param destClass 目标集合元素的类型
     * @param mapId     对象映射定义id
     * @return 返回新的集合
     * @modify xiao.xl 2021/10/11 13:23
     */
    public static <T> Set<T> transformSet(Set<?> source, Class<T> destClass, String mapId) {
        Set<T> destSet = new LinkedHashSet<>();
        if (source == null) { return destSet; }
        source.forEach(o -> destSet.add(transform(o, destClass, mapId)));
        return destSet;
    }

    /**
     * 把源Map数据转换成目标类型的Map数据
     *
     * @param source         源集合数据
     * @param destKeyClass   目标Map中key元素的类型
     * @param destValueClass 目标Map中value元素的类型
     * @return 返回新的Map
     * @modify xiao.xl 2021/10/11 13:24
     */
    public static <K, V> Map<K, V> transformMap(Map<?, ?> source, Class<K> destKeyClass, Class<V> destValueClass) {
        Map<K, V> destMap = new LinkedHashMap<>();
        if (source == null) { return destMap; }
        source.forEach((key, value) -> destMap.put(transform(key, destKeyClass), transform(value, destValueClass)));
        return destMap;
    }

    /**
     * 把源Map数据转换成目标类型的Map数据
     *
     * @param source         源集合数据
     * @param destKeyClass   目标Map中key元素的类型
     * @param destValueClass 目标Map中value元素的类型
     * @param keyMapId       目标Map中key元素类型的映射配置id
     * @param valueMapId     目标Map中value元素类型的映射配置id
     * @return 返回新的Map
     * @modify xiao.xl 2021/10/11 13:24
     */
    public static <K, V> Map<K, V> transformMap(Map<?, ?> source, Class<K> destKeyClass,
                                                Class<V> destValueClass, String keyMapId,
                                                String valueMapId) {
        Map<K, V> destMap = new LinkedHashMap<>();
        if (source == null) { return destMap; }
        source.forEach((key, value) -> {
            K destKey;
            V destValue;
            if (keyMapId == null) { destKey = transform(key, destKeyClass); }
            else { destKey = transform(key, destKeyClass, keyMapId); }
            if (valueMapId == null) { destValue = transform(value, destValueClass); }
            else { destValue = transform(value, destValueClass, valueMapId); }
            destMap.put(destKey, destValue);
        });
        return destMap;
    }

    /**
     * 把源Map数据转换成目标类型的Map数据
     *
     * @param source         源集合数据
     * @param destValueClass 目标Map中value元素的类型
     * @return 返回新的Map
     * @modify xiao.xl 2021/10/11 13:26
     */
    public static <V> Map<String, V> transformMap(Map<String, ?> source,
                                                  Class<V> destValueClass) {
        Map<String, V> destMap = new LinkedHashMap<>();
        if (source == null) { return destMap; }
        source.forEach((key, value) -> destMap.put(key, transform(value, destValueClass)));
        return destMap;
    }

    /**
     * 把源Map数据转换成目标类型的Map数据
     *
     * @param source         源集合数据
     * @param destValueClass 目标Map中value元素的类型
     * @param mapId          目标Map中key元素类型的映射配置id
     * @return 返回新的Map
     * @modify xiao.xl 2021/10/11 13:26
     */
    public static <V> Map<String, V> transformMap(Map<String, ?> source, Class<V> destValueClass, String mapId) {
        Map<String, V> destMap = new LinkedHashMap<>();
        if (source == null) { return destMap; }
        source.forEach((key, value) -> destMap.put(key, transform(value, destValueClass, mapId)));
        return destMap;
    }

    /**
     * 对象深度克隆---使用序列化进行深拷贝
     *
     * @param obj 要克隆的对象
     * @return 注意：
     * 使用序列化的方式来实现对象的深拷贝，但是前提是，对象必须是实现了 Serializable接口才可以，Map本身没有实现
     * Serializable 这个接口，所以这种方式不能序列化Map，也就是不能深拷贝Map。但是HashMap是可以的，因为它实现了Serializable。
     * @modify xiao.xl 2021/10/11 13:27
     */
    @SuppressWarnings({"unchecked"})
    public static <T extends Serializable> T deepClone(T obj) {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        ByteArrayOutputStream os = null;
        ByteArrayInputStream is = null;
        try {
            os = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(obj);
            is = new ByteArrayInputStream(os.toByteArray());
            ois = new ObjectInputStream(is);
            return (T) ois.readObject();
        }
        catch (Exception e) {
            log.error("深度拷贝失败", e);
            throw new RuntimeException(e);
        }
        finally {
            IoUtil.close(os);
            IoUtil.close(is);
            IoUtil.close(oos);
            IoUtil.close(ois);
        }
    }

}
