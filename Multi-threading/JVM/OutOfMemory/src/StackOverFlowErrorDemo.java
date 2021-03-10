public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        stackOverFlowError();
    }

    //Exception in thread "main" java.lang.StackOverflowError
    private static void stackOverFlowError() {
        stackOverFlowError();
    }
}
