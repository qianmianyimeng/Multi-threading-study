import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean FLAG=true;
    private AtomicInteger atomicInteger =new AtomicInteger();
    BlockingQueue<String> blockingQueue =null;
    //参数设置为接口，传参传接口
    public MyResource(BlockingQueue<String> blockingQueue)
    {
        this.blockingQueue=blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    public void myProd()throws Exception
    {
        String data =null;
        boolean retValue;
        while(FLAG)
        {
            data=atomicInteger.incrementAndGet()+"";
            retValue= blockingQueue.offer(data,2l, TimeUnit.SECONDS);
            if (retValue)
            {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 生产停止，true变为false ");
    }
    public void myConsumer()throws Exception
    {
        String result = null;
        while (FLAG)
        {
            result=blockingQueue.poll(6,TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase(""))
            {
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"超过6秒没有消费，生产退出");
                System.out.println();
                return;
            }
            TimeUnit.SECONDS.sleep(3);
            //无序性，可能会打印在生产之前，可以用睡眠象征性的控制一下
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
        }
    }
    public void stop()throws Exception{
        this.FLAG=false;
    }
}

public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws Exception {
        //传入具体类
        MyResource myResource =new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产对列启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费对列启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("60秒钟到，结束");
        myResource.stop();
    }
}
