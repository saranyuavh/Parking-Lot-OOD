package org.parkinglot;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! Welcome to dumb parking lot");
        Random random = new Random();
        int levels = random.nextInt(10);
        System.out.println(levels);
        Map<Integer, SpotType> spotMap = new HashMap<>();
        spotMap.put(0, SpotType.MOTORCYCLE);
        spotMap.put(1, SpotType.COMPACT);
        spotMap.put(2, SpotType.LARGE);
        for(int i=0; i<levels; i++) {
            int noOfSpots = random.nextInt(10);
            System.out.println("no of Spots in level "+i+" is "+noOfSpots);
            List<Spot> spots = new ArrayList<>();
            for (int j=0; j< noOfSpots; j++){
                SpotType type = spotMap.get(j%3);
                spots.add(new Spot(type, i));
                if(type.equals(SpotType.LARGE)) {
                    int t=0;
                    int lt = random.nextInt(5);
                    while(j<noOfSpots && t<lt) {
                        spots.add(new Spot(type, i));
                        j++;t++;
                    }
                }
            }
            ParkingLevel level = new ParkingLevel(spots);
            for(Spot spot : level.getSpots()) {
                System.out.print(spot.getType()+" ");
            }
            ParkingLot.addLevel(level);
            System.out.print("\n");
        }

        Map<Integer, VehicleType> vehicleTypeMap = new HashMap<>();
        vehicleTypeMap.put(0, VehicleType.MOTORCYCLE);
        vehicleTypeMap.put(1, VehicleType.CAR);
        vehicleTypeMap.put(2, VehicleType.TRUCK);

        int noOfVehicles = random.nextInt(20);
        System.out.println("Number of vehicles awaiting parking, "+noOfVehicles+"\n");
        ParkingService parkingService = new ParkingService(new LotManager());
        for(int i=0; i<noOfVehicles; i++) {

            Vehicle vehicle = new Vehicle(vehicleTypeMap.get(i%3));
            System.out.println("Requesting parking for "+ vehicle.toString());
            parkingService.park(vehicle);
        }
    }
}