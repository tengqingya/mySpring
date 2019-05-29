package com.tqy.document.reader.extention.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-04-12 17:38
 */
public class MyHandler implements InvocationHandler {
    private Object target;

    public MyHandler( Object target ) {
        this.target = target;
    }

    @Override
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
        out.println("jdk........................");
        out.println("jdk "+method.getName());
        method.invoke(target,args);
        return null;
    }
}
