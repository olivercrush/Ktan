package com.orinine.ktan.board;

import com.orinine.ktan.board.models.Board;
import com.orinine.ktan.board.models.Hex;
import com.orinine.ktan.board.models.Location;
import com.orinine.ktan.board.models.Road;

import java.util.List;

public class BoardBuilder {

    private Hex[][] hexGrid;
    private Location[][] locationGrid;
    private List<Road> roads;

    protected BoardBuilder() {

    }

    public static BoardBuilder aBoardBuilder() {
        return new BoardBuilder();
    }

    public BoardBuilder setHexGrid(Hex[][] hexGrid) {
        this.hexGrid = hexGrid;
        return this;
    }

    public BoardBuilder setLocationGrid(Location[][] locationGrid) {
        this.locationGrid = locationGrid;
        return this;
    }

    public BoardBuilder setRoads(List<Road> roads) {
        this.roads = roads;
        return this;
    }

    public Board build() {
        return new Board(hexGrid);
    }

}
