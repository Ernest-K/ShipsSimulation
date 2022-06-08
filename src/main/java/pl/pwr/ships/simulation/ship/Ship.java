package pl.pwr.ships.simulation.ship;

import pl.pwr.ships.simulation.team.Team;

public interface Ship {
    Team getTeam();
    void setTeam(Team team);
    ShipStatistic getShipStatistic();
}
