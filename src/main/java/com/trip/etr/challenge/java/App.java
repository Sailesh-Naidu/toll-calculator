package com.trip.etr.challenge.java;

import com.trip.etr.challenge.java.dto.Trip;
import com.trip.etr.challenge.java.service.TollCalculatorService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Trip trip = new TollCalculatorService().costOfTrip(args[0], args[1]);
        System.out.println("Distance: " + trip.getDistance());
        System.out.println("Cost: $" + trip.getCost());
    }
}
