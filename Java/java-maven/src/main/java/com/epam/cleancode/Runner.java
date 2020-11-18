package com.epam.cleancode;

import com.epam.cleancode.airline.Flight;
import com.epam.cleancode.airline.Military;
import com.epam.cleancode.airline.Passenger;
import com.epam.cleancode.models.MilitaryType;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<Flight> flights = Arrays.asList(
            new Passenger("Boeing-737", 900, 12000, 60500, 164),
            new Passenger("Boeing-737-800", 940, 12300, 63870, 192),
            new Passenger("Boeing-747", 980, 16100, 70500, 242),
            new Passenger("Airbus A320", 930, 11800, 65500, 188),
            new Passenger("Airbus A330", 990, 14800, 80500, 222),
            new Passenger("Embraer 190", 870, 8100, 30800, 64),
            new Passenger("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new Passenger("Bombardier CS300", 920, 11000, 60700, 196),
            new Military("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new Military("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new Military("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new Military("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new Military("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new Military("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
    );

    public static void main(String[] args) {
        Airport airport = new Airport(flights);
        Airport militaryFlights = new Airport(airport.getMilitaryFlights());
        Airport passengerFlights = new Airport(airport.getPassengerFlights());
        System.out.println("Military flight sorted by max distance: " + militaryFlights
                .sortByMaxDistance()
                .toString());
        System.out.println("Passenger flight sorted by max speed: " + passengerFlights
                .sortByMaxSpeed()
                .toString());

        System.out.println("Flight with max passenger capacity: " + passengerFlights.getPassengerWithMaxCapacity());
    }
}
