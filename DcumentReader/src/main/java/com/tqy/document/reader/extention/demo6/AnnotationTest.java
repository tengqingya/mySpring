package com.tqy.document.reader.extention.demo6;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author tengqingya
 * @create 2019-05-31 10:12
 */
@Component
@Aspect
public class AnnotationTest {
    private static final Logger LOGGER = Logger.getLogger( AnnotationTest.class );
    @Autowired
    private RedisTemplate redisTemplate;

    //定义切点
    @Around(value = "@annotation(MyCache)")
    public void sayings(ProceedingJoinPoint pjp){
        LOGGER.info("before.........");
        try {
            Object proceed = pjp.proceed();
            LOGGER.info(proceed);
            redisTemplate.opsForValue().set("aop:test", String.valueOf(proceed),3600);
        } catch( Throwable throwable ) {
            throwable.printStackTrace();
        }
        LOGGER.info("after............");
    }
}
