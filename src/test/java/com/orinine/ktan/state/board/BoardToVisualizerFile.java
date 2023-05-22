package com.orinine.ktan.state.board;

import com.orinine.ktan.state.board.generation.hexgrid.ClassicHexGridGenerator;
import com.orinine.ktan.state.board.json.BoardToJsonConverter;
import com.orinine.ktan.state.board.model.Board;
import com.orinine.ktan.utils.BoardBuilderForTests;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class  BoardToVisualizerFile {

    @Test
    public void writeVisualizerFile() throws IOException {
        var board = BoardBuilderForTests.aBoardBuilderForTests().build();

        var fileWriter = new FileWriter("visualizer/board.json");
        fileWriter.write(BoardToJsonConverter.toJson(board));
        fileWriter.close();
    }

}
