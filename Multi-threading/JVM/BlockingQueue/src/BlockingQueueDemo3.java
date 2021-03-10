import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo3 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(3);

        //offer(e,long,timeUnit) 是超时类
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
    }
}
