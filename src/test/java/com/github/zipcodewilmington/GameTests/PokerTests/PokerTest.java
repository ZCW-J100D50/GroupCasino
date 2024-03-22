package com.github.zipcodewilmington.GameTests.PokerTests;

import com.github.zipcodewilmington.casino.games.CardClasses.Card;
import com.github.zipcodewilmington.casino.games.CardClasses.Cards;
import com.github.zipcodewilmington.casino.games.CardClasses.Hand;
import com.github.zipcodewilmington.casino.games.Poker.PokerGame;
import org.junit.Test;

public class PokerTest {
    @Test
    public void testIsStraight() {
        PokerGame pg = new PokerGame();
        System.out.println(pg.isStraight(new Hand(new Card(Cards.CardValue.SIX, Cards.Suit.CLUBS), new Card(Cards.CardValue.QUEEN, Cards.Suit.SPADES), new Card(Cards.CardValue.ACE, Cards.Suit.HEARTS), new Card(Cards.CardValue.TWO, Cards.Suit.DIAMONDS))));
    }
}

//ArrayList<PlayerInterface> pokerPLayers;
//Dealer dealer;
//public class PokerTest {
//    PokerGame pokerGame = new PokerGame();
//    @Test
//    public void printRulesTest(){
//        String expected = "Place rules here";
//
//        String actual = GameInterface.printRules();
//
//        Assert.assertEquals(expected,actual);
//
//    }
//    @Test
//    public void addPlayerTest(PlayerInterface player) {
//        pokerPLayers.add(player);
//    }
//    @Test
//    public void removePlayerTest(PlayerInterface player){
//    pokerPLayers.remove(player);
//   }
//   @Test
//    public void run(){}
//    @Test
//    public void gameOver(){}
//
//}
