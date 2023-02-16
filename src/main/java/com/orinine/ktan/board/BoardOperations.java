package com.orinine.ktan.board;

import com.orinine.ktan.board.utils.Point;
import com.orinine.ktan.player.Player;

import java.util.ArrayList;
import java.util.List;

public class BoardOperations {

    public List<Point> getHexesCoordinatesFromDiceTarget(Board board, int diceTarget) {
        var hexGrid = board.getHexGrid();
        var hexesCoordinates = new ArrayList<Point>();

        for (int i = 0; i < hexGrid.length; i++)
            for (int j = 0; j < hexGrid[0].length; j++)
                if (diceTarget == hexGrid[i][j].diceTarget())
                    hexesCoordinates.add(new Point(i, j));

        return hexesCoordinates;
    }

    public Player getPlayerWithTheLongestRoad(Board board) {
        return null;
    }
}
