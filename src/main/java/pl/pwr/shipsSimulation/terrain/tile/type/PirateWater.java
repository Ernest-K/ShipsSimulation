package pl.pwr.shipsSimulation.terrain.tile.type;

import pl.pwr.shipsSimulation.terrain.tile.TerrainTile;
import pl.pwr.shipsSimulation.terrain.tile.TerrainTileBonus;

public class PirateWater implements TerrainTile {
    TerrainTileBonus terrainTileBonus;

    public PirateWater() {
        this.terrainTileBonus = new TerrainTileBonus(1.1, 0.9);
    }

    @Override
    public TerrainTileBonus getTerrainTileBonus() {
        return terrainTileBonus;
    }
}
