package com.epam.threads.main;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        int cars = 10, lots = 7;
        ParkingBlock parkingBlock = new ParkingBlock(lots);
        List<Thread> carList = createCars(cars, parkingBlock);
        waitCars(carList);

        System.out.println(carList);
    }

    public static List<Thread> createCars(int cars, ParkingBlock parkingBlock) {
        List<Thread> carList = new ArrayList<>();
        for (int i = 1; i <= cars; i++) {
            int waitTime = (int) (Math.random() * 25);
            int startTime = (int) (Math.random() * 5);
            int parkedTime = (int) (Math.random() * 25);
            carList.add(new CarThread(i, waitTime, startTime, parkedTime, parkingBlock));
        }
        return carList;
    }

    public static void waitCars(List<Thread> threads) {
        try {
            for (Thread thread : threads) thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
