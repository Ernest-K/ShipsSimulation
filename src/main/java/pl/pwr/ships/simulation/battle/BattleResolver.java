package pl.pwr.ships.simulation.battle;

import pl.pwr.ships.simulation.ship.ShipPosition;
import pl.pwr.ships.simulation.ship.ShipStatistic;
import pl.pwr.ships.simulation.statistic.DefaultStatisticCalculator;
import pl.pwr.ships.simulation.statistic.StatisticCalculator;
import pl.pwr.ships.simulation.terrain.Terrain;

public class BattleResolver {
    private final Terrain terrain;

    public BattleResolver(Terrain terrain) {
        this.terrain = terrain;
    }

    public BattleResult resolve(Battle battle){
        ShipPosition attackerShipPosition = battle.getAttacker();
        ShipPosition defenderShipPosition = battle.getDefender();

        StatisticCalculator statisticCalculator = new DefaultStatisticCalculator(attackerShipPosition.getShip().getShipStatistic(), defenderShipPosition.getShip().getShipStatistic());

        statisticCalculator.applyTerrainBonus(terrain.getTerrainTile(attackerShipPosition.getPosition()).getTerrainTileBonus(), terrain.getTerrainTile(defenderShipPosition.getPosition()).getTerrainTileBonus());
        statisticCalculator.applyRangeBonus();

        ShipStatistic attackerStatistic = statisticCalculator.getAttackerStatistic();
        ShipStatistic defenderStatistic = statisticCalculator.getDefenderStatistic();

        //Less = better
        double attackerTotalStrokes = getTotalStrokes(attackerStatistic.getAttack(), defenderStatistic.getDefend());
        double defenderTotalStrokes = getTotalStrokes(defenderStatistic.getAttack(), attackerStatistic.getDefend());

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
}
