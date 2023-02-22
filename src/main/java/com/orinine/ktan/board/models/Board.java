package com.orinine.ktan.board.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Hex[][] hexGrid;
    private final Location[][] locationGrid;
    private final List<Road> roads;

    public Board(Hex[][] hexGrid) {
        this.hexGrid = hexGrid;

        locationGrid = new Location[this.hexGrid.length][this.hexGrid[0].length];
        for (var i = 0; i < locationGrid.length; i++) {
            for (var j = 0; j < locationGrid[i].length; j++) {
                locationGrid[i][j] = new Location();
            }
        }

        this.roads = new ArrayList<Road>();
    }

    public Hex[][] getHexGrid() {
        return hexGrid;
    }

    public Location[][] getLocationGrid() {
        return locationGrid;
    }

    public List<Road> getRoads() {
        return roads;
    }
}
