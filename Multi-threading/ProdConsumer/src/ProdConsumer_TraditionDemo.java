import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private int number = 0;
    private Lock lock =new ReentrantLock();
    private Condition condition =lock.newCondition();

    public void increment()throws Exception{
        lock.lock();
        try{
            while (number!=0){
                condition.await();
            }
            //数字为0时，+1
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        //当数字非0时，挂起

    }
    public void decrement()throws Exception{
        //当数字非0时，挂起
        lock.lock();
        try{
            while (number==0){
                condition.await();
            }
            //数字为0时，+1
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}

public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData =new ShareData();
        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try{
                    shareData.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try{
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }


}
