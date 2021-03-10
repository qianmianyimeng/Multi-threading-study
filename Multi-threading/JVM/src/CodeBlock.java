class Code{
    public Code(){
        System.out.println("Code的构造方法1111");
    }
    {
        System.out.println("Code的构造块2222");
    }
    static {
        System.out.println("Code的静态代码块3333");
    }
}

public class CodeBlock {
    {
        System.out.println("CodeBlock的构造块444");
    }
    static {
        System.out.println("CodeBlock的静态代码块555");
    }
    public CodeBlock(){
        System.out.println("CodeBlock的构造方法666");
    }

    public static void main(String[] args) {
        System.out.println("====CodeBlock的main方法777");
        new Code();
        System.out.println("-------------------------");
        new Code();
        System.out.println("-------------------------");
        new CodeBlock();
    }
}
