package com.github.zipcodewilmington.casino.games.Roulette;


import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;

public class RoulettePlayer implements PlayerInterface {

    private String accountName;

    private String accountPassword;
    private double accountBalance;

    public  RoulettePlayer() {

    }

    public RoulettePlayer(String accountName, String accountPassword, double accountBalance) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountBalance = accountBalance;

    }


    Casino casino = new Casino();
    RouletteGame rouletteGame = new RouletteGame();

    @Override
    public CasinoAccount getArcadeAccount() {
        return casino.getCurrentPlayerAccount();
    }

    @Override
    public String play() {
        rouletteGame.run();
        return "Thank you for playing.";
    }
}


