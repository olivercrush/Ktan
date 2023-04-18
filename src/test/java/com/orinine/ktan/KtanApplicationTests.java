package com.orinine.ktan;

import com.orinine.ktan.state.State;
import com.orinine.ktan.state.board.BoardBuilder;
import com.orinine.ktan.state.board.hexgrid.ClassicHexGridGenerator;
import com.orinine.ktan.state.board.model.*;
import com.orinine.ktan.state.board.util.Point;
import com.orinine.ktan.state.debug.DebugStateObserver;
import com.orinine.ktan.state.player.PlayerColor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class KtanApplicationTests {

    @Test
    void contextLoads() throws IOException, InterruptedException {
        debugSocketTest();
    }

    private void debugSocketTest() throws IOException, InterruptedException {
        var socketObserver = new DebugStateObserver(65500);
        var state = new State(List.of(socketObserver));

        var hexGrid = ClassicHexGridGenerator.getInstance().generate();

        var board = BoardBuilder.aBoardBuilder()
                .setHexGrid(hexGrid)
                .build();

        board.getLocationGrid()[0][1] = new Location(null, Building.EMPTY, Port.GENERAL);
        board.getLocationGrid()[0][2] = new Location(null, Building.EMPTY, Port.WHEAT);
        board.getLocationGrid()[0][3] = new Location(null, Building.EMPTY, Port.WOOD);
        board.getLocationGrid()[3][0] = new Location(null, Building.EMPTY, Port.BRICK);
        board.getLocationGrid()[5][0] = new Location(null, Building.EMPTY, Port.SHEEP);
        board.getLocationGrid()[6][0] = new Location(null, Building.EMPTY, Port.ROCK);

        board.getLocationGrid()[5][3] = new Location(PlayerColor.BLUE, Building.VILLAGE, null);
        board.getLocationGrid()[3][2] = new Location(PlayerColor.BLUE, Building.CITY, null);
        board.getLocationGrid()[3][4] = new Location(PlayerColor.RED, Building.CITY, null);
        board.getLocationGrid()[4][0] = new Location(PlayerColor.WHITE, Building.VILLAGE, null);
        board.getLocationGrid()[6][1] = new Location(PlayerColor.WHITE, Building.VILLAGE, null);
        board.getLocationGrid()[7][2] = new Location(PlayerColor.YELLOW, Building.CITY, null);
        board.getLocationGrid()[9][3] = new Location(PlayerColor.YELLOW, Building.VILLAGE, null);
        board.getLocationGrid()[11][3] = new Location(PlayerColor.YELLOW, Building.CITY, null);
        
        board.getRoads().add(new Road(PlayerColor.BLUE, List.of(new Point(2, 3), new Point(2, 4))));
        board.getRoads().add(new Road(PlayerColor.BLUE, List.of(new Point(2, 4), new Point(3, 5))));
        board.getRoads().add(new Road(PlayerColor.RED, List.of(new Point(4, 3), new Point(4, 4))));
        board.getRoads().add(new Road(PlayerColor.WHITE, List.of(new Point(0, 4), new Point(1, 5))));
        board.getRoads().add(new Road(PlayerColor.WHITE, List.of(new Point(1, 5), new Point(1, 6))));
        board.getRoads().add(new Road(PlayerColor.YELLOW, List.of(new Point(2, 7), new Point(2, 8))));
        board.getRoads().add(new Road(PlayerColor.YELLOW, List.of(new Point(2, 8), new Point(3, 9))));
        board.getRoads().add(new Road(PlayerColor.YELLOW, List.of(new Point(3, 9), new Point(3, 10))));
        board.getRoads().add(new Road(PlayerColor.YELLOW, List.of(new Point(3, 10), new Point(3, 11))));

        state.updateBoard(board);
        Thread.sleep(100000);
        socketObserver.close();
    }

    private void consoleDisplayTest() {
        var hexGrid = ClassicHexGridGenerator.getInstance().generate();

        var board = BoardBuilder.aBoardBuilder()
                .setHexGrid(hexGrid)
                .build();

        var i = 0;
        for (var line : hexGrid) {
            if (i % 2 == 1)
                System.out.print(" ");

            for (var hex : line) {
                System.out.print(hexTypeToChar(hex.hexType()) + "  ");
            }
            System.out.println("");
            i++;
        }
    }

    private char hexTypeToChar(Hex.HexType hexType) {
        switch (hexType) {
            case DESERT: return 'D';
            case MOUNTAINS: return 'M';
            case PASTURE: return 'P';
            case FIELDS: return 'F';
            case FOREST: return 'T';
            case HILLS: return 'H';
            default: return ' ';
        }
    }

}
