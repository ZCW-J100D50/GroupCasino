package com.github.zipcodewilmington.casino.games.Poker;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

public class PokerPlayer extends IOConsole implements GameInterface {
    IOConsole io = new IOConsole();
    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        PokerGame poker = new PokerGame();


    }
//- Super(hand, handTotal, wagerAmount)
//    +boolean fold(PokerPlayer pokerPlayer) returns boolean

}
