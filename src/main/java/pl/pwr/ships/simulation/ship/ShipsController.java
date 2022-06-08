package pl.pwr.ships.simulation.ship;

import pl.pwr.ships.simulation.battle.Battle;
import pl.pwr.ships.simulation.battle.BattleResolver;
import pl.pwr.ships.simulation.battle.BattleResult;
import pl.pwr.ships.simulation.position.Position;
import pl.pwr.ships.simulation.position.PositionController;
import pl.pwr.ships.simulation.team.Team;

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

    public List<BattleResult> checkConflict(){
        List<ShipPosition> shipPositionsToRemove = new ArrayList<>();
        List<BattleResult> battleResultList = new ArrayList<>();

        for (ShipPosition shipPosition : shipPositionList){
            ShipPosition conflictShipPosition;
            if((conflictShipPosition = isConflict(shipPosition)) != null){
                //Prevent same battle twice
                if(shipPositionsToRemove.contains(shipPosition) || shipPositionsToRemove.contains(conflictShipPosition)){
                    continue;
                }
                BattleResult battleResult = battleResolver.resolve(new Battle(shipPosition, conflictShipPosition));
                battleResultList.add(battleResult);
                shipPositionsToRemove.add(battleResult.getLoserShip());
            }
        }

        this.shipPositionList.removeAll(shipPositionsToRemove);
        return battleResultList;
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
        shipPosition.setPosition(newPosition);
    }

    public List<Team> getTeamList(){
        return shipPositionList.stream().map(shipPosition -> shipPosition.getShip().getTeam()).distinct().toList();
    }

}
