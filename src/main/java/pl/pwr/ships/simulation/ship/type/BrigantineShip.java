package pl.pwr.ships.simulation.ship.type;

import pl.pwr.ships.simulation.ship.Ship;
import pl.pwr.ships.simulation.ship.ShipStatistic;
import pl.pwr.ships.simulation.team.Team;

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
