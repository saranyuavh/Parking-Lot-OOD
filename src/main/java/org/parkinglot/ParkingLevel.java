package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private static int globalParkingLevel=0;
    private int level;
    private List<Spot> spots;

    public ParkingLevel(List<Spot> spots) {
        this.spots = spots;
        this.level = ++globalParkingLevel;
    }
    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public int getLevel() {
        return level;
    }
}
