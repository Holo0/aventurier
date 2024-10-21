package fr.cirilgroup.aventurier.entities;

/**
 * Class representing the adventurer.
 */
public final class Aventurer {
    private Integer x;
    private Integer y;

    /**
     * Constructor
     *
     * @param x The initial x-coordinate of the adventurer.
     * @param y The initial y-coordinate of the adventurer.
     */
    public Aventurer(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the adventurer in the specified direction.
     *
     * @param direction The direction to move the adventurer.
     */
    public void move(EnumDirection direction) {
        int[] move = getMove(direction);
        this.x += move[0];
        this.y += move[1];
    }

    /**
     * Gets the next position of the adventurer based on the direction.
     *
     * @param direction The direction to calculate the next position.
     * @return The next position as an array of two integers [x, y].
     */
    public int[] getNextPosition(EnumDirection direction) {
        int[] move = getMove(direction);
        return new int[] { x + move[0], y + move[1] };
    }

    /**
     * Gets the current x-coordinate of the adventurer.
     *
     * @return The current x-coordinate.
     */
    public Integer getX() {
        return x;
    }

    /**
     * Gets the current y-coordinate of the adventurer.
     *
     * @return The current y-coordinate.
     */
    public Integer getY() {
        return y;
    }

    // PRIVATE

    /**
     * Determines the difference of coordinate based on the direction.
     *
     * @param direction The direction to move.
     * @return The move as an array of two integers [delta_x, delta_y].
     */
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
