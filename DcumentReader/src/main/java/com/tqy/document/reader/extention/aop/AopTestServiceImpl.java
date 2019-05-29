package com.tqy.document.reader.extention.aop;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-04-12 17:41
 */
public class AopTestServiceImpl implements  AopTestService {
    public void testNoAop(){
        sayHello("jdk no aop tqy ");
    }
    @Override
    public void sayHello( String a ) {
        out.println(a + "jdk  hello");
    }

    public void testIsAop(){
        sayHello("jdk is aop ?");
    }
}
