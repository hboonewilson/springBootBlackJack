package blackJack.game.pots;

import blackJack.game.user.WinnerState;

public class DivvyPots {
    PlayerPot playerPot;
    TablePot tablePot;

    public DivvyPots(PlayerPot playerPot, TablePot tablePot) {
        this.playerPot = playerPot;
        this.tablePot = tablePot;
    }

    public void divvy(WinnerState winnerState) {
        boolean playerWon = winnerState.isPlayerWon();
        boolean tableWon = winnerState.isTableWon();
        if (playerWon && tableWon){
            playerPot.addAmount(tablePot.getWager());
        }
        else if (playerWon){
            playerPot.addAmount(tablePot.getAmount());
        }
        tablePot.wipe();
    }
}
