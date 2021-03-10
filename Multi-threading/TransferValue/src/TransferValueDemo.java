class Person{
    String PersonName;

    public Person(String abc) {

}
    public String getPersonName() {
        return PersonName;
    }
    public void setPersonName(String personName) {
        PersonName = personName;
    }
}

public class TransferValueDemo {

    public void changeValue1(int age){
        age=30;
    }
    public void changeValue2(Person person){
        person.setPersonName("xxx");
    }
    public void changeValue3(String string){
        string="xxx";
    }

    public static void main(String[] args) {
        TransferValueDemo transferValueDemo = new TransferValueDemo();;
        int age=20;
        transferValueDemo.changeValue1(age);
        System.out.println("age----"+age);

        Person person =new Person("abc");
        transferValueDemo.changeValue2(person);
        System.out.println("personName----"+person.getPersonName());

        String string ="abc";
        transferValueDemo.changeValue3(string);
        System.out.println("String----"+string);
    }
}
