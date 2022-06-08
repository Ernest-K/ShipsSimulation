package pl.pwr.ships.simulation.terrain;

import pl.pwr.ships.simulation.board.BoardSize;
import pl.pwr.ships.simulation.position.Position;
import pl.pwr.ships.simulation.terrain.tile.TerrainTile;
import pl.pwr.ships.simulation.terrain.tile.TerrainTileFactory;
import pl.pwr.ships.simulation.terrain.tile.type.TerrainTileType;

import java.util.Arrays;
import java.util.List;

public class Terrain {
    public final List<TerrainTile> terrainTileList;
    public final BoardSize boardSize;
    public int[][] terrainIdMap;

    public Terrain(long seed, BoardSize boardSize) {
        this.terrainTileList = Arrays.stream(TerrainTileType.class.getEnumConstants()).map(TerrainTileFactory::getTerrainTile).toList();
//        this.terrainTileTypeList = Arrays.asList(TerrainTileType.class.getEnumConstants());
        this.boardSize = boardSize;
        TerrainGenerator terrainGenerator = new TerrainGenerator(seed, boardSize, terrainTileList);
        this.terrainIdMap = terrainGenerator.generate();
    }

    public void draw(){
        for (int i = 0; i < boardSize.getHeight(); i++) {
            for (int j = 0; j < boardSize.getWidth(); j++) {
                System.out.print(terrainIdMap[i][j] + "|");
            }
            System.out.print('\n');
        }
    }

    public TerrainTile getTerrainTile(Position position){
        return terrainTileList.get(terrainIdMap[position.getX()][position.getY()]);
    }

}
