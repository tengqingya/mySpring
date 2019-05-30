package com.tqy.document.reader.extention.demo5;

/**
 * @author tengqingya
 * @create 2019-05-29 17:48
 */
public class TestGCRoots01 {
    //https://blog.csdn.net/liao0801_123/article/details/83022647
    private int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];

    /**
     *
     * [GC (System.gc()) [PSYoungGen: 105513K->808K(458752K)] 105513K->82736K(983040K), 0.0396199 secs] [Times: user=0.22 sys=0.01, real=0.04 secs]
     * [Full GC (System.gc()) [PSYoungGen: 808K->0K(458752K)] [ParOldGen: 81928K->82596K(524288K)] 82736K->82596K(983040K), [Metaspace: 3275K->3275K(1056768K)], 0.0189096 secs] [Times: user=0.08
     * sys=0.00, real=0.02 secs]
     * 第一次GC完成
     * 返回main方法
     * [GC (System.gc()) [PSYoungGen: 7864K->96K(458752K)] 90460K->82692K(983040K), 0.0021218 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 96K->0K(458752K)] [ParOldGen: 82596K->659K(524288K)] 82692K->659K(983040K), [Metaspace: 3277K->3277K(1056768K)], 0.0051218 secs] [Times: user=0.00
     * sys=0.00, real=0.01 secs]
     * 第二次GC完成
     * Heap
     *  PSYoungGen      total 458752K, used 19661K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 393216K, 5% used [0x00000000e0000000,0x00000000e13334c8,0x00000000f8000000)
     *   from space 65536K, 0% used [0x00000000fc000000,0x00000000fc000000,0x0000000100000000)
     *   to   space 65536K, 0% used [0x00000000f8000000,0x00000000f8000000,0x00000000fc000000)
     *  ParOldGen       total 524288K, used 659K [0x00000000c0000000, 0x00000000e0000000, 0x00000000e0000000)
     *   object space 524288K, 0% used [0x00000000c0000000,0x00000000c00a4ee8,0x00000000e0000000)
     *  Metaspace       used 3284K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 359K, capacity 388K, committed 512K, reserved 1048576K
     * @param args
     */
    public static void main( String[] args ) {
        method01();
        System.out.println("返回main方法");
        System.gc();
        System.out.println("第二次GC完成");
    }

    public static void method01() {
        TestGCRoots01 t = new TestGCRoots01();
        System.gc();
        System.out.println("第一次GC完成");
    }
}
/**
 * 局部变量
 * 解释
 * 第一次Minor GC后，年轻代少了100M，总堆内存少了20M，说明，年轻代少的100M有20M是被垃圾回收了，还有80M是被放到老年代了，
 * 说明，局部变量，可以作为gc root（因为作为gc root的变量，在回收的时候只会往老年代移动）
 * 由于第一次gc是在局部变量的作用域范围，所以，gc root一直生效。
 * 第一次full gc，老年代几乎不变，总堆内存几乎不变
 *
 * 第二次Minor GC后，年轻代少了7.5M，总堆内存少了7.5M
 * 第二次full gc后，年轻代几乎不变，老年代少了80M，总堆内存少了80M,说明，局部变量的gc root的范围已过，局部变量可以被gc
 */
