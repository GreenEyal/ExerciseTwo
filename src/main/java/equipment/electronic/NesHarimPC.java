package equipment.electronic;

import equipment.ElectronicEquipment;

public class NesHarimPC extends ElectronicEquipment {
    public NesHarimPC(String id, String ip) {
        super(id, ip);
    }

    public String toString() {
        return "NesHarim PC - " + ip;
    }
}
