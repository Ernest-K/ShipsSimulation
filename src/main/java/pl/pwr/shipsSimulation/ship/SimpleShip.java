package pl.pwr.shipsSimulation.ship;

import java.util.UUID;

public class SimpleShip implements Ship{
    UUID teamId;
    ShipType shipType;

    public SimpleShip(UUID teamId, ShipType shipType) {
        this.teamId = teamId;
        this.shipType = shipType;
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
    public String toString() {
        return "SimpleShip{" +
                "teamId=" + teamId +
                ", shipType=" + shipType +
                ", shipStatistic=" + shipType.getShipStatistic() +
                '}';
    }
}
