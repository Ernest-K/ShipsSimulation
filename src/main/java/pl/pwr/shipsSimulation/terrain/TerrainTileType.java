package pl.pwr.shipsSimulation.terrain;

public enum TerrainTileType {
    DEFAULT_WATER(),
    STORM_WATER(new TerrainTileBonus(0.9, 1.1)),
    PIRATE_WATER(new TerrainTileBonus(1.1, 0.9));

    public final TerrainTileBonus terrainTileBonus;

    TerrainTileType(TerrainTileBonus terrainTileBonus){
        this.terrainTileBonus = terrainTileBonus;
    }

    TerrainTileType(){
        this.terrainTileBonus = new TerrainTileBonus();
    }

    public TerrainTileBonus getTerrainBonus() {
        return terrainTileBonus;
    }
}

