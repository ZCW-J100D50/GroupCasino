package com.github.zipcodewilmington.casino.games.Craps;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class CrapsPlayer implements PlayerInterface {

    private String accountName;
    private String accountPassword;
    private double accountBalance;
    Casino casino = new Casino();
    CrapsGame craps = new CrapsGame();


    public CrapsPlayer(String accountName, String accountPassword, double accountBalance){
        this.accountName = accountName;
        this. accountPassword = accountPassword;
        this.accountBalance = accountBalance;
    }

    public CrapsPlayer(CasinoAccount currentPlayerAccount) {
    }

    public CrapsPlayer() {

    }

    public double getAccountBalance() {
        return accountBalance;
    }


    @Override
    public CasinoAccount getArcadeAccount() {
        return casino.getCurrentPlayerAccount();
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {

        return null;
    }
}
