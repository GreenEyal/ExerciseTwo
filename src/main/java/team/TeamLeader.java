package team;

import equipment.Equipment;

import java.util.HashMap;

public class TeamLeader extends TeamMember {
    private HashMap<String, TeamMember> team;

    public TeamLeader(String personalNumber) {
        super(personalNumber);
        this.team = new HashMap<String, TeamMember>();
    }

    public void addTeamMember(TeamMember teamMember) {
        team.put(teamMember.getPersonalNumber(), teamMember);
    }

    public TeamMember removeTeamMember(String personalNumber) {
        return team.remove(personalNumber);
    }

    /**
     * Method to return a hashmap of equipmentId-->equipment of the equipment of all team
     * members in team leader's team.
     */
    public HashMap<String, Equipment> getTeamInventory() {
        HashMap<String, Equipment> teamInventory = new HashMap<String, Equipment>();
        for (String personalNumber : team.keySet()) {
            teamInventory.putAll(team.get(personalNumber).getInventory());
        }
        return teamInventory;
    }
}
