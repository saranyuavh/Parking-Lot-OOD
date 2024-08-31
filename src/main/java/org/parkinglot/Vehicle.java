package org.parkinglot;

public class Vehicle {
    private static int globalVehicleId = 0;

    private int id;

    private VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
        this.id = ++globalVehicleId;
    }

    public int getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }
}
