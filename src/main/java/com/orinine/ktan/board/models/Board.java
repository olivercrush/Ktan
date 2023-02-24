package com.orinine.ktan.board.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.orinine.ktan.board.BoardBuilder;
import com.orinine.ktan.board.utils.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private Hex[][] hexGrid;
    private Location[][] locationGrid;
    private List<Road> roads;

    public Board() {

    }

    public Board(Hex[][] hexGrid) {
        this.hexGrid = hexGrid;

        locationGrid = new Location[this.hexGrid.length * 3][this.hexGrid[0].length * 3 + 1];
        for (var i = 0; i < locationGrid.length; i++) {
            for (var j = 0; j < locationGrid[i].length; j++) {
                locationGrid[i][j] = new Location(null, Building.EMPTY, Port.EMPTY);
            }
        }

        this.roads = new ArrayList<Road>();
    }

    public Board(Hex[][] hexGrid, Location[][] locationGrid, List<Road> roads) {
        this.hexGrid = hexGrid;
        this.locationGrid = locationGrid;
        this.roads = roads;
    }

    public void setLocation(Location location, Point point) {
        locationGrid[point.y()][point.x()] = location;
    }

    public void addRoad(Road road) {
        roads.add(road);
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Board that)) return false;
        if (this == that) return true;
        return Arrays.deepEquals(hexGrid, that.getHexGrid()) && Arrays.deepEquals(locationGrid, that.getLocationGrid()) && roads.equals(that.getRoads());
    }

    @Override
    public String toString() {
        return "Board[ " +
                "HexGrid[ " + Arrays.deepToString(hexGrid) + " ], " +
                "LocationGrid[" + Arrays.deepToString(locationGrid) + " ], " +
                "Roads[ " + roads.toString() + " ]";
    }
}
