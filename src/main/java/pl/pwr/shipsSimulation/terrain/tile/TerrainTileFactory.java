package pl.pwr.shipsSimulation.terrain.tile;

import pl.pwr.shipsSimulation.terrain.tile.type.TerrainTileType;

public class TerrainTileFactory {
    public static TerrainTile getTerrainTile(TerrainTileType type){
        return type.getConstructor().get();
    }
}
