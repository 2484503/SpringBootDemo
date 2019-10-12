package com.example.demo.constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/10/10 15:32
 */
public class RedisCache {
    public static final Map<String, Object> redis = new ConcurrentHashMap<String, Object>();

    public static Object get(String key) {
        return redis.get(key);
    }

    public static void set(String key, Object obj) {
        redis.put(key, obj);
    }
}
