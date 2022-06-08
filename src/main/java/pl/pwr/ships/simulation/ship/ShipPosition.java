package pl.pwr.ships.simulation.ship;

import pl.pwr.ships.simulation.position.Position;

public class ShipPosition{
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

    @Override
    public String toString() {
        return "ShipPosition{" +
                "ship=" + ship +
                ", position=" + position +
                '}';
    }
}
