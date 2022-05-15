package pl.pwr.shipsSimulation.application;

import pl.pwr.shipsSimulation.battle.BattleResolver;
import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.position.PositionController;
import pl.pwr.shipsSimulation.position.RandomPositionGenerator;
import pl.pwr.shipsSimulation.ship.*;
import pl.pwr.shipsSimulation.ship.type.ShipType;
import pl.pwr.shipsSimulation.team.Team;
import pl.pwr.shipsSimulation.terrain.Terrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Application {
    public static void main(String[] args) {
        long seed = new Random().nextLong();
        BoardSize boardSize = new BoardSize(16,16);
        Terrain terrain = new Terrain(seed, boardSize);
        BattleResolver battleResolver = new BattleResolver(terrain);
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(seed, boardSize);

        List<Team> teamList = new ArrayList<>();
        teamList.add(new Team("Blue"));
        teamList.add(new Team("Red"));
        teamList.add(new Team("Green"));

        List<Ship> shipList = new ArrayList<>();
        shipList.add(ShipFactory.getShip(ShipType.BRIGANTINE, teamList.get(0)));
        shipList.add(ShipFactory.getShip(ShipType.GALLEON, teamList.get(1)));
        shipList.add(ShipFactory.getShip(ShipType.SLOOP, teamList.get(2)));

        List<ShipPosition> shipPositionList = randomPositionGenerator.generate(shipList);
        PositionController positionController = new PositionController(boardSize, shipPositionList);
        ShipsController shipsController = new ShipsController(positionController, battleResolver);

        shipPositionList.forEach(shipPosition -> System.out.println(shipPosition.getShip().getTeam().getName()+"    "+shipPosition.getPosition()));

        AtomicInteger moves = new AtomicInteger(0);

        while(shipsController.getTeamListSize()>1){
            shipsController.checkConflict();
            shipsController.moveShips();
            moves.getAndIncrement();
        }

        System.out.println("Simulation over after " + moves + " moves");
    }
}
