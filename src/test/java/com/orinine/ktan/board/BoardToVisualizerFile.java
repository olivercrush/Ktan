package com.orinine.ktan.board;

import com.orinine.ktan.state.board.hexgrid.ClassicHexGridGenerator;
import com.orinine.ktan.state.board.json.BoardToJsonConverter;
import com.orinine.ktan.state.board.model.Board;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class  BoardToVisualizerFile {

    @Test
    public void writeVisualizerFile() throws IOException {
        var hexGrid = ClassicHexGridGenerator.getInstance().generate();
        var board = new Board(hexGrid);

        var fileWriter = new FileWriter("visualizer/board.json");
        fileWriter.write(BoardToJsonConverter.toJson(board));
        fileWriter.close();
    }

}
