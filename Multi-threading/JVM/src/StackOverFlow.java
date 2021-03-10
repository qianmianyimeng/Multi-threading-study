public class StackOverFlow {

    //是错误，不是异常

    public static void m1(){
        System.out.println("********");
        m1();
    }
    public static void main(String[] args) {
        m1();
    }
}
