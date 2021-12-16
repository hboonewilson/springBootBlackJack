package blackJack.game;

import blackJack.game.user.WinnerState;
import blackJack.game.user.UserCan;
import blackJack.game.user.UserInput;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;

public class SharedHandState {
    private PlayerPot playerPot;
    private TablePot tablePot;

    private Hand playerHand;
    private Hand tableHand;


    private UserInput userInput;
    private UserCan userCan;
    private WinnerState winnerState;

    private boolean playingHand;


    public SharedHandState(PlayerPot playerPot, TablePot tablePot) {
        this.playerPot = playerPot;
        this.tablePot = tablePot;

        this.playerHand = new Hand();
        this.tableHand = new Hand();

        this.userInput = new UserInput();
        this.userCan = new UserCan();
        this.winnerState = new WinnerState();

        this.playingHand = true;

    }
    public TablePot getTablePot() {
        return tablePot;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getTableHand() {
        return tableHand;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }

    public UserCan getUserCan() {
        return userCan;
    }

    public WinnerState getWinnerState() {
        return winnerState;
    }

    public void setPlayingHand(boolean playingHand) {
        this.playingHand = playingHand;
    }

    public PlayerPot getPlayerPot() {
        return playerPot;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }
}
