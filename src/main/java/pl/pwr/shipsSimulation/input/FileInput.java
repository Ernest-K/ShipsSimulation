package pl.pwr.shipsSimulation.input;

import com.google.gson.Gson;
import pl.pwr.shipsSimulation.board.BoardSize;
import pl.pwr.shipsSimulation.ship.Ship;
import pl.pwr.shipsSimulation.ship.ShipFactory;
import pl.pwr.shipsSimulation.ship.type.ShipType;
import pl.pwr.shipsSimulation.team.Team;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileInput implements Input{
    private JsonObjectStructure[] jsonObjectStructures;
    private BoardSize boardSize;
    private List<Team> teamList;
    private List<Ship> shipList;

    public FileInput(int boardWidth, int boardHeight, String path) {
        this.boardSize = new BoardSize(boardWidth, boardHeight);

        try{
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            this.jsonObjectStructures = gson.fromJson(reader, JsonObjectStructure[].class);
            generateInput();
            reader.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public BoardSize getBoardSize() {
        return boardSize;
    }

    @Override
    public List<Team> getTeamList() {
        return this.teamList;
    }

    @Override
    public List<Ship> getShipList() {
        return this.shipList;
    }

    private void generateInput(){
        this.teamList = new ArrayList<>();
        this.shipList = new ArrayList<>();
        for (JsonObjectStructure jsonObjectStructure : jsonObjectStructures){
            Team team = new Team(jsonObjectStructure.getTeamName());
            this.teamList.add(team);
            for (String shipType : jsonObjectStructure.getShips()){
                Ship ship = ShipFactory.getShip(ShipType.valueOf(shipType), team);
                this.shipList.add(ship);
            }
        }
        if(!isCorrectNumberOfShips()){
            throw new RuntimeException("Invalid number of ships");
        }
    }

    private boolean isCorrectNumberOfShips(){
        return this.shipList.size() < this.boardSize.getWidth() * this.boardSize.getHeight();
    }
}
