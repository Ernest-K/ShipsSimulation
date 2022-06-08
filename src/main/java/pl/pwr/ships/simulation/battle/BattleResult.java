package pl.pwr.ships.simulation.battle;

import lombok.Builder;
import lombok.Getter;
import pl.pwr.ships.simulation.ship.ShipPosition;

@Getter
@Builder
public class BattleResult {
    private final ShipPosition winnerShip;
    private final ShipPosition loserShip;
}
