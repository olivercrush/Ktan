package com.orinine.ktan.utils;

import com.orinine.ktan.state.board.BoardBuilder;
import com.orinine.ktan.state.board.hexgrid.ClassicHexGridGenerator;
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
        locationGrid = new Location[this.hexGrid.length * 3][this.hexGrid[0].length * 3 + 1];
        for (var i = 0; i < locationGrid.length; i++) {
            for (var j = 0; j < locationGrid[i].length; j++) {
                locationGrid[i][j] = new Location(null, Building.EMPTY, Port.EMPTY);
            }
        }

        locationGrid[0][1] = new Location(null, Building.EMPTY, Port.GENERAL);
        locationGrid[0][2] = new Location(null, Building.EMPTY, Port.WHEAT);
        locationGrid[0][3] = new Location(null, Building.EMPTY, Port.WOOD);
        locationGrid[3][0] = new Location(null, Building.EMPTY, Port.BRICK);
        locationGrid[5][0] = new Location(null, Building.EMPTY, Port.SHEEP);
        locationGrid[6][0] = new Location(null, Building.EMPTY, Port.ROCK);

        locationGrid[5][3] = new Location(PlayerColor.BLUE, Building.VILLAGE, null);
        locationGrid[3][2] = new Location(PlayerColor.BLUE, Building.CITY, null);
        locationGrid[3][4] = new Location(PlayerColor.RED, Building.CITY, null);
        locationGrid[4][0] = new Location(PlayerColor.WHITE, Building.VILLAGE, null);
        locationGrid[6][1] = new Location(PlayerColor.WHITE, Building.VILLAGE, null);
        locationGrid[7][2] = new Location(PlayerColor.YELLOW, Building.CITY, null);
        locationGrid[9][3] = new Location(PlayerColor.YELLOW, Building.VILLAGE, null);
        locationGrid[11][3] = new Location(PlayerColor.YELLOW, Building.CITY, null);
    }

    private void setTestDefaultRoads() {
        roads = new ArrayList<>();
        roads.add(new Road(PlayerColor.BLUE, List.of(new Point(2, 3), new Point(2, 4))));
        roads.add(new Road(PlayerColor.BLUE, List.of(new Point(2, 4), new Point(3, 5))));
        roads.add(new Road(PlayerColor.RED, List.of(new Point(4, 3), new Point(4, 4))));
        roads.add(new Road(PlayerColor.WHITE, List.of(new Point(0, 4), new Point(1, 5))));
        roads.add(new Road(PlayerColor.WHITE, List.of(new Point(1, 5), new Point(1, 6))));
        roads.add(new Road(PlayerColor.YELLOW, List.of(new Point(2, 7), new Point(2, 8))));
        roads.add(new Road(PlayerColor.YELLOW, List.of(new Point(2, 8), new Point(3, 9))));
        roads.add(new Road(PlayerColor.YELLOW, List.of(new Point(3, 9), new Point(3, 10))));
        roads.add(new Road(PlayerColor.YELLOW, List.of(new Point(3, 10), new Point(3, 11))));
    }
}
