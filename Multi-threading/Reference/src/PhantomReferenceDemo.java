import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

        //很少使用
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object o1=new Object();
        //虚引用一般需要与ReferenceQueue配合使用，其余三种没有也可以使用
        ReferenceQueue<Object> referenceQueue =new ReferenceQueue<>();
        //创建引用的时候可以指定关联的队列，当GC释放对象内存的时候，会将引用加入到引用队列
        PhantomReference<Object> phantomReference =new PhantomReference<>(o1,referenceQueue);   //监控对象o1的回收信息(相当于是一种通知机制)

        System.out.println(o1);
        System.out.println(phantomReference.get()); //虚引用的get()方法总是返回null
        System.out.println(referenceQueue.poll());

        System.out.println("*********************");

        o1=null;        //单单置空无法将虚引用放到队列中,弱引用也是如此
        System.gc();    //只要产生GC虚引用就会被放到队列里面，

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

    }
}
