import java.util.Random;

public class JavaHeapSpaceDemo {

    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public static void main(String[] args) {
        String str="*************";
        while(true)
        {
            str += str +new Random().nextInt(999999999)+ new Random().nextInt(9999999);
        }


    }
}
