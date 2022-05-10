package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.team.Team;

public interface Ship {
    Team getTeam();
    ShipType getType();
    ShipStatistic getShipStatistic();
}
