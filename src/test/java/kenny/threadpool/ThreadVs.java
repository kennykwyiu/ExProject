package kenny.threadpool;

import org.junit.Test;

public class ThreadVs {

    @Test
    public void oldHandle() throws InterruptedException {

        // create 100 threads
        for (int request = 1; request <= 100; request++) {
            new Thread(() -> {
                System.out.println("Start to convert");

                try {
                    // convert word to pdf: take a long time
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Finished convert");
            }).start();
        }

        Thread.sleep(1000L * 1000);
    }

}
