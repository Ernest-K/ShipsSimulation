package pl.pwr.shipsSimulation.application;

import pl.pwr.shipsSimulation.input.Input;
import pl.pwr.shipsSimulation.simulation.Simulation;
import pl.pwr.shipsSimulation.simulation.SimulationConfig;

public class Application {
    public static void main(String[] args) {
        ArgumentParser argumentParser = new ArgumentParser(args);

        Input input = argumentParser.parse();

        SimulationConfig simulationConfig = new SimulationConfig(input.getBoardSize(), input.getTeamList(), input.getShipList());
        Simulation simulation = new Simulation(simulationConfig);
        simulation.run();
    }
}
