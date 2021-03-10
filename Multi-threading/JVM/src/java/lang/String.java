package java.lang;

/*
* 当一个类收到类加载请求，他首先不会尝试自己去加载这个类，而是把这个请求委派给父类去完成，
* 每一个层次类加载器都是如此，因此所有的加载请求都应该传送到启动类加载其中，只有当父类加载器反馈自己无法完成这个请求的时候，
* （在他的加载路径下没有找到所需加载的Class），子类加载器才会尝试自己去加载
* */


/*
    错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
    public static void main(String[] args)
     否则 JavaFX 应用程序类必须扩展javafx.application.Application
*/

public class String {
    public static void main(String[] args) {
        System.out.println("*****");
    }
}
