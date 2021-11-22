package lab1.part3;

import java.util.ArrayList;
import java.util.HashMap;

public final class Crew {
    private final ArrayList<Human> team;
    private Human leader;
    private final HashMap<Human, Vacation> vacations;

    public Crew() {
        team = new ArrayList<>();
        vacations = new HashMap<>();
    }

    public void addCrewMember(Human member) {
        team.add(member);
    }

    public void addVacation(Human human, Vacation vacation) {
        vacations.put(human, vacation);
    }

    public void setLeader(Human human) {
        leader = human;
    }

    public ArrayList<Human> getTeam() {
        return team;
    }

    public Human getLeader() {
        return leader;
    }

    public HashMap<Human, Vacation> getVacations() {
        return vacations;
    }

    public boolean isAnyoneLeavingTheShip() {
        return vacations.entrySet().stream().anyMatch(e -> e.getValue().getState() != VacationState.CANCELED);
    }
}
