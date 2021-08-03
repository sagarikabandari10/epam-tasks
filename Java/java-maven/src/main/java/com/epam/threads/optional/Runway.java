package com.epam.threads.optional;

public class Runway {
    private int departCount = 0;
    private final int name;

    public Runway(int name) {
        this.name = name;
    }

    public void printReport() {
        System.out.println("Runway " + name + " has a total of " + departCount + " departures.");
    }

    public void inc() {
        departCount++;
    }

    public String getName() {
        return "Strip " + name;
    }
}
