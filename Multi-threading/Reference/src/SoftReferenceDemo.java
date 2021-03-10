import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    //在缓存中使用可以减少OOM发生的可能
    public static void softRef_Memory_Enough()
    {
        Object o1 =new Object();
        SoftReference<Object> softReference =new SoftReference<>(o1);

        System.out.println(o1);     //有内存地址
        System.out.println(softReference.get());       //有内存地址

        o1=null; //置空
        System.gc();

        System.out.println(o1);     //null
        System.out.println(softReference.get());       //有内存地址
    }


    //内存够用就留着，不够用就回收软引用对象
    public static void softRef_Memory_NotEnough()
    {
        Object o1 =new Object();
        SoftReference<Object> softReference =new SoftReference<>(o1);

        System.out.println(o1);     //有内存地址
        System.out.println(softReference.get());       //有内存地址

        o1=null; //置空

        //VMOption中将堆内存大小设置为了10m
        try {
            byte[] bytes =new byte[20*1024*1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);     //null
            System.out.println(softReference.get());   //null
        }
    }

    public static void main(String[] args) {
        //softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
