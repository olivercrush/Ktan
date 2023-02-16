package com.orinine.ktan;

import com.orinine.ktan.board.BoardBuilder;
import com.orinine.ktan.board.models.Board;
import com.orinine.ktan.board.models.Hex;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KtanApplicationTests {

    @Test
    void contextLoads() {
        Hex[][] hexGrid = new Hex[][] {
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.FOREST, 6), new Hex(Hex.HexType.MOUNTAINS, 6), new Hex(Hex.HexType.PASTURE, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.FOREST, 6), new Hex(Hex.HexType.MOUNTAINS, 6), new Hex(Hex.HexType.PASTURE, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.FOREST, 6), new Hex(Hex.HexType.MOUNTAINS, 6), new Hex(Hex.HexType.PASTURE, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.FOREST, 6), new Hex(Hex.HexType.MOUNTAINS, 6), new Hex(Hex.HexType.PASTURE, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.FOREST, 6), new Hex(Hex.HexType.MOUNTAINS, 6), new Hex(Hex.HexType.PASTURE, 6), new Hex(Hex.HexType.EMPTY, 6) },
        };

        Board board = BoardBuilder.aBoardBuilder()
                .setHexGrid(hexGrid)
                .build();

        // TODO : print the hex grid
    }

}
