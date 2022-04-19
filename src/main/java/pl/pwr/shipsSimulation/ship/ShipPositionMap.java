package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.position.Position;
import pl.pwr.shipsSimulation.position.PositionController;

import java.util.List;
import java.util.Map;

public class ShipPositionMap {
    private final List<Ship> shipList;
    private final PositionController positionController;
    private final Map<Ship, Position> shipPositions;

    public ShipPositionMap(List<Ship> shipList, PositionController positionController) {
        this.shipList = shipList;
        this.positionController = positionController;
        this.shipPositions = positionController.setOnRandomPosition(shipList);
    }

    public Position getPositionOfShip(Ship ship){
        return shipPositions.get(ship);
    }

    public void moveShip(Ship ship){
        shipPositions.replace(ship, positionController.RandomMove(shipPositions.get(ship)));
    }

}
