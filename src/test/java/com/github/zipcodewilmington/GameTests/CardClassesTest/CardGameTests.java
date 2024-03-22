package com.github.zipcodewilmington.GameTests.CardClassesTest;

import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.CardClasses.CardGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardGameTests {
    CardGame cardGame;

    @Before
    public void setup(){
        cardGame = new BlackJackGame();
    }

    @Test
    public void addPlayer(){

        BlackJackPlayer bjp = new BlackJackPlayer(0);

        cardGame.add(bjp);

        Assert.assertTrue(cardGame.humanPlayers.contains(bjp));
    }

    @Test
    public void testRemovePlayer(){

        BlackJackPlayer bjp = new BlackJackPlayer(0);

        cardGame.add(bjp);
        cardGame.remove(bjp);

        Assert.assertFalse(cardGame.humanPlayers.contains(bjp));
    }
}
