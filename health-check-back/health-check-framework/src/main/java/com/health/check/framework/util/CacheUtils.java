package com.health.check.framework.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import com.google.common.collect.Lists;
import com.health.check.framework.base.CacheTreeNode;
import com.health.check.framework.enums.CacheScopeEnum;
import com.health.check.framework.exception.CacheException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 缓存工具类
 *
 * @author xiao.xl 2021/10/19 14:25
 */
@Slf4j
@Component
@SuppressWarnings("ALL")
public class CacheUtils {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${source.enableCache:true}")
	private Boolean enableCache;
	
	@Autowired
	private CacheTreeUtils cacheTreeUtils;
	
	private final static String LOCK_PREFIX = "Lock";
	
	private final static String KEY_DELIMITER = ":";
	
	public static final String UNLOCK_LUA;
	
	static {
		StringBuilder script = new StringBuilder();
		script.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
		script.append("then ");
		script.append("    return redis.call(\"del\",KEYS[1]) ");
		script.append("else ");
		script.append("    return 0 ");
		script.append("end ");
		UNLOCK_LUA = script.toString();
	}
	
	@Autowired(required = false)
	private RedisTemplate redisTemplate;
	
	@Autowired(required = false)
	private RedisCacheConfiguration redisCacheConfiguration;
	
	/**
	 * 判断key是否存在
	 *
	 * @param key 缓存键
	 * @return true: 存在
	 * @author xiao.xl 2021/10/19 14:31
	 */
	public Boolean exists(String key) {
		return exists(key, CacheScopeEnum.APPLICATION);
	}
	
	/**
	 * 判断key是否存在
	 *
	 * @param key        缓存键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @return true: 存在
	 * @author xiao.xl 2021/10/19 14:32
	 */
	public Boolean exists(String key, CacheScopeEnum cacheScope) {
		checkConfig();
		key = addPrefix(key, cacheScope);
		return redisTemplate.hasKey(key);
	}
	
	/**
	 * 从应用缓存中获取缓存
	 *
	 * @param key   缓存键
	 * @param clazz 对象类型
	 * @return 缓存对象实体
	 * @author xiao.xl 2021/10/19 14:32
	 */
	public <T> T get(String key, Class<T> clazz) {
		try {
			return (T) get(key, CacheScopeEnum.APPLICATION, clazz);
		} catch (ClassCastException e) {
			throw CacheException.cacheTypeError();
		}
	}
	
	/**
	 * 根据key获取缓存
	 *
	 * @param key        缓存键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @param clazz      对象类型
	 * @return 缓存对象实体
	 * @author xiao.xl 2021/10/19 14:36
	 */
	public <T> T get(String key, CacheScopeEnum cacheScope, Class<T> clazz) {
		checkConfig();
		key = addPrefix(key, cacheScope);
		try {
			return (T) redisTemplate.opsForValue().get(key);
		} catch (ClassCastException e) {
			throw CacheException.cacheTypeError();
		}
	}
	
	/**
	 * 根据key与hashKey获取应用缓存
	 *
	 * @param key     缓存键
	 * @param hashKey 哈希键
	 * @param clazz   对象类型
	 * @return 缓存对象实体
	 * @author xiao.xl 2021/10/19 14:36
	 */
	public <T> T hget(String key, String hashKey, Class<T> clazz) {
		return hget(key, hashKey, CacheScopeEnum.APPLICATION, clazz);
	}
	
	/**
	 * 根据key与hashKey获取缓存
	 *
	 * @param key        缓存键
	 * @param hashKey    哈希键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @param clazz      对象类型
	 * @return 缓存对象实体
	 * @author xiao.xl 2021/10/19 14:37
	 */
	public <T> T hget(String key, String hashKey, CacheScopeEnum cacheScope, Class<T> clazz) {
		checkConfig();
		key = addPrefix(key, cacheScope);
		try {
			return (T) redisTemplate.opsForHash().get(key, hashKey);
		} catch (ClassCastException e) {
			throw CacheException.cacheTypeError();
		}
	}
	
	/**
	 * 根据key获取应用缓存中的hash值
	 *
	 * @param key   缓存键
	 * @param clazz 对象类型
	 * @return 应用缓存中的hash值
	 * @author xiao.xl 2021/10/19 14:39
	 */
	public <T> Map<String, T> hmget(String key, Class<T> clazz) {
		return hmget(key, CacheScopeEnum.APPLICATION, clazz);
	}
	
	/**
	 * 根据key获取缓存Hash值
	 *
	 * @param key        缓存键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @param clazz      对象类型
	 * @return 应用缓存中的hash值
	 * @author xiao.xl 2021/10/19 14:40
	 */
	public <T> Map<String, T> hmget(String key, CacheScopeEnum cacheScope, Class<T> clazz) {
		checkConfig();
		key = addPrefix(key, cacheScope);
		return redisTemplate.opsForHash().entries(key);
	}
	
	/**
	 * 根据前缀获取缓存
	 *
	 * @param pre   缓存前缀
	 * @param clazz 对象类型
	 * @return 缓存集合
	 * @author xiao.xl 2021/10/19 14:41
	 */
	public <T> List<T> getByPre(String pre, Class<T> clazz) {
		return getByPre(pre, CacheScopeEnum.APPLICATION, clazz);
	}
	
	/**
	 * 根据前缀获取缓存
	 *
	 * @param pre        缓存前缀
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @param clazz      对象类型
	 * @return 应用缓存中的hash值
	 * @author xiao.xl 2021/10/19 14:42
	 */
	public <T> List<T> getByPre(String pre, CacheScopeEnum cacheScope, Class<T> clazz) {
		checkConfig();
		pre = addPrefix(pre, cacheScope);
		Set<String> keys = redisTemplate.keys(pre + "*");
		if (keys != null) {
			String[] keyArray = new String[]{};
			keys.toArray(keyArray);
			return redisTemplate.opsForValue().multiGet(keys);
		}
		return Lists.newArrayList();
	}
	
	/**
	 * 设置应用缓存
	 *
	 * @param key   缓存键
	 * @param value 缓存值
	 * @author xiao.xl 2021/10/19 14:42
	 */
	public void set(String key, Object value) {
		set(key, value, CacheScopeEnum.APPLICATION);
	}
	
	/**
	 * 设置过期时间写入引用缓存
	 *
	 * @param key   缓存键
	 * @param value 缓存值
	 * @param ttl   过期时间
	 * @author xiao.xl 2021/10/19 14:43
	 */
	public void set(String key, Object value, Duration ttl) {
		set(key, value, CacheScopeEnum.APPLICATION, ttl);
	}
	
	/**
	 * 缓存设置
	 *
	 * @param key        缓存键
	 * @param value      缓存值
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @author xiao.xl 2021/10/19 14:43
	 */
	public void set(String key, Object value, CacheScopeEnum cacheScope) {
		checkConfig();
		Duration ttl = redisCacheConfiguration.getTtl();
		set(key, value, cacheScope, ttl);
	}
	
	/**
	 * 缓存设置
	 *
	 * @param key        缓存键
	 * @param value      缓存值
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @param ttl        过期时间
	 * @author xiao.xl 2021/10/19 14:44
	 */
	public void set(String key, Object value, CacheScopeEnum cacheScope, Duration ttl) {
		checkConfig();
		key = addPrefix(key, cacheScope);
		redisTemplate.opsForValue().set(key, value, ttl);
	}
	
	/**
	 * 根据Key和HashKey设置应用缓存
	 *
	 * @param key     缓存键
	 * @param hashKey 哈希键
	 * @param value   缓存值
	 * @author xiao.xl 2021/10/19 14:45
	 */
	public void hset(String key, String hashKey, Object value) {
		hset(key, hashKey, value, CacheScopeEnum.APPLICATION);
	}
	
	/**
	 * 根据Key和HashKey设置缓存
	 *
	 * @param key        缓存键
	 * @param hashKey    哈希键
	 * @param value      缓存值
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @return
	 * @author xiao.xl 2021/10/19 14:45
	 */
	public void hset(String key, String hashKey, Object value, CacheScopeEnum cacheScope) {
		checkConfig();
		key = addPrefix(key, cacheScope);
		redisTemplate.opsForHash().put(key, hashKey, value);
	}
	
	/**
	 * 设置应用缓存Hash缓存
	 *
	 * @param key 缓存键
	 * @param map 应用缓存中的hash值
	 * @author xiao.xl 2021/10/19 14:46
	 */
	public void hmset(String key, Map<String, Object> map) {
		checkConfig();
		Duration ttl = redisCacheConfiguration.getTtl();
		hmset(key, map, CacheScopeEnum.APPLICATION, ttl);
	}
	
	/**
	 * 设置超时Hash缓存
	 *
	 * @param key        缓存键
	 * @param map        应用缓存中的hash值
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @param ttl        过期时间
	 * @author xiao.xl 2021/10/19 14:46
	 */
	public void hmset(String key, Map<String, Object> map, CacheScopeEnum cacheScope, Duration ttl) {
		checkConfig();
		key = addPrefix(key, cacheScope);
		redisTemplate.opsForHash().putAll(key, map);
		redisTemplate.expire(key, ttl.getSeconds(), TimeUnit.SECONDS);
	}
	
	/**
	 * 根据Key删除应用缓存
	 *
	 * @param key 缓存键
	 * @return true：成功
	 * @author xiao.xl 2021/10/19 14:48
	 */
	public Boolean remove(String key) {
		return remove(key, CacheScopeEnum.APPLICATION);
	}
	
	/**
	 * 删除单个缓存
	 *
	 * @param key        缓存键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @return
	 * @author xiao.xl 2021/10/19 14:49
	 */
	public Boolean remove(String key, CacheScopeEnum cacheScope) {
		checkConfig();
		key = addPrefix(key, cacheScope);
		return redisTemplate.delete(key);
	}
	
	/**
	 * 批量删除应用缓存
	 *
	 * @param keys 缓存键集合
	 * @return 受影响条数
	 * @author xiao.xl 2021/10/19 14:49
	 */
	public Long remove(String... keys) {
		return remove(keys, CacheScopeEnum.APPLICATION);
	}
	
	/**
	 * 批量删除缓存
	 *
	 * @param keys       缓存键集合
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @return 受影响条数
	 * @author xiao.xl 2021/10/19 14:50
	 */
	public Long remove(String[] keys, CacheScopeEnum cacheScope) {
		checkConfig();
		List<String> keysArray = addPrefixs(cacheScope, keys);
		return redisTemplate.delete(keysArray);
	}
	
	/**
	 * 根据前缀删除应用缓存
	 *
	 * @param pre 前缀
	 * @return 受影响条数
	 * @author xiao.xl 2021/10/19 14:50
	 */
	public Long removeByPre(String pre) {
		return removeByPre(pre, CacheScopeEnum.APPLICATION);
	}
	
	/**
	 * 根据前缀删除缓存
	 *
	 * @param pre        缓存键前缀
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @return 受影响条数
	 * @author xiao.xl 2021/10/19 14:51
	 */
	public Long removeByPre(String pre, CacheScopeEnum cacheScope) {
		checkConfig();
		pre = addPrefix(pre, cacheScope);
		Set<String> keys = redisTemplate.keys(pre + "*");
		if (keys != null) {
			String[] keyArray = ArrayUtil.toArray(keys, String.class);
			return remove(keyArray, cacheScope);
		}
		return 0L;
	}
	
	/**
	 * 获取应用缓存过期时间
	 *
	 * @param key 缓存键
	 * @return 缓存过期时间
	 * @author xiao.xl 2021/10/19 14:52
	 */
	public Date getExpireDate(String key) {
		return getExpireDate(key, CacheScopeEnum.APPLICATION);
	}
	
	/**
	 * 获取应用缓存过期时间
	 *
	 * @param key        缓存键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @return 缓存过期时间
	 * @author xiao.xl 2021/10/19 14:53
	 */
	public Date getExpireDate(String key, CacheScopeEnum cacheScope) {
		Integer seconds = getExpireSecond(key, cacheScope).intValue();
		if (seconds == -1) {
			return DateUtil.offset(new Date(), DateField.YEAR, 1000);
		}
		return DateUtil.offsetSecond(new Date(), seconds);
	}
	
	/**
	 * 获取应用缓存过期秒数
	 *
	 * @param key 缓存键
	 * @return 缓存过期秒数
	 * @author xiao.xl 2021/10/19 14:53
	 */
	public Long getExpireSecond(String key) {
		return getExpireSecond(key, CacheScopeEnum.APPLICATION);
	}
	
	/**
	 * 获取缓存过期秒数
	 *
	 * @param key        缓存键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @return 缓存过期秒数
	 * @author xiao.xl 2021/10/19 14:54
	 */
	public Long getExpireSecond(String key, CacheScopeEnum cacheScope) {
		checkConfig();
		if (exists(key, cacheScope)) {
			key = addPrefix(key, cacheScope);
			return redisTemplate.getExpire(key, TimeUnit.SECONDS);
		}
		return 0L;
	}
	
	/**
	 * 将长字符串采用MD5位移法生成缓存key
	 *
	 * @param prefix    前缀
	 * @param sourceKey 缓存键
	 * @return 缓存key
	 * @author xiao.xl 2021/10/19 14:54
	 */
	public String gentPrefixCacheKey(String prefix, String sourceKey) {
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("MD5").digest(sourceKey.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			log.error("Redis Key序列化异常：{}", sourceKey);
			log.error(e.toString());
		}
		//使用MD5生成位移key
		String md5Key = MD5Utils.encode(hash);
		if (StringUtils.isNotBlank(md5Key)) {
			return MessageFormat.format("{0}-{1}", prefix, md5Key);
		}
		return md5Key;
	}
	
	/**
	 * 在指定超时时间内获取缓存锁
	 *
	 * @param key        缓存键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @param timeOut    超时时间
	 * @param expire     过期时间
	 * @return true: 获取成功
	 * @author xiao.xl 2021/10/19 14:55
	 */
	public Boolean lockWithTimeout(String key, CacheScopeEnum cacheScope, Integer timeOut, Integer expire) {
		checkConfig();
		String cacheKey = addPrefix(MessageFormat.format("{0}:{1}", LOCK_PREFIX, key), cacheScope);
		Long expireAt = DateUtil.offsetSecond(new Date(), expire + 1).getTime();
		Long endTime = DateUtil.offsetSecond(new Date(), timeOut + 1).getTime();
		while (DateUtil.current() < endTime) {
			Boolean lock = (Boolean) redisTemplate.execute((RedisCallback) connection -> {
				Boolean acquire = connection.setNX(cacheKey.getBytes(), String.valueOf(expireAt).getBytes());
				if (acquire) {
					return Boolean.TRUE;
				} else {
					byte[] value = connection.get(cacheKey.getBytes());
					if (Objects.nonNull(value) && value.length > 0) {
						long expireTime = Long.parseLong(new String(value));
						if (expireTime < System.currentTimeMillis()) {
							byte[] oldValue = connection.getSet(cacheKey.getBytes(), String.valueOf(expireAt).getBytes());
							return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
						}
					}
				}
				return Boolean.FALSE;
			});
			if (lock) {
				return Boolean.TRUE;
			} else {
				log.debug(MessageFormat.format("Key: {0} 获取Redis锁失败，休眠重试：", cacheKey));
				try {
					// 休眠500毫秒再重试
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
		return Boolean.FALSE;
	}
	
	/**
	 * 释放缓存锁
	 *
	 * @param key        缓存键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @return true: 释放缓存锁成功
	 * @author xiao.xl 2021/10/19 15:01
	 */
	public Boolean releaseLock(String key, CacheScopeEnum cacheScope) {
		checkConfig();
		String cacheKey = addPrefix(MessageFormat.format("{0}:{1}", LOCK_PREFIX, key), cacheScope);
		return redisTemplate.delete(cacheKey);
	}
	
	/**
	 * 根据表达式返回所有符合要求的Redis Key
	 *
	 * @param pattern 表达式
	 * @return redis Key set
	 * @author xiao.xl 2021/10/19 15:03
	 */
	public Set<String> getKeys(String pattern) {
		return redisTemplate.keys(pattern);
	}
	
	/**
	 * 根据表达式返回所有符合要求要Redis CacheTreeNode对象
	 *
	 * @param pattern 表达式
	 * @return redis CacheTreeNode对象 set
	 * @author xiao.xl 2021/10/19 15:03
	 */
	public Set<CacheTreeNode> getCacheTreeNodes(String pattern) {
		Set<String> keys = getKeys(pattern);
		List<CacheTreeNode> cacheTreeNodeList = Lists.newArrayList();
		for (String key : keys) {
			String[] blocks = key.split(KEY_DELIMITER);
			for (int i = 0; i < blocks.length; i++) {
				String currentKey = blocks[i];
				CacheTreeNode cacheTreeNode = new CacheTreeNode(currentKey);
				if (i != 0) {
					cacheTreeNode.setParentKey(blocks[i - 1]);
				}
				if (i == blocks.length - 1) {
					cacheTreeNode.setKey(key);
					cacheTreeNode.setLeaf(true);
				} else {
					cacheTreeNode.setLeaf(false);
				}
				cacheTreeNodeList.add(cacheTreeNode);
			}
		}
		return cacheTreeUtils.buildTree(cacheTreeNodeList);
	}
	
	
	/**
	 * 自增操作
	 *
	 * @param key        缓存键
	 * @param expireTime 失效时间（单位为分钟）
	 * @Return 自增值
	 * @Author xiao.xl 2021/5/28 13:55
	 */
	public Long incrementAndGet(String key, Integer expireTime) {
		RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
		// 设置失效时间
		if (!Objects.isNull(expireTime)) {
			redisAtomicLong.expire(expireTime, TimeUnit.MINUTES);
		}
		return redisAtomicLong.incrementAndGet();
	}
	
	/**
	 * 缓存前缀追加配置
	 *
	 * @param key        缓存键
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @return 新缓存key
	 * @author xiao.xl 2021/10/19 15:04
	 */
	private String addPrefix(String key, CacheScopeEnum cacheScope) {
		if (CacheScopeEnum.APPLICATION == cacheScope) {
			key = MessageFormat.format("{0}:{1}", appName, key);
		}
		return key;
	}
	
	/**
	 * 缓存前缀追加配置
	 *
	 * @param cacheScope 缓存作用域 {@link CacheScope}
	 * @param keys       缓存键集
	 * @return 缓存前缀追加集合
	 * @author xiao.xl 2021/10/19 14:39
	 */
	private List<String> addPrefixs(CacheScopeEnum cacheScope, String... keys) {
		if (CacheScopeEnum.APPLICATION == cacheScope) {
			return Arrays.asList(keys).parallelStream().map(key -> MessageFormat.format("{0}:{1}", appName, key)).collect(Collectors.toList());
		}
		return Arrays.asList(keys);
	}
	
	/**
	 * 检查缓存配置是否启用
	 *
	 * @author xiao.xl 2021/10/19 14:38
	 */
	private void checkConfig() {
		if (!enableCache) {
			throw CacheException.cacheUnable();
		}
	}
	
}
