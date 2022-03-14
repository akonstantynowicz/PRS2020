package atomic;

import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CounterSynchronized {

    static Logger logger = Logger.getLogger(CounterSynchronized.class);
    static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        CounterThreadSynchronized counter = new CounterThreadSynchronized(number);

        Thread t1 = new Thread(() -> {
            IntStream.rangeClosed(1, 10000).forEach(num -> {
                counter.increment();
            });
        });

        Thread t2 = new Thread(() -> {
            IntStream.rangeClosed(1, 10000).forEach(num -> {
                counter.decrement();
            });
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        logger.info("Number " + counter.getNumber());

    }
}

class CounterThreadSynchronized {

    AtomicInteger number;

    public CounterThreadSynchronized(AtomicInteger number) {
        this.number = number;
    }

    public void increment() {
        number.incrementAndGet();
    }


    public void decrement() {
        number.decrementAndGet();
    }

    public Integer getNumber() {
        return number.get();
    }
}
