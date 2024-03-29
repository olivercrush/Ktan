package com.orinine.ktan;

import com.orinine.ktan.state.State;
import com.orinine.ktan.state.board.BoardBuilder;
import com.orinine.ktan.state.board.generation.hexgrid.ClassicHexGridGenerator;
import com.orinine.ktan.state.board.model.*;
import com.orinine.ktan.state.card.CardBank;
import com.orinine.ktan.state.debug.DebugStateObserver;
import com.orinine.ktan.state.player.Player;
import com.orinine.ktan.state.player.PlayerColor;
import com.orinine.ktan.utils.CardBankBuilderForTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.orinine.ktan.utils.BoardBuilderForTests;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class KtanApplicationTests {

    @Disabled
    @Test
    void contextLoads() throws IOException, InterruptedException {
        debugSocketTest();
    }

    private void debugSocketTest() throws IOException, InterruptedException {
        var socketObserver = new DebugStateObserver(65500);
        var board = BoardBuilderForTests.aBoardBuilderForTests().build();
        var cardBank = CardBankBuilderForTests.aCardBankBuilderForTests().build();
        var state = new State(board, cardBank, new Player[]{ new Player(PlayerColor.RED), new Player(PlayerColor.BLUE) }, List.of(socketObserver));

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
