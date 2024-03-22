package com.github.zipcodewilmington.casino.games.CardClasses;

import java.util.Comparator;

public class CardComparatorIgnoreSuit implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        return card1.getCardValue().ordinal() - card2.getCardValue().ordinal();
    }
}
