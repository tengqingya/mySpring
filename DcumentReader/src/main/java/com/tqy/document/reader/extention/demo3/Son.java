package com.tqy.document.reader.extention.demo3;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-04-13 18:56
 */
public class Son extends Parent {
    @Override
    public void say() {
        super.say();
    }

    @Override
    public void hello() {
        out.println("son hello");
    }

    @Override
    public void bye(){
        out.println("son bye");
    }
}
