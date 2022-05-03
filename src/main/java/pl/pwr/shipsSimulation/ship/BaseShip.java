package pl.pwr.shipsSimulation.ship;

import java.util.UUID;

public class BaseShip implements Ship {
    private final UUID teamId;
    private final ShipType shipType;
    private final ShipStatistic shipStatistic;

    public BaseShip(UUID teamId, ShipType shipType) {
        this.teamId = teamId;
        this.shipType = shipType;
        this.shipStatistic = shipType.getShipStatistic();
    }

    @Override
    public UUID getTeamId() {
        return teamId;
    }

    @Override
    public ShipType getType() {
        return shipType;
    }

    @Override
    public ShipStatistic getShipStatistic() {
        return shipStatistic;
    }

    @Override
    public String toString() {
        return "SimpleShip{" +
                "teamId=" + teamId +
                ", shipType=" + shipType +
                ", shipStatistic=" + shipType.getShipStatistic() +
                '}';
    }
}
