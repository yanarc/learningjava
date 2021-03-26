public class FinallyTest {
    public static void main(String[] args) {
        FinallyTest finallyTest = new FinallyTest();
        int myreturn = finallyTest.mytest(1);
        System.out.println("输出的是："+myreturn);
        System.out.println(1<<1);
    }

    public static int mytest(int a){
        int i = a;
        try {
            i = 2;
            i /=0;
            System.out.println("try里面的i="+i);
            return i;
        } catch (Exception e) {
            i = 3;
            System.out.println("catch里面的i="+i);
            return i;
        } finally {
            i = 4;
            System.out.println("finally里面的i="+i);
            return i;
        }
    }
}
