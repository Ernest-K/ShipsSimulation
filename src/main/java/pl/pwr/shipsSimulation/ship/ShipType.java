package pl.pwr.shipsSimulation.ship;

public enum ShipType {
    BATTLE_SHIP(new ShipStatistic(100, 500, 3)),
    AIRCRAFT_CARRIER(new ShipStatistic(150, 400, 3)),
    CRUISER(new ShipStatistic(80, 600, 3));

    private final ShipStatistic shipStatistic;

    ShipType(ShipStatistic shipStatistic) {
        this.shipStatistic = shipStatistic;
    }

    public ShipStatistic getShipStatistic() {
        return shipStatistic;
    }
}
