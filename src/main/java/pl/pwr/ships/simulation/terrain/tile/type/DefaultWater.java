package pl.pwr.ships.simulation.terrain.tile.type;

import pl.pwr.ships.simulation.terrain.tile.TerrainTile;
import pl.pwr.ships.simulation.terrain.tile.TerrainTileBonus;

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
