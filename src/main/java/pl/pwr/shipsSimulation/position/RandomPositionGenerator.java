package pl.pwr.shipsSimulation.position;

import pl.pwr.shipsSimulation.board.BoardSize;

import java.util.Random;

public class RandomPositionGenerator {
    private final Random seed;
    private final BoardSize boardSize;

    public RandomPositionGenerator(Random seed, BoardSize boardSize) {
        this.seed = seed;
        this.boardSize = boardSize;
    }

    public Position generatePosition(){
        return new Position(seed.nextInt(boardSize.getWidth()), seed.nextInt(boardSize.getHeight()));
    }
}
