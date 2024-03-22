package com.github.zipcodewilmington.casino.games.Craps;


import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

public class CrapsGame extends Dice implements GameInterface {

    private int dice1;
    private int dice2;
    private double bet;
    int payout;

    private int accountBalance;


    @Override
    public void add(PlayerInterface player) {
    //Store account balance in local variable
    }

    @Override
    public void remove(PlayerInterface player) {
    //update account balance when player leaves, map to player casino account
    }

    @Override
    public void run() {
       while(true) {
           IOConsole io = new IOConsole();
           chooseAmountToWager(accountBalance);
           chooseYourBetPositions();
           String input = io.getStringInput("Do you want to keep playing? Type YES or NO");
           if(!input.equalsIgnoreCase("yes")){
               break;
           }
       }
    }

    public double chooseAmountToWager(double accBalance) {
        try {
            IOConsole io = new IOConsole();
            int bet = io.getIntegerInput("How much would you like to wager?");
            this.bet = bet;
            accBalance = accBalance - bet;
            if (bet > accBalance) {
                System.out.println("Not enough funds available in your account!!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Not a number or integer");
        }
        return bet;
    }


        public void chooseYourBetPositions () {
            try {
                IOConsole io = new IOConsole();
                System.out.println("CRAPS BETTING POSITIONS: ");
                System.out.println("1. Any Seven Pays 7:1");
                System.out.println("2. Big Six or Eight Pays 1:1");
                System.out.println("3. Hardways Pays up to 9:1");
                System.out.println("4. One Roll Bets Pays up to 30:1");
                System.out.println("5. Any Craps Bet Pays 7:1");
                int choice = io.getIntegerInput("Where do you want to place your bet?");
                switch (choice) {
                    case 1:
                        System.out.println("You need any combination to make a 7. Pays 7:1. Good Luck!!");
                        rollDice();
                        anySeven(dice1, dice2, bet);
                        break;
                    case 2:
                        System.out.println("You need any combination to make a 6 or an 8. Pays 1:1. Good Luck!!");
                        rollDice();
                        bigSixAndEight(dice1, dice2, bet);
                        break;
                    case 3:
                        System.out.println("You need Two 2s, Two 3s, Two 4s, or Two 5s. Pays 7:1. Good Luck!");
                        rollDice();
                        hardWays(dice1, dice2, bet);
                        break;
                    case 4:
                        System.out.println("You need Two 1s(Pays 30:1), Two 6s(Pays 30:1), 3(Pays 15:1), or 11(Pays 15:1). Good Luck!");
                        rollDice();
                        oneRollBets(dice1, dice2, bet);
                        break;
                    case 5:
                        System.out.println("You need a 2, 3, or 12. Pays 7:1. Good Luck!");
                        rollDice();
                        anyCrapsBet(dice1, dice2, bet);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please make a choice between 1 and 5.");
            }
        }

        public void rollDice () {
            dice1 = randomNumberGenerator();
            dice2 = randomNumberGenerator();
        }


        public double anySeven ( int d1, int d2, double wager){
            if (d1 == 2 && d2 == 5 || d1 == 5 && d2 == 2 ||
                    d1 == 4 && d2 == 3 ||d1 == 3 && d2 == 4 ||
                d1 == 1 && d2 == 6 ||d1 == 6 && d2 == 1) {
                System.out.println("Dice 1: " + d1);
                System.out.println("Dice 2: " + d2);
                System.out.println("YOU WON!!!");
                return wager * 7.0;
            }
            System.out.println("Dice 1: " + d1);
            System.out.println("Dice 2: " + d2);
            System.out.println("You Lost....");
            return 0;
        }

        public double bigSixAndEight (int d1, int d2, double wager){
            if (d1 == 3 && d2 == 3 ||d1 == 5 && d2 == 1 ||
                    d1 == 1 && d2 == 5 || d1 == 4 && d2 == 2 ||
                    d1 == 2 && d2 == 4 || d1 == 4 && d2 == 4 ||
                    d1 == 5 && d2 == 3 || d1 == 3 && d2 == 5 ||
                    d1 == 6 && d2 == 2 || d1 == 2 && d2 == 6) {
                System.out.println("Dice 1: " + d1);
                System.out.println("Dice 2: " + d2);
                System.out.println("YOU WON!!!");
                return wager + wager;
            }
            System.out.println("Dice 1: " + d1);
            System.out.println("Dice 2: " + d2);
            System.out.println("You Lost....");
            return 0;
        }

        public double hardWays ( int d1, int d2, double wager){
            if (d1 == 3 && d2 == 3 || d1 == 4 && d2 == 4) {
                System.out.println("Dice 1: " + d1);
                System.out.println("Dice 2: " + d2);
                System.out.println("YOU WON!!!");
                return wager * 9;
            } else if (d1 == 5 && d2 == 5 || d1 == 2 && d2 == 2) {
                System.out.println("Dice 1: " + d1);
                System.out.println("Dice 2: " + d2);
                System.out.println("YOU WON!!!");
                return wager * 7;
            }
            System.out.println("Dice 1: " + d1);
            System.out.println("Dice 2: " + d2);
            System.out.println("You Lost....");
            return 0;

        }

        public double oneRollBets ( int d1, int d2, double wager){
            if (d1 == 1 && d2 == 1 || d1 == 6 && d2 == 6) {
                System.out.println("Dice 1: " + d1);
                System.out.println("Dice 2: " + d2);
                System.out.println("YOU WON!!!");
                return wager * 30;
            } else if (d1 == 1 && d2 == 2 || d1 == 2 && d2 == 1 ||
                    d1 == 5 && d2 == 6 || d1 == 6 && d2 == 5) {
                System.out.println("Dice 1: " + d1);
                System.out.println("Dice 2: " + d2);
                System.out.println("YOU WON!!!");
                return wager * 15;
            }
            System.out.println("Dice 1: " + d1);
            System.out.println("Dice 2: " + d2);
            System.out.println("You Lost....");
            return 0;
        }

        public double anyCrapsBet ( int d1, int d2, double wager){
            if (d1 == 1 && d2 == 1 || d1 == 1 && d2 == 2 ||
                    d1 == 2 && d2 == 1 || d1 == 6 && d2 == 6) {
                System.out.println("Dice 1: " + d1);
                System.out.println("Dice 2: " + d2);
                System.out.println("YOU WON!!!");
                return wager * 7.0;
            }
            System.out.println("Dice 1: " + d1);
            System.out.println("Dice 2: " + d2);
            System.out.println("You Lost....");
            return 0;
        }


}
