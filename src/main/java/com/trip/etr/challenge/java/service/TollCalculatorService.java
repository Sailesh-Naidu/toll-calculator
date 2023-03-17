package com.trip.etr.challenge.java.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.text.DecimalFormat;
import lombok.SneakyThrows;
import com.trip.etr.challenge.java.dto.*;

public class TollCalculatorService {


    private Map<String, Integer> locationIdMap = new HashMap<String, Integer>();

    private double[][] distanceGraph;

    @SneakyThrows
    public TollCalculatorService() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<String, Location>> typeReference =
                new TypeReference<HashMap<String, Location>>() {};
        InputStream is = TollCalculatorService.class.getResourceAsStream("/interchanges.json");
        Interchanges interchanges = objectMapper.readValue(is, Interchanges.class);
        Map<String, Location> locations = interchanges.getLocations();

        distanceGraph = new double[100][100];
        for (Entry<String, Location> entry : locations.entrySet()) {
            int source = Integer.parseInt(entry.getKey());
            for (Route route : entry.getValue().getRoutes()) {
                distanceGraph[source][route.getToId()] = route.getDistance();
                distanceGraph[route.getToId()][source] = route.getDistance();
            }

            locationIdMap.put(entry.getValue().getName(), source);
        }
    }

    public Trip costOfTrip(String source, String destination) {
        int sourceId = Math.min(locationIdMap.get(source), locationIdMap.get(destination));
        int destinationId = Math.max(locationIdMap.get(source), locationIdMap.get(destination));

        double totalDistance = 0;
        for (int i = sourceId; i < destinationId; ++i) {
            totalDistance += distanceGraph[i][i+1];
        }
        DecimalFormat df = new DecimalFormat("#.###");
        double distance = Double.valueOf(df.format(totalDistance));
        return Trip.builder()
                .distance(distance)
                .cost(distance * 0.25)
                .build();
    }
}