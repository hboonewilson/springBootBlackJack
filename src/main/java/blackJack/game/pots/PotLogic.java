package blackJack.game.pots;

import blackJack.game.user.WinnerState;

public class PotLogic {
    private PlayerPot playerPot;
    private TablePot tablePot;

    public PotLogic(PlayerPot playerPot, TablePot tablePot) {
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

    public PlayerPot getPlayerPot() {
        return playerPot;
    }

    public void setPlayerPot(PlayerPot playerPot) {
        this.playerPot = playerPot;
    }

    public TablePot getTablePot() {
        return tablePot;
    }

    public void setTablePot(TablePot tablePot) {
        this.tablePot = tablePot;
    }
}
