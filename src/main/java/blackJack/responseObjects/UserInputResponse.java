package blackJack.responseObjects;

import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;
import blackJack.game.user.WinnerState;

public class UserInputResponse {
    String msg;
    Hand playerHand;
    Hand tableHand;
    int wager;
    TablePot tablePot;
    PlayerPot playerPot;
    WinnerState winnerState;

    public UserInputResponse(Hand playerHand, Hand tableHand, int wager, TablePot tablePot, PlayerPot playerPot,
                             WinnerState winnerState) {

        this.playerHand = playerHand;
        this.tableHand = tableHand;
        this.wager = wager;
        this.tablePot = tablePot;
        this.playerPot = playerPot;
        this.winnerState = winnerState;
    }

    public UserInputResponse() {
    }

    public void badDoubleDown() {
        this.msg = "Not enough money for a Double Down";
    }
    private void setMsg(){
        if(winnerState.isPlayerWon() && winnerState.isTableWon()){
            this.msg = "Push!";
        }
        else if (winnerState.isPlayerWon()){
            this.msg = "Player Wins!";
        }
        else{
            this.msg = "Table Wins.";
        }
    }

    public String getMsg() {
        return msg;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getTableHand() {
        return tableHand;
    }

    public int getWager() {
        return wager;
    }


    public TablePot getTablePot() {
        return tablePot;
    }

    public PlayerPot getPlayerPot() {
        return playerPot;
    }

    public WinnerState getWinnerState() {
        return winnerState;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    public void setTableHand(Hand tableHand) {
        this.tableHand = tableHand;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }

    public void setTablePot(TablePot tablePot) {
        this.tablePot = tablePot;
    }

    public void setPlayerPot(PlayerPot playerPot) {
        this.playerPot = playerPot;
    }

    public void setWinnerState(WinnerState winnerState) {
        this.winnerState = winnerState;
    }
}
