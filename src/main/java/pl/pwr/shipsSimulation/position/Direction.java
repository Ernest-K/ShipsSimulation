package pl.pwr.shipsSimulation.position;

import java.util.Random;

public enum Direction {
    TOP, BOTTOM, LEFT, RIGHT;

    public static Direction getRandomDirection(){
        return values()[new Random().nextInt(values().length)];
    }
}
