//DCL(Double Check Lock)

public class doubleCheckLock {
    private static volatile doubleCheckLock instance=null;
    private doubleCheckLock(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法doubleCheckLock()");
    }
    public static doubleCheckLock getInstance(){
        if(instance == null)
            {
                //instance = new doubleCheckLock();//
                synchronized (doubleCheckLock.class)//加上限制，没有了多个构造方法
                {
                if (instance == null)
                    {
                    instance = new doubleCheckLock();
                   }
                }
            }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <=10 ; i++) {
            new Thread(()->{
                doubleCheckLock.getInstance();
            },String.valueOf(i)).start();

        }
    }
}
