package org.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class Spot {

    private static int globalSpotId = 0;
    private int id;
    private SpotType type;
    private SpotStatus status;

    private int level;

    private static Map<Integer, Spot> spotsMap = new HashMap<>();

    public Spot(SpotType type, int level) {
        this.type = type;
        this.id = ++globalSpotId;
        this.status = SpotStatus.AVAILABLE;
        this.level = level;
        spotsMap.put(this.id, this);
    }
    public int getId() {
        return id;
    }

    public SpotType getType() {
        return type;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public void setType(SpotType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public static Spot getSpotById(Integer id) {
        return spotsMap.get(id);
    }

    @Override
    public String toString(){
        return "id "+this.getId() + " at level "+this.getLevel() +" of type "+this.getType().name();
    }
}
