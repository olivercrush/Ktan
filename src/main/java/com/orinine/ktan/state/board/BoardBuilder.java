package com.orinine.ktan.state.board;

import com.orinine.ktan.state.board.model.Board;
import com.orinine.ktan.state.board.model.Hex;
import com.orinine.ktan.state.board.model.Location;
import com.orinine.ktan.state.board.model.Road;

import java.util.List;

public class BoardBuilder {

    protected Hex[][] hexGrid;
    protected Location[][] locationGrid;
    protected List<Road> roads;

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
        return new Board(hexGrid, locationGrid, roads);
    }

}
