package com.orinine.ktan;

import com.orinine.ktan.state.State;
import com.orinine.ktan.state.board.BoardBuilder;
import com.orinine.ktan.state.board.hexgrid.ClassicHexGridGenerator;
import com.orinine.ktan.state.board.model.Hex;
import com.orinine.ktan.state.debug.DebugStateObserver;
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
        var socketObserver = new DebugStateObserver("127.0.0.1", 65500);
        var state = new State(List.of(socketObserver));

        for (var i = 0; i < 5; i++) {
            var hexGrid = ClassicHexGridGenerator.getInstance().generate();

            var board = BoardBuilder.aBoardBuilder()
                    .setHexGrid(hexGrid)
                    .build();

            state.updateBoard(board);
            Thread.sleep(5000);
        }

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
