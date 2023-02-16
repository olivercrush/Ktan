package com.orinine.ktan.board.models;

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
