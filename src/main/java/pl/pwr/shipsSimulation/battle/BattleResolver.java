package pl.pwr.shipsSimulation.battle;

import pl.pwr.shipsSimulation.ship.ShipPosition;

public class BattleResolver {
    public BattleResolver() {
    }

//    return loser
    public ShipPosition resolve(ShipPosition shipPosition1, ShipPosition shipPosition2){
        if (shipPosition1.getShip().getShipStatistic().getAttack() > shipPosition2.getShip().getShipStatistic().getAttack()){
            return shipPosition2;
        }else{
            return shipPosition1;
        }
    }
}
