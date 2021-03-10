public class UnableToCreateNewNativeThreadDemo {
    //别运行，会卡出去
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            System.out.println("****************i="+i);
            new Thread(()->{
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },""+i).start();
        }
    }
}
