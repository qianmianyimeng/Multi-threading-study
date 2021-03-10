import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafeDemo {
    public static void main(String[] args)
    {
        //List<String> list =new ArrayList<>();     //1.会导致java.util.ConcurrentModificationException
        //导致原因：并发争抢导致，写未完成，被挂起
        //List<String> list =new Vector<>();        //2.Vector
        //List<String> list = Collections.synchronizedList(new ArrayList<>());      //3.Collections.synchronizedList(new ArrayList<>())

        List<String> list=new CopyOnWriteArrayList<>(); //还有Set类，map类，都是非线程安全的类

        //Set<String> set =Collections.synchronizedSet(new HashSet<>());    CopyOnWriteArraySet
        //Map<String,String> map =new ConcurrentHashMap<>();

        //HashSet的底层是HashMap，Hashset调用add时填入的值是，map的key，值的默认值是PRESENT


        for (int i = 1; i <=30 ; i++)
        {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
