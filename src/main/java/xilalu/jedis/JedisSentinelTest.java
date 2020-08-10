package xilalu.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class JedisSentinelTest {

    public static void main(String[] args) {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        String masterName = "mymaster";

        Set<String> sentinels = new HashSet<>();
        sentinels.add(new HostAndPort("121.89.193.201", 26379).toString());
        sentinels.add(new HostAndPort("121.89.193.201", 26380).toString());
        sentinels.add(new HostAndPort("121.89.193.201", 26381).toString());
        JedisSentinelPool jedisSentinelPool =
                new JedisSentinelPool(masterName, sentinels, config, 3000, null);

        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            System.out.println(jedis.set("sentinel", "hello"));
            System.out.println(jedis.get("sentinel"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
