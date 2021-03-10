import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread2 implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("**************come in, CallAble");
        TimeUnit.SECONDS.sleep(5);
        return 1024;
    }
}

public class CallAbleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Thread t1 =new Thread();
        //t1.start();
        //Thread(Runnable target,String name)
        FutureTask<Integer> futureTask= new FutureTask<>(new MyThread());
        new Thread(futureTask,"AA").start();
        new Thread(futureTask,"BB").start();//多个线程抢一个task，结果只计算一次
        //int result2=futureTask.get();//要求获得callAble线程的计算结果，如果没有计算完成就要去强求，会导致阻塞，直到计算完成,建议放在最后，

        System.out.println(Thread.currentThread().getName()+"++++++++++++++++++++");
        int result1=100;

      /*  //另一种方法
        while (!futureTask.isDone()){

        }
      */
        int result2=futureTask.get();//要求获得callAble线程的计算结果，如果没有计算完成就要去强求，会导致阻塞，直到计算完成,建议放在最后，有充足的时间给他执行

        System.out.println(result1+result2);
    }
}
