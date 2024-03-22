package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;


/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface {

    private String accountName;

    private String accountPassword;
    private double accountBalance;
    SlotsGame slotsGame = new SlotsGame();
    public  SlotsPlayer() {

    }

    public SlotsPlayer(String accountName, String accountPassword, double accountBalance) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountBalance = accountBalance;

    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    Casino casino = new Casino();

    @Override
    public CasinoAccount getArcadeAccount() {
        return casino.getCurrentPlayerAccount();
    }

    @Override
    public String play() {
        SlotsPlayer tempSlotsPlayer = new SlotsPlayer(getArcadeAccount().getAccountName(), getArcadeAccount().getAccountPassword(), getArcadeAccount().getAccountBalance());
        slotsGame.add(tempSlotsPlayer);

        slotsGame.run();
        slotsGame.remove(tempSlotsPlayer);
        return "Thanks for playing.";
    }
}