package pl.pwr.shipsSimulation.input;

import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.team.Team;

import java.util.List;

public interface Input {
    List<Team> getTeamList();
    List<Ship> getShipList();
}
