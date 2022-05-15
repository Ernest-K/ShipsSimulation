package pl.pwr.shipsSimulation.application;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.ship.ShipFactory;
import pl.pwr.shipsSimulation.ship.type.ShipType;
import pl.pwr.shipsSimulation.simulation.Simulation;
import pl.pwr.shipsSimulation.simulation.SimulationConfig;
import pl.pwr.shipsSimulation.team.Team;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        BoardSize boardSize = new BoardSize(32,32);

        List<Team> teamList = new ArrayList<>();
        teamList.add(new Team("Blue"));
        teamList.add(new Team("Red"));
        teamList.add(new Team("Green"));

        List<Ship> shipList = new ArrayList<>();
        shipList.add(ShipFactory.getShip(ShipType.BRIGANTINE, teamList.get(0)));
        shipList.add(ShipFactory.getShip(ShipType.GALLEON, teamList.get(1)));
        shipList.add(ShipFactory.getShip(ShipType.SLOOP, teamList.get(2)));

        SimulationConfig simulationConfig = new SimulationConfig(boardSize, teamList, shipList);
        Simulation simulation = new Simulation(simulationConfig);
        simulation.run();

    }
}
