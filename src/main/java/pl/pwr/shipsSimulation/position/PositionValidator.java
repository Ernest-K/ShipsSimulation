package pl.pwr.shipsSimulation.position;

import pl.pwr.shipsSimulation.map.MapSize;

import java.util.List;

public class PositionValidator {
    private final MapSize mapSize;

    public PositionValidator(MapSize mapSize) {
        this.mapSize = mapSize;
    }

    public boolean isOccupied(List<Position> positionList, Position position){
        return positionList.stream().noneMatch(value -> value.equals(position));
    }

    public boolean borderCollision(Position position){
        return position.getX() < 0 || position.getX() > mapSize.getWidth() - 1 || position.getY() < 0 || position.getY() > mapSize.getHeight() - 1;
    }
}
