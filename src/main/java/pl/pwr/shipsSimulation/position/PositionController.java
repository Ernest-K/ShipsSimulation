package pl.pwr.shipsSimulation.position;

import pl.pwr.shipsSimulation.map.MapSize;
import pl.pwr.shipsSimulation.ship.Ship;

import java.util.*;

public class PositionController {
    private final Random seed;
    private final MapSize mapSize;
    private final PositionValidator positionValidator;
    private final RandomPositionGenerator randomPositionGenerator;

    public PositionController(Random seed, MapSize mapSize) {
        this.seed = seed;
        this.mapSize = mapSize;
        this.positionValidator = new PositionValidator();
        this.randomPositionGenerator = new RandomPositionGenerator(seed, mapSize);
    }

    public Map<Ship, Position> setOnRandomPosition(List<Ship> shipList){
        Map<Ship, Position> shipPositionMap = new HashMap<>();
        shipList.forEach(ship -> {
            Position tempPosition = randomPositionGenerator.getPosition();
            while(!positionValidator.isOccupied(new ArrayList<>(shipPositionMap.values()), tempPosition)){
                tempPosition = randomPositionGenerator.getPosition();
            }
            shipPositionMap.put(ship, tempPosition);
        });
        return shipPositionMap;
    }
}
