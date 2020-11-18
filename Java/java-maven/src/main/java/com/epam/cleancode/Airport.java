package com.epam.cleancode;

import com.epam.cleancode.airline.Experimental;
import com.epam.cleancode.airline.Flight;
import com.epam.cleancode.airline.Military;
import com.epam.cleancode.airline.Passenger;
import com.epam.cleancode.models.MilitaryType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Airport {

    private final List<? extends Flight> flights;

    public Airport(List<? extends Flight> flights) {
        this.flights = flights;
    }

    public List<? extends Flight> getFlights() { return flights;}

    public List<Passenger> getPassengerFlights() {
        List<Passenger> passengerFlights = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (flight instanceof Passenger) {
                passengerFlights.add((Passenger) flight);
            }
        }
        return passengerFlights;
    }

    public Passenger getPassengerWithMaxCapacity() {
        List<Passenger> passengers = getPassengerFlights();
        Passenger passengerWithMaxCapacity = passengers.get(0);
        for (Passenger passenger : passengers) {
            if (passenger.getCapacity() > passengerWithMaxCapacity.getCapacity()) {
                passengerWithMaxCapacity = passenger;
            }
        }
        return passengerWithMaxCapacity;
    }

    public List<Military> getMilitaryFlights() {
        List<Military> militaryFlights = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (flight instanceof Military) {
                militaryFlights.add((Military) flight);
            }
        }
        return militaryFlights;
    }

    public List<Military> getMilitaryWithTransport() {
        List<Military> transportMilitaries = new ArrayList<>();
        List<Military> militaries = getMilitaryFlights();
        for (Military military : militaries) {
            if (military.getMilitaryType().equals(MilitaryType.TRANSPORT)) {
                transportMilitaries.add(military);
            }
        }
        return transportMilitaries;
    }

    public List<Military> getMilitaryWithBomber() {
        List<Military> bomberMilitaries = new ArrayList<>();
        List<Military> militaries = getMilitaryFlights();
        for (Military plane : militaries) {
            if (plane.getMilitaryType().equals(MilitaryType.BOMBER)) {
                bomberMilitaries.add(plane);
            }
        }
        return bomberMilitaries;
    }

    public List<Experimental> getExperimentalFlights() {
        List<Experimental> experimentals = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight instanceof Experimental) {
                experimentals.add((Experimental) flight);
            }
        }
        return experimentals;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(flights, new Comparator<Flight>() {
            public int compare(Flight o1, Flight o2) {
                return o1.getMaxDistance() - o2.getMaxDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(flights, new Comparator<Flight>() {
            public int compare(Flight o1, Flight o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(flights, new Comparator<Flight>() {
            public int compare(Flight o1, Flight o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "flights=" + flights.toString() +
                '}';
    }
}
