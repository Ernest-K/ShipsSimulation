package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.terrain.TerrainTileBonus;

public class ShipStatistic {
    private final double attack;
    private final double defend;
    private final int range;

    public ShipStatistic(double attack, double defend, int range) {
        this.attack = attack;
        this.defend = defend;
        this.range = range;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefend() {
        return defend;
    }

    public int getRange() {
        return range;
    }

    @Override
    public String toString() {
        return "ShipStatistic{" +
                "attack=" + attack +
                ", defend=" + defend +
                ", range=" + range +
                '}';
    }

    public ShipStatistic applyTerrainBonus(TerrainTileBonus terrainTileBonus){
        double attack = this.attack * terrainTileBonus.getAttackBonus();
        double defend = this.defend * terrainTileBonus.getDefendBonus();
        return new ShipStatistic(attack, defend, this.range);
    }
}
