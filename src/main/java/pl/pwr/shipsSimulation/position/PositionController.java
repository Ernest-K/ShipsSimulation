package pl.pwr.shipsSimulation.position;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.ship.ShipPosition;

import java.util.List;

public class PositionController {
    private final PositionValidator positionValidator;
    private final List<ShipPosition> shipPositionList;

    public PositionController(BoardSize boardSize, List<ShipPosition> shipPositionList) {
        this.positionValidator = new PositionValidator(boardSize);
        this.shipPositionList = shipPositionList;
    }

    public Position randomMove(Position position){
        Position newPosition;
        do{
            newPosition = changePosition(position, Direction.getRandomDirection());
        }while(positionValidator.isBorderCollision(newPosition) || positionValidator.isOccupied(getPositionList(this.shipPositionList), newPosition));

        return newPosition;
    }

    private Position changePosition(Position position, Direction direction){
        Position newPosition = new Position(position.getX(), position.getY());
        switch (direction) {
            case TOP -> newPosition.setY(newPosition.getY() + 1);
            case BOTTOM -> newPosition.setY(newPosition.getY() - 1);
            case LEFT -> newPosition.setX(newPosition.getX() - 1);
            case RIGHT -> newPosition.setX(newPosition.getX() + 1);
        }
        return newPosition;
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
