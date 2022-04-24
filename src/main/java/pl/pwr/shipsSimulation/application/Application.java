package pl.pwr.shipsSimulation.application;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.position.PositionController;
import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.ship.ShipPositionMap;
import pl.pwr.shipsSimulation.ship.ShipType;
import pl.pwr.shipsSimulation.ship.SimpleShip;
import pl.pwr.shipsSimulation.team.Team;
import pl.pwr.shipsSimulation.terrain.TerrainBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


public class Application {
    public static void main(String[] args) {
        Random seed = new Random();
        BoardSize boardSize = new BoardSize(32,32);
        TerrainBoard terrainBoard = new TerrainBoard(seed, boardSize);

        List<Team> teamList = new ArrayList<>();
        teamList.add(new Team("Blue"));
        teamList.add(new Team("Red"));

        List<Ship> shipList = new ArrayList<>();
        shipList.add(new SimpleShip(teamList.get(0).getId(), ShipType.BATTLE_SHIP));
        shipList.add(new SimpleShip(teamList.get(1).getId(), ShipType.AIRCRAFT_CARRIER));

        PositionController positionController = new PositionController(seed, boardSize);
        ShipPositionMap shipPositionMap = new ShipPositionMap(shipList, positionController);

        AtomicBoolean conflict = new AtomicBoolean(false);
        AtomicInteger moves = new AtomicInteger(0);

        while(!conflict.get()){
            shipList.forEach(ship -> {
                shipPositionMap.moveShip(ship);
                moves.getAndIncrement();
                if (shipPositionMap.isShipConflict(ship)){
                    conflict.set(true);
                }
            });
        }

        System.out.println("Ship conflict after " + moves + " moves");
    }
}
