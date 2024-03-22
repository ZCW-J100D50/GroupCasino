package com.github.zipcodewilmington.UtilTests;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import org.junit.Test;
import org.junit.Assert;

import java.util.Date;

public class CasinoAccountTests {

    @Test
    public void showBalanceTest() {
        CasinoAccount account1 = new CasinoAccount("hl", "salsa", 100.0);

        double expectedBalance = 100.0;
        double actualBalance = account1.showBalance();

        Assert.assertEquals(expectedBalance, actualBalance, 0.00001);
    }

    @Test
    public void loginTest() {
        Date date = new Date(9/30/1946);
        CasinoAccount account1 = new CasinoAccount("hl", "salsa", 100.0);

        String expectedAccountName = "hl";
        String actualAccountName = account1.getAccountName();
        Assert.assertEquals(expectedAccountName, actualAccountName);
    }

}
