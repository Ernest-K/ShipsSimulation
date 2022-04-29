package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.position.Position;
import pl.pwr.shipsSimulation.position.PositionController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShipController {
    private final List<Ship> shipList;
    private final PositionController positionController;
    private final Map<Ship, Position> shipPositions;

    public ShipController(List<Ship> shipList, PositionController positionController) {
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

    public boolean isShipConflict(Ship ship){
        List<Position> positionList = new ArrayList<>();
        shipPositions.forEach((shipKey, position) -> {
            if(!shipKey.equals(ship)){
                positionList.add(position);
            }
        });
        return positionController.isOtherPositionInRange(shipPositions.get(ship), positionList, ship.getType().getShipStatistic().getRange());
    }

}
