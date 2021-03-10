public class RefCountGC {
    private byte[] bigSize =new byte[2*1024*1024];
    Object instance =null;

    public static void main(String[] args) {
        RefCountGC objectA =new RefCountGC();
        RefCountGC objectB =new RefCountGC();

        objectA.instance=objectB;
        objectB.instance=objectA;

        objectA=null;
        objectB=null;

        System.gc();
    }
}
