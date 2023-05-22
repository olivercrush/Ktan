package com.orinine.ktan.state.board.model;

import com.orinine.ktan.state.board.util.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private Hex[][] hexGrid;
    private Location[][] locationGrid;
    private List<Road> roads;

    public Board() {

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
