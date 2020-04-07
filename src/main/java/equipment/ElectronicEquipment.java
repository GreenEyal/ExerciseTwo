package equipment;

public abstract class ElectronicEquipment extends Equipment {
    protected String ip;

    public ElectronicEquipment(String id, String ip) {
        super(id);
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
