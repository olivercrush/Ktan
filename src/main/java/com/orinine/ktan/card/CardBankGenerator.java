package com.orinine.ktan.card;

import java.util.ArrayList;
import java.util.List;

public class CardBankGenerator {

    private static final int SINGLE_RESOURCE_CARD_AMOUNT = 19;
    private static final int ARMY_CARD_AMOUNT = 14;
    private static final int TWO_ROADS_CARD_AMOUNT = 3;
    private static final int TWO_RESOURCES_CARD_AMOUNT = 3;
    private static final int VICTORY_CARD_AMOUNT = 5;

    public static List<ResourceCard> generateResourcesCard() {
        var list = new ArrayList<ResourceCard>();

        for (ResourceCard.ResourceCardType type : ResourceCard.ResourceCardType.values())
            for (var i = 0; i < SINGLE_RESOURCE_CARD_AMOUNT; i++)
                list.add(new ResourceCard(type));

        return list;
    }

    public static List<DevelopmentCard> generateDevelopmentCards() {
        var list = new ArrayList<DevelopmentCard>();

        for (var i = 0; i < ARMY_CARD_AMOUNT; i++)
            list.add(new DevelopmentCard(DevelopmentCard.DevelopmentCardType.ARMY));

        for (var i = 0 ; i < TWO_ROADS_CARD_AMOUNT; i++)
            list.add(new DevelopmentCard(DevelopmentCard.DevelopmentCardType.TWO_ROADS));

        for (var i = 0; i < TWO_RESOURCES_CARD_AMOUNT; i++)
            list.add(new DevelopmentCard(DevelopmentCard.DevelopmentCardType.TWO_RESOURCES));

        for (var i = 0; i < VICTORY_CARD_AMOUNT; i++)
            list.add(new DevelopmentCard(DevelopmentCard.DevelopmentCardType.VICTORY_POINT));

        return list;
    }

    public static List<UniqueCard> generateUniqueCards() {
        var list = new ArrayList<UniqueCard>();

        for (UniqueCard.UniqueCardType type : UniqueCard.UniqueCardType.values())
            list.add(new UniqueCard(type));

        return list;
    }

}
