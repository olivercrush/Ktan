package com.orinine.ktan.card;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class CardBank {

    private List<ResourceCard> resourceCards;
    private List<DevelopmentCard> developmentCards;
    private List<UniqueCard> uniqueCards;

    public CardBank(List<ResourceCard> resourceCards, List<DevelopmentCard> developmentCards, List<UniqueCard> uniqueCards) {
        this.resourceCards = resourceCards;
        this.developmentCards = developmentCards;
        this.uniqueCards = uniqueCards;
    }

    public Optional<ResourceCard> takeResourceCard(ResourceCard.ResourceCardType type) {
        return resourceCards.stream()
                .filter(resourceCard -> resourceCard.type() == type)
                .findFirst();
    }

    public Optional<DevelopmentCard> takeDevelopmentCard() {
        return developmentCards.size() == 0 ?
                Optional.empty() :
                Optional.of(developmentCards.get(new Random().nextInt(developmentCards.size() - 1)));
    }

    public Optional<UniqueCard> takeUniqueCard(UniqueCard.UniqueCardType type) {
        return uniqueCards.stream()
                .filter(uniqueCard -> uniqueCard.type() == type)
                .findFirst();
    }
}
