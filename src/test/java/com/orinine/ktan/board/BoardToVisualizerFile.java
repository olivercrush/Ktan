package com.orinine.ktan.board;

import com.orinine.ktan.board.hexgrid.ClassicHexGridGenerator;
import com.orinine.ktan.board.json.BoardToJsonConverter;
import com.orinine.ktan.board.models.Board;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class BoardToVisualizerFile {

    @Test
    public void writeVisualizerFile() throws IOException {
        var hexGrid = ClassicHexGridGenerator.getInstance().generate();
        var board = new Board(hexGrid);

        var fileWriter = new FileWriter("visualizer/board.json");
        fileWriter.write(BoardToJsonConverter.toJson(board));
        fileWriter.close();
    }

}
