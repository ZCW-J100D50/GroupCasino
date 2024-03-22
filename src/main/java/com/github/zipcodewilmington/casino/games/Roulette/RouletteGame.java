package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.InputMismatchException;

public class RouletteGame extends IOConsole implements GameInterface {
    private String printRules = "Welcome to Roulette! Adapted for the non-gambling community, see if you can guess what number the ball will stop on.";
    private int playerGuess;

    IOConsole io = new IOConsole();
    Wheel wheel = new Wheel();

    public RouletteGame() {
    }

    public String getRules() {
        return printRules;
    }
    @Override
    public void run() {
<<<<<<< HEAD
        while(true) {
            System.out.println("Lets Play!\n Where do you think the ball will land?\n  ");
            playerGuess = io.getIntegerInput("Pick a number between 0 and 36.");
            if(playerGuess == randomNumberResult){
                System.out.println("Are you psychic??! Way to go! You win!");
            } else if (playerGuess != randomNumberResult) {
                System.out.println("Sorry that's not correct, would you like to try again?");
            }else {

            }
        }

=======
        runGame();
>>>>>>> abf77ce99555cb994d1de83df96ef4c92ff190cc
    }



    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    public void runGame() {
        while(true) {
            try {
                System.out.println("Lets Play!\n Where do you think the ball will land?\n");
                playerGuess = io.getIntegerInput("Pick a number between 0 and 36");
                if (playerGuess == wheel.spinWheel()) {
                    System.out.println("Are you psychic??! Way to go! You win!");
                    String tryAgain = io.getStringInput("Would you like to try your luck again? (Yes or No) ");
                    if (tryAgain.equalsIgnoreCase("No")) {
                        break;
                    }
                } else if (playerGuess != wheel.spinWheel()) {
                    String playAgain = io.getStringInput("Sorry that's not correct, would you like to play again? (Yes or No) ");
                    if (playAgain.equalsIgnoreCase("No")) {
                        break;
                    }

                }
            }
            catch(InputMismatchException e){
                System.out.println("Your input is not valid try a number between 0 and 36");

            }
        }

    }
}
