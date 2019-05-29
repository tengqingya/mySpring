package com.tqy.document.reader.extention.aop;

import com.tqy.document.reader.extention.demo3.Parent;
import com.tqy.document.reader.extention.demo3.Son;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-04-12 17:41
 */
public class myMain {
    public static void main(String[] args){
        AopTestService aopTestService = new AopTestServiceImpl();
//        AopTestService proxyInstance = (AopTestService)Proxy.newProxyInstance(AopTestService.class.getClassLoader(), AopTestService.class.getInterfaces(), new MyHandler(aopTestService));
        //为什么上面的写法不可以
        AopTestService proxyInstance = (AopTestService)Proxy.newProxyInstance(AopTestService.class.getClassLoader(), aopTestService.getClass().getInterfaces(), new MyHandler(aopTestService));
        //jdk动态代理只能强转为接口，不能强转为实现类，因为他只实现了接口
        proxyInstance.testNoAop();

        ( (AopTestServiceImpl)aopTestService ).testIsAop();

        //-------------------------------------


        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AopTestServiceImpl2.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept( Object obj, Method method, Object[] args, MethodProxy proxy)
                    throws Throwable {
//                method.invoke(obj,args); 会死循环
                out.println("enhancer by cglib 调用代理对象的方法开始");
                proxy.invokeSuper(obj,args);
                out.println("enhancer by cglib 调用代理对象的方法结束");
//                out.println("enhancer by cglib 调用原始对象的方法开始");
//                proxy.invoke(new AopTestServiceImpl2(),args);
//                out.println("enhancer by cglib 调用原始对象的方法结束");
                return null;
            }
        });
        AopTestServiceImpl2 proxy = (AopTestServiceImpl2) enhancer.create();
        proxy.testIsAop();

//https://blog.csdn.net/makecontral/article/details/79593732

//        net.sf.cglib.proxy.Enhancer enhancer1 = new net.sf.cglib.proxy.Enhancer();
//        enhancer1.setSuperclass(AopTestServiceImpl2.class);
//        enhancer1.setCallback(new net.sf.cglib.proxy.MethodInterceptor() {
//            @Override
//            public Object intercept( Object o, Method method, Object[] objects, net.sf.cglib.proxy.MethodProxy methodProxy ) throws Throwable {
////                method.invoke(o,objects); //会死循环
////                out.println("enhancer by original cglib 调用代理对象的方法开始");
////                methodProxy.invokeSuper(o,objects);
////                out.println("enhancer by original cglib 调用代理对象的方法结束");
//                out.println("enhancer by original cglib 调用原始对象的方法开始");
//                methodProxy.invoke(new AopTestServiceImpl2(),objects);
//                out.println("enhancer by original cglib 调用原始对象的方法结束");
//                return null;
//            }
//        });

//        AopTestServiceImpl2 proxy2 = (AopTestServiceImpl2) enhancer1.create();
//        proxy2.testIsAop();

    }
}
