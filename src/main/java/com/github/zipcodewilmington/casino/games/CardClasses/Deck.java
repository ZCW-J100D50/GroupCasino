package com.github.zipcodewilmington.casino.games.CardClasses;

import com.github.zipcodewilmington.casino.games.CardClasses.Card;

import java.util.Collections;
import java.util.Stack;

public class Deck extends Stack<Card> {

    public Deck(){
        // Loop through each possible card value
        for(Cards.CardValue val : Cards.CardValue.values()){;
            // Iterate through the suites
            for(Cards.Suit suit : Cards.Suit.values()){
                // Creates card with value CardValue i and Suite j
                Card card = new Card(val, suit);
                add(card);
            }
        }

        // Shuffles the deck AFTER all the cards have been added
        Collections.shuffle(this);
    }

}
