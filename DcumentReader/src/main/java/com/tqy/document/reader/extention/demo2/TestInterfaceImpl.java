package com.tqy.document.reader.extention.demo2;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-04-29 15:41
 */
public class TestInterfaceImpl implements TestInterface {
    @Override
    public String getHalloWorld() {
        out.println("hello");
        return "hello";
    }
}
