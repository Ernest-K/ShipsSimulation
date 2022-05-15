package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.team.Team;

public interface Ship {
    Team getTeam();
    void setTeam(Team team);
    ShipStatistic getShipStatistic();
}
