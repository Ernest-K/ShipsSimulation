package pl.pwr.shipsSimulation.position;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.ship.ShipPosition;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
    private final BoardSize boardSize;
    private final PositionValidator positionValidator;
    private List<ShipPosition> shipPositionList;

    public PositionController(BoardSize boardSize, List<ShipPosition> shipPositionList) {
        this.boardSize = boardSize;
        this.positionValidator = new PositionValidator(boardSize);
        this.shipPositionList = shipPositionList;
    }

    public Position randomMove(Position position){
        Direction randomDirection = Direction.getRandomDirection();
        Position newPosition = changePosition(position, randomDirection);
        while(positionValidator.isBorderCollision(newPosition) || positionValidator.isOccupied(getPositionList(this.shipPositionList), newPosition)){
            randomDirection = Direction.getRandomDirection();
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

    public boolean isInRange(Position position1, Position position2, int range){
        return position1.getX() >= position2.getX() - range && position1.getX() <= position2.getX() + range && position1.getY() >= position2.getY() - range && position1.getY() <= position2.getY() + range;
    }

    private List<Position> getPositionList(List<ShipPosition> shipPositionList){
        return shipPositionList.stream().map(ShipPosition::getPosition).toList();
    }

    public List<ShipPosition> getShipPositionList() {
        return shipPositionList;
    }
}
