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

        System.out.println(terrain.getTerrainTile(attackerShipPosition.getPosition()).getTerrainTileBonus() + "  " + terrain.getTerrainTile(defenderShipPosition.getPosition()).getTerrainTileBonus());
        System.out.println(attackerShipStatistic + "  " + defenderShipStatistic);

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
