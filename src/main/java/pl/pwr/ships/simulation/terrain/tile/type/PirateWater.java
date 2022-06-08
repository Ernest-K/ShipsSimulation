package pl.pwr.ships.simulation.terrain.tile.type;

import pl.pwr.ships.simulation.terrain.tile.TerrainTile;
import pl.pwr.ships.simulation.terrain.tile.TerrainTileBonus;

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
