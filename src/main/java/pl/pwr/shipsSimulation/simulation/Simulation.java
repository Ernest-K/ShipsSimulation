package pl.pwr.shipsSimulation.simulation;

import pl.pwr.shipsSimulation.battle.BattleResolver;
import pl.pwr.shipsSimulation.battle.BattleResult;
import pl.pwr.shipsSimulation.position.PositionController;
import pl.pwr.shipsSimulation.position.RandomPositionGenerator;
import pl.pwr.shipsSimulation.ship.ShipPosition;
import pl.pwr.shipsSimulation.ship.ShipsController;
import pl.pwr.shipsSimulation.terrain.Terrain;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Simulation {
    private final long seed;
    private final Terrain terrain;
    private final BattleResolver battleResolver;
    private final RandomPositionGenerator randomPositionGenerator;
    private final PositionController positionController;
    private final ShipsController shipsController;
    private final List<ShipPosition> shipPositionList;

    public Simulation(SimulationConfig simulationConfig) {
        this.seed = new Random().nextLong();
        this.terrain = new Terrain(seed, simulationConfig.getBoardSize());
        this.battleResolver = new BattleResolver(this.terrain);
        this.randomPositionGenerator = new RandomPositionGenerator(seed, simulationConfig.getBoardSize());
        this.shipPositionList = this.randomPositionGenerator.generate(simulationConfig.getShipList());
        this.positionController = new PositionController(simulationConfig.getBoardSize(), this.shipPositionList);
        this.shipsController = new ShipsController(this.positionController, this.battleResolver);
    }

    public void run(){
        AtomicInteger turn = new AtomicInteger();
        List<BattleResult> battleResultList;
        while(this.shipsController.getTeamList().size()>1){
            battleResultList = this.shipsController.checkConflict();
            battleResultList.forEach(battleResult -> {
                System.out.println(battleResult.getWinnerShip().getShip().getTeam().getName() + " Team " + battleResult.getWinnerShip().getShip().getClass().getSimpleName() + " destroyed " + battleResult.getLoserShip().getShip().getTeam().getName() + " Team " + battleResult.getLoserShip().getShip().getClass().getSimpleName() + " in " + turn + " turn");
            });
            this.shipsController.moveShips();
            turn.getAndIncrement();
        }
        int totalTurns = turn.get()-1;

        System.out.println(this.shipsController.getTeamList().get(0).getName() + " Team win");
        System.out.println("Simulation over after " + totalTurns + " turns");
    }
}
