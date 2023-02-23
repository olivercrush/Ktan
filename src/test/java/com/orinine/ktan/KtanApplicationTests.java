package com.orinine.ktan;

import com.orinine.ktan.board.BoardBuilder;
import com.orinine.ktan.board.hexgrid.ClassicHexGridGenerator;
import com.orinine.ktan.board.models.Board;
import com.orinine.ktan.board.models.Hex;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KtanApplicationTests {

    @Test
    void contextLoads() {
        var hexGrid = ClassicHexGridGenerator.getInstance().generate();

        Board board = BoardBuilder.aBoardBuilder()
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
