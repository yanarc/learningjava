import java.util.concurrent.TimeUnit;

public class DeadLock {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        DeadLock deadLock = new DeadLock();
        new Thread(new MyThread(a,b), "ThreadA").start();
        new Thread(new MyThread(b,a), "ThreadB").start();
    }
}

class MyThread implements Runnable{
    String a;
    String b;

    public MyThread(String a, String b){
        this.a = a;
        this.b = b;
    }

    public void run() {
        synchronized(a){
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(2L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
