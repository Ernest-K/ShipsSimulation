package pl.pwr.ships.simulation.ship;

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
}
