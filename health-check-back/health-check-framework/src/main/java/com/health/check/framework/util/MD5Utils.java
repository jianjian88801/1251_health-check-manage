package com.health.check.framework.util;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * MD5+盐加密工具类
 *
 * @author xiao.xl 2022/4/23 20:46
 */
@SuppressWarnings("ALL")
public class MD5Utils {
	
	/**
	 * 十六进制各位可用字符数组
	 */
	private static final char[] HEXADECIMAL = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	/**
	 * 十六进制各位可用字符串数组
	 */
	private static final String HEX_DIGITS[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
	
	/**
	 * 普通MD5
	 *
	 * @param input 待计算MD5字符串值
	 * @return 字符串MD5值
	 * @author daniel 2016-6-11 下午8:00:28
	 */
	public static String MD5(String input) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		char[] charArray = input.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuilder hexValue = new StringBuilder();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) { hexValue.append(StringPool.ZERO); }
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	
	/**
	 * 计算字符串MD5值，并将MD5字节数组值转换为16进制
	 *
	 * @param origin      待计算MD5字符串值
	 * @param charsetName 字符编码类型名称
	 * @return 16进制编码的MD5值
	 */
	public static String MD5Encode(String origin, String charsetName) {
		String resultString = origin;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (StringUtils.isBlank(charsetName)) {
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			} else { resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetName))); }
		} catch (Exception exception) {
			// quiet process
		}
		return resultString;
	}
	
	/**
	 * 字节数组转16进制字符串值
	 *
	 * @param bytes 字节数组值
	 * @return 16进制字符串值
	 */
	private static String byteArrayToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte v : bytes) { sb.append(byteToHexString(v)); }
		return sb.toString();
	}
	
	/**
	 * 字节转16进制
	 *
	 * @param b 字节值
	 * @return 16进制字符串
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) { n += 256; }
		int d1 = n / 16;
		int d2 = n % 16;
		return HEX_DIGITS[d1] + HEX_DIGITS[d2];
	}
	
	/**
	 * 加盐MD5
	 *
	 * @param password 待处理字符串值
	 * @return 加盐MD5值
	 * @author daniel 2016-6-11 下午8:45:04
	 */
	public static String generate(String password) {
		if (password == null) { return null; }
		Random r = new Random();
		StringBuilder sb = new StringBuilder(16);
		sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
		int len = sb.length();
		// 补零
		for (int i = 0; i < 16 - len; i++) { sb.append(StringPool.ZERO); }
		String salt = sb.toString();
		password = md5Hex(password + salt);
		char[] cs = new char[48];
		for (int i = 0; i < 48; i += 3) {
			cs[i] = password.charAt(i / 3 * 2);
			char c = salt.charAt(i / 3);
			cs[i + 1] = c;
			cs[i + 2] = password.charAt(i / 3 * 2 + 1);
		}
		return new String(cs);
	}
	
	/**
	 * 校验加盐后是否和原文一致
	 *
	 * @param password 原字符串值
	 * @param md5      md5值
	 * @return true：一致
	 * @author daniel 2016-6-11 下午8:45:39
	 */
	public static boolean verify(String password, String md5) {
		char[] cs1 = new char[32];
		char[] cs2 = new char[16];
		for (int i = 0; i < 48; i += 3) {
			cs1[i / 3 * 2] = md5.charAt(i);
			cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
			cs2[i / 3] = md5.charAt(i + 1);
		}
		return md5Hex(password + new String(cs2)).equals(new String(cs1));
	}
	
	/**
	 * 获取十六进制字符串形式的MD5摘要
	 *
	 * @param src 原字符串值
	 * @return 十六进制字符串形式的MD5值
	 */
	private static String md5Hex(String src) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return new String(new Hex().encode(md5.digest(src.getBytes())));
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 字节数组转换为16进制字符串值
	 *
	 * @param binaryData 字节数据值
	 * @return 16进制字符串值
	 */
	public static String encode(byte[] binaryData) {
		if (binaryData.length != 16) { return null; }
		char[] buffer = new char[32];
		for (int i = 0; i < 16; i++) {
			int low = binaryData[i] & 0x0f;
			int high = (binaryData[i] & 0xf0) >> 4;
			buffer[i * 2] = HEXADECIMAL[high];
			buffer[i * 2 + 1] = HEXADECIMAL[low];
		}
		return new String(buffer);
	}
	
}
