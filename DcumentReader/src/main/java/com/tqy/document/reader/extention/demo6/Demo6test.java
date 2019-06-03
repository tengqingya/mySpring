package com.tqy.document.reader.extention.demo6;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-05-30 10:32
 */
public class Demo6test {
    private static final Logger LOGGER = Logger.getLogger( Demo6test.class );
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/tqy/document/reader/extention/demo6/demo6.xml");
        RedisTest redisTest = (RedisTest)ac.getBean("redisTest");
        LOGGER.debug("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        LOGGER.warn("bbbbbbbbbbbbbbbbbbbbbbb");

        redisTest.test2("提取");

        LOGGER.info(redisTest.test());

    }
}
