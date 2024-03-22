package com.github.zipcodewilmington.casino.games.CardClasses;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;

public abstract class CardGame implements GameInterface {
    public ArrayList<CardGamePlayer> humanPlayers;
    public Dealer dealer;

    public CardGame(){
        humanPlayers = new ArrayList<>();
        dealer = new Dealer();
    }
    @Override
    public void add(PlayerInterface player) {
        humanPlayers.add((CardGamePlayer) player);
    }

    @Override
    public void remove(PlayerInterface player) {
        humanPlayers.remove(player);
    }

    public String printRules(){

        return null;
    }

    @Override
    public void run() {

    }
}
