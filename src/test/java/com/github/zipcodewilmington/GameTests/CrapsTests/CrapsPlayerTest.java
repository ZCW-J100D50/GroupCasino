package com.github.zipcodewilmington.GameTests.CrapsTests;

import com.github.zipcodewilmington.casino.games.Craps.CrapsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class CrapsPlayerTest {

    @Test
    public void constructorTest(){
        //Given
        String expectedName = "Matt";
        String expectedPassword = "Matt";
        Double expectedBalance = 1000.00;

        //When
        CrapsPlayer cp = new CrapsPlayer(expectedName, expectedPassword, expectedBalance);
        Double actual = cp.getAccountBalance();

        //Then
        Assert.assertEquals(expectedBalance, actual);
    }
}
