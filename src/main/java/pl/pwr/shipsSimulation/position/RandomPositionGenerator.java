package pl.pwr.shipsSimulation.position;

import pl.pwr.shipsSimulation.map.MapSize;

import java.util.Random;

public class RandomPositionGenerator {
    private final Random seed;
    private final MapSize mapSize;

    public RandomPositionGenerator(Random seed, MapSize mapSize) {
        this.seed = seed;
        this.mapSize = mapSize;
    }

    public Position getPosition(){
        return new Position(seed.nextInt(mapSize.getWidth()), seed.nextInt(mapSize.getHeight()));
    }
}
