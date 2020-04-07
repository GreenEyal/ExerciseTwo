package equipment.electronic;

import equipment.ElectronicEquipment;

public class InternetPC extends ElectronicEquipment {
    public InternetPC(String id, String ip) {
        super(id, ip);
    }

    public String toString() {
        return "Internet PC - " + ip;
    }
}
