package pl.pwr.ships.simulation.input;

import pl.pwr.ships.simulation.board.BoardSize;
import pl.pwr.ships.simulation.ship.Ship;
import pl.pwr.ships.simulation.team.Team;

import java.util.List;

public interface Input {
    BoardSize getBoardSize();
    List<Team> getTeamList();
    List<Ship> getShipList();
}
