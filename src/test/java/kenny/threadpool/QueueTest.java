package kenny.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
    public void test() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("add value into queue: " + i);
        }
    }
}
