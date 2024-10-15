package fr.cirilgroup.aventurier.entities;

public final class Aventurier {

    private Integer coordonneeX;
    private Integer coordonneeY;

    public Aventurier(Integer x, Integer y) {
        coordonneeX = x;
        coordonneeY = y;
    }

    public void bouger(String direction) throws Exception {
        switch (direction) {
            case "S":
                this.coordonneeY = this.coordonneeY + 1;
                break;
            case "N":
                this.coordonneeY = this.coordonneeY - 1;
                break;
            case "E":
                this.coordonneeX = this.coordonneeX + 1;
                break;
            case "O":
                this.coordonneeX = this.coordonneeX - 1;
                break;
            default:
                throw new Exception("Wrong direction entered");
        }
    }

    @Override
    public String toString() {
        return "aventurier [coordonneeX=" + coordonneeX + ", coordonneeY=" + coordonneeY + "]";
    }

    public Integer getCoordonneeX() {
        return coordonneeX;
    }

    public Integer getCoordonneeY() {
        return coordonneeY;
    }
}