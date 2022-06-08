package pl.pwr.ships.simulation.terrain;

import pl.pwr.ships.simulation.board.BoardSize;
import pl.pwr.ships.simulation.noise.OpenSimplexNoise;
import pl.pwr.ships.simulation.terrain.tile.TerrainTile;

import java.util.List;

public class TerrainGenerator {
    private final long seed;
    private final BoardSize boardSize;
    private final List<TerrainTile> terrainTileList;

    public TerrainGenerator(long seed, BoardSize boardSize, List<TerrainTile> terrainTileTypeList) {
        this.seed = seed;
        this.boardSize = boardSize;
        this.terrainTileList = terrainTileTypeList;
    }

    public int[][] generate(){
        OpenSimplexNoise openSimplexNoise = new OpenSimplexNoise(seed);
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
        double scaledValue = clampedValue * terrainTileList.size();

        if(scaledValue >= terrainTileList.size()){
            scaledValue = terrainTileList.size() - 1;
        }

        return (int) Math.floor(scaledValue);
    }
}
