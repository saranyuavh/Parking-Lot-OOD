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

    }

    public void exit(Vehicle vehicle) {
        for(Spot spot : vehicle.getSpotsAllotted()) {
            spot.setStatus(SpotStatus.AVAILABLE);
        }
        vehicle.releaseSpots();
    }
}
