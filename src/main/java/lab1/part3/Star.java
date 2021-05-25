package lab1.part3;

public class Star {
    private final String name;
    private final StarBase base;

    public Star(String name, StarBase base) {
        this.name = name;
        this.base = base;
    }

    public String getName() {
        return name;
    }
    public StarBase getBase() {
        return base;
    }

    public boolean hasBase() {
        return base != null;
    }
}
