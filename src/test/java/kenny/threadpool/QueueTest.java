package kenny.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueTest {

    @Test
    public void arrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("add value into queue: " + i);
        }
    }

    @Test
    public void linkedBlockingQueue() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("add value into queue: " + i);
        }
    }
    @Test
    public void synchronousQueue() {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("add successfully");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                queue.take();
                System.out.println("remove successfully");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
