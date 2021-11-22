package lab1.part3;

import java.util.ArrayList;
import java.util.HashMap;

public class StarBase {
    private final HashMap<Ship, Inspection> inspections;
    private final ArrayList<Ship> ships;

    public StarBase() {
        inspections = new HashMap<>();
        ships = new ArrayList<>();
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void addInspection(Ship ship, Inspection inspection) {
        inspections.put(ship, inspection);
    }

    public HashMap<Ship, Inspection> getInspections() {
        return inspections;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public boolean isAnyoneLanded() {
        return !ships.isEmpty();
    }

    public boolean hasEmergencyInspections() {
        return inspections.entrySet().stream().anyMatch(e -> e.getValue().getType() == InspectionType.EMERGENCY);
    }
}
