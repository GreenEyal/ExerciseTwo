package team;

import equipment.Equipment;
import exceptions.ItemNotFoundException;
import exceptions.MemberNotFoundException;

import java.util.HashMap;

public class TeamLeader extends TeamMember {
    private HashMap<String, TeamMember> team;

    public TeamLeader(String personalNumber) {
        super(personalNumber);
        this.team = new HashMap<String, TeamMember>();
    }

    public TeamLeader(String personalNumber, HashMap<String, TeamMember> team) {
        super(personalNumber);
        this.team = team;
    }

    public void addTeamMember(TeamMember teamMember) {
        team.put(teamMember.getPersonalNumber(), teamMember);
    }

    public TeamMember removeTeamMember(String personalNumber) {
        return team.remove(personalNumber);
    }

    /**
     * Method to return combined inventory of all team members
     *
     * @return HashMap of equipment ID keys pointing to matching equipment objects
     */
    public HashMap<String, Equipment> getTeamInventory() {
        HashMap<String, Equipment> teamInventory = new HashMap<String, Equipment>();
        for (String personalNumber : team.keySet()) {
            teamInventory.putAll(team.get(personalNumber).getInventory());
        }
        return teamInventory;
    }

    /**
     * Method to return inventory of all team members with distinction by team member
     *
     * @return HashMap of personal number keys pointing to matching team member's inventory
     */
    public HashMap<String, HashMap<String, Equipment>> getTeamInventoryByMember() {
        HashMap<String, HashMap<String, Equipment>> teamInventoryByMember = new HashMap<String, HashMap<String, Equipment>>();
        for (String personalNumber : team.keySet()) {
            teamInventoryByMember.put(personalNumber, team.get(personalNumber).getInventory());
        }
        return teamInventoryByMember;
    }

    /**
     * Method to trade a piece of equipment between 2 team members.
     *
     * @param giverPersonalNumber personal number of the item giver
     * @param takerPersonalNumber personal number of the item receiver
     * @param itemID              id of the item to be given
     * @throws MemberNotFoundException if either giver or taker ID not found in team's members
     * @throws ItemNotFoundException   if given item ID not found in giver's inventory
     */
    public void tradeItems(String giverPersonalNumber, String takerPersonalNumber, String itemID) throws ItemNotFoundException, MemberNotFoundException {
        if (!team.containsKey(giverPersonalNumber)) {
            throw new MemberNotFoundException(giverPersonalNumber + " - Not found in team");
        } else if (!team.containsKey(takerPersonalNumber)) {
            throw new MemberNotFoundException(takerPersonalNumber + " - Not found in team");
        } else if (!team.get(giverPersonalNumber).getInventory().containsKey(itemID)) {
            throw new ItemNotFoundException("Item " + itemID + " not found in inventory of " + giverPersonalNumber);
        } else {
            team.get(takerPersonalNumber).addItem(team.get(giverPersonalNumber).removeItem(itemID));
        }
    }
}
