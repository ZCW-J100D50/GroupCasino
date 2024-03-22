package com.github.zipcodewilmington.GameTests.CardClassesTest;

import com.github.zipcodewilmington.casino.games.CardClasses.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DeckTests {
    private Deck deck;

    @Before
    public void setUp(){
        deck = new Deck();
    }
    @Test
    public void testInheritance(){

        Assert.assertTrue(deck instanceof Stack);
    }

    @Test
    public void testPop(){
        Card expected = deck.peek();

        Card actual = deck.pop();
        Cards.CardValue x = deck.pop().getCardValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testShuffle(){

        Deck tempDeck = (Deck) deck.clone();

        boolean isEqual = true;

        Collections.shuffle(deck);
        for(int i = 0; i < deck.size(); i++){
            Card original  = tempDeck.pop();
            Card shuffled = deck.pop();
            if(original != shuffled){
                isEqual = false;
            }
        }
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testConstructorSuits(){
        int expected = 4;

        ArrayList<Cards.Suit> suits = new ArrayList<>();

        for(int i = 0; i < deck.size() - 1; i++){
            if(!suits.contains(deck.get(i).getSuit())){
                suits.add(deck.get(i).getSuit());
            }
        }

        int actual = suits.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConstructorValues(){
        int expected = 13;

        ArrayList<Cards.CardValue> cv = new ArrayList<>();

        for(int i = 0; i < deck.size() - 1; i++){
            if(!cv.contains(deck.get(i).getCardValue())){
                cv.add(deck.get(i).getCardValue());
            }
        }

        int actual = cv.size();

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testConstructorSize(){
        int expected = 52;
        int actual = deck.size();

        Assert.assertEquals(expected, actual);
    }


}
