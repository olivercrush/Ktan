package com.orinine.ktan.state.card;

public record DevelopmentCard(DevelopmentCardType type) {
    public enum DevelopmentCardType {
        VICTORY_POINT,
        TWO_ROADS,
        MONOPOLY,
        ARMY,
        TWO_RESOURCES
    }
}
