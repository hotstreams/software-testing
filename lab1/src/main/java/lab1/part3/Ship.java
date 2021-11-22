package lab1.part3;

enum EngineState { HYPER, BASIC };

public class Ship {
    private final EngineState engineState;
    private final Star target;
    private final Crew crew;

    public Ship(EngineState engineState, Star target, Crew crew) {
        if (crew == null) {
            throw new IllegalArgumentException();
        }

        this.engineState = engineState;
        this.target = target;
        this.crew = crew;
    }

    public EngineState getEngineState() {
        return engineState;
    }

    public Star getTarget() {
        return target;
    }

    public Crew getCrew() {
        return crew;
    }
}
