public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1=new Object();   //这样定义的默认就是强引用
        Object obg2=obj1;   //obj2引用赋值
        obj1=null;      //置空
        System.gc();    //手动启动GC
        //空间不够也不回收，死都不收
        System.out.println(obg2);
    }
}
