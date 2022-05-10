package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.battle.Battle;
import pl.pwr.shipsSimulation.battle.BattleResolver;
import pl.pwr.shipsSimulation.battle.BattleResult;
import pl.pwr.shipsSimulation.position.PositionController;

import java.util.ArrayList;
import java.util.List;

public class ShipsController {
    private List<Ship> shipList;
    private final PositionController positionController;
    private final BattleResolver battleResolver;
    public final List<ShipPosition> shipPositionList;

    public ShipsController(List<Ship> shipList, PositionController positionController, BattleResolver battleResolver) {
        this.shipList = shipList;
        this.positionController = positionController;
        this.battleResolver = battleResolver;
        this.shipPositionList = positionController.getShipPositionList();
    }

    public void checkConflict(){
        List<ShipPosition> shipPositionsToRemove = new ArrayList<>();

        for (ShipPosition shipPosition : shipPositionList){
            if(shipPositionsToRemove.contains(shipPosition)){
                continue;
            }
            ShipPosition conflictShipPosition;
            if((conflictShipPosition = isConflict(shipPosition)) != null){
                BattleResult battleResult = battleResolver.resolve(new Battle(shipPosition, conflictShipPosition));
                shipPositionsToRemove.add(battleResult.getLoserShip());
            }
        }

        this.shipPositionList.removeAll(shipPositionsToRemove);
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
