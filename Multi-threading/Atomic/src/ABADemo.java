import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
   static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        int stamp=atomicStampedReference.getStamp();
        new Thread(()->{
            //System.out.println(Thread.currentThread().getName()+"\t"+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            atomicStampedReference.compareAndSet(101,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
        },"t1").start();

        new Thread (()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+"修改是否成功"+result+"当前实际版本号"+atomicStampedReference.getStamp());
        },"t2").start();

    }
}
