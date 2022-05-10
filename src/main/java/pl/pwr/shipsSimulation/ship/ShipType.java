package pl.pwr.shipsSimulation.ship;

public enum ShipType {
    BATTLE_SHIP{
        public ShipStatistic getShipStatistic(){
            return new ShipStatistic(100, 500,3);
        }
    }, AIRCRAFT_CARRIER{
        public ShipStatistic getShipStatistic(){
            return new ShipStatistic(120, 400,3);
        }
    }, CRUISER{
        public ShipStatistic getShipStatistic(){
            return new ShipStatistic(80, 600,3);
        }
    };

    public abstract ShipStatistic getShipStatistic();
}
