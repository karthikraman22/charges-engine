package in.achuala.core.common;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class RedisWrapper {
    private final Jedis jedis;
    private final JedisCluster jedisCluster;

    private RedisWrapper(Jedis jedis, JedisCluster jedisCluster) {
        this.jedis = jedis;
        this.jedisCluster = jedisCluster;
    }

    public static RedisWrapper newRedisWrapper(String host, boolean clusterEnabled) {
        if (!clusterEnabled) {
            Jedis jedis = new Jedis(host, 6379);
            return new RedisWrapper(jedis, null);
        } else {
            Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
            //Jedis Cluster will attempt to discover cluster nodes automatically
            jedisClusterNodes.add(new HostAndPort(HostAndPort.getLocalhost(), 6379));
            JedisCluster jc = new JedisCluster(jedisClusterNodes);
            return new RedisWrapper(null, jc);
        }
    }

    public <V> V get(final String key) {
        V v = null;
        if (this.jedisCluster != null) v = (V) this.jedisCluster.get(key.getBytes(StandardCharsets.UTF_8));
        else v = (V) this.jedis.get(key.getBytes(StandardCharsets.UTF_8));
        return v;
    }


    public void set(final String key, final byte[] value) {
        if (this.jedisCluster != null) this.jedisCluster.set(key.getBytes(StandardCharsets.UTF_8), value);
        else this.jedis.set(key.getBytes(StandardCharsets.UTF_8), value);
    }


    public void close() {
        if (this.jedis != null) this.jedis.close();
        if (this.jedisCluster != null)  this.jedisCluster.close();
    }
}
