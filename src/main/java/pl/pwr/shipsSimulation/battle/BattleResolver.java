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

        ShipStatistic attackerShipStatistic = attackerShipPosition.getShip().getShipStatistic().applyTerrainBonus(terrain.getTerrainTile(attackerShipPosition.getPosition()).getTerrainTileBonus());
        ShipStatistic defenderShipStatistic = defenderShipPosition.getShip().getShipStatistic().applyTerrainBonus(terrain.getTerrainTile(defenderShipPosition.getPosition()).getTerrainTileBonus());

        double attackBonus = calculateAttackBonus(attackerShipStatistic.getRange(), defenderShipStatistic.getRange());

        if(attackerShipStatistic.getRange() > defenderShipStatistic.getRange()){
            attackerShipStatistic = attackerShipStatistic.applyRangeBonus(attackBonus);
        }else{
            defenderShipStatistic = defenderShipStatistic.applyRangeBonus(attackBonus);
        }

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

    private double calculateAttackBonus(int attackerRange, int defenderRange){
        return 1 + (Math.abs(attackerRange - defenderRange)/10.0);
    }

}
