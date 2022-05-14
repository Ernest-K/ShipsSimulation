package pl.pwr.shipsSimulation.terrain.tile.type;

import pl.pwr.shipsSimulation.terrain.tile.TerrainTile;
import pl.pwr.shipsSimulation.terrain.tile.TerrainTileBonus;

public class DefaultWater implements TerrainTile {
    TerrainTileBonus terrainTileBonus;

    public DefaultWater() {
        this.terrainTileBonus = new TerrainTileBonus();
    }

    @Override
    public TerrainTileBonus getTerrainTileBonus() {
        return terrainTileBonus;
    }
}
