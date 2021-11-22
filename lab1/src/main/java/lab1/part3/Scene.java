package lab1.part3;

import java.sql.Date;
import java.time.Duration;

public class Scene {
    private Ship ship;

    public Scene() {
        StarBase base = new StarBase();
        Star star = new Star("Барнард", base);
        Crew crew = new Crew();

        Human shrek = new Human("Shrek", MaritalStatus.MARRIED, Wellness.BAD);
        Human fiona = new Human("Fiona", MaritalStatus.MARRIED, Wellness.BAD);
        Human dragon = new Human("Dragon", MaritalStatus.DIVORCED, Wellness.DEAD);
        Human osel = new Human("Osel", MaritalStatus.DIVORCED, Wellness.BAD);

        crew.addCrewMember(shrek);
        crew.addCrewMember(fiona);
        crew.addCrewMember(dragon);
        crew.setLeader(osel);

        crew.addVacation(shrek, new Vacation(Date.valueOf("2007-12-20"), Date.valueOf("2007-12-25"), VacationState.CANCELED));
        crew.addVacation(fiona, new Vacation(Date.valueOf("2007-12-20"), Date.valueOf("2007-12-25"), VacationState.CANCELED));
        crew.addVacation(dragon, new Vacation(Date.valueOf("2007-12-20"), Date.valueOf("2007-12-25"), VacationState.CANCELED));

        ship = new Ship(EngineState.HYPER, star, crew);

        base.addShip(ship);
        base.addInspection(ship, new Inspection(Duration.ofHours(72), InspectionType.MAINTENANCE));
    }

    Ship getShip() {
        return ship;
    }
}
