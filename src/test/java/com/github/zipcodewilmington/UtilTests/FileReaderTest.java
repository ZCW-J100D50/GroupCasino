package com.github.zipcodewilmington.UtilTests;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import com.github.zipcodewilmington.utils.FileReader;
import org.junit.Test;
import org.junit.Assert;

import java.io.FileNotFoundException;

public class FileReaderTest {

    @Test
    public void fileReaderTest1() throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        boolean actual = fileReader.readFile("username", "password");

        Assert.assertTrue(actual);
    }

    @Test
    public void fileReaderTest2() throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        boolean actual = fileReader.readFile("Ali", "Bangash");

        Assert.assertTrue(actual);
    }

    @Test
    public void fileReaderTest3() throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        boolean actual = fileReader.readFile("James", "Rocket");

        Assert.assertTrue(actual);
    }

    @Test
    public void fileWriterTest1() throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        CasinoAccount newAccount = new CasinoAccount("lorimerjohnson", "pwtsor");
        fileReader.writeFile(newAccount);

        boolean actual = fileReader.readFile("lorimerjohnson", "pwtsor");

        Assert.assertTrue(actual);
    }

    @Test
    public void fileWriterTest2() throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        CasinoAccount newAccount = new CasinoAccount("coolpanda3", "97Gb$s4");
        fileReader.writeFile(newAccount);

        boolean actual = fileReader.readFile("coolpanda3", "97Gb$s4");

        Assert.assertTrue(actual);
    }

    @Test
    public void fileWriterTest3() throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        CasinoAccount newAccount = new CasinoAccount("b.runnicle24", "yRszDtK");
        fileReader.writeFile(newAccount);

        boolean actual = fileReader.readFile("b.runnicle24", "yRszDtK");

        Assert.assertTrue(actual);
    }

    @Test
    public void updateBalanceTest() throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        fileReader.updateBalance("b.runnicle", "yRszDtK", 400.0);

        boolean actual = fileReader.readFile("b.runnicle24", "yRszDtK", 400.0);

        Assert.assertTrue(actual);
    }
}
