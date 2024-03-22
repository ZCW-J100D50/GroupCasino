package com.github.zipcodewilmington.GameTests.RouletteTests;
import com.github.zipcodewilmington.casino.games.Roulette.Wheel;
import org.junit.Assert;
import org.junit.Test;

public class WheelTest {
    @Test
    public void testSpinWheel() {
        Wheel wheel = new Wheel();

        boolean expectedSpinResult = wheel.spinWheel() <= 36;

        Assert.assertTrue(expectedSpinResult);
    }

    @Test
    public void testRandomNumberGenerator() {
        Wheel spin = new Wheel();

        boolean expectedResult = spin.randomNumberGenerator() <= 36;

        Assert.assertTrue(expectedResult);
    }
}
