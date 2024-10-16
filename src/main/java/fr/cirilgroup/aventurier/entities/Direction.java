package fr.cirilgroup.aventurier.entities;

public enum Direction {
    N, S, E, O;

    public static Direction fromChar(char moveChar) throws Exception {
        switch (moveChar) {
            case 'N': return Direction.N;
            case 'S': return Direction.S;
            case 'E': return Direction.E;
            case 'O': return Direction.O;
            default: throw new Exception("Invalid direction character: " + moveChar);
        }
    }
}