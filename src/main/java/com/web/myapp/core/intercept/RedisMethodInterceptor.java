package com.web.myapp.core.intercept;

import com.web.myapp.core.cache.RedisUtil;
import com.web.myapp.core.config.CommonConfig;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *	redis数据缓存
 */
public class RedisMethodInterceptor implements MethodInterceptor {
	private Logger logger = Logger.getLogger(RedisMethodInterceptor.class);
	private RedisUtil redisUtil;
	private List<String> targetNamesList; // 不需要缓存的类
	private List<String> methodNamesList; // 不需要缓存的方法
	private Long defaultCacheExpireTime; // 缓存默认的过期时间
	private Long userServiceExpireTime; //
	private Long memberServiceExpireTime; //

	/**
	 * 初始化读取不需要缓存的类和方法
	 */
	public RedisMethodInterceptor() {
		try {
			Properties prop = new Properties();
			InputStream is = CommonConfig.class.getClassLoader()
					.getResourceAsStream("redis.properties");
			prop.load(new InputStreamReader(is, "UTF-8"));

			String[] targetNames = prop.getProperty("targetNames").split(",");
			String[] methodNames = prop.getProperty("methodNames").split(",");
			targetNamesList = new ArrayList<String>(targetNames.length);
			methodNamesList = new ArrayList<String>(methodNames.length);
			Integer maxLen = (targetNames.length > methodNames.length) ? targetNames.length
					: methodNames.length;
			// 将不需要缓存的类名和方法名添加到list中
			for (int i = 0; i < maxLen; i++) {
				if (i < targetNames.length) {
					targetNamesList.add(targetNames[i]);
				}
				if (i < methodNames.length) {
					methodNamesList.add(methodNames[i]);
				}
			}
			
			defaultCacheExpireTime = Long.valueOf(prop
					.getProperty("defaultCacheExpireTime"));
			userServiceExpireTime = Long.valueOf(prop
					.getProperty("com.web.myapp.module.service.UserService"));
			memberServiceExpireTime = Long.valueOf(prop
					.getProperty("com.web.myapp.module.service.MemberService"));
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object value = null;
		String targetName = invocation.getThis().getClass().getName();
		String methodName = invocation.getMethod().getName();
		// 判断是否加入缓存
		if (!isAddCache(targetName, methodName)) {
			 // 执行方法返回结果 
			return invocation.proceed();
		}

		Object[] arguments = invocation.getArguments();
		// 创建缓存key
		String key = getCacheKey(targetName, methodName, arguments);
		try {
			// 判断缓存中是否有对应的key
			if (redisUtil.exists(key)) {
				return redisUtil.get(key);
			}

			// 执行方法返回结果
			value = invocation.proceed();

			if (value != null) {
				final String tkey = key;
				final Object tvalue = value;
				new Thread(new Runnable() {
					@Override
					public void run() {
						if (tkey.startsWith("com.web.myapp.module.service.UserService")) {
							redisUtil.set(tkey, tvalue, userServiceExpireTime);
						} else if (tkey.startsWith("com.web.myapp.module.service.MemberService")) {
							redisUtil.set(tkey, tvalue, memberServiceExpireTime);
						} else {
							redisUtil.set(tkey, tvalue, defaultCacheExpireTime);
						}
					}
				}).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (value == null) {
				return invocation.proceed();
			}
		}
		return value;
	}

	/**
	 * 是否加入缓存
	 *
	 * @return
	 */
	private boolean isAddCache(String targetName, String methodName) {
		boolean flag = true;
		if (targetNamesList.contains(targetName)
				|| methodNamesList.contains(methodName)) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 创建缓存key
	 *
	 * @param targetName
	 * @param methodName
	 * @param arguments
	 */
	private String getCacheKey(String targetName, String methodName,
			Object[] arguments) {
		StringBuffer sbu = new StringBuffer();
		sbu.append(targetName).append("_").append(methodName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				sbu.append("_").append(arguments[i]);
			}
		}
		return sbu.toString();
	}

	public void setRedisUtil(RedisUtil redisUtil) {
		this.redisUtil = redisUtil;
	}
}