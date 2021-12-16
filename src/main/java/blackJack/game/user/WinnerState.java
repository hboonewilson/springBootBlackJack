package blackJack.game.user;

public class WinnerState {
    private boolean playerWon;
    private boolean tableWon;

    public WinnerState() {
        this.playerWon = false;
        this.tableWon = false;
    }

    public boolean isPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }

    public boolean isTableWon() {
        return tableWon;
    }

    public void setTableWon(boolean tableWon) {
        this.tableWon = tableWon;
    }
}
