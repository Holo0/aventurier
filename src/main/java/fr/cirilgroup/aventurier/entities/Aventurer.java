package fr.cirilgroup.aventurier.entities;

public final class Aventurer {

    private Integer x;
    private Integer y;

    public Aventurer(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void move(char direction) throws Exception {
        int[] move = getMove(direction);
        this.x += move[0];
        this.y += move[1];
    }

    public int[] getNextPosition(char direction) throws Exception {
        int[] move = getMove(direction);
        return new int[] { x + move[0], y + move[1] };
    }

    @Override
    public String toString() {
        return "aventurer [x=" + x + ", y=" + y + "]";
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    
    // PRIVATE
    
    private int[] getMove(char direction) throws Exception {
        switch (direction) {
            case 'N': return new int[]{0, -1}; // Move up
            case 'S': return new int[]{0, 1};  // Move down
            case 'E': return new int[]{1, 0};  // Move right
            case 'W': return new int[]{-1, 0}; // Move left
            default: throw new Exception("Wrong direction entered");
        }
    }
}