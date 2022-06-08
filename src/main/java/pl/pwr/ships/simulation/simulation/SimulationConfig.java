package pl.pwr.ships.simulation.simulation;

import pl.pwr.ships.simulation.board.BoardSize;
import pl.pwr.ships.simulation.ship.Ship;
import pl.pwr.ships.simulation.team.Team;

import java.util.List;

public class SimulationConfig {
    private final BoardSize boardSize;
    private final List<Team> teamList;
    private final List<Ship> shipList;

    public SimulationConfig(BoardSize boardSize, List<Team> teamList, List<Ship> shipList) {
        this.boardSize = boardSize;
        this.teamList = teamList;
        this.shipList = shipList;
    }

    public BoardSize getBoardSize() {
        return boardSize;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public List<Ship> getShipList() {
        return shipList;
    }
}
