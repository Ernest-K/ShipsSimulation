package pl.pwr.ships.simulation.terrain.tile;

import pl.pwr.ships.simulation.terrain.tile.type.TerrainTileType;

public class TerrainTileFactory {
    public static TerrainTile getTerrainTile(TerrainTileType type){
        return type.getConstructor().get();
    }
}
