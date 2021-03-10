import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//写需要严格控制原子性，读不需要
//资源类
    class MyCache{
    private volatile Map<String,Object> map =new HashMap<>();
    //private Lock lock=new ReentrantLock();    //不能用ReentrantLock，虽然保证了原子性，但是并发性下降
    private ReentrantReadWriteLock rwLock =new ReentrantReadWriteLock();//没用这个的时候，会写时挂起，不报错但是会有未写入完成就开始读，读为null的情况
    public void put(String key,Object value)
    {
        rwLock.writeLock().lock();//调用ReentrantReadWriteLock的方法
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch (Exception e){e.printStackTrace();}finally {
            rwLock.writeLock().unlock();
        }


    }

        public void get(String key)
        {
            rwLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName()+"\t 正在读取");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object result = map.get(key);
                System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
            }catch (Exception e){e.printStackTrace();}finally {
                rwLock.readLock().unlock();
            }

        }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache=new MyCache();
        for (int i = 1; i <=5 ; i++)
        {
            final int intTamp=i;
            new Thread(()->{
                myCache.put(intTamp+"",intTamp+"");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <=5 ; i++)
        {
            final int intTamp=i;
            new Thread(()->{
                myCache.get(intTamp+"");
            },String.valueOf(i)).start();
        }
    }


}