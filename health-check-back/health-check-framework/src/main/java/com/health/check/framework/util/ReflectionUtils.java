package com.health.check.framework.util;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.Validate;
import org.springframework.core.ResolvableType;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 扩展反射工具类
 *
 * @author 2018年1月4日 下午7:06:40
 * @modify xiao.xl 2021/10/11 17:29
 * @see ReflectUtil
 */
public abstract class ReflectionUtils extends ReflectUtil {

    /**
     * 通过反射, 获得Class定义中声明的泛型参数的类型, 注意泛型必须定义在父类处 如无法找到, 返回Object.class. eg. public
     * UserDao extends HibernateDao<User>
     *
     * @param clazz The class to introspect
     * @return the first generic declaration, or Object.class if cannot be determined
     * @modify xiao.xl 2021/10/11 17:29
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> Class<T> getClassGenericType(final Class clazz) {
        return getClassGenericType(clazz, 0);
    }

    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     * <p>
     * 如public UserDao extends HibernateDao<User,Long>
     *
     * @param clazz clazz The class to introspect
     * @param index the Index of the generic declaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be determined
     * @modify xiao.xl 2021/10/11 17:30
     */
    @SuppressWarnings("rawtypes")
    public static Class getClassGenericType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) { return Object.class; }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if ((index >= params.length) || (index < 0)) { return Object.class; }
        if (!(params[index] instanceof Class)) { return Object.class; }

        return (Class) params[index];
    }

    /**
     * user class
     *
     * @param instance 实例对象
     * @return user class
     * @modify xiao.xl 2021/10/11 17:38
     */
    public static Class<?> getUserClass(Object instance) {
        Validate.notNull(instance, "Instance must not be null");
        Class<?> clazz = instance.getClass();
        if ((clazz != null) && clazz.getName().contains(StringPools.CGLIB_CLASS_SEPARATOR)) {
            Class<?> superClass = clazz.getSuperclass();
            if ((superClass != null) && !Object.class.equals(superClass)) { return superClass; }
        }
        return clazz;
    }

    /**
     * 将反射时的checked exception转换为unchecked exception.
     *
     * @param e 异常信息
     * @return 运行时异常
     * @modify xiao.xl 2021/10/11 17:39
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if ((e instanceof IllegalAccessException) || (e instanceof IllegalArgumentException)
                || (e instanceof NoSuchMethodException)) {
            return new IllegalArgumentException(e);
        }
        else if (e instanceof InvocationTargetException) {
            return new RuntimeException(((InvocationTargetException) e).getTargetException());
        }
        else if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }

    /**
     * 得到指定类型的指定位置的泛型实参
     *
     * @param clazz 类型
     * @param index 泛型索引
     * @param <T>   泛型类型
     * @return 泛型类型
     * @modify xiao.xl 2021/10/11 17:40
     */
    @SuppressWarnings({"unchecked"})
    public static <T> Class<T> findParameterizedType(Class<?> clazz, int index) {
        Type parameterizedType = clazz.getGenericSuperclass();
        // CGLIB subclass target object(泛型在父类上)
        if (!(parameterizedType instanceof ParameterizedType)) {
            parameterizedType = clazz.getSuperclass().getGenericSuperclass();
        }
        if (!(parameterizedType instanceof ParameterizedType)) {
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) parameterizedType).getActualTypeArguments();
        if (actualTypeArguments == null || actualTypeArguments.length == 0) {
            return null;
        }
        return (Class<T>) actualTypeArguments[index];
    }

    /**
     * 获取参数以及其对应值，返回JSON字符串
     *
     * @param clazz      类对象
     * @param methodName 方法名
     * @param arguments  参数值
     * @return 参数以及其对应值JSON串
     * @modify xiao.xl 2021/10/11 17:44
     */
    @SuppressWarnings("rawtypes")
    public static String getMethodParameters(Class clazz, String methodName, Object[] arguments) {
        Parameter[] parameters = null;
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            if (m.getName().equals(methodName)) { parameters = m.getParameters(); }
        }
        JSONObject jsonObject = new JSONObject();
        if (parameters != null && parameters.length == arguments.length) {
            for (int i = 0; i < parameters.length; i++) { jsonObject.put(parameters[i].getName(), arguments[i]); }
        }
        return jsonObject.toJSONString();
    }

    /**
     * 通过类名加载类对象
     *
     * @param clazz 类名
     * @return 类对象
     * @throws UtilException 工具类异常
     * @modify xiao.xl 2021/10/11 17:47
     */
    public static Class<?> getClazz(String clazz) throws UtilException {
        try {
            return Class.forName(clazz);
        }
        catch (Exception e) {
            throw new UtilException(e, "Get Class [{}] error!", clazz);
        }
    }

    /**
     * 通过属性get方法获取属性值
     *
     * @param obj   对象实例
     * @param field 属性对象
     * @return 属性值
     * @throws UtilException 工具类异常
     * @author Jason 2019/4/3 3:05 PM
     * @modify xiao.xl 2021/10/11 17:48
     */
    public static Object getFieldValueByGetMethod(Object obj, Field field) throws UtilException {
        return getFieldValueByGetMethod(obj, field.getName());
    }

    /**
     * 对象的属性为空串的设置为null
     *
     * @param entity 实例对象
     * @param <T>    泛型类型
     * @return 转换后实例对象
     * @author xiao.xl 2019/8/27 16:47
     * @modify xiao.xl 2021/10/11 17:50
     */
    public static <T> T setFieldEmptyStringToNull(T entity) {
        Field[] fields = ReflectionUtils.getFields(entity.getClass());
        for (Field field : fields) {
            Object fieldValue = ReflectionUtils.getFieldValue(entity, field);
            if (StringPools.EMPTY.equals(fieldValue)) {
                ReflectionUtils.setFieldValue(entity, field, null);
            }
        }
        return entity;
    }

    /**
     * 对象的属性类型为String且值为null的设置为空串
     *
     * @param entity 实例对象
     * @param <T>    泛型类型
     * @return 转换后实例对象
     * @modify xiao.xl 2021/10/11 17:50
     */
    public static <T> T setFieldNullToEmptyString(T entity) {
        Field[] fields = ReflectionUtils.getFields(entity.getClass());
        for (Field field : fields) {
            Object value = ReflectionUtils.getFieldValue(entity, field);
            if (String.class == field.getType() && value == null) {
                ReflectionUtils.setFieldValue(entity, field, StringPools.EMPTY);
            }
        }
        return entity;
    }

    /**
     * 通过属性get方法获取属性值
     *
     * @param obj       对象实例
     * @param fieldName 属性名
     * @return 属性值
     * @throws UtilException 工具类异常
     * @author Jason 2019/4/3 3:05 PM
     * @modify xiao.xl 2021/10/11 17:48
     */
    public static Object getFieldValueByGetMethod(Object obj, String fieldName) throws UtilException {
        try {
            Object value = getFieldValue(obj, fieldName);
            if (value == null) {
                String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method readMethod = ReflectionUtils.getMethod(obj.getClass(), methodName);
                return readMethod.invoke(obj);
            }
            return value;
        }
        catch (Exception e) {
            throw new UtilException(e);
        }
    }

    /**
     * 获取类静态属性值
     *
     * @param clazz           指定类对象
     * @param staticFieldName 静态字段名
     * @param <T>             类泛型
     * @return 静态属性值
     * @author xiao.xl 2021/11/10 13:01
     */
    public static <T> Object getStaticFieldValue(Class<T> clazz, String staticFieldName) {
        try {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                if (StringUtils.equals(field.getName(), staticFieldName) && field.getType() == Map.class && Modifier.isStatic(field.getModifiers())) {
                    if (field.isAccessible()) { return field.get(clazz); }
                    field.setAccessible(true);
                    Object o = field.get(clazz);
                    field.setAccessible(false);
                    return o;
                }
            }
        }
        catch (Exception e) {
            // quiet process
        }
        return null;
    }

    /**
     * 设置类静态属性值
     *
     * @param clazz           指定类对象
     * @param staticFieldName 静态字段名
     * @param <T>             类泛型
     * @author xiao.xl 2021/11/10 13:01
     */
    public static <T> void setStaticFieldValue(Class<T> clazz, String staticFieldName, Object o) {
        try {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                if (StringUtils.equals(field.getName(), staticFieldName) && field.getType() == Map.class && Modifier.isStatic(field.getModifiers())) {
                    if (field.isAccessible()) { field.set(clazz, o); }
                    field.setAccessible(true);
                    field.set(clazz, o);
                    field.setAccessible(false);
                }
            }
        }
        catch (Exception e) {
            // quiet process
        }
    }

    /**
     * 获取类接口泛型类型
     *
     * @param clazz         指定类
     * @param interfaceType 接口类型
     * @return 类接口泛型
     * @author xiao.xl 2021/12/24 10:01
     */
    public static Class<?> getInterfaceGenericType(Class<?> clazz, Class<?> interfaceType) {
        if (interfaceType == null || !interfaceType.isInterface()) {
            throw new IllegalArgumentException("parameter 1 must be interface type");
        }
        List<ResolvableType> resolvableTypes = Lists.newLinkedList();
        resolvable(resolvableTypes, clazz);
        for (ResolvableType resolvableType : resolvableTypes) {
            Class<?> rawClass = resolvableType.getRawClass();
            if (rawClass == null) { continue; }
            if (rawClass.isAssignableFrom(interfaceType)) {
                return resolvableType.getGeneric(0).resolve();
            }
        }
        return null;
    }

    /**
     * 递归解析类
     *
     * @param resolvableTypes 解析结果集合
     * @param clazz           待解析类
     * @author xiao.xl 2021/12/23 16:53
     */
    private static void resolvable(List<ResolvableType> resolvableTypes, Class<?> clazz) {
        ResolvableType resolvableType = ResolvableType.forClass(clazz);
        ResolvableType[] interfaces = resolvableType.getInterfaces();
        if (interfaces.length > 0) { resolvableTypes.addAll(Arrays.asList(interfaces)); }
        ResolvableType superType = resolvableType.getSuperType();
        // 退出递归
        if (superType.getRawClass() == null || superType.getRawClass() == Object.class) { return; }
        resolvable(resolvableTypes, superType.getRawClass());
    }

}
