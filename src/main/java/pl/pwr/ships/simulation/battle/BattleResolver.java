package pl.pwr.ships.simulation.battle;

import pl.pwr.ships.simulation.ship.ShipPosition;
import pl.pwr.ships.simulation.ship.ShipStatistic;
import pl.pwr.ships.simulation.terrain.Terrain;

public class BattleResolver {
    private final Terrain terrain;

    public BattleResolver(Terrain terrain) {
        this.terrain = terrain;
    }

    public BattleResult resolve(Battle battle){
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
            return BattleResult.builder()
                    .winnerShip(attackerShipPosition)
                    .loserShip(defenderShipPosition)
                    .build();
        }else{
            return BattleResult.builder()
                    .winnerShip(defenderShipPosition)
                    .loserShip(attackerShipPosition)
                    .build();
        }
    }

    private double getTotalStrokes(double attack, double defend ){
        return defend/attack;
    }

    private double calculateAttackBonus(int attackerRange, int defenderRange){
        return 1 + (Math.abs(attackerRange - defenderRange)/10.0);
    }

}
