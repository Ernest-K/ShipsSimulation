package pl.pwr.ships.simulation.application;

import pl.pwr.ships.simulation.input.Input;
import pl.pwr.ships.simulation.simulation.Simulation;
import pl.pwr.ships.simulation.simulation.SimulationConfig;

public class Application {
    public static void main(String[] args) {
        ArgumentParser argumentParser = new ArgumentParser(args);

        Input input = argumentParser.parse();

        SimulationConfig simulationConfig = new SimulationConfig(input.getBoardSize(), input.getTeamList(), input.getShipList());
        Simulation simulation = new Simulation(simulationConfig);
        simulation.run();
    }
}
