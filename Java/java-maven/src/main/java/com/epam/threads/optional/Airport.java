package com.epam.threads.optional;

import java.util.Random;
import java.util.concurrent.*;

public class Airport {

    public static void main(String[] args) {
        int runwayCount = 5;
        Random rand = new Random();
        BlockingQueue<Runway> runways = new ArrayBlockingQueue<>(runwayCount);
        ExecutorService pool = Executors.newFixedThreadPool(runwayCount);

        for (int i = 1; i <= runwayCount; i++) {
            runways.add(new Runway(i));
        }

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(rand.nextInt(4001));
                pool.submit(new Aircraft(i, runways));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
        try {
            if (pool.awaitTermination(400, TimeUnit.SECONDS)) {
                for (int i = 1; i <= runwayCount; i++) {
                    runways.take().printReport();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
