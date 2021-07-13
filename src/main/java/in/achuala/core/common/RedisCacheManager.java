package in.achuala.core.common;

import lombok.val;

import java.util.HashMap;

public class RedisCacheManager {

    private final RedisWrapper redisWrapper;

    private final HashMap<String, RedisCache> redisCacheHashMap;

    public RedisCacheManager(final RedisWrapper redisWrapper) {
        this.redisWrapper = redisWrapper;
        this.redisCacheHashMap = new HashMap<>();
    }

    public RedisCache getCache(final String cacheName) {
        RedisCache cache = this.redisCacheHashMap.get(cacheName);
        if (cache == null) {
            cache = new RedisCache(cacheName, this.redisWrapper);
            this.redisCacheHashMap.put(cacheName, cache);
        }
        return cache;
    }

}
