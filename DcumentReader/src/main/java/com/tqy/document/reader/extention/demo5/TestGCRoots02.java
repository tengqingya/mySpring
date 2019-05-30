package com.tqy.document.reader.extention.demo5;

/**
 * @author tengqingya
 * @create 2019-05-30 9:39
 */
public class TestGCRoots02 {
    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memory;

    private static TestGCRoots02 t;

    public TestGCRoots02(int size) {
        memory = new byte[size];
    }

    /**
     * [GC (System.gc()) [PSYoungGen: 166953K->62280K(458752K)] 166953K->62288K(983040K), 0.0378540 secs] [Times: user=0.20 sys=0.03, real=0.04 secs]
     * [Full GC (System.gc()) [PSYoungGen: 62280K->0K(458752K)] [ParOldGen: 8K->62116K(524288K)] 62288K->62116K(983040K), [Metaspace: 3276K->3276K(1056768K)], 0.0502749 secs] [Times: user=0.05
     * sys=0.22, real=0.05 secs]
     * Heap
     *  PSYoungGen      total 458752K, used 3932K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 393216K, 1% used [0x00000000e0000000,0x00000000e03d7218,0x00000000f8000000)
     *   from space 65536K, 0% used [0x00000000f8000000,0x00000000f8000000,0x00000000fc000000)
     *   to   space 65536K, 0% used [0x00000000fc000000,0x00000000fc000000,0x0000000100000000)
     *  ParOldGen       total 524288K, used 62116K [0x00000000c0000000, 0x00000000e0000000, 0x00000000e0000000)
     *   object space 524288K, 11% used [0x00000000c0000000,0x00000000c3ca9168,0x00000000e0000000)
     *  Metaspace       used 3283K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 359K, capacity 388K, committed 512K, reserved 1048576K
     * @param args
     */
    public static void main(String[] args) {
        TestGCRoots02 t2 = new TestGCRoots02(8 * _10MB);
        t2.t = new TestGCRoots02(6 * _10MB);
        t2 = null;
        System.gc();
    }
}

/**
 * 静态成员变量
 * 解释
 * 第一次Minor GC后，年轻代少了100M，总堆内存少了100M，说明，年轻代少的100M是被垃圾回收了(其中包括80M成员变量),但是年轻代里面还有60M，说明第一次minor gc，可作为gc root的static成员变量没有被放到老年代
 * 第一次full gc，年轻代的60M被清空，老年代增加了60M，并且总堆内存维持60M不变，说明static成员变量作为gc root没有随着t2的回收而被回收。
 *
 */
