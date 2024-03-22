package com.github.zipcodewilmington.GameTests.RouletteTests;

import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;//ali
import java.io.InputStream;

public class RouletteTest {
    @Test
    public void testPrintRules() {
        RouletteGame roulette = new RouletteGame();

        String expectedRules = "Welcome to Roulette! Adapted for the non-gambling community, see if you can guess what number the ball will stop on.";

        String actualRules = roulette.getRules();

        Assert.assertEquals(expectedRules, actualRules);
    }

//    @Test
//    public void testPlayerGuess() {
//        RouletteGame rouletteGame = new RouletteGame();
//        int mockPlayerGuess = 36;
//        System.setIn(new Integer(rouletteGame.playerGuess()));
//
//        int expectedPlayerGuess = 36;
//
//        int actualPlayerGuess = rouletteGame.getPlayerGuess();
//
//        Assert.assertEquals(expectedPlayerGuess,actualPlayerGuess);
//    }
//
//    @Test
//    public void testRunGame (){
//        RouletteGame rouletteGame = new RouletteGame();
//        String expectedresult
//
//    }
}
