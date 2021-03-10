import java.util.concurrent.TimeUnit;

//-Xms  等价于-XX:InitialHeapSize
//两个一般设置为同一个数，防止堆内存空间忽高忽低
//-Xmx  等价于-XX:MaxHeapSize

//-Xss  设置栈空间的大小，等价于-XX:ThreadStackSize  0代表用的是默认值

//Xmn   设置年轻代大小，一般就用默认值

//-XX:MetaspaceSize 设置元空间的大小，初始多为20m

//-XX:+PrintGCDetails   打印GC信息

//-XX:SurvivorRatio=8,Eden: S0:S1=8:1:1     设置的是伊甸区的占比
//-XX:SurvivorRatio=4,Eden: S0:S1=4:1:1     设置的是伊甸区的占比

//-XX:NewRatio=2新生代占1，老年代占2，年轻代占整个堆的1/3     NewRatio值就是设置老年代的占比，剩下的1给新生代
//-XX:NewRatio=4新生代占1，老年代占4，年轻代占整个堆的1/5

//-XX:MaxTenuringThreshold=15  设置垃圾最大年龄，java8之后范围是0~15，默认15


public class GG {
    public static void main(String[] args) {
        System.out.println("*******************");
//        try {
//            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}