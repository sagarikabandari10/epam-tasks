package com.epam.collections.main.flowergirl.models;

public enum Wrapper {
    CREPEPAPER(2), PLASTICPAPER(3), POLYDECOR(5);

    private final int value;

    Wrapper(int i) {
        this.value = i;
    }

    public double getValue() {
        return value;
    }
}
