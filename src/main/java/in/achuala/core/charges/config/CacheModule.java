package in.achuala.core.charges.config;

import dagger.Module;
import dagger.Provides;
import in.achuala.core.common.RedisCache;
import in.achuala.core.common.RedisCacheManager;
import in.achuala.core.common.RedisWrapper;
import redis.clients.jedis.HostAndPort;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class CacheModule {

    @Provides
    @Singleton
    RedisWrapper redisWrapper() {
        return RedisWrapper.newRedisWrapper(HostAndPort.getLocalhost(), false);
    }

    @Provides
    @Singleton
    RedisCacheManager cacheManager(RedisWrapper redisWrapper) {
        return new RedisCacheManager(redisWrapper);
    }

    @Provides
    @Named("CUST")
    @Singleton
    RedisCache customerCache(RedisCacheManager cacheManager) {
        return cacheManager.getCache("CUST");
    }

    @Provides
    @Named("ACCT")
    @Singleton
    RedisCache accountCache(RedisCacheManager cacheManager) {
        return cacheManager.getCache("ACCT");
    }

    @Provides
    @Named("PROD")
    @Singleton
    RedisCache productCache(RedisCacheManager cacheManager) {
        return cacheManager.getCache("PROD");
    }

    @Provides
    @Named("CHARGECFG")
    @Singleton
    RedisCache chargeConfigCache(RedisCacheManager cacheManager) {
        return cacheManager.getCache("CHARGECFG");
    }
}
