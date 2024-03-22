package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.CardClasses.CardGamePlayer;
import com.github.zipcodewilmington.casino.games.CardClasses.Cards;
import com.github.zipcodewilmington.casino.games.CardClasses.Hand;

public class BlackJackPlayer extends CardGamePlayer implements PlayerInterface {
    Casino casino = new Casino();
    Hand hand;
    double wager;

    public BlackJackPlayer(){
        super(0);
        this.wager = super.getWagerAmount();
        hand = super.getHand();
    }
    public BlackJackPlayer(double wager){
        super(wager);
        this.wager = super.getWagerAmount();
        hand = super.getHand();
    }
    public BlackJackPlayer(double wager, Cards.Card... cards){
        super(wager, cards);

        this.wager = super.getWagerAmount();
        hand = super.getHand();
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casino.getCurrentPlayerAccount();
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        BlackJackGame bjg = new BlackJackGame();
        bjg.run();
        return null;
    }



    // I hate this. It is not clean at all. However, project is due tonight and this is the only workaround I could find
    // in time. If a new way to do this is discovered I will fix it.
    public int getHandTotal(){
        int total = 0;

        for (Cards.Card card : hand) {
            switch(card.getCardValue()){
                case ACE:
                    total += 11;
                    break;
                case KING:
                case JACK:
                case QUEEN:
                case TEN:
                    total += 10;
                    break;
                case NINE:
                    total += 9;
                    break;
                case EIGHT:
                    total += 8;
                    break;
                case SEVEN:
                    total += 7;
                    break;
                case SIX:
                    total += 6;
                    break;
                case FIVE:
                    total += 5;
                    break;
                case FOUR:
                    total += 4;
                    break;
                case THREE:
                    total += 3;
                    break;
                case TWO:
                    total += 2;
                    break;
            }
        }
        if(total > 21 && hand.checkIfContainsValue(Cards.CardValue.ACE)){
            total -= 10;
        }
        return total;
    }

    public boolean isBusted() {
        return getHandTotal() > 21;
    }

    public boolean has21() {
        return getHandTotal() == 21;
    }
    public void printHand(){
        System.out.print("Your hand : ");
        int index = 1;
        for(Cards.Card card : hand){
            if(index < hand.size()) {
                System.out.print(card.getCardValue() + " of " + card.getSuit() + ", ");
            }
            else {
                System.out.println(card.getCardValue() + " of " + card.getSuit());
            }
            index++;
        }
    }
}
