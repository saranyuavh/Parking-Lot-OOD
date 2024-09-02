package org.parkinglot;

import java.util.*;

public class VehicleRequirements {
    private static Map<VehicleType, Set<SpotType>> vehicleSpotMap;
    private static Map<VehicleType, Integer> spotsQuantity;

    static {
        vehicleSpotMap = new HashMap<VehicleType, Set<SpotType>>();
        vehicleSpotMap.put(VehicleType.MOTORCYCLE, new HashSet<SpotType>());
        vehicleSpotMap.get(VehicleType.MOTORCYCLE).add(SpotType.MOTORCYCLE);
        vehicleSpotMap.put(VehicleType.CAR, new HashSet<SpotType>());
        vehicleSpotMap.get(VehicleType.CAR).add(SpotType.COMPACT);
        vehicleSpotMap.get(VehicleType.CAR).add(SpotType.LARGE);
        vehicleSpotMap.put(VehicleType.TRUCK, new HashSet<SpotType>());
        vehicleSpotMap.get(VehicleType.TRUCK).add(SpotType.LARGE);

        spotsQuantity = new HashMap<VehicleType, Integer>();
        spotsQuantity.put(VehicleType.MOTORCYCLE, 1);
        spotsQuantity.put(VehicleType.CAR, 1);
        spotsQuantity.put(VehicleType.TRUCK, 5);
    }

    public static Map<VehicleType, Set<SpotType>> getVehicleSpotMap() {
        return vehicleSpotMap;
    }

    public static Map<VehicleType, Integer> getSpotsQuantity() {
        return spotsQuantity;
    }
}
