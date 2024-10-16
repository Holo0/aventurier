package fr.cirilgroup.aventurier.entities;

public final class Aventurer {

    private Integer x;
    private Integer y;

    public Aventurer(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void move(String direction) throws Exception {
        switch (direction) {
            case "S":
                this.y = this.y + 1;
                break;
            case "N":
                this.y = this.y - 1;
                break;
            case "E":
                this.x = this.x + 1;
                break;
            case "O":
                this.x = this.x - 1;
                break;
            default:
                throw new Exception("Wrong direction entered");
        }
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
}