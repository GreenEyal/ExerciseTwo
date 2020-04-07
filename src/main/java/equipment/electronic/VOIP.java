package equipment.electronic;

import equipment.ElectronicEquipment;

public class VOIP extends ElectronicEquipment {
    public VOIP(String id, String ip) {
        super(id, ip);
    }

    public String toString() {
        return "VOIP - " + ip;
    }
}
