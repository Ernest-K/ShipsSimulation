package pl.pwr.ships.simulation.ship.type;

import pl.pwr.ships.simulation.ship.Ship;
import pl.pwr.ships.simulation.ship.ShipStatistic;
import pl.pwr.ships.simulation.team.Team;

class SloopShip implements Ship {
    private final ShipStatistic shipStatistic;
    private Team team;

    SloopShip() {
        shipStatistic = new ShipStatistic(97, 450, 4);
    }

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
