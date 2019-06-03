package com.tqy.document.reader.extention.demo6;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author tengqingya
 * @create 2019-05-30 10:20
 */
@Service
public class RedisTest {
    private static final Logger LOGGER = Logger.getLogger( RedisTest.class );
    @Autowired
    private RedisTemplate redisTemplate;

    public String test(){
        return String.valueOf(redisTemplate.hasKey("aop:test"));
    }

    @MyCache
    public String test2(String a){
        LOGGER.info("test2......");
        return a;
    }

}
