package com.tqy.document.reader.extention.demo3;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-04-13 18:55
 */
public class Parent {
    public void say(){
        out.println("parent say");
        this.hello();
        hello();
    }
    public void hello(){
        out.println("parent hello");
    }

    public void bye(){
        out.println("parent bye");
    }
}
