package pl.pwr.ships.simulation.application;

import pl.pwr.ships.simulation.input.FileInput;
import pl.pwr.ships.simulation.input.Input;

public class ArgumentParser {
    private final int boardWidth;
    private final int boardHeight;
    private final String fileName;

    public ArgumentParser(String[] Args) {
        switch (Args.length) {
            case 3 -> {
                this.boardWidth = Integer.parseUnsignedInt(Args[0]);
                this.boardHeight = Integer.parseUnsignedInt(Args[1]);
                this.fileName = Args[2];
            }
            case 2 -> {
                this.boardWidth = Integer.parseUnsignedInt(Args[0]);
                this.boardHeight = Integer.parseUnsignedInt(Args[1]);
                this.fileName = DefaultArgument.FILE_NAME;
            }
            case 1 -> {
                this.boardWidth = DefaultArgument.BOARD_WIDTH;
                this.boardHeight = DefaultArgument.BOARD_HEIGHT;
                this.fileName = Args[0];
            }
            case 0 -> {
                this.boardWidth = DefaultArgument.BOARD_WIDTH;
                this.boardHeight = DefaultArgument.BOARD_HEIGHT;
                this.fileName = DefaultArgument.FILE_NAME;
            }
            default -> throw new RuntimeException("Invalid arguments");
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
