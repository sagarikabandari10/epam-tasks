package com.epam.cleancode.airline;

import java.util.Objects;

abstract public class Flight {
    private final String model;
    private final int maxSpeed;
    private final int maxDistance;
    private final int maxLoadCapacity;

    public Flight(String model, int maxSpeed, int maxDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxDistance = maxDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() { return model; }

    public int getMaxSpeed() { return maxSpeed; }

    public int getMaxDistance() {
        return maxDistance;
    }

    public int getMaxLoadCapacity() { return this.maxLoadCapacity; }

    @Override
    public String toString() {
        return "Flight{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxDistance=" + maxDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Flight)) {
            return false;
        }
        Flight flight = (Flight) o;
        return maxSpeed == flight.maxSpeed &&
                maxDistance == flight.maxDistance &&
                maxLoadCapacity == flight.maxLoadCapacity &&
                Objects.equals(model, flight.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxDistance, maxLoadCapacity);
    }
}
