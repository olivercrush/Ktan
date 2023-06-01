package com.orinine.ktan.state.card;

public record ResourceCard(ResourceCardType type) {
    public enum ResourceCardType {
        WOOD,
        ROCK,
        BRICK,
        WHEAT,
        SHEEP
    }
}
