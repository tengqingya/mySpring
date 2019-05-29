package com.tqy.document.reader.extention.demo4;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author tengqingya
 * @create 2019-05-04 13:26
 */
public class Demo4Main {
    public static void main(String[] args){
        //https://segmentfault.com/q/1010000009997165
        Foo foo = new Foo();
        BeforeAdvice advice = new BeforeFoo();
        ProxyFactory pf = new ProxyFactory();
//        pf.setOptimize(true);
        pf.setProxyTargetClass(true);//启用Cglib2AopProxy创建代理
        pf.setTarget(foo);
        pf.addAdvice(advice);
        Foo foo2 = (Foo) pf.getProxy();
        foo2.fun1();
    }
}
