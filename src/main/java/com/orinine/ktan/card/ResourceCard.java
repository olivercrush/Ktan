package com.orinine.ktan.card;

public record ResourceCard(ResourceCardType type) {
    public enum ResourceCardType {
        FOREST,
        MOUNTAINS,
        HILLS,
        FIELDS,
        PASTURE
    }
}
