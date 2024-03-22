package com.github.zipcodewilmington.GameTests.CardClassesTest;

import com.github.zipcodewilmington.casino.games.CardClasses.Card;
import com.github.zipcodewilmington.casino.games.CardClasses.Cards;
import com.github.zipcodewilmington.casino.games.CardClasses.Hand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HandTests {
    Hand hand;

    @Before
    public void setup(){
        hand = new Hand();
    }

    @Test
    public void testAdd(){
        Card card = new Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);

        hand.add(card);

        Assert.assertTrue(hand.contains(card));
    }

    @Test
    public void testInheritance(){
        Assert.assertTrue(hand instanceof ArrayList);
    }

    @Test
    public void testGet(){
        Card card = new Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        Card expected = new Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);

        hand.add(card);
        hand.add(expected);

        Card actual = hand.get(1);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testConstructorWithParam(){
        Card card = new Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        Card card2 = new Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Card card3 = new Card(Cards.CardValue.JACK, Cards.Suit.CLUBS);
        Card card4 = new Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);

        Hand testHand = new Hand(card, card2, card3, card4);

        Assert.assertTrue(testHand.contains(card));
        Assert.assertTrue(testHand.contains(card2));
        Assert.assertTrue(testHand.contains(card3));
        Assert.assertTrue(testHand.contains(card4));
    }

    @Test
    public void testsContainsCardVal(){
        Card card = new Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        Card card2 = new Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Card card3 = new Card(Cards.CardValue.JACK, Cards.Suit.CLUBS);
        Card card4 = new Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);

        Hand testHand = new Hand(card, card2, card3, card4);
        boolean actual = testHand.checkIfContainsValue(Cards.CardValue.ACE);
        Assert.assertTrue(actual);
    }

    @Test
    public void testsContainsCardVal1(){
        Card card2 = new Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Card card3 = new Card(Cards.CardValue.JACK, Cards.Suit.CLUBS);
        Card card4 = new Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);

        Hand testHand = new Hand(card2, card3, card4);
        boolean actual = testHand.checkIfContainsValue(Cards.CardValue.ACE);
        Assert.assertFalse(actual);
    }

}
