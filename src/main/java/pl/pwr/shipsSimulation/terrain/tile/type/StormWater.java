package pl.pwr.shipsSimulation.terrain.tile.type;

import pl.pwr.shipsSimulation.terrain.tile.TerrainTile;
import pl.pwr.shipsSimulation.terrain.tile.TerrainTileBonus;

public class StormWater implements TerrainTile {
    TerrainTileBonus terrainTileBonus;

    public StormWater() {
        this.terrainTileBonus = new TerrainTileBonus(0.9, 1.1);
    }

    @Override
    public TerrainTileBonus getTerrainTileBonus() {
        return terrainTileBonus;
    }
}
