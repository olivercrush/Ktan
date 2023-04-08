package com.orinine.ktan.state.board.model;

public record Hex(HexType hexType, int diceTarget) {
    public enum HexType {
        FOREST,
        MOUNTAINS,
        HILLS,
        FIELDS,
        PASTURE,
        DESERT,
        EMPTY
    }
}
