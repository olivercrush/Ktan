package com.orinine.ktan.state.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardBankGeneratorTest {

    @Test
    public void generateResourceCardsTest() {
        var resourceCards = CardBankGenerator.generateResourcesCard();
        assertEquals(95, resourceCards.size());
        assertEquals(19, resourceCards.stream().filter(resourceCard -> resourceCard.type() == ResourceCard.ResourceCardType.WOOD).toList().size());
        assertEquals(19, resourceCards.stream().filter(resourceCard -> resourceCard.type() == ResourceCard.ResourceCardType.ROCK).toList().size());
        assertEquals(19, resourceCards.stream().filter(resourceCard -> resourceCard.type() == ResourceCard.ResourceCardType.BRICK).toList().size());
        assertEquals(19, resourceCards.stream().filter(resourceCard -> resourceCard.type() == ResourceCard.ResourceCardType.WHEAT).toList().size());
        assertEquals(19, resourceCards.stream().filter(resourceCard -> resourceCard.type() == ResourceCard.ResourceCardType.SHEEP).toList().size());
    }

    @Test
    public void generateDevelopmentCardsTest() {
        var developmentCards = CardBankGenerator.generateDevelopmentCards();
        assertEquals(25, developmentCards.size());
        assertEquals(14, developmentCards.stream().filter(developmentCard -> developmentCard.type() == DevelopmentCard.DevelopmentCardType.ARMY).toList().size());
        assertEquals(3, developmentCards.stream().filter(developmentCard -> developmentCard.type() == DevelopmentCard.DevelopmentCardType.TWO_RESOURCES).toList().size());
        assertEquals(3, developmentCards.stream().filter(developmentCard -> developmentCard.type() == DevelopmentCard.DevelopmentCardType.TWO_ROADS).toList().size());
        assertEquals(5, developmentCards.stream().filter(developmentCard -> developmentCard.type() == DevelopmentCard.DevelopmentCardType.VICTORY_POINT).toList().size());
    }

    @Test
    public void generateUniqueCardsTest() {
        var uniqueCards = CardBankGenerator.generateUniqueCards();
        assertEquals(2, uniqueCards.size());
        assertTrue(uniqueCards.contains(new UniqueCard(UniqueCard.UniqueCardType.LONGEST_ROAD)));
        assertTrue(uniqueCards.contains(new UniqueCard(UniqueCard.UniqueCardType.BIGGEST_ARMY)));
    }
}
