package pl.pwr.shipsSimulation.ship;

import pl.pwr.shipsSimulation.position.Position;

public class ShipPosition {
    private final Ship ship;
    private Position position;

    public ShipPosition(Ship ship, Position position) {
        this.ship = ship;
        this.position = position;
    }

    public Ship getShip() {
        return ship;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
