package com.epam.cleancode.airline;

import java.util.Objects;

public class Passenger extends Flight {

    private final int capacity;

    public Passenger(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int capacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", capacity=" + capacity +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Passenger)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Passenger plane = (Passenger) o;
        return capacity == plane.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }
}
