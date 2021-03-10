import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue blockingQueue=new SynchronousQueue();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put a");
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName()+"\t put b");
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName()+"\t put c");
                blockingQueue.put("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                try {
                    TimeUnit.SECONDS.sleep(5);
                }catch (Exception e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t take a");
                blockingQueue.take();
                try {
                    TimeUnit.SECONDS.sleep(5);
                }catch (Exception e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t take b");
                blockingQueue.take();
                try {
                    TimeUnit.SECONDS.sleep(5);
                }catch (Exception e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t take c");
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
    }
}
