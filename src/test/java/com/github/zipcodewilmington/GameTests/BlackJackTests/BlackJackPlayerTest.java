package com.github.zipcodewilmington.GameTests.BlackJackTests;

import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.CardClasses.CardGamePlayer;
import com.github.zipcodewilmington.casino.games.CardClasses.Cards;
import com.github.zipcodewilmington.casino.games.CardClasses.Hand;
import com.github.zipcodewilmington.casino.games.Trivia.Questions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//+ has21(): bool
public class BlackJackPlayerTest {
    BlackJackPlayer player;
    @Before
    public void setup(){
        player = new BlackJackPlayer(0);
    }
    @Test
    public void testInheritance(){
        Assert.assertTrue(player instanceof CardGamePlayer);
    }

    @Test
    public void testGetHandTotal(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        int expected = 20;

        player.addToHand(card1, card2);

        int actual = player.getHandTotal();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandTotal1(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        int expected = 21;

        player.addToHand(card1, card2, card3);

        int actual = player.getHandTotal();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandTotal2(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        Cards.Card card4 = new Cards.Card(Cards.CardValue.TWO, Cards.Suit.CLUBS);
        int expected = 23;

        player.addToHand(card1, card2, card3, card4);

        int actual = player.getHandTotal();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsBusted(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        Cards.Card card4 = new Cards.Card(Cards.CardValue.TWO, Cards.Suit.CLUBS);

        player.addToHand(card1, card2, card3, card4);

        boolean actual = player.isBusted();

        Assert.assertTrue(actual);
    }

    @Test
    public void testIsBustedEqual21(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);

        player.addToHand(card1, card2, card3);

        boolean actual = player.isBusted();

        Assert.assertFalse(actual);
    }
    @Test
    public void testIsBustedUnder21(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);

        player.addToHand(card1, card2);

        boolean actual = player.isBusted();

        Assert.assertFalse(actual);
    }

    @Test
    public void testHas21(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);

        player.addToHand(card1, card2);

        boolean actual = player.has21();

        Assert.assertFalse(actual);
    }

    @Test
    public void testHas21Equal21(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);

        player.addToHand(card1, card2, card3);

        boolean actual = player.has21();

        Assert.assertTrue(actual);
    }
    @Test
    public void testHas21Over21(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        Cards.Card card4 = new Cards.Card(Cards.CardValue.TWO, Cards.Suit.CLUBS);

        player.addToHand(card1, card2, card3, card4);

        boolean actual = player.has21();

        Assert.assertFalse(actual);
    }
}
