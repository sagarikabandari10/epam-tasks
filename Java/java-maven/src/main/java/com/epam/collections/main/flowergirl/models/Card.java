package com.epam.collections.main.flowergirl.models;

public enum Card {
    ANNIVERSARY(1.5), BESTWISHER(1), BIRTHDAY(2), NOCARD(0);

    private final double value;

    Card(double i) {
        this.value = i;
    }

    public double getValue() {
        return value;
    }
}
