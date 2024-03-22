package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.games.RandomNumber;


public class Wheel implements RandomNumber {

    public Wheel() {
    }

    public int spinWheel() {
        int spinResult = randomNumberGenerator();
        return spinResult;

    }

    @Override
    public int randomNumberGenerator() {
        return (int) (37 *Math.random());
    }
}
