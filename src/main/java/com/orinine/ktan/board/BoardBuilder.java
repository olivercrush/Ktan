package com.orinine.ktan.board;

import com.orinine.ktan.board.models.Board;
import com.orinine.ktan.board.models.Hex;

public class BoardBuilder {

    private Hex[][] hexGrid;

    protected BoardBuilder() {

    }

    public static BoardBuilder aBoardBuilder() {
        return new BoardBuilder();
    }

    public BoardBuilder setHexGrid(Hex[][] hexGrid) {
        this.hexGrid = hexGrid;
        return this;
    }

    public Board build() {
        return new Board(hexGrid);
    }

}
