package lab1.part3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
