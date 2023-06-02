package com.orinine.ktan.state.card;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class CardBank {

    List<ResourceCard> resourceCards;
    List<DevelopmentCard> developmentCards;
    List<UniqueCard> uniqueCards;

    public CardBank(List<ResourceCard> resourceCards, List<DevelopmentCard> developmentCards, List<UniqueCard> uniqueCards) {
        this.resourceCards = resourceCards;
        this.developmentCards = developmentCards;
        this.uniqueCards = uniqueCards;
    }

    public Optional<ResourceCard> takeResourceCard(ResourceCard.ResourceCardType type) {
        Optional<ResourceCard> resourceCard = resourceCards.stream()
                .filter(r -> r.type() == type)
                .findFirst();

        resourceCard.ifPresent(r -> resourceCards.remove(r));
        return resourceCard;
    }

    public void putResourceCards(List<ResourceCard> resourceCards) {
        this.resourceCards.addAll(resourceCards);
    }

    public Optional<DevelopmentCard> takeDevelopmentCard() {
        Optional<DevelopmentCard> developmentCard = developmentCards.size() == 0 ?
                Optional.empty() :
                Optional.of(developmentCards.get(new Random().nextInt(developmentCards.size() - 1)));

        developmentCard.ifPresent(d -> developmentCards.remove(d));
        return developmentCard;
    }

    public Optional<UniqueCard> takeUniqueCard(UniqueCard.UniqueCardType type) {
        Optional<UniqueCard> uniqueCard = uniqueCards.stream()
                .filter(u -> u.type() == type)
                .findFirst();

        uniqueCard.ifPresent(u -> uniqueCards.remove(u));
        return uniqueCard;
    }
}
