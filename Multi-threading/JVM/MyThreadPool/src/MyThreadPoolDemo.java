import org.omg.SendingContext.RunTime;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool=new ThreadPoolExecutor(
                2,
                80,//比如8核cpu：8/1-0.9=80个线程数，阻塞系数一般为0.8~0.9之间 || 2*cpu核数
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
                //ThreadPoolExecutor.CallerRunsPolicy();
                //ThreadPoolExecutor.DiscardOldestPolicy();
                 //ThreadPoolExecutor.DiscardPolicy();

        try{
            // AbortPolicy中i最大为12
            for (int i = 1; i <=20 ; i++) {
                threadPool.execute(()-> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                //暂停一会线程，模拟网络拥堵
                //TimeUnit.MILLISECONDS.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }


        public static void threadPoolInit()
        {
        //ExecutorService threadPool= Executors.newFixedThreadPool(5);//一池5个处理线程
        //ExecutorService threadPool= Executors.newSingleThreadExecutor();//一池1个处理线程
        //ExecutorService threadPool= Executors.newCachedThreadPool();//一池N个处理线程
    }
}
