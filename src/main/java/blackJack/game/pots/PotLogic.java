package blackJack.game.pots;

import blackJack.game.cardsAndHands.WinnerState;

public class DivvyThePot {
    private PlayerPot playerPot;
    private TablePot tablePot;

    public DivvyThePot(PlayerPot playerPot, TablePot tablePot) {
        this.playerPot = playerPot;
        this.tablePot = tablePot;
    }

    public void divvyThePot(WinnerState winnerState) {
        if (winnerState.isPlayerWon() && winnerState.isTableWon()){
            playerPot.addAmount(tablePot.getWager());
        }
        else if (winnerState.isPlayerWon()){
            playerPot.addAmount(tablePot.getAmount());
        }
        tablePot.wipe();
    }
}
