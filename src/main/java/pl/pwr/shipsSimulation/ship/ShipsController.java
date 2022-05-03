package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.position.PositionController;

import java.util.List;

public class ShipsController {
    private final List<Ship> shipList;
    private final PositionController positionController;
    public final List<ShipPosition> shipPositionList;

    public ShipsController(List<Ship> shipList, PositionController positionController) {
        this.shipList = shipList;
        this.positionController = positionController;
        this.shipPositionList = positionController.setOnRandomPosition(shipList);
    }

    public void update(){
        for (ShipPosition shipPosition : shipPositionList){
            moveShip(shipPosition);
            Ship conflictShip;
            if((conflictShip = isConflict(shipPosition)) != null){
                shipList.remove(conflictShip);
                shipPositionList.remove(conflictShip);
            }
        }
    }

    private Ship isConflict(ShipPosition referenceShipPosition){
        List<ShipPosition> conflictShipList = shipPositionList.stream()
                .filter(shipPosition -> shipPosition.getShip().getTeamId() != referenceShipPosition.getShip().getTeamId())
                .toList();

        for (ShipPosition shipPosition : conflictShipList){
            if (positionController.isInRange(referenceShipPosition.getPosition(), shipPosition.getPosition(), referenceShipPosition.getShip().getShipStatistic().getRange())){
                return shipPosition.getShip();
            }
        }
        return null;

    }

    public int getTeamListSize(){
        return shipList.stream().map(Ship::getTeamId).distinct().toList().size();
    }

    private void moveShip(ShipPosition shipPosition){
        shipPosition.setPosition(positionController.randomMove(shipPosition.getPosition()));
    }
}
