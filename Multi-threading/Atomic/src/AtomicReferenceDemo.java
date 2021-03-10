import java.util.concurrent.atomic.AtomicReference;

class User {
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        String userName;
        int age;

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    '}';
        }

        public User(String userName, int age){
        this.userName=userName;
        this.age=age;
    }
}
public class AtomicReferenceDemo
{
    public static void main(String[] args)
    {
        User z3=new User("z3",22);
        User li4=new User("li4",44);

        AtomicReference<User> atomicReference =new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());//CAS比较与交换


    }
}
