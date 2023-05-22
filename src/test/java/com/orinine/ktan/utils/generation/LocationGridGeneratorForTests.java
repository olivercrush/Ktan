package com.orinine.ktan.utils.generation;

import com.orinine.ktan.state.board.generation.LocationGridGenerator;
import com.orinine.ktan.state.board.model.Building;
import com.orinine.ktan.state.board.model.Location;
import com.orinine.ktan.state.board.model.Port;
import com.orinine.ktan.state.player.PlayerColor;

public class LocationGridGeneratorForTests extends LocationGridGenerator {

    public static Location[][] generateTestLocationGrid(int hexgridWidth, int hexgridHeight) {
        var locationGrid = generateLocationGrid(hexgridWidth, hexgridHeight);

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

        return locationGrid;
    }

}
