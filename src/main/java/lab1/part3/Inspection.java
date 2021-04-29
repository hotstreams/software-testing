package lab1.part3;

import java.time.Duration;

enum InspectionType { MAINTENANCE, EMERGENCY };

public class Inspection {
    private Duration duration;
    private InspectionType type;

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

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setType(InspectionType type) {
        this.type = type;
    }
}
