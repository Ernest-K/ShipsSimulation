package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.team.Team;

public class BaseShip implements Ship {
    private final Team team;
    private final ShipType shipType;
    private final ShipStatistic shipStatistic;

    public BaseShip(Team team, ShipType shipType) {
        this.team = team;
        this.shipType = shipType;
        this.shipStatistic = shipType.getShipStatistic();
    }

    @Override
    public Team getTeam() {
        return team;
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
        return "BaseShip{" +
                "team=" + team +
                ", shipType=" + shipType +
                ", shipStatistic=" + shipStatistic +
                '}';
    }
}
