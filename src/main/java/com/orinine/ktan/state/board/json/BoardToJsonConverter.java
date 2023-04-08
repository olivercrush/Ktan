package com.orinine.ktan.state.board.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orinine.ktan.state.board.model.Board;

public class BoardToJsonConverter {

    public static String toJson(Board board) throws JsonProcessingException {
        var objectWriter = new ObjectMapper().writer();
        return objectWriter.writeValueAsString(board);
    }

    public static String toJsonWithPrettyPrinting(Board board) throws JsonProcessingException {
        var objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return objectWriter.writeValueAsString(board);
    }
}
