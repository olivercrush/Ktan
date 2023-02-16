package com.orinine.ktan.board.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Hex[][] hexGrid;
    private Location[][] locationGrid;
    private final List<Road> roads;

    public Board(Hex[][] hexGrid) {
        this.hexGrid = hexGrid;
        // TODO : initialize location grid based on hex grid width / height
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
