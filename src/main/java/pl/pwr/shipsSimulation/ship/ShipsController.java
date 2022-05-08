package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.battle.BattleResolver;
import pl.pwr.shipsSimulation.position.PositionController;

import java.util.ArrayList;
import java.util.List;

public class ShipsController {
    private List<Ship> shipList;
    private final PositionController positionController;
    private final BattleResolver battleResolver;
    public final List<ShipPosition> shipPositionList;

    public ShipsController(List<Ship> shipList, PositionController positionController) {
        this.shipList = shipList;
        this.positionController = positionController;
        this.battleResolver = new BattleResolver();
        this.shipPositionList = positionController.setOnRandomPosition(shipList);
    }

    public void checkConflict(){
        List<ShipPosition> shipPositionsToRemove = new ArrayList<>();

        for (ShipPosition shipPosition : shipPositionList){
            ShipPosition conflictShipPosition;
            if((conflictShipPosition = isConflict(shipPosition)) != null){
                shipPositionsToRemove.add(battleResolver.resolve(shipPosition, conflictShipPosition));
            }
        }

        shipPositionsToRemove.forEach(shipPositionList::remove);
        updateShipList();
    }

    public void moveShips(){
        for (ShipPosition shipPosition : shipPositionList){
            moveShip(shipPosition);
        }
    }

    private ShipPosition isConflict(ShipPosition referenceShipPosition){
        List<ShipPosition> conflictShipList = shipPositionList.stream()
                .filter(shipPosition -> shipPosition.getShip().getTeamId() != referenceShipPosition.getShip().getTeamId())
                .toList();

        for (ShipPosition shipPosition : conflictShipList){
            if (positionController.isInRange(referenceShipPosition.getPosition(), shipPosition.getPosition(), referenceShipPosition.getShip().getShipStatistic().getRange())){
                return shipPosition;
            }
        }
        return null;
    }

    private void moveShip(ShipPosition shipPosition){
        shipPosition.setPosition(positionController.randomMove(shipPosition.getPosition()));
    }

    public int getTeamListSize(){
        return shipList.stream().map(Ship::getTeamId).distinct().toList().size();
    }

    private void updateShipList(){
        this.shipList = shipPositionList.stream().map(ShipPosition::getShip).toList();
    }
}
