import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 =new Object();
        ReferenceQueue<Object> referenceQueue=new ReferenceQueue();//被回收前，需要被引用队列保存一下
        WeakReference<Object> weakReference =new WeakReference<>(o1,referenceQueue);//传入对象和一个队列

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());  //没有GC前，为null

        System.out.println("********************");

        o1=null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());  //GC后，会被装到引用队列

    }
}
