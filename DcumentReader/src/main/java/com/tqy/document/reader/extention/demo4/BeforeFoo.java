package com.tqy.document.reader.extention.demo4;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author tengqingya
 * @create 2019-04-12 18:35
 */
public class BeforeFoo implements MethodBeforeAdvice {

    @Override
    public void before( Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before ");
    }
}