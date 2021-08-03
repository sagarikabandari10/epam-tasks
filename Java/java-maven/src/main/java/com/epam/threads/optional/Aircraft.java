package com.epam.threads.optional;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Aircraft implements Runnable {
    private final int ID;
    private final BlockingQueue<Runway> runways;
    private Runway runway;

    public Aircraft(int ID, BlockingQueue<Runway> runways) {
        this.ID = ID;
        this.runways = runways;
    }

    @Override
    public void run() {
        try {
            runway = runways.take();
            System.out.println(java.time.LocalTime.now() + " The " + runway.getName() + " has \"accepted\" the plane " + ID + ".");
            System.out.println(java.time.LocalTime.now() + " The Plane " + ID + " began to enter the runway " + runway.getName() + ".");
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runway.inc();
        System.out.println(java.time.LocalTime.now() + " The Plane " + ID + " takeoff.");
        runways.add(runway);
        System.out.println(java.time.LocalTime.now() + " The " + runway.getName() + " is free.");
    }
}
