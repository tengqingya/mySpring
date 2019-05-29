package com.tqy.document.reader.extention.demo1;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author tengqingya
 * @create 2019-04-23 12:50
 */
public class TestCGLibMain {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\gitCode\\mySpring\\DcumentReader\\src\\main\\java\\com\\tqy\\document\\reader\\extention\\demo1");

        TestCGLib testCGLib = new TestCGLib();
        TestInterface o = (TestInterface) testCGLib.getInstance(TestInterface.class);
        System.out.println(o.getHalloWorld());
    }
}
