package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class LotManager {

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
                    if(spotsReq == 0) return allottedSpots;
                    else {
                        allottedSpots.clear();
                    }
                }

            }

        }
        allottedSpots.clear();
        return allottedSpots;
    }

    public void exitVehicleAndReleaseSpots(Vehicle vehicles) {

    }
}
