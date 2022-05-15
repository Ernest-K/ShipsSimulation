package pl.pwr.shipsSimulation.ship.type;

import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.ship.ShipStatistic;
import pl.pwr.shipsSimulation.team.Team;

class GalleonShip implements Ship {
    private final ShipStatistic shipStatistic;
    private Team team;

    GalleonShip() {
        this.shipStatistic = new ShipStatistic(80, 600, 3);
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
