package com.orinine.ktan.state.card;

import java.util.List;

public class CardBankBuilder {

    protected List<ResourceCard> resourceCards;
    protected List<DevelopmentCard> developmentCards;
    protected List<UniqueCard> uniqueCards;

    protected CardBankBuilder() {

    }

    public static CardBankBuilder aCardBankBuilder() {
        return new CardBankBuilder();
    }

    public CardBankBuilder setResourceCards(List<ResourceCard> resourceCards) {
        this.resourceCards = resourceCards;
        return this;
    }

    public CardBankBuilder setDevelopmentCards(List<DevelopmentCard> developmentCards) {
        this.developmentCards = developmentCards;
        return this;
    }

    public CardBankBuilder setUniqueCards(List<UniqueCard> uniqueCards) {
        this.uniqueCards = uniqueCards;
        return this;
    }

    public CardBank build() {
        return new CardBank(resourceCards, developmentCards, uniqueCards);
    }
}
