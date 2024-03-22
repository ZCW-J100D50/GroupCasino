package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.CardClasses.*;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Arrays;

public class BlackJackGame extends CardGame implements GameInterface {

    IOConsole console = new IOConsole();
    BlackJackPlayer player = new BlackJackPlayer();
    /*
    Steps:
        Print the rules
        Gets users and their wager amounts
        Have the dealer deal every player 2 cards to start
        During a player's turn
            - Reveal every player's (including the dealer's) first card
            - Get if the user or deal has blackjack or busted
            - Count an ace as 11 until the user has > 21 at which point change the ace to a 1
            - Ask if they wish to hit
                - if not end the user's turn
        During a dealer's turn
            - Hit until hand total >= 16
            - Check for blackjack or bust
        Check winner
        Payout
        Ask if user wants to play again
     */

    public BlackJackGame(BlackJackPlayer... players){
        this.humanPlayers.addAll(Arrays.asList(players));
        this.dealer = new Dealer();
    }

    @Override
    public void run() {
        System.out.println(printRules() + '\n');

        int playerNum = 1;
        player.addToHand(dealer.deal(2));
        printPlayerHand(player, playerNum);


        dealer.addToHand(dealer.deal(2));
        System.out.print("Dealer's hand: ");
        for(int i = 0; i < dealer.getHand().size(); i++){
            if(i != dealer.getHand().size()- 1){
                System.out.print(dealer.getHand().get(i).getCardValue() +
                        " of " + dealer.getHand().get(i).getSuit() + ", ");
            }
            else{
                System.out.println("+ 1 face down card\n");
            }
        }

        boolean gameOver = false;

        while(true){
            System.out.println("Player " + playerNum + " it's your turn");
            gameOver = playPlayerTurn( player);

            if(gameOver){
                break;
            }

            // Take the dealer's turn
            gameOver = playDealerTurn();
            if(gameOver){
                break;
            }
            if(player.getHandTotal() > dealer.getHandTotal()){
                System.out.println("YOU WIN! You had a total of " + player.getHandTotal());
                System.out.println("Dealer had " + dealer.getHandTotal());
                break;
            }
            else{
                System.out.println("You Lose! You had a total of " + player.getHandTotal());
                System.out.println("Dealer had " + dealer.getHandTotal());
                break;
            }
        }
    }

    public static void printPlayerHand(CardGamePlayer player, int playerNum){
        System.out.print("Player " + playerNum + "'s hand: ");
        for(int i = 0; i < player.getHand().size(); i++){
            if(i != player.getHand().size()- 1){
                System.out.print(player.getHand().get(i).getCardValue() +
                        " of " + player.getHand().get(i).getSuit() + ", ");
            }
            else{
                System.out.println("+ 1 face down card");
            }
        }
    }

    public boolean playPlayerTurn(BlackJackPlayer player){
        player.printHand();
        String move = console.getStringInput("Would you like to hit or stay");

        while(!move.equalsIgnoreCase("stay")){

            player.addToHand(dealer.deck.pop());

            player.printHand();

            // Check if user busted or has black jack
            if(player.isBusted()){
                System.out.println("You've busted! You lose!");
                return true;
            }
            if(player.has21()){
                System.out.println("You have BlackJack! You win!");
                return true;
            }
            move = console.getStringInput("Would you like to hit or stay");
        }
        return false;
    }

    public boolean playDealerTurn(){
        System.out.println(dealer.printDealerHand());
        while(dealer.getHandTotal() < 16){
            dealer.addToHand(dealer.deal(1));
            System.out.println(dealer.printDealerHand());

            if(dealer.getHandTotal() > 21){
                System.out.println("Dealer busted! You Win!");
                return true;
            }
            else if(dealer.getHandTotal() == 21){
                System.out.println("Dealer got blackjack. Dealer wins");
                return true;
            }
        }
        return false;

    }

    @Override
    public String printRules(){

        return  "Goal: Get as close to 21 as possible without going over.\n" +
                "Betting: Before the round begins, each player places a bet using their chips.\n" +
                "Cards: The dealer gives each player one card face up, then themselves, then another face up," +
                " and finally takes their second card face down.\n" +
                "Values: Jacks, Queens, and Kings are worth 10, while Aces can be counted as 1 or 11." +
                " The remaining cards are worth face value.\n" +
                "Hand values: The player wins if their hand is higher than the dealer's without going bust." +
                " Going bust, or over 21, is an automatic loss.";
    }

    public static void main(String[] args){
        BlackJackPlayer player = new BlackJackPlayer();
        BlackJackGame bjg = new BlackJackGame(player);

        bjg.run();
    }


}







