package com.health.check.framework.serializer.kryo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.IoUtil;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 序列化、反序列化Kryo实现
 *
 * @author xiao.xl 2021/10/15 14:15
 */
@Slf4j
@SuppressWarnings("ALL")
public class KryoSerializerUtils {

	private static final Kryo KRYO;

	// 初始化Kryo
	static {
		// configure kryo instance, customize settings
		KRYO = new Kryo();
		KRYO.setReferences(false);
		KRYO.register(Collection.class);
		KRYO.register(Map.class);
	}

	private final static Map<Class, Registration> REGISTRATIONS = new ConcurrentHashMap<>();

	/**
	 * 对象序列化为字符串值(base64编码)
	 *
	 * @param obj 待序列化对象
	 * @return 序列化字符串值
	 * @author xiao.xl 2021/10/15 15:20
	 */
	public static <T> String serializerToString(T obj) {
		return Base64.encode(serializerToByte(obj));
	}

	/**
	 * 对象序列化为字节数组
	 *
	 * @param obj 待序列化对象
	 * @return 序列化结果字节数组
	 * @author xiao.xl 2021/10/15 15:21
	 */
	public static <T> byte[] serializerToByte(T obj) {
		Class<T> clazz = (Class<T>) obj.getClass();
		if (!REGISTRATIONS.containsKey(clazz)) {
			Registration registration = KRYO.register(clazz);
			REGISTRATIONS.put(clazz, registration);
		}
		ByteArrayOutputStream outputStream = null;
		Output output = null;
		try {
			outputStream = new ByteArrayOutputStream();
			output = new Output(outputStream);
			KRYO.writeObject(output, obj);
			output.flush();
			return outputStream.toByteArray();
		} finally {
			IoUtil.close(output);
			IoUtil.close(outputStream);
		}
	}

	/**
	 * 反序列化对象
	 *
	 * @param data  待反序列化字符串值（base64编码）
	 * @param clazz 反序列化对象类型
	 * @return 反序列化对象实例
	 * @author xiao.xl 2021/10/15 15:21
	 */
	public static <T> T deserializerByString(String data, Class<T> clazz) {
		return deserializerByByte(Base64.decode(data), clazz);
	}

	/**
	 * 反序列化
	 *
	 * @param data  待反序列化字节数组值
	 * @param clazz 待反序列化为对象类型
	 * @return 反序列化对象实例
	 * @author xiao.xl 2021/10/15 15:22
	 */
	public static <T> T deserializerByByte(byte[] data, Class<T> clazz) {
		Registration registration = REGISTRATIONS.get(clazz);
		if (registration == null) {
			registration = KRYO.register(clazz);
			REGISTRATIONS.put(clazz, registration);
		}
		ByteArrayInputStream byteArrayInputStream = null;
		Input input = null;
		try {
			byteArrayInputStream = new ByteArrayInputStream(data);
			input = new Input(byteArrayInputStream);
			return (T) KRYO.readObject(input, registration.getType());
		} finally {
			IoUtil.close(input);
			IoUtil.close(byteArrayInputStream);
		}
	}

}
