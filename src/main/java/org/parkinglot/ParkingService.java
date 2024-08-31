package org.parkinglot;

public class ParkingService {
    LotManager manager;
    public ParkingService(LotManager manager) {
        this.manager = manager;
    }
    public void park(Vehicle vehicle) {
        manager.getASpotForVehicle(vehicle);
    }
}
