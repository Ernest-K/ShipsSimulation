package pl.pwr.shipsSimulation.terrain;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.position.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TerrainBoard {
    public final Random seed;
    public final List<TerrainType> terrainTypeList;
    public final BoardSize boardSize;
    public int[][] terrainIdMap;

    public TerrainBoard(Random seed, BoardSize boardSize) {
        this.seed = seed;
        this.terrainTypeList = Arrays.asList(TerrainType.class.getEnumConstants());
        this.boardSize = boardSize;
        TerrainGenerator terrainGenerator = new TerrainGenerator(seed, boardSize, terrainTypeList);
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

    public TerrainType getTerrainType(Position position){
        return terrainTypeList.get(terrainIdMap[position.getX()][position.getY()]);
    }

}
