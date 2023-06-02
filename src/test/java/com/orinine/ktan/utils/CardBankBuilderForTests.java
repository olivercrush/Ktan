package com.orinine.ktan.utils;

import com.orinine.ktan.state.card.CardBankBuilder;
import com.orinine.ktan.state.card.CardBankGenerator;

public class CardBankBuilderForTests extends CardBankBuilder {

    protected CardBankBuilderForTests() {
        resourceCards = CardBankGenerator.generateResourcesCard();
        developmentCards = CardBankGenerator.generateDevelopmentCards();
        uniqueCards = CardBankGenerator.generateUniqueCards();
    }

    public static CardBankBuilderForTests aCardBankBuilderForTests() {
        return new CardBankBuilderForTests();
    }
}
