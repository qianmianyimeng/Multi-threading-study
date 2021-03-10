import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =new ArrayBlockingQueue<>(3);
        //add 抛出异常  offer 特殊值

        //System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        //add进去的值可以poll掉
        //offer的值也可以remove掉
        //System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        //System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.peek());//将a，b移除，剩下头元素c
    }
}
