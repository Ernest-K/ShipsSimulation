package pl.pwr.shipsSimulation.ship;

public class ShipStatistic {
    private final double attack;
    private final double defend;

    public ShipStatistic(double attack, double defend) {
        this.attack = attack;
        this.defend = defend;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefend() {
        return defend;
    }

    @Override
    public String toString() {
        return "ShipStatistic{" +
                "attack=" + attack +
                ", defend=" + defend +
                '}';
    }
}
