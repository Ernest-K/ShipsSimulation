package pl.pwr.shipsSimulation.ship.type;

import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.ship.ShipStatistic;
import pl.pwr.shipsSimulation.team.Team;

class BrigantineShip implements Ship {
    private final ShipStatistic shipStatistic;
    private Team team;

    BrigantineShip() {
        this.shipStatistic = new ShipStatistic(120, 400, 3);
    }

    @Override
    public ShipStatistic getShipStatistic() {
        return shipStatistic;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public void setTeam(Team team) {
        this.team = team;
    }
}
