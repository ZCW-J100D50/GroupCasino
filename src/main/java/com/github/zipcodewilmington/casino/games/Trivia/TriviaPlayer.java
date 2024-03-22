package com.github.zipcodewilmington.casino.games.Trivia;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;

public class TriviaPlayer implements PlayerInterface {
    Casino casino = new Casino();
    TriviaGame triviaGame = new TriviaGame();

    @Override
    public CasinoAccount getArcadeAccount() {
        return casino.getCurrentPlayerAccount();
    }

    @Override
    public String play() {
        triviaGame.run();
        return "Thank you for playing.";
    }
}
