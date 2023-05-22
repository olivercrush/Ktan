package com.orinine.ktan.state.board.json;

import com.orinine.ktan.state.board.BoardBuilder;
import com.orinine.ktan.state.board.generation.LocationGridGenerator;
import com.orinine.ktan.state.board.model.*;
import com.orinine.ktan.state.board.util.Point;
import com.orinine.ktan.state.player.PlayerColor;
import com.orinine.ktan.utils.BoardBuilderForTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonToBoardConverterTest {

    private static final ClassLoader classLoader = JsonToBoardConverterTest.class.getClassLoader();

    @Test
    public void fromJson() throws IOException {
        var json = new String(classLoader.getResource("com/orinine/ktan/state/board/json/simpleBoard.json").openStream().readAllBytes());

        var hexGrid = new Hex[][] {
                { new Hex(Hex.HexType.FOREST, 6), new Hex(Hex.HexType.DESERT, 0), new Hex(Hex.HexType.PASTURE, 8) },
                { new Hex(Hex.HexType.FIELDS, 3), new Hex(Hex.HexType.MOUNTAINS, 12), new Hex(Hex.HexType.EMPTY, 0) },
                { new Hex(Hex.HexType.HILLS, 10), new Hex(Hex.HexType.HILLS, 2), new Hex(Hex.HexType.PASTURE, 11) }
        };

        var board = BoardBuilderForTests.aBoardBuilderForTests()
                .setHexGrid(hexGrid)
                .setLocationGrid(LocationGridGenerator.generateLocationGrid(hexGrid[0].length, hexGrid.length))
                .build();
        board.setLocation(new Location(PlayerColor.RED, Building.VILLAGE, Port.EMPTY), new Point(3, 3));
        board.setLocation(new Location(PlayerColor.BLUE, Building.CITY, Port.EMPTY), new Point(1, 5));
        board.addRoad(new Road(PlayerColor.RED, new ArrayList<Point>() {{
            add(new Point(3,3));
            add(new Point(3, 4));
        }}));
        board.addRoad(new Road(PlayerColor.RED, new ArrayList<Point>() {{
            add(new Point(1,5));
            add(new Point(1, 4));
        }}));

        assertEquals(board, JsonToBoardConverter.fromJson(json));
    }

}
