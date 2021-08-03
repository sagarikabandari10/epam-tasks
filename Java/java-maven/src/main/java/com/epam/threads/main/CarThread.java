package com.epam.threads.main;

import java.util.concurrent.TimeUnit;

public class CarThread extends Thread {

    private final int waitTime;
    private final int startTime;
    private final int parkedTime;
    private final ParkingBlock parkingBlock;
    private final int car;

    public CarThread(int car, int waitTime, int startTime, int parkedTime, ParkingBlock parkingBlock) {
        this.car = car;
        this.waitTime = waitTime;
        this.startTime = startTime;
        this.parkedTime = parkedTime;
        this.parkingBlock = parkingBlock;
        start();
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void run() {
        try {
            wait(startTime);
            boolean isAccepted = this.parkingBlock.accept(this);
            if (isAccepted) {
                wait(parkedTime);
                this.parkingBlock.release(this);
            } else {
                System.out.println("Car: "+this.car + " waitTime: "+getWaitTime()+", can't wait more. leave to another parking lot.");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    public void wait(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Car: " + car
                + " waitTime: " + waitTime
                + " startTime:" + startTime
                + " parkedTime:" + parkedTime
                + "\n";
    }

}
