package pl.pwr.shipsSimulation.position;

import pl.pwr.shipsSimulation.board.BoardSize;

import java.util.Random;

public class RandomPositionGenerator {
    private final Random random;
    private final BoardSize boardSize;

    public RandomPositionGenerator(long seed, BoardSize boardSize) {
        this.random = new Random(seed);
        this.boardSize = boardSize;
    }

    public Position generatePosition(){
        return new Position(random.nextInt(boardSize.getWidth()), random.nextInt(boardSize.getHeight()));
    }
}
