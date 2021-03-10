import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue(3);

        //put 阻塞队列
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        System.out.println("三个a");
        //blockingQueue.put("a");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

    }
}
