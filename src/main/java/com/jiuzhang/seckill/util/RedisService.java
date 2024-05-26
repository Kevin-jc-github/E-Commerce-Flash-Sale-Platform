package com.jiuzhang.seckill.util;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Collections;

@Service
public class RedisService {

    @Resource
    private JedisPool jedisPool;

    public RedisService setValue(String key, Long value){
        Jedis client = jedisPool.getResource();
        client.set(key, value.toString());
        client.close();
        return this;
    }

    public String getValue(String key){
        Jedis client = jedisPool.getResource();
        String value = client.get(key);
        client.close();
        return value;
    }

    public boolean stockDeductValidation(String key){
        try(Jedis client = jedisPool.getResource()){
            String script = "if redis.call('exists',KEYS[1]) == 1 then\n" +
                    "                 local stock = tonumber(redis.call('get', KEYS[1]))\n" +
                    "                 if( stock <=0 ) then\n" +
                    "                    return -1\n" +
                    "                 end;\n" +
                    "                 redis.call('decr',KEYS[1]);\n" +
                    "                 return stock - 1;\n" +
                    "             end;\n" +
                    "             return -1;";
            Long stock = (Long) client.eval(script, Collections.singletonList(key), Collections.emptyList());

            if(stock < 0){
                System.out.println("库存不足");
                return false;
            }
            System.out.println("抢购成功，恭喜");
            return true;
        }catch (Throwable throwable){
            System.out.println("库存扣减失败" + throwable.toString());
            return false;
        }
    }

}

