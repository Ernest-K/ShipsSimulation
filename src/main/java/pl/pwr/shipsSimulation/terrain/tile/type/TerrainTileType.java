package pl.pwr.shipsSimulation.terrain.tile.type;

import pl.pwr.shipsSimulation.terrain.tile.TerrainTile;

import java.util.function.Supplier;

public enum TerrainTileType{
    DEFAULT_WATER(DefaultWater::new), STORM_WATER(StormWater::new), PIRATE_WATER(PirateWater::new);

    private final Supplier<TerrainTile> constructor;

    TerrainTileType(Supplier<TerrainTile> constructor) {
        this.constructor = constructor;
    }

    public Supplier<TerrainTile> getConstructor() {
        return constructor;
    }
}
