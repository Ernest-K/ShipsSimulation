package pl.pwr.shipsSimulation.terrain;

import pl.pwr.shipsSimulation.map.MapSize;
import pl.pwr.shipsSimulation.position.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TerrainMap {
    public final Random seed;
    public final List<TerrainType> terrainTypeList;
    public final MapSize mapSize;
    public int[][] terrainIdMap;

    public TerrainMap(Random seed, MapSize mapSize) {
        this.seed = seed;
        this.terrainTypeList = Arrays.asList(TerrainType.class.getEnumConstants());
        this.mapSize = mapSize;
        TerrainGenerator terrainGenerator = new TerrainGenerator(seed, mapSize, terrainTypeList);
        this.terrainIdMap = terrainGenerator.generate();
    }

    public void draw(){
        for (int i = 0; i < mapSize.getHeight(); i++) {
            for (int j = 0; j < mapSize.getWidth(); j++) {
                System.out.print(terrainIdMap[i][j] + "|");
            }
            System.out.print('\n');
        }
    }

    public TerrainType getTerrainType(Position position){
        return terrainTypeList.get(terrainIdMap[position.getX()][position.getY()]);
    }

}
