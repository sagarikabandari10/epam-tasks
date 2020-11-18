package com.epam.cleancode.airline;

import com.epam.cleancode.models.MilitaryType;
import java.util.Objects;

public class Military extends Flight {

    private final MilitaryType militaryType;

    public Military(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType militaryType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = militaryType;
    }

    public MilitaryType getMilitaryType() {
        return militaryType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryType +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Military)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Military that = (Military) o;
        return militaryType == that.militaryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }
}
