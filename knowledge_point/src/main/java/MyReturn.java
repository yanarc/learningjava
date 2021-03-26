import org.junit.Test;

/*
* （1）异常体系中，若finally代码块中存在return语句，则try、catch语句失效。
  （2）若finally无return，try有return语句，则try代码块先暂存代码块中的值，
* 然后在代码块中还是该进行怎样的操作就进行怎样的操作，变量的值该怎么变化就怎么变化，
* 最后执行finally代码块，只不过最终返回的是try语句块中的暂存值。
  原文链接：https://blog.csdn.net/fll980205/article/details/99829823
*
* */
public class MyReturn {
    public static void main(String[] args) {
        MyReturn myReturn = new MyReturn();
        int myretun = myReturn.mytest();
        System.out.println(myretun);
    }

    public int mytest() {
        int i = 1;
        try {
            i = 2;
            System.out.println("try:" + i);
            int x = i / 0;
            System.out.println("reach：" + i);
            return i;
        } catch (Exception e) {
            i = 3;
            System.out.println("catch:" + i);
            return i;
        } finally { // 要明确的是Finally中用到的是对应信息的副本
            i = 4;
            System.out.println("finally:" + i);
            return i;
//        return 5;
        }
    }

}

