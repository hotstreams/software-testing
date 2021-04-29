package lab1.part3;

public class Star {
    private String name;
    private StarBase base;

    public Star(String name, StarBase base) {
        this.name = name;
        this.base = base;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StarBase getBase() {
        return base;
    }

    public void setBase(StarBase base) {
        this.base = base;
    }
}
