package pl.pwr.ships.simulation.statistic;

import pl.pwr.ships.simulation.ship.ShipStatistic;
import pl.pwr.ships.simulation.terrain.tile.TerrainTileBonus;

public class DefaultStatisticCalculator implements StatisticCalculator{
    private ShipStatistic attackerStatistic;
    private ShipStatistic defenderStatistic;

    public DefaultStatisticCalculator(ShipStatistic attackerStatistic, ShipStatistic defenderStatistic) {
        this.attackerStatistic = new ShipStatistic(attackerStatistic.getAttack(), attackerStatistic.getDefend(), attackerStatistic.getRange());
        this.defenderStatistic = new ShipStatistic(defenderStatistic.getAttack(), defenderStatistic.getDefend(), defenderStatistic.getRange());
    }

    @Override
    public void applyTerrainBonus(TerrainTileBonus attackerTerrainTileBonus, TerrainTileBonus defenderTerrainTileBonus) {
        this.attackerStatistic = addAttackDefendBonus(this.attackerStatistic, attackerTerrainTileBonus.getAttackBonus(), attackerTerrainTileBonus.getDefendBonus());
        this.defenderStatistic = addAttackDefendBonus(this.defenderStatistic, defenderTerrainTileBonus.getAttackBonus(), defenderTerrainTileBonus.getDefendBonus());
    }

    @Override
    public void applyRangeBonus() {
        double attackMultiplier = calculateAttackMultiplier(this.attackerStatistic.getRange(), this.defenderStatistic.getRange());

        if(attackerStatistic.getRange() > defenderStatistic.getRange()){
            this.attackerStatistic = addRangeBonus(this.attackerStatistic, attackMultiplier);
        }else{
            this.defenderStatistic = addRangeBonus(this.defenderStatistic, attackMultiplier);
        }
    }

    @Override
    public ShipStatistic getAttackerStatistic() {
        return this.attackerStatistic;
    }

    @Override
    public ShipStatistic getDefenderStatistic() {
        return this.defenderStatistic;
    }

    private ShipStatistic addRangeBonus(ShipStatistic shipStatistic, double attackMultiplier){
        double newAttack = shipStatistic.getAttack() * attackMultiplier;

        return new ShipStatistic(newAttack, shipStatistic.getDefend(), shipStatistic.getRange());
    }

    private ShipStatistic addAttackDefendBonus(ShipStatistic shipStatistic, double attackBonus, double defendBonus){
        double newAttack = shipStatistic.getAttack() * attackBonus;
        double newDefend = shipStatistic.getDefend() * defendBonus;

        return new ShipStatistic(newAttack, newDefend, shipStatistic.getRange());
    }

    private double calculateAttackMultiplier(int attackerRange, int defenderRange){
        return 1 + (Math.abs(attackerRange - defenderRange)/10.0);
    }
}
