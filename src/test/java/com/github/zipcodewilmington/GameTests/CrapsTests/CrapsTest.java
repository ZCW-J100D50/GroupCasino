package com.github.zipcodewilmington.GameTests.CrapsTests;

import com.github.zipcodewilmington.casino.games.Craps.CrapsGame;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    @Test
    public void testAnySeven1(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.anySeven(2, 5, 100);

        //Then
        Assert.assertEquals(expected, actual, .00001);
    }

    @Test
    public void testAnySeven2(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.anySeven(5, 2, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testAnySeven3(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.anySeven(4, 3, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testAnySeven4(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.anySeven(3, 4, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testAnySeven5(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.anySeven(1, 6, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testAnySeven6(){
        //Given
        CrapsGame craps = new CrapsGame();
        int expected = 700;

        //When
        double actual = craps.anySeven(6, 1, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testAnySevenLoss(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 0;

        //When
        double actual = craps.anySeven(1, 1, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight1(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(3, 3, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight2(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(5, 1, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight3(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(1, 5, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight4(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(4, 2, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight5(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(2, 4, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight6(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(4, 4, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight7(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(5, 3, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight8(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(3, 5, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight9(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(6, 2, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEight10(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 200;

        //When
        double actual = craps.bigSixAndEight(2, 6, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testBigSixAndEightLoss(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 0;

        //When
        double actual = craps.bigSixAndEight(1, 1, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testHardWays1(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 900;

        //When
        double actual = craps.hardWays(3, 3, 100);

        //Then
        Assert.assertEquals(expected, actual, .001);
    }

    @Test
    public void testHardWays2(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 900;

        //When
        double actual = craps.hardWays(4, 4, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testHardWays3(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.hardWays(5, 5, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testHardWays4(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.hardWays(2, 2, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testHardWaysLoss(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 0;

        //When
        double actual = craps.hardWays(1, 1, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testOneRollBets1(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 3000;

        //When
        double actual = craps.oneRollBets(1, 1, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testOneRollBets2(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 3000;

        //When
        double actual = craps.oneRollBets(6, 6, 100);

        //Then
        Assert.assertEquals(expected, actual, .001);
    }

    @Test
    public void testOneRollBets3(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 1500;

        //When
        double actual = craps.oneRollBets(1, 2, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testOneRollBets4(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 1500;

        //When
        double actual = craps.oneRollBets(2, 1, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testOneRollBets5(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 1500;

        //When
        double actual = craps.oneRollBets(5, 6, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testOneRollBets6(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 1500;

        //When
        double actual = craps.oneRollBets(6, 5, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testOneRollBetsLoss(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 0;

        //When
        double actual = craps.oneRollBets(4, 6, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testAnyCrapsBet1(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.anyCrapsBet(1, 1, 100);

        //Then
        Assert.assertEquals(expected, actual, .00001);
    }

    @Test
    public void testAnyCrapsBet2(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.anyCrapsBet(1, 2, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testAnyCrapsBet3(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.anyCrapsBet(2, 1, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testAnyCrapsBet4(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 700;

        //When
        double actual = craps.anyCrapsBet(6, 6, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }

    @Test
    public void testAnyCrapsBetLoss(){
        //Given
        CrapsGame craps = new CrapsGame();
        double expected = 0;

        //When
        double actual = craps.anyCrapsBet(4, 6, 100);

        //Then
        Assert.assertEquals(expected, actual, .0001);
    }
}
