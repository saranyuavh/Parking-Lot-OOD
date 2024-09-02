package org.parkinglot;

import java.util.List;

public class ParkingService {
    LotManager manager;
    public ParkingService(LotManager manager) {
        this.manager = manager;
    }
    public void park(Vehicle vehicle) {
        List<Spot> spotsAllotted = manager.getASpotForVehicle(vehicle);
        vehicle.setSpotsAllotted(spotsAllotted);
        for(Spot spot : spotsAllotted) {
            spot.setStatus(SpotStatus.OCCUPIED);
        }
        if(spotsAllotted.size() > 0) {
            System.out.print(vehicle + " is allotted " + spotsAllotted.size()+" spot(s): \n");
            for (Spot spot : spotsAllotted) {
                System.out.println("spot "+spot);
            }
        } else {
            System.out.println("sorry, no spots available for " + vehicle);
        }
        System.out.print("\n\n");
    }

    public void exit(Vehicle vehicle) {
        for(Spot spot : vehicle.getSpotsAllotted()) {
            spot.setStatus(SpotStatus.AVAILABLE);
        }
        vehicle.releaseSpots();
    }
}
