package pl.pwr.ships.simulation.ship.type;

import pl.pwr.ships.simulation.ship.Ship;
import pl.pwr.ships.simulation.ship.ShipStatistic;
import pl.pwr.ships.simulation.team.Team;

class GalleonShip implements Ship {
    private final ShipStatistic shipStatistic;
    private Team team;

    GalleonShip() {
        this.shipStatistic = new ShipStatistic(80, 500, 5);
    }

    @Override
    public ShipStatistic getShipStatistic() {
        return shipStatistic;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
