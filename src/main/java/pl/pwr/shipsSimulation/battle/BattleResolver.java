package pl.pwr.shipsSimulation.battle;

import pl.pwr.shipsSimulation.ship.ShipPosition;
import pl.pwr.shipsSimulation.ship.ShipStatistic;
import pl.pwr.shipsSimulation.terrain.Terrain;

public class BattleResolver {
    private final Terrain terrain;

    public BattleResolver(Terrain terrain) {
        this.terrain = terrain;
    }

    public BattleResult resolve(Battle battle){
        BattleResult battleResult = new BattleResult();

        ShipPosition attackerShipPosition = battle.getAttacker();
        ShipPosition defenderShipPosition = battle.getDefender();

        ShipStatistic attackerShipStatistic = attackerShipPosition.getShip().getShipStatistic().applyTerrainBonus(terrain.getTerrainType(attackerShipPosition.getPosition()).getTerrainBonus());
        ShipStatistic defenderShipStatistic = defenderShipPosition.getShip().getShipStatistic().applyTerrainBonus(terrain.getTerrainType(defenderShipPosition.getPosition()).getTerrainBonus());

        System.out.println(terrain.getTerrainType(attackerShipPosition.getPosition())+"  "+terrain.getTerrainType(defenderShipPosition.getPosition()));
        System.out.println(attackerShipStatistic+"  "+defenderShipStatistic);

        //Less = better
        double attackerTotalStrokes = getTotalStrokes(attackerShipStatistic.getAttack(), defenderShipStatistic.getDefend());
        double defenderTotalStrokes = getTotalStrokes(defenderShipStatistic.getAttack(), attackerShipStatistic.getDefend());

        if (attackerTotalStrokes < defenderTotalStrokes){
            battleResult.setLoserShip(battle.getDefender());
            battleResult.setWinnerShip(battle.getAttacker());
        }else{
            battleResult.setLoserShip(battle.getAttacker());
            battleResult.setWinnerShip(battle.getDefender());
        }
        return battleResult;
    }

    private double getTotalStrokes(double attack, double defend ){
        return defend/attack;
    }
}
