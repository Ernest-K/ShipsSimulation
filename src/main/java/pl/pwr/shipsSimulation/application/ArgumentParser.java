package pl.pwr.shipsSimulation.application;

import pl.pwr.shipsSimulation.input.FileInput;
import pl.pwr.shipsSimulation.input.Input;

public class ArgumentParser {
    private final int boardWidth;
    private final int boardHeight;
    private final String fileName;
    private String[] args;

    public ArgumentParser(String[] Args) {
        switch (Args.length){
            case 3:
                this.boardWidth = Integer.parseUnsignedInt(Args[0]);
                this.boardHeight = Integer.parseUnsignedInt(Args[1]);
                this.fileName = Args[2];
                break;
            case 1:
                this.boardWidth = DefaultArgument.BOARD_WIDTH;
                this.boardHeight = DefaultArgument.BOARD_HEIGHT;
                this.fileName = Args[0];
                break;
            case 0:
                this.boardWidth = DefaultArgument.BOARD_WIDTH;
                this.boardHeight = DefaultArgument.BOARD_HEIGHT;
                this.fileName = DefaultArgument.FILE_NAME;
            default:
                throw new RuntimeException("Invalid arguments");
        }
    }

    private int getBoardWidth() {
        return this.boardWidth;
    }

    private int getBoardHeight() {
        return this.boardHeight;
    }

    private String getPath() {
        return "src/main/resources/" + this.fileName;
    }

    public Input parse(){
        return new FileInput(getBoardWidth(), getBoardHeight(), getPath());
    }
}
