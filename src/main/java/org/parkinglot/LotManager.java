package org.parkinglot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotManager {
    private static Set<Vehicle> parkedVehicles = new HashSet<>();
    public List<Spot> getASpotForVehicle(Vehicle vehicle) {

        List<Spot> allottedSpots = new ArrayList<>();

        for(ParkingLevel level : ParkingLot.getLevels()) {
            System.out.println("checking level "+ level.getLevel() +" to park "+ vehicle);
            for(Spot spot : level.getSpots()) {
                if(VehicleRequirements.getVehicleSpotMap().get(vehicle.getType()).contains(spot.getType())){
                    SpotType spotType = spot.getType();
                    int spotsReq = VehicleRequirements.getSpotsQuantity().get(vehicle.getType());
                    int spotId = spot.getId();
                    int spotLevel = spot.getLevel();

                    while(spotsReq>0) {
                        Spot prospectiveSpot = Spot.getSpotById(spotId);
                        if(prospectiveSpot!=null && prospectiveSpot.getLevel() == spotLevel  && prospectiveSpot.getType().equals(spotType) && prospectiveSpot.getStatus().equals(SpotStatus.AVAILABLE)) {
                            spotsReq--;
                            allottedSpots.add(prospectiveSpot);
                            spotId++;
                        } else {
                            allottedSpots.clear();
                            break;
                        }
                    }
                    if(spotsReq == 0) {
                        parkedVehicles.add(vehicle);
                        return allottedSpots;
                    }
                    else {
                        allottedSpots.clear();
                    }
                }

            }

        }
        allottedSpots.clear();
        return allottedSpots;
    }

    public void exitVehicleAndReleaseSpots(Vehicle vehicle) {
        if(parkedVehicles.contains(vehicle)) {
            for (Spot spot : vehicle.getSpotsAllotted()) {
                spot.setStatus(SpotStatus.AVAILABLE);
                System.out.println("Released "+spot);
            }
            vehicle.releaseSpots();
            parkedVehicles.remove(vehicle);
            System.out.println(vehicle+" exited successfully");
        } else {
            System.out.println("Invalid Request, vehicle is not parked at all or left already");
        }
    }
}
