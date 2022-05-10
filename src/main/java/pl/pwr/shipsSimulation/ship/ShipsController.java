package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.battle.Battle;
import pl.pwr.shipsSimulation.battle.BattleResolver;
import pl.pwr.shipsSimulation.battle.BattleResult;
import pl.pwr.shipsSimulation.position.Position;
import pl.pwr.shipsSimulation.position.PositionController;

import java.util.ArrayList;
import java.util.List;

public class ShipsController {
    private final PositionController positionController;
    private final BattleResolver battleResolver;
    public final List<ShipPosition> shipPositionList;

    public ShipsController(PositionController positionController, BattleResolver battleResolver) {
        this.positionController = positionController;
        this.battleResolver = battleResolver;
        this.shipPositionList = positionController.getShipPositionList();
    }

    public void checkConflict(){
        List<ShipPosition> shipPositionsToRemove = new ArrayList<>();

        for (ShipPosition shipPosition : shipPositionList){
            ShipPosition conflictShipPosition;
            if((conflictShipPosition = isConflict(shipPosition)) != null){
                //Prevent same battle twice
                if(shipPositionsToRemove.contains(shipPosition) || shipPositionsToRemove.contains(conflictShipPosition)){
                    continue;
                }
                BattleResult battleResult = battleResolver.resolve(new Battle(shipPosition, conflictShipPosition));
                System.out.println(battleResult.getWinnerShip().getShip().getTeam().getName()+" destroy "+battleResult.getLoserShip().getShip().getTeam().getName());
                shipPositionsToRemove.add(battleResult.getLoserShip());
            }
        }

        this.shipPositionList.removeAll(shipPositionsToRemove);
    }

    public void moveShips(){
        for (ShipPosition shipPosition : shipPositionList){
            moveShip(shipPosition);
        }
    }

    private ShipPosition isConflict(ShipPosition referenceShipPosition){
        List<ShipPosition> conflictShipList = shipPositionList.stream()
                .filter(shipPosition -> shipPosition.getShip().getTeam().getId() != referenceShipPosition.getShip().getTeam().getId())
                .toList();

        for (ShipPosition shipPosition : conflictShipList){
            if (positionController.isInRange(referenceShipPosition.getPosition(), shipPosition.getPosition(), referenceShipPosition.getShip().getShipStatistic().getRange())){
                return shipPosition;
            }
        }
        return null;
    }

    private void moveShip(ShipPosition shipPosition){
        Position newPosition = positionController.randomMove(shipPosition.getPosition());
        System.out.println(shipPosition.getShip().getTeam().getName()+" move to "+newPosition);
        shipPosition.setPosition(newPosition);
    }

    public int getTeamListSize(){
        return shipPositionList.stream().map(shipPosition -> shipPosition.getShip().getTeam()).distinct().toList().size();
    }

}
