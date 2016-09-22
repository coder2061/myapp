package com.web.myapp.core.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class CacheManager {
	 
	public static HashMap<String, Object> cacheMap = new HashMap<String, Object>();    
	    
    //单实例构造方法    
    private CacheManager() {    
        super();    
    }
    
    //获取布尔值的缓存    
    public static boolean getSimpleFlag(String key){    
        try{    
            return (Boolean) cacheMap.get(key);    
        }catch(NullPointerException e){    
            return false;    
        }    
    }
    
    public static long getServerStartdt(String key){    
        try {    
            return (Long)cacheMap.get(key);    
        } catch (Exception ex) {    
            return 0;    
        }    
    }
    
    //设置布尔值的缓存    
    public synchronized static boolean setSimpleFlag(String key,boolean flag){    
        if (flag && getSimpleFlag(key)) {//假如为真不允许被覆盖    
            return false;    
        }else{    
            cacheMap.put(key, flag);    
            return true;    
        }    
    }
    
    public synchronized static boolean setSimpleFlag(String key,long serverbegrundt){    
        if (cacheMap.get(key) == null) {    
            cacheMap.put(key,serverbegrundt);    
            return true;    
        }else{    
            return false;    
        }    
    }    
   
   
    //得到缓存。同步静态方法    
    private synchronized static CacheEntity getCache(String key) {    
        return (CacheEntity) cacheMap.get(key);    
    }    
   
    //判断是否存在一个缓存    
    private synchronized static boolean hasCache(String key) {    
        return cacheMap.containsKey(key);    
    }    
   
    //清除所有缓存    
    public synchronized static void clearAll() {    
        cacheMap.clear();    
    }    
   
    //清除某一类特定缓存,通过遍历HASHMAP下的所有对象，来判断它的KEY与传入的TYPE是否匹配    
    public synchronized static void clearAll(String type) {    
        Iterator<Entry<String, Object>> i = cacheMap.entrySet().iterator();    
        String key;    
        ArrayList<String> arr = new ArrayList<String>();    
        try {    
            while (i.hasNext()) {    
                java.util.Map.Entry<String, Object> entry = (java.util.Map.Entry<String, Object>) i.next();    
                key = (String) entry.getKey();    
                if (key.startsWith(type)) { //如果匹配则删除掉    
                    arr.add(key);    
                }    
            }    
            for (int k = 0; k < arr.size(); k++) {    
                clearOnly(arr.get(k));    
            }    
        } catch (Exception ex) {    
            ex.printStackTrace();    
        }    
    }    
   
    //清除指定的缓存    
    public synchronized static void clearOnly(String key) {    
        cacheMap.remove(key);    
    }    
   
    //载入缓存    
    public synchronized static void putCache(String key, CacheEntity obj) {    
        cacheMap.put(key, obj);    
    }    
   
    //获取缓存信息    
    public static CacheEntity getCacheInfo(String key) {    
   
        if (hasCache(key)) {    
         CacheEntity cache = getCache(key);    
            if (cacheExpired(cache)) { //调用判断是否终止方法    
                cache.setExpired(true);    
            }    
            return cache;    
        }else   
            return null;    
    }    
   
    //获取缓存信息    
    public static CacheEntity getCacheInfoNoExpired(String key) {    
        if (hasCache(key)) {    
        	CacheEntity cache = getCache(key);    
            return cache;    
        }else   
            return null;    
    } 
    
    //载入缓存信息    
    public static void putCacheInfo(String key, CacheEntity obj, long dt,boolean expired) {    
     CacheEntity cache = new CacheEntity();    
        cache.setKey(key);    
        cache.setTimeOut(dt + System.currentTimeMillis()); //设置多久后更新缓存    
        cache.setValue(obj);    
        cache.setExpired(expired); //缓存默认载入时，终止状态为FALSE    
        cacheMap.put(key, cache);    
    }

    //重写载入缓存信息方法    
    public static void putCacheInfo(String key,Object obj,long dt){    
     CacheEntity cache = new CacheEntity();    
        cache.setKey(key);    
        cache.setTimeOut(dt+System.currentTimeMillis());    
        cache.setValue(obj);    
        cache.setExpired(false);    
        cacheMap.put(key,cache);    
    }    
   
    //判断缓存是否终止    
    public static boolean cacheExpired(CacheEntity cache) {    
        if (null == cache) { //传入的缓存不存在    
            return false;    
        }    
        long nowDt = System.currentTimeMillis(); //系统当前的毫秒数    
        long cacheDt = cache.getTimeOut(); //缓存内的过期毫秒数    
        if (cacheDt <= 0||cacheDt>nowDt) { //过期时间小于等于零时,或者过期时间大于当前时间时，则为FALSE    
            return false;    
        } else { //大于过期时间 即过期    
            return true;    
        }    
    }    
   
    //获取缓存中的大小    
    public static int getCacheSize() {    
        return cacheMap.size();    
    }    
   
    //获取指定的类型的大小    
    public static int getCacheSize(String type) {    
        int k = 0;    
        Iterator<Entry<String, Object>> i = cacheMap.entrySet().iterator();    
        String key;    
        try {    
            while (i.hasNext()) {    
                java.util.Map.Entry<String, Object> entry = (java.util.Map.Entry<String, Object>) i.next();    
                key = (String) entry.getKey();    
                if (key.indexOf(type) != -1) { //如果匹配则删除掉    
                    k++;    
                }    
            }    
        } catch (Exception ex) {    
            ex.printStackTrace();    
        }    
        return k;    
    }    
   
    //获取缓存对象中的所有键值名称    
    @SuppressWarnings("finally")
    public static List<String> getCacheAllkey() {    
        List<String> a = new ArrayList<String>();    
        try {    
            Iterator<Entry<String, Object>> i = cacheMap.entrySet().iterator();    
            while (i.hasNext()) {    
                java.util.Map.Entry<String, Object> entry = (java.util.Map.Entry<String, Object>) i.next();    
                a.add((String) entry.getKey());    
            }    
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	return a;
        }    
    }    
   
    //获取缓存对象中指定类型 的键值名称    
    @SuppressWarnings("finally")
    public static List<String> getCacheListkey(String type) {    
        List<String> a = new ArrayList<String>();    
        String key;    
        try {    
            Iterator<Entry<String, Object>> i = cacheMap.entrySet().iterator();    
            while (i.hasNext()) {    
                java.util.Map.Entry<String, Object> entry = (java.util.Map.Entry<String, Object>) i.next();    
                key = (String) entry.getKey();    
                if (key.indexOf(type) != -1) {    
                    a.add(key);    
                }    
            }    
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {    
            return a;    
        }    
    }  
}