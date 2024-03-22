package com.github.zipcodewilmington.casino.games.CardClasses;

public class Card implements Comparable<Card> {
    private Cards.Suit suit;
    private Cards.CardValue cardValue;

    public Card (Cards.CardValue cardValue, Cards.Suit suit) {
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public Cards.Suit getSuit() {
        return suit;
    }

    public void setSuit(Cards.Suit suit) {
        this.suit = suit;
    }

    public Cards.CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(Cards.CardValue cardValue) {
        this.cardValue = cardValue;
    }

    @Override
    public int compareTo(Card other) {
        return (this.cardValue.ordinal() - other.cardValue.ordinal()) + ((this.suit.ordinal() - other.suit.ordinal()) * 13);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", cardValue=" + cardValue +
                '}';
    }
}