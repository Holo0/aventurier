package fr.cirilgroup.aventurier.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import fr.cirilgroup.aventurier.Main;

public class Map {
    private char[][] map;

    public Map(String mapFile) throws IOException {
        loadMap(mapFile);
    }

    private void loadMap(String mapFile) throws IOException {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(mapFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        
        List<char[]> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line.toCharArray());
        }
        reader.close();
        map = lines.toArray(new char[0][]);
    }

    public char[][] getMap() {
        return map;
    }
}
