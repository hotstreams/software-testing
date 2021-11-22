package lab1.part3;

import java.time.Duration;

enum InspectionType { MAINTENANCE, EMERGENCY };

public class Inspection {
    private final Duration duration;
    private final InspectionType type;

    public Inspection(Duration duration, InspectionType type) {
        this.duration = duration;
        this.type = type;
    }

    public Duration getDuration() {
        return duration;
    }

    public InspectionType getType() {
        return type;
    }
}
