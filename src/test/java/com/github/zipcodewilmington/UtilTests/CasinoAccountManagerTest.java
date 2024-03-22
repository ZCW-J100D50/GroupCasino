package com.github.zipcodewilmington.UtilTests;
//import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccountManager;
import com.github.zipcodewilmington.utils.FileReader;
import org.junit.Test;
import org.junit.Assert;

import java.io.File;
import java.util.LinkedHashMap;

public class CasinoAccountManagerTest {

    @Test
    public void getAccountTest1() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        CasinoAccount testAccount = casinoAccountManager.getAccount("username", "password");
        String expectedName = "username";
        String actualUserName = testAccount.getAccountName();
        Assert.assertEquals(expectedName, actualUserName);
    }

    @Test
    public void getAccountTest2() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        CasinoAccount testAccount = casinoAccountManager.getAccount("Ali", "Bangash");
        String expectedName = "Bangash";
        String actualUserName = testAccount.getAccountPassword();
        Assert.assertEquals(expectedName, actualUserName);
    }

    @Test
    public void getAccountTest3() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        CasinoAccount testAccount = casinoAccountManager.getAccount("Ali", "Bangash");
        String expectedName = "Ali";
        String actualUserName = testAccount.getAccountName();
        Assert.assertEquals(expectedName, actualUserName);
    }


}
