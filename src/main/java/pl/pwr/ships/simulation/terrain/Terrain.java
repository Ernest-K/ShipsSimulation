package pl.pwr.ships.simulation.terrain;

import pl.pwr.ships.simulation.position.Position;
import pl.pwr.ships.simulation.terrain.tile.TerrainTile;

import java.util.List;

public class Terrain {
    private final List<TerrainTile> terrainTileList;
    private int[][] terrainIdMap;

    public Terrain(List<TerrainTile> terrainTileList, int [][]terrainIdMap) {
        this.terrainTileList = terrainTileList;
        this.terrainIdMap = terrainIdMap;
    }

    public TerrainTile getTerrainTile(Position position){
        return terrainTileList.get(terrainIdMap[position.getX()][position.getY()]);
    }
}
