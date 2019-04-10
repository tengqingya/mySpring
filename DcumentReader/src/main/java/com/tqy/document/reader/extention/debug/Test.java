package com.tqy.document.reader.extention.debug;

import com.tqy.document.reader.extention.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-04-10 16:37
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext( new String[] {"classpath*:applicationContext.xml"});
        TestService testService = (TestService)xmlApplicationContext.getBean("testService");
        out.println(testService.test("aaa"));

    }
}
