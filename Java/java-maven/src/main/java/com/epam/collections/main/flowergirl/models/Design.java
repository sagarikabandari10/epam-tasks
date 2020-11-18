package com.epam.collections.main.flowergirl.models;

public enum Design {
    CLASSIC(1.8), FANCY(2.5), NORMAL(1);

    private final double value;

    Design(double d) {
        this.value = d;
    }

    public double getValue() {
        return value;
    }
}
