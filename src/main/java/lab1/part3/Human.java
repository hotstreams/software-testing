package lab1.part3;

enum MaritalStatus { MARRIED, DIVORCED, SINGLE };
enum Wellness { GOOD, BAD, ALIVE, DEAD };

public class Human {
    private String name;
    private MaritalStatus status;
    private Wellness wellness;

    public Human(String name, MaritalStatus status, Wellness wellness) {
        this.name = name;
        this.status = status;
        this.wellness = wellness;
    }

    String getName() {
        return name;
    }

    MaritalStatus getStatus() {
        return status;
    }

    Wellness getWellness() {
        return wellness;
    }
}
