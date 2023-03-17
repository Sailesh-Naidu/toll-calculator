package com.trip.etr.challenge.java.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trip.etr.challenge.java.dto.Trip;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TollCalculatorServiceTest {

    private TollCalculatorService tollCalculatorService
            = new TollCalculatorService();


    @Test
    public void testQEWHighway400() {
        String source = "Bramalea Road";
        String destination = "QEW";
        Trip trip = tollCalculatorService.costOfTrip(source, destination);
        assertEquals(51.703, trip.getDistance());
        assertEquals(12.92575, trip.getCost());
    }

    @Test
    public void testSalemRoadQEW() {
        String source = "Salem Road";
        String destination = "QEW";
        Trip trip = tollCalculatorService.costOfTrip(source, destination);
        assertEquals(100.382, trip.getDistance());
        assertEquals(25.0955, trip.getCost());
    }

    @Test
    public void testQEWSalemRoad() {
        String source = "QEW";
        String destination = "Salem Road";
        Trip trip = tollCalculatorService.costOfTrip(source, destination);
        assertEquals(100.382, trip.getDistance());
        assertEquals(25.0955, trip.getCost());
    }
}