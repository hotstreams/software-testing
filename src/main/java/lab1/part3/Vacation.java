package lab1.part3;

import javax.security.auth.login.LoginException;
import java.time.Duration;
import java.util.Date;

enum VacationState { PLANNED, CANCELED }

public class Vacation {
    private final Date start;
    private final Date end;
    private final VacationState state;

    public Vacation(Date start, Date end, VacationState state) {
        if (start == null || end == null) {
            throw new IllegalArgumentException();
        }

        if (!start.before(end)) {
            throw new IllegalStateException();
        }

        this.start = start;
        this.end = end;
        this.state = state;
    }

    public VacationState getState() {
        return state;
    }
}
