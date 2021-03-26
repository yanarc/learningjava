import java.util.concurrent.locks.Lock;

public class MyLock {
    public static void main(String[] args) {
        Lock lock = (Lock) new Object();
        
        lock.lock();

        lock.unlock();

    }

}
