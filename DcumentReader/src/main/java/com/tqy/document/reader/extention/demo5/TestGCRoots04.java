package com.tqy.document.reader.extention.demo5;

/**
 * @author tengqingya
 * @create 2019-05-30 10:09
 */
public class TestGCRoots04 {
    private static int _10MB = 10 * 1024 * 1024;
    private TestGCRoots04 t;
    private byte[] memory;

    public TestGCRoots04(int size) {
        memory = new byte[size];
    }

    /**
     * [GC (System.gc()) [PSYoungGen: 146473K->872K(458752K)] 146473K->880K(983040K), 0.0009470 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 872K->0K(458752K)] [ParOldGen: 8K->676K(524288K)] 880K->676K(983040K), [Metaspace: 3276K->3276K(1056768K)], 0.0034223 secs] [Times: user=0.00 sys=0.00,
     * real=0.00 secs]
     * Heap
     *  PSYoungGen      total 458752K, used 3932K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 393216K, 1% used [0x00000000e0000000,0x00000000e03d7218,0x00000000f8000000)
     *   from space 65536K, 0% used [0x00000000f8000000,0x00000000f8000000,0x00000000fc000000)
     *   to   space 65536K, 0% used [0x00000000fc000000,0x00000000fc000000,0x0000000100000000)
     *  ParOldGen       total 524288K, used 676K [0x00000000c0000000, 0x00000000e0000000, 0x00000000e0000000)
     *   object space 524288K, 0% used [0x00000000c0000000,0x00000000c00a9148,0x00000000e0000000)
     *  Metaspace       used 3283K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 359K, capacity 388K, committed 512K, reserved 1048576K
     * @param args
     */
    public static void main(String[] args) {
        TestGCRoots04 t4 = new TestGCRoots04(4 * _10MB);
        t4.t = new TestGCRoots04(8 * _10MB);
        t4 = null;
        System.gc();
    }
}

/**
 * 成员变量
 * 解释
 * 第一次Minor GC后，80M和40M的内存都被清空
 * 第一次full gc，没有做额外的清理大内存控件的工作
 */
