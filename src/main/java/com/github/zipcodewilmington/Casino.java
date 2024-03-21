package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Accounts.CasinoAccount;
import com.github.zipcodewilmington.casino.Accounts.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.Craps.CrapsGame;
import com.github.zipcodewilmington.casino.games.Craps.CrapsPlayer;
import com.github.zipcodewilmington.casino.games.Poker.PokerGame;
import com.github.zipcodewilmington.casino.games.Poker.PokerPlayer;
import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.Roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.games.Trivia.TriviaGame;
import com.github.zipcodewilmington.casino.games.Trivia.TriviaPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private CasinoAccount currentPlayerAccount;

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                currentPlayerAccount = casinoAccount;
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equals("SLOTS")) {
                        play(new SlotsGame(), new SlotsPlayer());
                    } else if (gameSelectionInput.equals("ROULETTE")) {
                        play(new RouletteGame(), new RoulettePlayer());
                    } else if (gameSelectionInput.equals("TRIVIA")) {
                        play(new TriviaGame(), new TriviaPlayer());
                    } else if (gameSelectionInput.equals("CRAPS")) {
                        play(new CrapsGame(), new CrapsPlayer());
                    } else if (gameSelectionInput.equals("BLACKJACK")) {
                        play(new BlackJackGame(), new BlackJackPlayer());
                    } else if (gameSelectionInput.equals("POKER")) {
                        play(new PokerGame(), new PokerPlayer());
                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
                getGameSelectionInput();
                currentPlayerAccount = newAccount;
                break;
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ ROULETTE ], [ TRIVIA ], [ CRAPS ], [ BLACKJACK ], [ POKER ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }

    public CasinoAccount getCurrentPlayerAccount() {
        return currentPlayerAccount;
    }

    public void setCurrentPlayerAccount(CasinoAccount currentPlayerAccount) {
        this.currentPlayerAccount = currentPlayerAccount;
    }
}
