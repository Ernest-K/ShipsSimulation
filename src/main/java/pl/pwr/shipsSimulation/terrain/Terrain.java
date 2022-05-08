package pl.pwr.shipsSimulation.terrain;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.position.Position;

import java.util.Arrays;
import java.util.List;

public class Terrain {
    public final List<TerrainTileType> terrainTileTypeList;
    public final BoardSize boardSize;
    public int[][] terrainIdMap;

    public Terrain(long seed, BoardSize boardSize) {
        this.terrainTileTypeList = Arrays.asList(TerrainTileType.class.getEnumConstants());
        this.boardSize = boardSize;
        TerrainGenerator terrainGenerator = new TerrainGenerator(seed, boardSize, terrainTileTypeList);
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

    public TerrainTileType getTerrainType(Position position){
        return terrainTileTypeList.get(terrainIdMap[position.getX()][position.getY()]);
    }

}
