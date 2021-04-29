package lab1.part3;

import java.util.ArrayList;
import java.util.HashMap;

public class Crew {
    private ArrayList<Human> team = new ArrayList<>();
    private Human leader;
    private HashMap<Human, Vacation> vacations = new HashMap<>();

    public Crew() {}

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
}
