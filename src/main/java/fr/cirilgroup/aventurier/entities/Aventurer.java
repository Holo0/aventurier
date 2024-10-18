package fr.cirilgroup.aventurier.entities;

public final class Aventurer {

    private Integer x;
    private Integer y;

    public Aventurer(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void move(EnumDirection direction) {
        int[] move = getMove(direction);
        this.x += move[0];
        this.y += move[1];
    }

    public int[] getNextPosition(EnumDirection direction) {
        int[] move = getMove(direction);
        return new int[] { x + move[0], y + move[1] };
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    // PRIVATE

    private int[] getMove(EnumDirection direction) {
        switch (direction) {
            case N:
                return new int[] { 0, -1 }; // Move up
            case S:
                return new int[] { 0, 1 }; // Move down
            case E:
                return new int[] { 1, 0 }; // Move right
            case O:
                return new int[] { -1, 0 }; // Move left
        }
        return null; // Default case should never be reached
    }
}