package pl.pwr.shipsSimulation.ship;

public enum ShipType {
    BATTLE_SHIP(new ShipStatistic(100, 500)),
    AIRCRAFT_CARRIER(new ShipStatistic(150, 400)),
    CRUISER(new ShipStatistic(80, 600));

    private final ShipStatistic shipStatistic;

    ShipType(ShipStatistic shipStatistic) {
        this.shipStatistic = shipStatistic;
    }

    public ShipStatistic getShipStatistic() {
        return shipStatistic;
    }
}
