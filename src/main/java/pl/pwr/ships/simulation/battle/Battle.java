package pl.pwr.ships.simulation.battle;

import pl.pwr.ships.simulation.ship.ShipPosition;

public class Battle {
    private final ShipPosition attacker;
    private final ShipPosition defender;

    public Battle(ShipPosition attacker, ShipPosition defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public ShipPosition getAttacker() {
        return attacker;
    }

    public ShipPosition getDefender() {
        return defender;
    }
}
