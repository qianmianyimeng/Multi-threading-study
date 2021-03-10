import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int number = 0;

    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger =new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}
public class volatileDemo {

    public static void main(String[] args)
    {
        MyData myData= new MyData();
        for (int i = 1; i <=20 ; i++)

            {
                new Thread(() ->{
                    for (int j = 1; j <=1000 ; j++) {
                        myData.addPlusPlus();  //不保证原子性
                        myData.addAtomic();     //保证原子性
                    }
                },String.valueOf(i)).start();
            }
            while (Thread.activeCount()>2){
                Thread.yield();
            }


        System.out.println(Thread.currentThread().getName()+"\t int type, finally number value:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type finally number value:"+myData.atomicInteger);
    }


}
