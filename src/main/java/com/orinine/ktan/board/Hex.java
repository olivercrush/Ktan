package com.orinine.ktan.board;

public record Hex(HexType hexType, int diceTarget) {
    public enum HexType {
        FOREST,
        MOUNTAINS,
        HILLS,
        FIELDS,
        PASTURE,
        DESERT
    }
}
