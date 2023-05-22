package com.orinine.ktan.state.board.generation;

import com.orinine.ktan.state.board.model.Building;
import com.orinine.ktan.state.board.model.Location;
import com.orinine.ktan.state.board.model.Port;

public class LocationGridGenerator {

    public static Location[][] generateLocationGrid(int hexgridWidth, int hexgridHeight) {
        var locationGrid = new Location[hexgridHeight * 3][hexgridWidth * 3 + 1];
        for (var i = 0; i < locationGrid.length; i++) {
            for (var j = 0; j < locationGrid[i].length; j++) {
                locationGrid[i][j] = new Location(null, Building.EMPTY, Port.EMPTY);
            }
        }
        return locationGrid;
    }

}
