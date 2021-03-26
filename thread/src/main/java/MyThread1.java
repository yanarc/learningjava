/**
 * 多线程的创建方式
 */
public class MyThread1 extends Thread{
    // 空参构造器
    public MyThread1(){};

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread() + " : " + i);
        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();
        MyThread1 myThread3 = new MyThread1();
        MyThread1 myThread4 = new MyThread1();
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
    }
}
