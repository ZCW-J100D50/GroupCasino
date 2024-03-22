package com.github.zipcodewilmington.casino.games.Craps;

import com.github.zipcodewilmington.casino.games.RandomNumber;

import java.util.Random;

public class Dice implements RandomNumber {


    @Override
    public int randomNumberGenerator() {
        return (int) (6.0 * Math.random() +1 );
    }


}
