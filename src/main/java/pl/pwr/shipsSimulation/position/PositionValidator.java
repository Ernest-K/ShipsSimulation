package pl.pwr.shipsSimulation.position;

import java.util.List;

public class PositionValidator {
    public PositionValidator() {
    }

    public boolean isOccupied(List<Position> positionList, Position position){
        return positionList.stream().noneMatch(value -> value.equals(position));
    }
}
