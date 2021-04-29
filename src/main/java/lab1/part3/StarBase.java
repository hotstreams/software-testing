package lab1.part3;

import java.util.ArrayList;
import java.util.HashMap;

public class StarBase {
    private HashMap<Ship, Inspection> inspections = new HashMap<>();
    private ArrayList<Ship> ships = new ArrayList<>();

    public StarBase() {}

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
}
