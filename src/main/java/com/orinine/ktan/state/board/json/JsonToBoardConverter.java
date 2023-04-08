package com.orinine.ktan.state.board.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orinine.ktan.state.board.model.Board;

import java.io.IOException;

public class JsonToBoardConverter {

    public static Board fromJson(String json) throws IOException {
        var objectReader = new ObjectMapper().reader();
        return objectReader.readValue(json, Board.class);
    }

}
