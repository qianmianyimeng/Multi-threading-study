import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo implements Runnable{

    Lock lock =new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        lock.lock();//只要一一配对 在33行
        try{
            System.out.println(Thread.currentThread().getName()+"\t invoked get()");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t ####invoked set()");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            lock.unlock();//只要一一配对 在14行
        }
    }

    public static void main(String[] args) {
        ReentrantDemo reentrantDemo =new ReentrantDemo();
        Thread t1 =new Thread(reentrantDemo,"t1");
        Thread t2 =new Thread(reentrantDemo,"t2");
        t1.start();
        t2.start();
    }

}
