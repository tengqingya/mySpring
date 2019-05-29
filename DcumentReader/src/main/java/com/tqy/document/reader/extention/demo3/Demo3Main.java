package com.tqy.document.reader.extention.demo3;

import static java.lang.System.out;

/**
 * @author tengqingya
 * @create 2019-05-04 13:06
 */
public class Demo3Main {
    public static void main(String[] args){
        Son p2 = new Son();
        p2.say();
        p2.bye();

        out.println("--------");
        Parent p3 = new Parent();
        p3.say();
        p3.bye();

        out.println("--------");
        Parent p1 = new Son();
        p1.say();
        p1.bye();


    }
}
