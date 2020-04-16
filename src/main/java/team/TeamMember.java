package team;

import equipment.Equipment;

import java.util.HashMap;

public class TeamMember {
    private String personalNumber;
    private HashMap<String, Equipment> inventory;

    public TeamMember(String personalNumber) {
        this.personalNumber = personalNumber;
        this.inventory = new HashMap<String, Equipment>();
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public HashMap<String, Equipment> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Equipment> inventory) {
        this.inventory = inventory;
    }

    public void addItem(Equipment item) {
        inventory.put(item.getId(), item);
    }

    public Equipment removeItem(String id) {
        return inventory.remove(id);
    }

    public void printItems() {
        for (String id : inventory.keySet()) {
            System.out.println(inventory.get(id).toString());
        }
    }
}
