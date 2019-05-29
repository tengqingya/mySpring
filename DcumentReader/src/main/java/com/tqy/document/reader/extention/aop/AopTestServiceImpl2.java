package com.tqy.document.reader.extention.aop;

import net.sf.cglib.proxy.Enhancer;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-04-12 17:41
 */
public class AopTestServiceImpl2  {
    public void testNoAop(){
        sayHello("no aop tqy ");
    }
    public void sayHello( String a ) {
        out.println(a + " hello");
    }
    public void testIsAop(){
        sayHello("is aop ?");
    }
}
