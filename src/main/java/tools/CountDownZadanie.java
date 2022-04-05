package tools;

import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountDownZadanie {

    static Logger logger = Logger.getLogger(CountDownZadanie.class);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        ExecutorService service = Executors.newFixedThreadPool(5);

        IntStream.rangeClosed(1,5).forEach(it -> {
            service.submit(() -> {
                logger.info("Working long task" + Thread.currentThread().getName());
                try {
                    Thread.sleep(new Random().nextInt()%1000 + 2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("Working long finished" + Thread.currentThread().getName());
                latch.countDown();
                logger.info("Wait to finish" + Thread.currentThread().getName());
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("Finished" + Thread.currentThread().getName());
            });
        });

        Thread threadKiller = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            service.shutdown();
        });

        threadKiller.start();

    }
}
