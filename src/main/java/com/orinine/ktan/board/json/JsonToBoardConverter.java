package com.orinine.ktan.board.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orinine.ktan.board.models.Board;

import java.io.IOException;

public class JsonToBoardConverter {

    public static Board fromJson(String json) throws IOException {
        var objectReader = new ObjectMapper().reader();
        return objectReader.readValue(json, Board.class);
    }

}
