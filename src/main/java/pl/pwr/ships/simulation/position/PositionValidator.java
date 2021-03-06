package pl.pwr.ships.simulation.position;

import pl.pwr.ships.simulation.board.BoardSize;

import java.util.List;

public class PositionValidator {
    private final BoardSize boardSize;

    public PositionValidator(BoardSize boardSize) {
        this.boardSize = boardSize;
    }

    public boolean isOccupied(List<Position> positionList, Position position){
        return positionList.stream().anyMatch(value -> value.equals(position));
    }

    public boolean isBorderCollision(Position position){
        return position.getX() < 0 || position.getX() > boardSize.getWidth() - 1 || position.getY() < 0 || position.getY() > boardSize.getHeight() - 1;
    }
}
