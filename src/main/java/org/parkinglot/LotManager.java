package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class LotManager {

    public List<Spot> getASpotForVehicle(Vehicle vehicle) {

        List<Spot> allottedSpots = new ArrayList<>();

        for(ParkingLevel level : ParkingLot.getLevels()) {

            for(Spot spot : level.getSpots()) {
                if(VehicleRequirements.getVehicleSpotMap().get(vehicle.getType()).contains(spot.getType())){
                    SpotType spotType = spot.getType();
                    Integer spotsReq = VehicleRequirements.getSpotsQuantity().get(vehicle.getType());
                    int spotId = spot.getId();
                    int spotLevel = spot.getLevel();

                    while(spotsReq>=0) {
                        Spot prospectiveSpot = Spot.getSpotById(spotId);
                        if(Spot.getSpotById(spotId).getLevel() == spotLevel  && spot.getType().equals(spotType)) {
                            spotsReq--;
                            allottedSpots.add(prospectiveSpot);
                            spotId++;
                        } else {
                            allottedSpots.clear();
                            break;
                        }
                    }

                }

            }

        }
        return allottedSpots;
    }

    public void exitVehicleAndReleaseSpots(Vehicle vehicles) {

    }
}
