package pl.pwr.shipsSimulation.ship;

public enum ShipType {
    BATTLE_SHIP{
        public ShipStatistic getShipStatistic(){
            return new ShipStatistic(100, 500,10);
        }
    }, AIRCRAFT_CARRIER{
        public ShipStatistic getShipStatistic(){
            return new ShipStatistic(150, 450,10);
        }
    }, CRUISER{
        public ShipStatistic getShipStatistic(){
            return new ShipStatistic(80, 600,10);
        }
    };

    public abstract ShipStatistic getShipStatistic();
}
