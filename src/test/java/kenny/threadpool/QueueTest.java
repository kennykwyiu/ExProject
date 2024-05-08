package kenny.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {

    @Test
    public void arrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("add value into queue: " + i);
        }
    }
}
