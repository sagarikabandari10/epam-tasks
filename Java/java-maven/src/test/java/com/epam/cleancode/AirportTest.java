package com.epam.cleancode;

import com.epam.cleancode.airline.Experimental;
import com.epam.cleancode.airline.Flight;
import com.epam.cleancode.airline.Military;
import com.epam.cleancode.airline.Passenger;
import com.epam.cleancode.models.ClassificationLevel;
import com.epam.cleancode.models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static final List<Flight> flights = Arrays.asList(
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
            new Military("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new Experimental("Bell X-14", 277, 482, 500, ClassificationLevel.SECRET),
            new Experimental("Ryan X-13 Vertijet", 560, 307, 500, ClassificationLevel.TOPSECRET)
    );

    private static final Airport airport = new Airport(flights);

    @Test
    public void testHasAtLeastOneTransportInMilitaryFlights() {
        List<Military> transportMilitaries = airport.getMilitaryWithTransport();
        boolean isMilataryTransport = false;
        for (Military military : transportMilitaries) {
            if ((military.getMilitaryType() == MilitaryType.TRANSPORT)) {
                isMilataryTransport = true;
                break;
            }
        }
        Assert.assertTrue(isMilataryTransport);
    }

    @Test
    public void testGetPassengerWithMaxCapacity() {
        Passenger expected = new Passenger("Boeing-747", 980, 16100, 70500, 242);
        Passenger actual = airport.getPassengerWithMaxCapacity();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCurrentFligthGreaterThanNextFligthLoadCapacityWhenSortByMaxLoadCapacity() {
        airport.sortByMaxLoadCapacity();
        List<? extends Flight> sortByMaxLoadCapacity = airport.getFlights();
        boolean isNextFligthLoadCapacityHigher = true;
        for (int i = 0; i < sortByMaxLoadCapacity.size() - 1; i++) {
            Flight currentFlight = sortByMaxLoadCapacity.get(i);
            Flight nextFlight = sortByMaxLoadCapacity.get(i + 1);
            if (currentFlight.getMaxLoadCapacity() > nextFlight.getMaxLoadCapacity()) {
                isNextFligthLoadCapacityHigher = false;
                break;
            }
        }
        Assert.assertTrue(isNextFligthLoadCapacityHigher);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryFlights() {
        List<Military> bomberMilitaries = airport.getMilitaryWithBomber();
        boolean hasMilitaryBombers = false;
        for (Military military : bomberMilitaries) {
            if ((military.getMilitaryType() == MilitaryType.BOMBER)) {
                hasMilitaryBombers = true;
                break;
            }
        }
        Assert.assertTrue(hasMilitaryBombers);
    }

    @Test
    public void testHasAtLeastOneUnclassifiedInExperimentalFlights() {
        List<Experimental> experimentals = airport.getExperimentalFlights();
        boolean hasUnclassifiedFlights = false;
        for (Experimental experimental : experimentals) {
            if (experimental.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED) {
                hasUnclassifiedFlights = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedFlights);
    }
}
