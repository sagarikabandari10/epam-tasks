package com.epam.threads.main;

import java.util.ArrayList;
import java.util.List;

public class ParkingBlock {

    private static int carLimit;
    private static final List<Thread> parkedCars = new ArrayList<>();

    public ParkingBlock(int carLimit) {
        ParkingBlock.carLimit = carLimit;
    }

    public synchronized boolean accept(CarThread thread) throws InterruptedException {
        if (carLimit == 0) {
            wait(thread.getWaitTime());
            if (carLimit == 0) return false;
        }
        carLimit--;
        parkedCars.add(thread);
        notifyAll();
        return true;
    }


    public synchronized void release(CarThread thread) {
        if (parkedCars.contains(thread)) {
            carLimit++;
            parkedCars.remove(thread);
        }
    }
}
