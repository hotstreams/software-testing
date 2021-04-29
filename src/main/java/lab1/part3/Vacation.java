package lab1.part3;

import java.util.Date;

enum VacationState { PLANNED, CANCELED }

public class Vacation {
    private Date start;
    private Date end;
    private VacationState state;

    public Vacation(Date start, Date end, VacationState state) {
        this.start = start;
        this.end = end;
        this.state = state;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public VacationState getState() {
        return state;
    }

    public void setState(VacationState state) {
        this.state = state;
    }
}
