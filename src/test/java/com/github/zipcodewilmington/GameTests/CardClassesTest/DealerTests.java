package com.github.zipcodewilmington.GameTests.CardClassesTest;

import com.github.zipcodewilmington.casino.games.CardClasses.Cards;
import com.github.zipcodewilmington.casino.games.CardClasses.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;


public class DealerTests {
    Dealer dealer;

    @Before
    public void setUp(){
        dealer = new Dealer();
    }

    @Test
    public void testShuffle(){
        Deck tempDeck = (Deck) dealer.deck.clone();

        boolean isEqual = true;

        Collections.shuffle(dealer.deck);
        for(int i = 0; i < dealer.deck.size(); i++){
            Cards.Card original  = tempDeck.pop();
            Cards.Card shuffled = dealer.deck.pop();
            if(original != shuffled){
                isEqual = false;
            }
        }
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testDeal(){
        Cards.Card[] expected = new Cards.Card[1];
        expected[0] = dealer.deck.peek();

        Cards.Card[] actual = dealer.deal(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDealLength(){
        int expected = 10;

        Cards.Card[] actual = dealer.deal(10);

        Assert.assertEquals(expected, actual.length);
    }

    @Test
    public void testAddToHand(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        Cards.Card card4 = new Cards.Card(Cards.CardValue.TWO, Cards.Suit.CLUBS);
        ArrayList<Cards.Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        dealer.addToHand(card1, card2, card3, card4);

        Assert.assertEquals(cards, dealer.hand);

    }

    @Test
    public void testGetHand(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        Cards.Card card4 = new Cards.Card(Cards.CardValue.TWO, Cards.Suit.CLUBS);
        ArrayList<Cards.Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        dealer.addToHand(card1, card2, card3, card4);
        for(int i = 0; i < dealer.getHand().size(); i++){
         Assert.assertEquals(dealer.getHand().get(i), cards.get(i));
        }
    }

    @Test
    public void testPrintDeck(){
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);

        dealer.addToHand(card2, card3);

        String expected = "Dealer's Hand: QUEEN of CLUBS, ACE of CLUBS";
        String actual = dealer.printDealerHand();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandTotal(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        int expected = 20;

        dealer.addToHand(card1, card2);

        int actual = dealer.getHandTotal();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandTotal1(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        int expected = 21;

        dealer.addToHand(card1, card2, card3);

        int actual = dealer.getHandTotal();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandTotal2(){
        Cards.Card card1 = new Cards.Card(Cards.CardValue.TEN, Cards.Suit.CLUBS);
        Cards.Card card2 = new Cards.Card(Cards.CardValue.QUEEN, Cards.Suit.CLUBS);
        Cards.Card card3 = new Cards.Card(Cards.CardValue.ACE, Cards.Suit.CLUBS);
        Cards.Card card4 = new Cards.Card(Cards.CardValue.TWO, Cards.Suit.CLUBS);
        int expected = 23;

        dealer.addToHand(card1, card2, card3, card4);

        int actual = dealer.getHandTotal();

        Assert.assertEquals(expected, actual);
    }

}
