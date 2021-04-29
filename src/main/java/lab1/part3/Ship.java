package lab1.part3;

enum EngineState { HYPER, BASIC };

public class Ship {
    private EngineState engineState;
    private Star target;
    private Crew crew;

    public Ship(EngineState engineState, Star target, Crew crew) {
        this.engineState = engineState;
        this.target = target;
        this.crew = crew;
    }

    public EngineState getEngineState() {
        return engineState;
    }

    public void setEngineState(EngineState engineState) {
        this.engineState = engineState;
    }

    public Star getTarget() {
        return target;
    }

    public void setTarget(Star target) {
        this.target = target;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }
}
