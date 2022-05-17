package pl.pwr.shipsSimulation.application;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.input.FileInput;
import pl.pwr.shipsSimulation.input.Input;
import pl.pwr.shipsSimulation.simulation.Simulation;
import pl.pwr.shipsSimulation.simulation.SimulationConfig;



public class Application {
    public static void main(String[] args) {
        BoardSize boardSize = new BoardSize(32,32);

        Input fileInput = new FileInput("src/config.json");

        SimulationConfig simulationConfig = new SimulationConfig(boardSize, fileInput.getTeamList(), fileInput.getShipList());
        Simulation simulation = new Simulation(simulationConfig);
        simulation.run();

    }
}
