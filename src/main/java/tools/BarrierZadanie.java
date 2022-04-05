package tools;

import org.apache.log4j.Logger;
import tools.model.Task;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BarrierZadanie {
    static Logger logger = Logger.getLogger(BarrierZadanie.class);

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);
        CyclicBarrier barrierPostSynch = new CyclicBarrier(3);


        ExecutorService service = Executors.newFixedThreadPool(3);

        IntStream.rangeClosed(1, 100).forEach(it -> {
            Random r = new Random();
            Task t = Math.abs(r.nextInt()) % 100 <= 90 ? Task.PROCESS : Task.SYNCHRONIZATION;
            service.submit(new LoopTask(t, logger, barrier, barrierPostSynch));
        });

        service.shutdown();
    }

}


class LoopTask implements Runnable {

    static Logger logger;

    private Task loopTaskType;

    private CyclicBarrier barrier;

    private CyclicBarrier barrierPostSynch;

    public LoopTask(Task loopTaskName, Logger logger, CyclicBarrier barrier, CyclicBarrier barrierPostSynch) {
        super();
        this.loopTaskType = loopTaskName;
        this.logger = logger;
        this.barrier = barrier;
        this.barrierPostSynch = barrierPostSynch;
    }

    @Override
    public void run() {
        if (loopTaskType.equals(Task.PROCESS)) {
            logger.info("Process");
        }
        if(barrier.getNumberWaiting()>0) {
            try {
                logger.info("waiting");
                barrier.await();
                logger.info("synchronization");
                barrierPostSynch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        if (loopTaskType.equals(Task.SYNCHRONIZATION)) {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            logger.info("Synchronization");
        }
    }
}
