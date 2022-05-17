package pl.pwr.shipsSimulation.board;

public class BoardSize {
    private final int width;
    private final int height;

    public BoardSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
