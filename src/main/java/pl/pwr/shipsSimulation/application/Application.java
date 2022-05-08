package pl.pwr.shipsSimulation.application;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.position.PositionController;
import pl.pwr.shipsSimulation.ship.BaseShip;
import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.ship.ShipsController;
import pl.pwr.shipsSimulation.ship.ShipType;
import pl.pwr.shipsSimulation.team.Team;
import pl.pwr.shipsSimulation.terrain.Terrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Application {
    public static void main(String[] args) {
        long seed = new Random().nextLong();
        BoardSize boardSize = new BoardSize(32,32);
        Terrain terrain = new Terrain(seed, boardSize);

        List<Team> teamList = new ArrayList<>();
        teamList.add(new Team("Blue"));
        teamList.add(new Team("Red"));
        teamList.add(new Team("Green"));

        List<Ship> shipList = new ArrayList<>();
        shipList.add(new BaseShip(teamList.get(0).getId(), ShipType.BATTLE_SHIP));
        shipList.add(new BaseShip(teamList.get(1).getId(), ShipType.AIRCRAFT_CARRIER));
        shipList.add(new BaseShip(teamList.get(2).getId(), ShipType.CRUISER));

        PositionController positionController = new PositionController(seed, boardSize);
        ShipsController shipsController = new ShipsController(shipList, positionController);

        AtomicInteger moves = new AtomicInteger(0);

        while(shipsController.getTeamListSize()>1){
            shipsController.checkConflict();
            shipsController.moveShips();
            moves.getAndIncrement();
        }

        System.out.println("Simulation over after " + moves + " moves");
    }
}
