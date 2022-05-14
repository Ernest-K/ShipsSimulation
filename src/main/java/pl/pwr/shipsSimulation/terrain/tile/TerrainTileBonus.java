package pl.pwr.shipsSimulation.terrain.tile;

public class TerrainTileBonus {
    private static final double DEFAULT_ATTACK_BONUS = 1;
    private static final double DEFAULT_DEFEND_BONUS = 1;

    private final double attackBonus;
    private final double defendBonus;

    public TerrainTileBonus(double attackBonus, double defendBonus) {
        this.attackBonus = attackBonus;
        this.defendBonus = defendBonus;
    }

    public TerrainTileBonus(){
        this.attackBonus = DEFAULT_ATTACK_BONUS;
        this.defendBonus = DEFAULT_DEFEND_BONUS;
    }

    public double getAttackBonus() {
        return attackBonus;
    }

    public double getDefendBonus() {
        return defendBonus;
    }

    @Override
    public String toString() {
        return "TerrainBonus{" +
                "attackBonus=" + attackBonus +
                ", defendBonus=" + defendBonus +
                '}';
    }
}
