package pl.pwr.shipsSimulation.terrain;

public enum TerrainType{
    DEFAULT_WATER(),
    STORM_WATER(new TerrainBonus(0.9, 1.1)),
    PIRATE_WATER(new TerrainBonus(1.1, 0.9));

    public final TerrainBonus terrainBonus;

    TerrainType(TerrainBonus terrainBonus){
        this.terrainBonus = terrainBonus;
    }

    TerrainType(){
        this.terrainBonus = new TerrainBonus();
    }

    public TerrainBonus getTerrainBonus() {
        return terrainBonus;
    }
}

