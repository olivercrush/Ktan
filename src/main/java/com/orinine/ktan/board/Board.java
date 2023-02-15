package com.orinine.ktan.board;

import com.orinine.ktan.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Hex[][] hexGrid;
    private Location[][] locationGrid;
    private final List<Road> roads;

    public Board(Hex[][] hexGrid) {
        this.hexGrid = hexGrid;
        this.roads = new ArrayList<Road>();
    }

    public List<int[]> getHexesCoordinatesFromDiceTarget(int diceTarget) {
        var hexesCoordinates = new ArrayList<int[]>();

        for (int i = 0; i < hexGrid.length; i++)
            for (int j = 0; j < hexGrid[0].length; j++)
                if (diceTarget == hexGrid[i][j].diceTarget())
                    hexesCoordinates.add(new int[] { i, j });

        return hexesCoordinates;
    }

    public List<Location> getPointsFromHexCoordinates(int x, int y) {
        var points = new ArrayList<Location>();

        return points;
    }

    public Player getPlayerWithTheLongestRoad() {
        return null;
    }
}
