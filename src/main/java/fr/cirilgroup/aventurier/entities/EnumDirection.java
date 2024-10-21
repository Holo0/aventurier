package fr.cirilgroup.aventurier.entities;

/**
 * Enumeration representing cardinal directions.
 */
public enum EnumDirection {
    N, S, E, O;

    /**
     * Converts an array of characters to an array of EnumDirection.
     *
     * @param movesChar Array of characters representing directions.
     * @return Array of EnumDirection corresponding to the characters.
     * @throws Exception If an invalid direction character is encountered.
     */
    public static EnumDirection[] fromChar(char[] movesChar) throws Exception {
        EnumDirection[] directions = new EnumDirection[movesChar.length];
        for (Integer i = 0; i < movesChar.length; i++) {
            switch (movesChar[i]) {
                case 'N':
                    directions[i] = EnumDirection.N;
                    break;
                case 'S':
                    directions[i] = EnumDirection.S;
                    break;
                case 'E':
                    directions[i] = EnumDirection.E;
                    break;
                case 'O':
                    directions[i] = EnumDirection.O;
                    break;
                default:
                    throw new Exception("Invalid direction character: " + movesChar[i]);
            }
        }
        return directions;
    }
}
