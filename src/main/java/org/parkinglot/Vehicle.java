package org.parkinglot;

import java.util.List;

public class Vehicle {
    private static int globalVehicleId = 0;

    private int id;

    private VehicleType type;

    private List<Spot> spotsAllotted;
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

    public List<Spot> getSpotsAllotted() {
        return spotsAllotted;
    }

    public void setSpotsAllotted(List<Spot> spotsAllotted) {
        this.spotsAllotted = spotsAllotted;
    }

    public void releaseSpots() {
        this.spotsAllotted.clear();
    }
}
