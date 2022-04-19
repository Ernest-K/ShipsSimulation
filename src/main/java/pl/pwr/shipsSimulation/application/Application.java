package pl.pwr.shipsSimulation.application;

import pl.pwr.shipsSimulation.map.MapSize;
import pl.pwr.shipsSimulation.position.PositionController;
import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.ship.ShipPositionMap;
import pl.pwr.shipsSimulation.ship.ShipType;
import pl.pwr.shipsSimulation.ship.SimpleShip;
import pl.pwr.shipsSimulation.team.Team;
import pl.pwr.shipsSimulation.terrain.TerrainMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Application {
    public static void main(String[] args) {
        Random seed = new Random();
        MapSize mapSize = new MapSize(48,48);
        TerrainMap terrainMap = new TerrainMap(seed, mapSize);

        List<Team> teamList = new ArrayList<>();
        teamList.add(new Team("Blue"));
        teamList.add(new Team("Red"));

        List<Ship> shipList = new ArrayList<>();
        shipList.add(new SimpleShip(teamList.get(0).getId(), ShipType.BATTLE_SHIP));
        shipList.add(new SimpleShip(teamList.get(1).getId(), ShipType.AIRCRAFT_CARRIER));

        PositionController positionController = new PositionController(seed, mapSize);
        ShipPositionMap shipPositionMap = new ShipPositionMap(shipList, positionController);

        shipList.forEach(ship -> System.out.println(shipPositionMap.getPositionOfShip(ship)));
        shipPositionMap.moveShips();
        shipList.forEach(ship -> System.out.println(shipPositionMap.getPositionOfShip(ship)));

    }
}
