package pl.pwr.ships.simulation.ship.type;

import pl.pwr.ships.simulation.ship.Ship;

import java.util.function.Supplier;

public enum ShipType {
    SLOOP(SloopShip::new), BRIGANTINE(BrigantineShip::new), GALLEON(GalleonShip::new);

    private final Supplier<Ship> constructor;

    ShipType(Supplier<Ship> constructor) {
        this.constructor = constructor;
    }

    public Supplier<Ship> getConstructor() {
        return constructor;
    }
}

