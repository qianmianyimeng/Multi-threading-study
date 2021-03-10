//import net.sf.cglib.proxy.Enhancer;
//视频p87
public class MetaSpaceDemo {
    static class OOM{}

    public static void main(String[] args) {
        int i =0;//模拟多少次计数以后发生异常

        try {
            while (true)
            {
                i++;

            }
        } catch (Exception e) {
            System.out.println("***************多少次后发生异常"+i);
            e.printStackTrace();
        }
    }
}
