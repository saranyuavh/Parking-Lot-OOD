package org.parkinglot;

import java.util.*;
public class ParkingLot {
    private static List<ParkingLevel> levels = new ArrayList<>();

    public static List<ParkingLevel> getLevels() {
        return levels;
    }

    public static void addLevel(ParkingLevel level) {
        levels.add(level);
    }
}
