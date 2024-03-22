package com.github.zipcodewilmington.casino.games.CardClasses;


import java.util.ArrayList;

import java.util.Arrays;

public class Dealer {

    public Deck deck;

    public Hand hand;

    public Dealer(){
        this.deck = new Deck();
        this.hand = new Hand();
    }

    public Card[] deal(int numCards){
        Card[] cards = new Card[numCards];
        for(int i = 0; i < numCards; i++){
            cards[i] = deck.pop();
        }
        return cards;
    }

    public void addToHand(Card... cards) {
        this.hand.addAll(Arrays.asList(cards));
    }

    public Hand getHand() {
        return hand;
    }

    public String printDealerHand(){
        String output = "Dealer's Hand: ";

        int index = 1;
        for(Card card : hand){
            if(index != hand.size()) {
                output += card.getCardValue() + " of " + card.getSuit() + ", ";
            }
            else{
                output += card.getCardValue() + " of " + card.getSuit();
            }
            index += 1;
        }
        return output;
    }

    public int getHandTotal(){
        int total = 0;

        for (Cards.Card card : hand) {
            switch(card.getCardValue()){
                case ACE:
                    total += 11;
                    break;
                case KING:
                case JACK:
                case QUEEN:
                case TEN:
                    total += 10;
                    break;
                case NINE:
                    total += 9;
                    break;
                case EIGHT:
                    total += 8;
                    break;
                case SEVEN:
                    total += 7;
                    break;
                case SIX:
                    total += 6;
                    break;
                case FIVE:
                    total += 5;
                    break;
                case FOUR:
                    total += 4;
                    break;
                case THREE:
                    total += 3;
                    break;
                case TWO:
                    total += 2;
                    break;
            }
        }
        if(total > 21 && hand.checkIfContainsValue(Cards.CardValue.ACE)){
            total -= 10;
        }
        return total;
    }

}

