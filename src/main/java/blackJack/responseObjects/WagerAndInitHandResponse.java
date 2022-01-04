package blackJack.responseObjects;

import blackJack.game.cardsAndHands.Hand;
import blackJack.game.user.UserCan;

public class WagerAndInitHandResponse {
    /*
    wagerAmount repeated back
    table/player hands
    amount left in player pot
    string format of what went wrong
    * */
   private int wagerAmount;
   private Hand playerHand;
   private Hand tableHand;
   private int playerPotLeft;
   private String errorMsg;
   private boolean goodWager;
   private UserCan userCan;

    public WagerAndInitHandResponse(int wagerAmount, Hand playerHand, Hand tableHand, int playerPotLeft, boolean validWager, UserCan userCan) {
        this.wagerAmount = wagerAmount;
        this.playerHand = playerHand;
        this.tableHand = tableHand;
        this.playerPotLeft = playerPotLeft;
        this.goodWager = validWager;
        this.userCan = userCan;
    }

    public WagerAndInitHandResponse(int wagerAmount, Hand playerHand, Hand tableHand, int playerPotLeft, String errorMsg, boolean goodWager) {
        this.wagerAmount = wagerAmount;
        this.playerHand = playerHand;
        this.tableHand = tableHand;
        this.playerPotLeft = playerPotLeft;
        this.errorMsg = errorMsg;
        this.goodWager = goodWager;

    }

    public WagerAndInitHandResponse() {
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setGoodWager(boolean goodWager) {
        this.goodWager = goodWager;
    }

    public int getWagerAmount() {
        return wagerAmount;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getTableHand() {
        return tableHand;
    }

    public int getPlayerPotLeft() {
        return playerPotLeft;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public UserCan getUserCan() {
        return userCan;
    }

    public boolean isGoodWager() {
        return goodWager;
    }
}
