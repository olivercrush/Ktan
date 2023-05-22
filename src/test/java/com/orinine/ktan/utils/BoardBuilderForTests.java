package com.orinine.ktan.utils;

import com.orinine.ktan.state.board.BoardBuilder;
import com.orinine.ktan.state.board.generation.LocationGridGenerator;
import com.orinine.ktan.state.board.generation.hexgrid.ClassicHexGridGenerator;
import com.orinine.ktan.state.board.model.Building;
import com.orinine.ktan.state.board.model.Location;
import com.orinine.ktan.state.board.model.Port;
import com.orinine.ktan.state.board.model.Road;
import com.orinine.ktan.state.board.util.Point;
import com.orinine.ktan.state.player.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public class BoardBuilderForTests extends BoardBuilder {

    protected BoardBuilderForTests() {
        setTestDefaultHexGrid();
        setTestDefaultLocationGrid();
        setTestDefaultRoads();
    }

    public static BoardBuilderForTests aBoardBuilderForTests() {
        return new BoardBuilderForTests();
    }

    private void setTestDefaultHexGrid() {
        hexGrid = ClassicHexGridGenerator.getInstance().generate();
    }

    private void setTestDefaultLocationGrid() {
        locationGrid = LocationGridGenerator.generateLocationGrid(this.hexGrid[0].length, this.hexGrid.length);
    }

    private void setTestDefaultRoads() {
        roads = new ArrayList<>();
    }
}
