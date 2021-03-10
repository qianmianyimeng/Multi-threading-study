public class MyObject {
    public static void main(String[] args) {

        //启动类加载器(Bootstrap) C++
        //扩展类加载器(Extension) Java
        //应用程序加载器(AppClassLoader) Java也叫系统类加载器，加载当前应用的classpath的所有类


        Object object =new Object();
        System.out.println(object.getClass().getClassLoader().getParent().getParent());
        System.out.println(object.getClass().getClassLoader().getParent());
        System.out.println(object.getClass().getClassLoader());     //null

        System.out.println();
        System.out.println();
        System.out.println();

        MyObject myObject =new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());   //null
        System.out.println(myObject.getClass().getClassLoader().getParent());   //sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println(myObject.getClass().getClassLoader());   //sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
