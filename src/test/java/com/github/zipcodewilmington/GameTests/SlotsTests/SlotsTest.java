package com.github.zipcodewilmington.GameTests.SlotsTests;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
public class SlotsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void randomNumberGeneratorTest() {
        SlotsGame slotsGame = new SlotsGame();

        boolean expectedNumber = slotsGame.randomNumberGenerator() <=6;

        Assert.assertTrue(expectedNumber);
    }

    @Test
    public void setBlocksTest() {
        SlotsGame slotsGame = new SlotsGame();
        int symbol = slotsGame.randomNumberGenerator();

        boolean expectedSymbolValue = symbol <=6;

        Assert.assertTrue(expectedSymbolValue);
    }

    @Test
    public void switchSymbolTest1() {
        SlotsGame slotsGame = new SlotsGame();

        int testNum = 1;

        String expectedValue = "CHERRY";
        String actualValue = slotsGame.switchSymbol(testNum);

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void switchSymbolTest2() {
        SlotsGame slotsGame = new SlotsGame();

        int testNum = 3;

        String expectedValue = "ORANGE";
        String actualValue = slotsGame.switchSymbol(testNum);

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void switchSymbolTest3() {
        SlotsGame slotsGame = new SlotsGame();

        int testNum = 5;

        String expectedValue = "BELL";
        String actualValue = slotsGame.switchSymbol(testNum);

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getResultsTest1() {
        SlotsGame slotsGame = new SlotsGame();
        String symbolOne = slotsGame.switchSymbol(5);
        String symbolTwo = slotsGame.switchSymbol(6);
        String symbolThree = slotsGame.switchSymbol(6);

        String expectedResult = "BELL BAR BAR";
        String actualResult = (symbolOne + " " + symbolTwo + " " + symbolThree);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getResultsTest2() {
        SlotsGame slotsGame = new SlotsGame();
        String symbolOne = slotsGame.switchSymbol(1);
        String symbolTwo = slotsGame.switchSymbol(3);
        String symbolThree = slotsGame.switchSymbol(2);

        String expectedResult = "CHERRY ORANGE LEMON";
        String actualResult = (symbolOne + " " + symbolTwo + " " + symbolThree);

        Assert.assertEquals(expectedResult, actualResult);
    }

}
