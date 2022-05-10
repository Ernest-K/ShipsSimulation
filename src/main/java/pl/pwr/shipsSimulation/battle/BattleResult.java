package pl.pwr.shipsSimulation.battle;

import pl.pwr.shipsSimulation.ship.ShipPosition;

public class BattleResult {
    private ShipPosition winnerShip;
    private ShipPosition loserShip;

    public BattleResult() {
    }

    public ShipPosition getWinnerShip() {
        return winnerShip;
    }

    public void setWinnerShip(ShipPosition winnerShip) {
        this.winnerShip = winnerShip;
    }

    public ShipPosition getLoserShip() {
        return loserShip;
    }

    public void setLoserShip(ShipPosition loserShip) {
        this.loserShip = loserShip;
    }
}
