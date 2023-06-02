package com.orinine.ktan.state.card;

import com.orinine.ktan.utils.CardBankBuilderForTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardBankTest {

    private CardBank cardBank;

    @BeforeEach
    public void setup() {
        cardBank = CardBankBuilderForTests.aCardBankBuilderForTests().build();
    }

    @Test
    public void takeResourceCardTest() {
        var wheatCard = cardBank.takeResourceCard(ResourceCard.ResourceCardType.WHEAT);
        assertTrue(wheatCard.isPresent());
        assertEquals(ResourceCard.ResourceCardType.WHEAT, wheatCard.get().type());
        assertEquals(94, cardBank.resourceCards.size());

        var rockCard = cardBank.takeResourceCard(ResourceCard.ResourceCardType.ROCK);
        assertTrue(rockCard.isPresent());
        assertEquals(ResourceCard.ResourceCardType.ROCK, rockCard.get().type());
        assertEquals(93, cardBank.resourceCards.size());
    }

    @Test
    public void takeDevelopmentCardTest() {
        var developmentCard = cardBank.takeDevelopmentCard();
        assertTrue(developmentCard.isPresent());
        assertEquals(24, cardBank.developmentCards.size());
    }

    @Test
    public void takeUniqueCardTest() {
        var longestRoadCard = cardBank.takeUniqueCard(UniqueCard.UniqueCardType.LONGEST_ROAD);
        assertTrue(longestRoadCard.isPresent());
        assertEquals(UniqueCard.UniqueCardType.LONGEST_ROAD, longestRoadCard.get().type());
        assertEquals(1, cardBank.uniqueCards.size());

        var biggestArmyCard = cardBank.takeUniqueCard(UniqueCard.UniqueCardType.BIGGEST_ARMY);
        assertTrue(biggestArmyCard.isPresent());
        assertEquals(UniqueCard.UniqueCardType.BIGGEST_ARMY, biggestArmyCard.get().type());
        assertTrue(cardBank.uniqueCards.isEmpty());

        var secondLongestRoad = cardBank.takeUniqueCard(UniqueCard.UniqueCardType.LONGEST_ROAD);
        assertTrue(secondLongestRoad.isEmpty());
    }

}
