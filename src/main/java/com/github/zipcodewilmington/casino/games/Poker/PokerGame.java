package com.github.zipcodewilmington.casino.games.Poker;

import com.github.zipcodewilmington.casino.games.CardClasses.*;

public class PokerGame extends Cards {

    public String evaluateHand(Hand hand) {
        if (isRoyalFlush(hand))
            return PokerHands.ROYAL_FLUSH.getPokerHandName();
        if (isStraightFlush(hand))
            return PokerHands.STRAIGHT_FLUSH.getPokerHandName();
        if (isFourOfAKind(hand))
            return PokerHands.FOUR_OF_A_KIND.getPokerHandName();
        if (isFullHouse(hand))
            return PokerHands.FULL_HOUSE.getPokerHandName();
        if (isFlush(hand))
            return PokerHands.FLUSH.getPokerHandName();
        if (isStraight(hand))
            return PokerHands.STRAIGHT.getPokerHandName();
        if (isThreeOfAKind(hand))
            return PokerHands.THREE_OF_A_KIND.getPokerHandName();
        if (isTwoPair(hand))
            return PokerHands.TWO_PAIR.getPokerHandName();
        if ((isOnePair(hand)))
            return PokerHands.ONE_PAIR.getPokerHandName();
        return PokerHands.HIGH_CARD.getPokerHandName();
    }

    private boolean isStraightFlush(Hand hand) {

        hand.sort(new CardComparatorIgnoreSuit());

        Card firstCard = hand.get(0);
        Suit firstCardSuit = firstCard.getSuit();


        for (int i = 0; i < hand.size() -1; i++) {
            if(hand.get(i).getSuit() == firstCardSuit || hand.get(i).getCardValue().ordinal() + 1 == hand.get(i + 1).getCardValue().ordinal()){
                return true;
            }
        }
        return false;
    }
    public boolean isStraight(Hand hand) {
        hand.sort(new CardComparatorIgnoreSuit());

        for (int i = 0; i < hand.size() -1; i++) {
            if(hand.get(i).getCardValue().ordinal() +1 == hand.get(i + 1).getCardValue().ordinal()) {
                return true;
            }
        }
        return false;
    }
    private boolean isFullHouse(Hand hand) {
        Card firstCard = hand.get(0);
        Card secondCard = hand.get(1);
        Card thirdCard = hand.get(2);
        Card fourthCard = hand.get(3);
        Card fifthCard = hand.get(4);
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        if (firstCard == secondCard) {
            c1++;
            c2++;
        }

        if (secondCard == thirdCard) {
            c2++;
            c3++;
        }

        if (firstCard == thirdCard) {
            c1++;
            c3++;
        }

        for (int i = 3; i < hand.size(); i++) {
            if (hand.get(i).getCardValue() == firstCard.getCardValue()) {
                c1++;
            }
            if (hand.get(i).getCardValue() == secondCard.getCardValue()) {
                c2++;
            }
            if (hand.get(i).getCardValue() == thirdCard.getCardValue()) {
                c3++;
            }
        }if(c1 + c2 + c3 == 5){
            return true;
        }else if(c1 + c2 + c3 == 4) {
            return true;
        }else if(c1 + c2 + c3 == 6 && fourthCard.getCardValue() == fifthCard.getCardValue()){
            return true;
        }else{
            return false;
        }
    }
    private boolean isRoyalFlush(Hand hand) {
        Card firstCardValue = hand.get(0);
        Suit firstCardSuit = firstCardValue.getSuit();
        int sameSuitCards = 0;
        CardValue c1 = CardValue.ACE;
        CardValue c2 = CardValue.KING;
        CardValue c3 = CardValue.QUEEN;
        CardValue c4 = CardValue.JACK;
        CardValue c5 = CardValue.TEN;


        for (int i = 0; i < hand.size(); i++) {
            if(hand.get(i).getSuit() == firstCardSuit) {
                sameSuitCards++;
                if(sameSuitCards == 4 && hand.checkIfContainsValue(c1) && hand.checkIfContainsValue(c2) && hand.checkIfContainsValue(c3) && hand.checkIfContainsValue(c4) && hand.checkIfContainsValue(c5))
                    return true;
            }
        }
        return false;
    }
    private boolean isOnePair(Hand hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).getCardValue() == hand.get(j).getCardValue()) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isThreeOfAKind(Hand hand) {
        Card firstCard = hand.get(0);
        Card secondCard = hand.get(1);
        Card thirdCard = hand.get(2);
        int cardCount1 = 0;
        int cardCount2 = 0;
        int cardCount3 = 0;

        if (firstCard == secondCard){
            cardCount1++;
            cardCount2++;
        }

        if (secondCard == thirdCard){
            cardCount2++;
            cardCount3++;
        }

        if (firstCard == thirdCard){
            cardCount1++;
            cardCount3++;
        }

        for (int i = 3; i < hand.size(); i++) {
            if(hand.get(i).getCardValue() == firstCard.getCardValue()){
                cardCount1++;
                if(cardCount1 == 2) {
                    return true;
                }
            }
            if(hand.get(i).getCardValue() == secondCard.getCardValue()){
                cardCount2++;
                if(cardCount2 == 2) {
                    return true;
                }
            }
            if(hand.get(i).getCardValue() == thirdCard.getCardValue()) {
                cardCount3++;
                if (cardCount3 == 2){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isTwoPair(Hand hand) {
        int pairCount = 0;
        for (int i = 0; i < hand.size() - 1; i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i).getCardValue() == hand.get(j).getCardValue()) {
                    pairCount++;
                }
            }
        }
        return pairCount == 2;
    }
    private boolean isFlush(Hand hand) {
        Card firstCard = hand.get(0);
        Suit suit = firstCard.getSuit();

        for (int i = 1; i < hand.size(); i++) {
            Card nextCard = hand.get(i);
            Suit cardSuit = nextCard.getSuit();
            if (cardSuit != suit)
                return false;
        }
        return true;
    }
    private boolean isFourOfAKind(Hand hand) {
        Card firstCard = hand.get(0);
        Card secondCard = hand.get(1);
        int firstCardCount = 0;
        int secondCardCount = 0;

        if(firstCard == secondCard){
            firstCardCount++;
            secondCardCount++;
        }

        for (int i = 2; i < hand.size(); i++) {
            if(hand.get(i).getCardValue() == firstCard.getCardValue()) {
                firstCardCount++;
                if (firstCardCount == 3)
                    return true;
            }
            if(hand.get(i).getCardValue() == secondCard.getCardValue()) {
                secondCardCount++;
                if (secondCardCount == 3)
                    return true;
            }
        }
        return false;
    }



    public enum PokerHands{
        HIGH_CARD("♥ ♦ High Card ♠ ♣ "),
        ONE_PAIR("♠ ♣ One Pair ♦ ♥"),
        TWO_PAIR("♠ ♣ Two Pair ♦ ♥"),
        THREE_OF_A_KIND("♠ ♣ Three of a kind ♦ ♥"),
        STRAIGHT("♠ ♣ Straight ♦ ♥"),
        FLUSH("♠ ♣ Flush ♦ ♥"),
        FULL_HOUSE("♠ ♣ Full House ♦ ♥"),
        FOUR_OF_A_KIND("♠ ♣ Four of a kind ♦ ♥"),
        STRAIGHT_FLUSH("♠ ♣ Straight Flush ♦ ♥"),
        ROYAL_FLUSH("♠ ♣ Royal Flush ♦ ♥");
        private final String pokerHandName;
        PokerHands(String pokerHandName) {
            this.pokerHandName = pokerHandName;
        }
        public String getPokerHandName(){
            return pokerHandName;
        }
    }
    public void printRules() {
        System.out.println("♠ ♣ ♦ ♥ Welcome to Poker FIVE-DRAW PLAY! ♦ ♥ ♠ ♣" +
                "-->Bid for this game it's fixed at $10\n" +
                "-->You will get 5 cards.\n" +
                "-->You can choose to keep them or switch them." +
                "-->Bet against dealer if you think you have the highest poker hand.\n" +
                "$$ Let" + "'s" + " play $$$!"
        );
    }
}

