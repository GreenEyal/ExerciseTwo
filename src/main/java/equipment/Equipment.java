package equipment;

public abstract class Equipment {
    protected String id;

    public Equipment(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
