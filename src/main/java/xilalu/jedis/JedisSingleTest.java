package xilalu.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.Arrays;
import java.util.List;

public class JedisSingleTest {

    public static void main(String[] args) {

        JedisPoolConfig jedisConfig = new JedisPoolConfig();
        jedisConfig.setMaxTotal(20);
        jedisConfig.setMaxIdle(10);
        jedisConfig.setMinIdle(5);

        JedisPool jedisPool = new JedisPool(jedisConfig, "121.89.193.201", 6379, 3000, null);

        Jedis jedis = jedisPool.getResource();

//        System.out.println(jedis.set("xialu", "hello"));
//        System.out.println(jedis.get("xialu"));

        // 管道.
//        Pipeline pl = jedis.pipelined();
//        for (int i = 0; i < 10; i++) {
//            pl.incr("pipelineKey");
//            pl.set("xialu" + i, "hello");
//        }
//        List<Object> objects = pl.syncAndReturnAll();
//        System.out.println(objects);

        // lua
        String script = "local count = redis.call('get', KEYS[1]) " +
                " local a = tonumber(count) " +
                " local b = tonumber(ARGV[1]) " +
                "  if a >= b then " +
                " redis.call('set', KEYS[1], count - b) " +
                " return 1 end " +
                " return 0 ";
        Object eval = jedis.eval(script, Arrays.asList("xialu"), Arrays.asList("10"));
        System.out.println(eval);


        jedis.close();
    }
}
