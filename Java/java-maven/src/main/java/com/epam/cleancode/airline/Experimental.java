package com.epam.cleancode.airline;

import com.epam.cleancode.models.ClassificationLevel;

public class Experimental extends Flight {

    private final ClassificationLevel classificationLevel;

    public Experimental(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
