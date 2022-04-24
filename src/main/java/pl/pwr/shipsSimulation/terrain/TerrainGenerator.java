package pl.pwr.shipsSimulation.terrain;

import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.noise.OpenSimplexNoise;

import java.util.List;
import java.util.Random;

public class TerrainGenerator {
    private final Random seed;
    private final BoardSize boardSize;
    private final List<TerrainType> terrainTypeList;

    public TerrainGenerator(Random seed, BoardSize boardSize, List<TerrainType> terrainTypeList) {
        this.seed = seed;
        this.boardSize = boardSize;
        this.terrainTypeList = terrainTypeList;
    }

    public int[][] generate(){
        OpenSimplexNoise openSimplexNoise = new OpenSimplexNoise(seed.nextLong());
        int[][] terrainIdMap = new int[boardSize.getHeight()][boardSize.getWidth()];

        double magnification = 6;

        for (int i = 0; i < boardSize.getHeight(); i++) {
            for (int j = 0; j < boardSize.getWidth(); j++) {
                terrainIdMap[i][j] = terrainIdValueRemap(rangeValueRemap(openSimplexNoise.eval(i/magnification, j/magnification), -1, 1, 0, 1));
            }
        }
        return terrainIdMap;
    }

    private double rangeValueRemap(double value, double from1, double to1, double from2, double to2){
        return (value - from1) / (to1 - from1) * (to2 - from2) + from2;
    }

    private int terrainIdValueRemap(double value){
        double clampedValue = Math.max(0, Math.min(1, value));
        double scaledValue = clampedValue * terrainTypeList.size();

        if(scaledValue >= terrainTypeList.size()){
            scaledValue = terrainTypeList.size() - 1;
        }

        return (int) Math.floor(scaledValue);
    }
}
