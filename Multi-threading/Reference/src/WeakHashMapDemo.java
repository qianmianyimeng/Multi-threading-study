import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashmap();
        System.out.println("********************");
        myWeakHashmap();
    }

    //弱key，置空后GC直接回收
    private static void myWeakHashmap() {
        WeakHashMap<Integer,String> map =new WeakHashMap<>();
        Integer key =new Integer(2);
        String value ="WeakHashMap";

        map.put(key,value);
        System.out.println(map);

        key =null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());
    }

    private static void myHashmap() {
        HashMap<Integer,String> map =new HashMap<>();
        Integer key =new Integer(1);
        String value ="HashMap";

        map.put(key,value);
        System.out.println(map);

        key =null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());

    }
}
