package pl.pwr.shipsSimulation.terrain;

public class TerrainBonus {
    private static final double DEFAULT_ATTACK_BONUS = 1;
    private static final double DEFAULT_DEFEND_BONUS = 1;

    private final double attackBonus;
    private final double defendBonus;

    public TerrainBonus(double attackBonus, double defendBonus) {
        this.attackBonus = attackBonus;
        this.defendBonus = defendBonus;
    }

    public TerrainBonus(){
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
