package hw3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private static int count = 0;
    private static Lock lock;

    public int increment(){
        return count++;
    }

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
