package com.github.zipcodewilmington.casino.Accounts;
import com.github.zipcodewilmington.utils.FileReader;
import com.github.zipcodewilmington.utils.IOConsole;

import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Date;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    private Logger accountLogger = Logger.getLogger("New Accounts Log");
    Date date = new Date();
    IOConsole console = new IOConsole();
    SimpleFormatter logFormatter = new SimpleFormatter();
    FileHandler fileHandler;

    {
        try {
            fileHandler = new FileHandler("Casino_Accounts.csv", true);
            accountLogger.addHandler(fileHandler);
            accountLogger.setLevel(Level.INFO);
            fileHandler.setFormatter(logFormatter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        boolean exists = false;
        CasinoAccount result = null;
        CasinoAccount casinoAccount1 = new CasinoAccount(accountName, accountPassword, 0);
        try {
            if (FileReader.readFile(accountName, accountPassword)) {
                exists = true;
                result = casinoAccount1;

            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        CasinoAccount casinoAccount = new CasinoAccount(accountName, accountPassword, 0.0);
        return casinoAccount;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount newAccount) {
        try {
            FileReader fileReader = new FileReader();
            String accountName = newAccount.getAccountName();
            String accountPassword = newAccount.getAccountPassword();

            fileReader.writeFile(newAccount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccountBalance(CasinoAccount tempCasinoAccount) {

    }
}



