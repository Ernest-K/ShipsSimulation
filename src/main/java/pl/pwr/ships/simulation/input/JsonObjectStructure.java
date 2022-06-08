package pl.pwr.ships.simulation.input;

public class JsonObjectStructure {
    private final String teamName;
    private final String[] ships;

    public JsonObjectStructure(String teamName, String[] ships) {
        this.teamName = teamName;
        this.ships = ships;
    }

    public String getTeamName() {
        return teamName;
    }

    public String[] getShips() {
        return ships;
    }
}
