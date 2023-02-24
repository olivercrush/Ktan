package com.orinine.ktan.board.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orinine.ktan.board.models.Board;

public class BoardToJsonConverter {

    public static String toJson(Board board) throws JsonProcessingException {
        var objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return objectWriter.writeValueAsString(board);
    }

}
