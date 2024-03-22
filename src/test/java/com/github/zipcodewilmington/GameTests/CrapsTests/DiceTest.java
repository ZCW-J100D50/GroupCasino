package com.github.zipcodewilmington.GameTests.CrapsTests;

import com.github.zipcodewilmington.casino.games.Craps.Dice;
import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void testRandomNumberGen(){
        Dice dice = new Dice();

        boolean expected = dice.randomNumberGenerator() <= 6;

        Assert.assertTrue(expected);
    }
}
