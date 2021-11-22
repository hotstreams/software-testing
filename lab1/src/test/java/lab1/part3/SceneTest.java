package lab1.part3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SceneTest {
    private Scene scene;

    @BeforeEach
    public void setUp() {
        scene = new Scene();
    }

    @Test
    public void testShip() {
        assertEquals(scene.getShip().getEngineState(), EngineState.HYPER);
        assertEquals("Барнард", scene.getShip().getTarget().getName());
    }

    @Test
    public void testInspection() {
        StarBase base = scene.getShip().getTarget().getBase();
        assertEquals(base.getInspections().get(scene.getShip()).getDuration(), Duration.ofHours(72));
        assertEquals(base.getInspections().get(scene.getShip()).getType(), InspectionType.MAINTENANCE);
    }

    @Test
    public void testVacations() {
        Crew crew = scene.getShip().getCrew();
        crew.getVacations().forEach((h, v) -> assertEquals(v.getState(), VacationState.CANCELED));
    }

    @Test
    public void testDivorced() {
        Human leader = scene.getShip().getCrew().getLeader();
        assertEquals(leader.getStatus(), MaritalStatus.DIVORCED);
    }

    @Test
    public void testWellness() {
        Crew crew = scene.getShip().getCrew();
        crew.getTeam().forEach(h -> assertNotEquals(h.getWellness(), Wellness.GOOD));
    }

    @Test void testCrewLeaving() {
        Crew crew = scene.getShip().getCrew();
        assertFalse(crew.isAnyoneLeavingTheShip());
    }

    @Test
    void testHuman() {
        Human human = new Human("Fiona", MaritalStatus.MARRIED, Wellness.ALIVE);

        assertEquals(human.getName(), "Fiona");
        assertEquals(human.getStatus(), MaritalStatus.MARRIED);
        assertEquals(human.getWellness(), Wellness.ALIVE);
        assertTrue(human.isAlive());
        assertTrue(human.isMarried());
    }

    @Test
    void testStarBase() {
        StarBase base = new StarBase();

        assertFalse(base.isAnyoneLanded());

        Ship ship = new Ship(EngineState.BASIC, new Star("Pluto", null), new Crew());

        base.addShip(ship);
        assertTrue(base.getShips().contains(ship));

        base.addInspection(ship, new Inspection(Duration.ofHours(1), InspectionType.EMERGENCY));
        assertTrue(base.hasEmergencyInspections());
    }

    @Test
    void testStar() {
        Star star = new Star("Pluto", null);
        assertFalse(star.hasBase());
        assertEquals(star.getName(), "Pluto");
    }

    @Test
    void testVacation() {
        assertThrows(IllegalArgumentException.class, () -> new Vacation(null, Date.valueOf("2019-12-12"), VacationState.PLANNED));
        assertThrows(IllegalStateException.class, () -> new Vacation(Date.valueOf("2019-12-13"), Date.valueOf("2019-12-12"), VacationState.PLANNED));
    }

    @Test
    void testShipCreation() {
        assertThrows(IllegalArgumentException.class, () ->  new Ship(EngineState.HYPER, null, null));
    }
}
