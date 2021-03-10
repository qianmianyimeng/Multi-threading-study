//jinfo -flag  xxx   端口号

//-Xms10m -Xmx10m -XX:+UseSerialGC  使用串行回收器

//-Xms10m -Xmx10m -XX:+UseParallelGC  使用串行回收器

//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC    (PSYoungGen+ParOldGen)
//两个相互绑定，JDK1.8为例，不加就是默认(PSYoungGen+ParOldGen)
//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC (PSYoungGen+ParOldGen)

//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC (par new generation + concurrent mark-sweep)


//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC  G1垃圾回收器
/*
* -XX:UseG1GC
* -XX:G1HeapRegionSize=n:设置的G1区域的大小。值是2的幂，范围是1MB~32MB。目标是根据最小的java堆大小划分出约2048个区域。
* -XX:MaxGCPauseMillis=n:最大GC停顿时间，这是个软目标，JVM将尽可能(但不保证)停顿小于这个时间
* -XX:InitiatingHeapOccupancyPercent=n:堆占用了多少的时候就触发GC，默认为45
* -XX:ConcGCThreads=n:并发GC使用的线程数
* -XX:G1ReservePercent=n:设置作为空闲空间的预留内存百分比，以降低目标空间溢出的风险，默认是10%
* */


//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC   已经被淘汰了



public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("******");
        //Thread.sleep(Integer.MAX_VALUE);

        for(int i = 0; i< 5;i++) {
            new Thread(new Runnable() {
                public void run() {

                    try {
                        Thread.sleep(Integer.MAX_VALUE);
                    } catch(Exception e) {

                    }
                }}).start();
        }
    }
}
