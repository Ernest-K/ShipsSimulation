package pl.pwr.shipsSimulation.position;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.ship.ShipPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PositionController {
    private final Random seed;
    private final BoardSize boardSize;
    private final PositionValidator positionValidator;
    private final RandomPositionGenerator randomPositionGenerator;
    private List<ShipPosition> shipPositionList;

    public PositionController(Random seed, BoardSize boardSize) {
        this.seed = seed;
        this.boardSize = boardSize;
        this.positionValidator = new PositionValidator(boardSize);
        this.randomPositionGenerator = new RandomPositionGenerator(seed, boardSize);
    }

    public List<ShipPosition> setOnRandomPosition(List<Ship> shipList){
        List<ShipPosition> shipPositionList = new ArrayList<>();
        for (Ship ship : shipList){
            Position tempPosition = randomPositionGenerator.generatePosition();
            while(!positionValidator.isOccupied(getPositionList(shipPositionList), tempPosition)){
                tempPosition = randomPositionGenerator.generatePosition();
            }
            shipPositionList.add(new ShipPosition(ship, tempPosition));
        }
        this.shipPositionList = shipPositionList;
        return shipPositionList;
    }

    public Position randomMove(Position position){
        Direction randomDirection = Direction.getRandomDirection(seed);
        Position newPosition = changePosition(position, randomDirection);
        while(positionValidator.isBorderCollision(newPosition) || positionValidator.isOccupied(getPositionList(this.shipPositionList), newPosition)){
            randomDirection = Direction.getRandomDirection(seed);
            newPosition = changePosition(position, randomDirection);
        }
        return newPosition;
    }

    private Position changePosition(Position position, Direction direction){
        switch (direction) {
            case TOP -> position.setY(position.getY() + 1);
            case BOTTOM -> position.setY(position.getY() - 1);
            case LEFT -> position.setX(position.getX() - 1);
            case RIGHT -> position.setX(position.getX() + 1);
        }
        return position;
    }

    public boolean isOtherPositionInRange(Position referencePosition, List<Position> positionList, int range){
        for(Position position : positionList){
            if(isInRange(position, referencePosition, range)){
                return true;
            }
        }
        return false;
    }

    public boolean isInRange(Position position1, Position position2, int range){
        return position1.getX() >= position2.getX() - range && position1.getX() <= position2.getX() + range && position1.getY() >= position2.getY() - range && position1.getY() <= position2.getY() + range;
    }

    private List<Position> getPositionList(List<ShipPosition> shipPositionList){
        return shipPositionList.stream().map(ShipPosition::getPosition).toList();
    }
}
