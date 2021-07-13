package in.achuala.core.common;

import lombok.NonNull;

import java.nio.charset.StandardCharsets;

public class RedisCache {

    private final RedisCachePrefix redisCachePrefix;
    private final RedisWrapper redisWrapper;

    RedisCache(final String cacheName, RedisWrapper redisWrapper) {
        this.redisCachePrefix = new RedisCachePrefix(cacheName);
        this.redisWrapper = redisWrapper;
    }

    public String get(@NonNull String key) {
        byte[] bytes = this.getBytes(key);
        if (bytes != null)  return new String(this.getBytes(key));
        else return  null;
    }

    public byte[] getBytes(@NonNull String key) {
        final String mappedKey = this.redisCachePrefix.getKey(key);
        return this.redisWrapper.get(mappedKey);
    }

    public void set(@NonNull String key, @NonNull String value) {
        this.setBytes(key, value.getBytes(StandardCharsets.UTF_8));
    }

    public void set(@NonNull String key, @NonNull Object value) {
        this.set(key, value.toString());
    }

    public void setBytes(@NonNull String key, @NonNull byte[] value) {
        final String mappedKey = this.redisCachePrefix.getKey(key);
        this.redisWrapper.set(mappedKey, value);
    }

    static class RedisCachePrefix {
        private final String cachePrefix;
        private RedisCachePrefix(final String cachePrefix) {
            this.cachePrefix = cachePrefix + "::";
        }

        String getKey(String key) {
            return this.cachePrefix+key;
        }
    }

}
