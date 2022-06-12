package pl.pwr.ships.simulation.statistic;

import pl.pwr.ships.simulation.ship.ShipStatistic;
import pl.pwr.ships.simulation.terrain.tile.TerrainTileBonus;

public interface StatisticCalculator {
    void applyTerrainBonus(TerrainTileBonus attackerTerrainTileBonus, TerrainTileBonus defenderTerrainTileBonus);
    void applyRangeBonus();
    ShipStatistic getAttackerStatistic();
    ShipStatistic getDefenderStatistic();
}
