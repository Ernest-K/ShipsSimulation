package pl.pwr.shipsSimulation.ship;

public enum ShipType {
    BATTLE_SHIP{
        public ShipStatistic getShipStatistic(){
            return new ShipStatistic(100, 500,3);
        }
    }, AIRCRAFT_CARRIER{
        public ShipStatistic getShipStatistic(){
            return new ShipStatistic(100, 500,3);
        }
    }, CRUISER{
        public ShipStatistic getShipStatistic(){
            return new ShipStatistic(100, 500,3);
        }
    };

    public abstract ShipStatistic getShipStatistic();
}
