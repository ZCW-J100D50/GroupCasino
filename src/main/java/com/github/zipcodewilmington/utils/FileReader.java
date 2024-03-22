package com.github.zipcodewilmington.utils;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileWriter;

public class FileReader {
    static File testFile = new File("src/main/java/com/github/zipcodewilmington/casino/Accounts/TestAccountFile.csv");

    public static boolean readFile(String userName, String passWord) throws FileNotFoundException {
        boolean isInCSV = false;

        try {

            Scanner fileIn = new Scanner(testFile);

            while (fileIn.hasNext()) {
                String lineIn = fileIn.nextLine();
                String[] temp = lineIn.split(",");
                    if (temp[0].equals(userName) && temp[1].equals(passWord)) {
                        isInCSV = true;
                    }
                }
            fileIn.close();
                // check to see if account data is different on file than what is stored in mainMenu.
                // if so, update account information with most recent file data
        } catch(IOException e) {
            System.out.println("File not found.");
        }
        return isInCSV;
    }

    public static boolean readFile(String userName, String passWord, double balance) throws FileNotFoundException {
        boolean isInCSV = false;

        try {

            Scanner fileIn = new Scanner(testFile);

            while (fileIn.hasNext()) {
                String lineIn = fileIn.nextLine();
                String[] temp = lineIn.split(",");
                if (temp[0].equals(userName) && temp[1].equals(passWord)) {
                    isInCSV = true;
                }
            }
            fileIn.close();
            // check to see if account data is different on file than what is stored in mainMenu.
            // if so, update account information with most recent file data
        } catch(IOException e) {
            System.out.println("File not found.");
        }
        return isInCSV;
    }

    public void writeFile(CasinoAccount newAccount) throws FileNotFoundException {
        try {
            FileWriter fileWriter = new FileWriter(testFile, true);
            BufferedWriter fileOut = new BufferedWriter(fileWriter);
            String accountName = newAccount.getAccountName();
            String accountPassword = newAccount.getAccountPassword();
            String lineIn = accountName + "," + accountPassword + "," + 500.0;

            fileOut.newLine();
            fileOut.append(lineIn);

            fileOut.close();

        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public static void updateBalance(String userName, String passWord, double wagers) throws FileNotFoundException {
        try {

            Scanner fileIn = new Scanner(testFile);
            FileWriter fileWriter = new FileWriter(testFile, true);
            BufferedWriter fileOut = new BufferedWriter(fileWriter);

            while (fileIn.hasNext()) {
                String lineIn = fileIn.nextLine();
                String[] temp = lineIn.split(",");
                if (temp[0].equals(userName) && temp[1].equals(passWord)) {
                    lineIn = userName + "," + passWord + "," + wagers;
                    fileOut.append(lineIn);
                }
            }
            fileIn.close();
            // check to see if account data is different on file than what is stored in mainMenu.
            // if so, update account information with most recent file data
        } catch(IOException e) {
            System.out.println("File not found.");
        }
    }

}
