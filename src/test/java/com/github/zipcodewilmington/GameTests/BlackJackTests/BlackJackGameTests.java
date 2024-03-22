package com.github.zipcodewilmington.GameTests.BlackJackTests;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.CardClasses.CardGame;
import com.github.zipcodewilmington.casino.games.CardClasses.Cards;
import com.github.zipcodewilmington.casino.games.CardClasses.Dealer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BlackJackGameTests {
    BlackJackGame bjg;
    BlackJackPlayer player = new BlackJackPlayer();

    @Before
    public void setup(){
        bjg = new BlackJackGame(player);
    }

    @Test
    public void testInheritance(){
        Assert.assertTrue(bjg instanceof CardGame);
        Assert.assertTrue(bjg instanceof GameInterface);
    }
    @Test
    public void printRulesTest(){
        String expect = "Goal: Get as close to 21 as possible without going over.\n" +
                "Betting: Before the round begins, each player places a bet using their chips.\n" +
                "Cards: The dealer gives each player one card face up, then themselves, then another face up," +
                " and finally takes their second card face down.\n" +
                "Values: Jacks, Queens, and Kings are worth 10, while Aces can be counted as 1 or 11." +
                " The remaining cards are worth face value.\n" +
                "Hand values: The player wins if their hand is higher than the dealer's without going bust." +
                " Going bust, or over 21, is an automatic loss.";

        String actual = bjg.printRules();
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testPlayDealerTurn() {
    }
}
