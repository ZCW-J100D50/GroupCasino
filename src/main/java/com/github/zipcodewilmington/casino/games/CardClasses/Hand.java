package com.github.zipcodewilmington.casino.games.CardClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand extends ArrayList<Card> {

    public Hand(){}
    public Hand(Card... cards){
        this.addAll(Arrays.asList(cards));
    }

    public boolean checkIfContainsValue(Cards.CardValue val){
        for(Card card: this){
            if(card.getCardValue() == val){
                return true;
            }
        }
        return false;
    }


}
