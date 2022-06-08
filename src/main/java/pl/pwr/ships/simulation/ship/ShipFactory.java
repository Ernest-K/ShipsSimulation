package pl.pwr.ships.simulation.ship;

import pl.pwr.ships.simulation.ship.type.ShipType;
import pl.pwr.ships.simulation.team.Team;

public class ShipFactory {
    public static Ship getShip(ShipType type, Team team){
        Ship ship = type.getConstructor().get();
        ship.setTeam(team);
        return ship;
    }
}