package pl.pwr.shipsSimulation.position;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.ship.Ship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PositionController {
    private final Random seed;
    private final BoardSize boardSize;
    private final PositionValidator positionValidator;
    private final RandomPositionGenerator randomPositionGenerator;

    public PositionController(Random seed, BoardSize boardSize) {
        this.seed = seed;
        this.boardSize = boardSize;
        this.positionValidator = new PositionValidator(boardSize);
        this.randomPositionGenerator = new RandomPositionGenerator(seed, boardSize);
    }

    public Map<Ship, Position> setOnRandomPosition(List<Ship> shipList){
        Map<Ship, Position> shipPositionMap = new HashMap<>();
        shipList.forEach(ship -> {
            Position tempPosition = randomPositionGenerator.generatePosition();
            while(!positionValidator.isOccupied(new ArrayList<>(shipPositionMap.values()), tempPosition)){
                tempPosition = randomPositionGenerator.generatePosition();
            }
            shipPositionMap.put(ship, tempPosition);
        });
        return shipPositionMap;
    }

    public Position RandomMove(Position position){
        Direction randomDirection = Direction.getRandomDirection(seed);
        Position newPosition = changePosition(position, randomDirection);
        while(positionValidator.borderCollision(newPosition)){
            randomDirection = Direction.getRandomDirection(seed);
            newPosition = changePosition(position, randomDirection);
        }
        return newPosition;
    }

    private Position changePosition(Position position, Direction direction){
        switch (direction){
            case TOP:
                position.setY(position.getY() + 1);
                break;
            case BOTTOM:
                position.setY(position.getY() - 1);
                break;
            case LEFT:
                position.setX(position.getX() - 1);
                break;
            case RIGHT:
                position.setX(position.getX() + 1);
                break;
        }
        return position;
    }

    public boolean isOtherPositionInRange(Position referencePosition, List<Position> positionList, int range){
        for(Position position : positionList){
            if(isInRange(position, referencePosition, range)){
                return true;
            };
        }
        return false;
    }

    private boolean isInRange(Position position1, Position position2, int range){
        return position1.getX() >= position2.getX() - range && position1.getX() <= position2.getX() + range && position1.getY() >= position2.getY() - range && position1.getY() <= position2.getY() + range;
    }
}
