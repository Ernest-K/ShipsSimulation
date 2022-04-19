package pl.pwr.shipsSimulation.position;

import java.util.Random;

public enum Direction {
    TOP, BOTTOM, LEFT, RIGHT;

    public static Direction getRandomDirection(Random random){
        return values()[random.nextInt(values().length)];
    }
}
