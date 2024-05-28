package com.jiuzhang.seckill;

import com.jiuzhang.seckill.service.SeckillActivityService;
import com.jiuzhang.seckill.util.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedisDemoTest {

    @Resource
    private RedisService redisService;

    @Resource
    SeckillActivityService seckillActivityService;


//    @Test
//    public void stockTest(){
//        String value = redisService.setValue("stock:19", 10L).getValue();
//        System.out.println(value);
//    }

    @Test
    public void pushSeckillInfoToRedisTest(){
        seckillActivityService.pushSeckillInfoToRedis(19);
    }

}
