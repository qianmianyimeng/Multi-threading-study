import java.lang.ref.WeakReference;

//在缓存中使用可以减少OOM发生的可能
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1=new Object();
        WeakReference<Object> weakReference=new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1=null;
        System.gc();
        System.out.println("******************");

        System.out.println(o1); //null
        //弱引用只要一触发GC，而且GCRoots不可达就回收
        System.out.println(weakReference.get());    //null
    }
}
