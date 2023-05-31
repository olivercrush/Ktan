package com.orinine.ktan.card;

public record UniqueCard(UniqueCardType type) {
    enum UniqueCardType {
        LONGEST_ROAD,
        BIGGEST_ARMY
    }
}
