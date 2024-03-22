package com.github.zipcodewilmington.casino.games.CardClasses;

import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Arrays;
import java.util.Stack;

public class CardGamePlayer implements PlayerInterface {

    private Hand hand;
    double wagerAmount;


    protected CardGamePlayer(double wagerAmount){
        this.wagerAmount = wagerAmount;
        this.hand = new Hand();
    }

    protected CardGamePlayer(double wagerAmount, Cards.Card... cards){
        this.wagerAmount = wagerAmount;
        this.hand = new Hand();
        this.hand.addAll(Arrays.asList(cards));
    }
    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

   public void addToHand(Cards.Card... cards) {
       this.hand.addAll(Arrays.asList(cards));
    }

    public double getWagerAmount() {
        return wagerAmount;
    }

    public void setWagerAmount(double wagerAmount) {
        this.wagerAmount = wagerAmount;
    }

    public int getHandTotal(){
        return 0;
    }

    public Stack<Card> drawCards(int numToDraw){

        return new Stack<>();
    }

    public void takeTurn(){}

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
