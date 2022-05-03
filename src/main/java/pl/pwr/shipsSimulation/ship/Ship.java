package pl.pwr.shipsSimulation.ship;

import java.util.UUID;

public interface Ship {
    UUID getTeamId();
    ShipType getType();
    ShipStatistic getShipStatistic();
}
