package com.tqy.document.reader.extention.demo5;

/**
 * @author tengqingya
 * @create 2019-05-30 9:58
 */
public class TestGCRoots03 {
    private static int _10MB = 10 * 1024 * 1024;
    private static final TestGCRoots03 t = new TestGCRoots03(8 * _10MB);
    private byte[] memory;

    public TestGCRoots03(int size) {
        memory = new byte[size];
    }

    /**
     * [GC (System.gc()) [PSYoungGen: 146473K->840K(458752K)] 146473K->82768K(983040K), 0.0406743 secs] [Times: user=0.19 sys=0.03, real=0.04 secs]
     * [Full GC (System.gc()) [PSYoungGen: 840K->0K(458752K)] [ParOldGen: 81928K->82596K(524288K)] 82768K->82596K(983040K), [Metaspace: 3274K->3274K(1056768K)], 0.0167332 secs] [Times: user=0.09
     * sys=0.00, real=0.02 secs]
     * Heap
     *  PSYoungGen      total 458752K, used 3932K [0x00000000e0000000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 393216K, 1% used [0x00000000e0000000,0x00000000e03d7218,0x00000000f8000000)
     *   from space 65536K, 0% used [0x00000000f8000000,0x00000000f8000000,0x00000000fc000000)
     *   to   space 65536K, 0% used [0x00000000fc000000,0x00000000fc000000,0x0000000100000000)
     *  ParOldGen       total 524288K, used 82596K [0x00000000c0000000, 0x00000000e0000000, 0x00000000e0000000)
     *   object space 524288K, 15% used [0x00000000c0000000,0x00000000c50a9168,0x00000000e0000000)
     *  Metaspace       used 3281K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 359K, capacity 388K, committed 512K, reserved 1048576K
     * @param args
     */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                TestGCRoots03 t3 = new TestGCRoots03(4 * _10MB);
                t3 = null;
                System.gc();
            }
        }).start();
        try {
            Thread.sleep(1111);
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }
        System.gc();
    }
}
/**
 * 常量
 * 解释
 * 第一次Minor GC后，年轻代少了140M，其中40M的成员变量，80M的常量，堆的总内存从140M降低到80M，说明常量被放到了老年代。其余40M的成员变量和20M的额外的内存占用被回收
 * 第一次full gc，年轻代几乎不变，老年代的80M没有被回收，说明常量可以作为gc root(由于常量必须初始化且无法在后期修改，所以，常量会永远无法被gc)
 */
