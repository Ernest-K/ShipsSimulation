package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.ship.type.ShipType;
import pl.pwr.shipsSimulation.team.Team;

public class ShipFactory {
    public static Ship getShip(ShipType type, Team team){
        Ship ship = type.getConstructor().get();
        ship.setTeam(team);
        return ship;
    }
}