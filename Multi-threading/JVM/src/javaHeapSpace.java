//jinfo -flag  xxx   端口号

//-Xms10m -Xmx10m -XX:+UseSerialGC  使用串行回收器

//-Xms10m -Xmx10m -XX:+UseParallelGC  使用串行回收器

//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC    (PSYoungGen+ParOldGen)
//两个相互绑定，JDK1.8为例，不加就是默认(PSYoungGen+ParOldGen)
//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC (PSYoungGen+ParOldGen)

//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC (par new generation + concurrent mark-sweep)

//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC  G1垃圾回收器
/*
* */

//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC   已经被淘汰了


import java.util.Random;

public class javaHeapSpace {
    public static void main(String[] args) {
        String str="*************";
        while(true)
        {
            str += str +new Random().nextInt(999999999)+ new Random().nextInt(9999999);
        }

        //byte[] bytes =new byte[20*1024*1024];
    }

}
