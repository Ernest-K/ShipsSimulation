package pl.pwr.shipsSimulation.ship.type;

import pl.pwr.shipsSimulation.ship.Ship;

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

