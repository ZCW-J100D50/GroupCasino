package com.github.zipcodewilmington.GameTests.CardClassesTest;

import com.github.zipcodewilmington.casino.games.CardClasses.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTests {
    Card card;
    @Before
    public void setUp(){
        card = new Card(Cards.CardValue.SEVEN, Cards.Suit.CLUBS);
    }
    @Test
    public void testGetCardValue(){
        Cards.CardValue expected = Cards.CardValue.SEVEN;

        Cards.CardValue actual = card.getCardValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCardSuite(){
        Cards.Suit expected = Cards.Suit.CLUBS;
        Cards.Suit actual = card.getSuit();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCardSuite(){
        Cards.Suit expected = Cards.Suit.HEARTS;
        card.setSuit(Cards.Suit.HEARTS);

        Cards.Suit actual = card.getSuit();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCardValue(){
        Cards.CardValue expected = Cards.CardValue.ACE;
        card.setCardValue(Cards.CardValue.ACE);

        Cards.CardValue actual = card.getCardValue();

        Assert.assertEquals(expected, actual);}
}
