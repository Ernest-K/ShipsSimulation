package pl.pwr.ships.simulation.position;

import pl.pwr.ships.simulation.board.BoardSize;
import pl.pwr.ships.simulation.ship.Ship;
import pl.pwr.ships.simulation.ship.ShipPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPositionGenerator {
    private final Random random;
    private final BoardSize boardSize;

    public RandomPositionGenerator(long seed, BoardSize boardSize) {
        this.random = new Random(seed);
        this.boardSize = boardSize;
    }

    public List<ShipPosition> generate(List<Ship> shipList){
        PositionValidator positionValidator = new PositionValidator(boardSize);
        List<ShipPosition> shipPositionList = new ArrayList<>();

        for (Ship ship : shipList){
            Position tempPosition = generateRandomPosition();
            while(positionValidator.isOccupied(shipPositionList.stream().map(ShipPosition::getPosition).toList(), tempPosition)){
                tempPosition = generateRandomPosition();
            }
            shipPositionList.add(new ShipPosition(ship, tempPosition));
        }

        return shipPositionList;
    }

    private Position generateRandomPosition(){
        return new Position(random.nextInt(boardSize.getWidth()), random.nextInt(boardSize.getHeight()));
    }


}
