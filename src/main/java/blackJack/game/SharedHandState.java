package blackJack.game;

import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;

public class SharedHandState {
    private PlayerPot playerPot;
    private TablePot tablePot;

    private boolean canDoubleDown;
    private boolean canSplit;
    private boolean canHit;

    private boolean wantsDoubleDown;
    private boolean wantsSplit;
    private boolean wantsHit;

    private int wager;

    public SharedHandState(PlayerPot playerPot) {
        this.playerPot = playerPot;
        this.tablePot = new TablePot(0);
        this.canDoubleDown = false;
        this.canSplit = false;
        this.canHit = false;

        this.wantsDoubleDown = false;
        this.wantsSplit = false;
        this.wantsHit = false;
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

    public boolean isCanDoubleDown() {
        return canDoubleDown;
    }

    public void setCanDoubleDown(boolean canDoubleDown) {
        this.canDoubleDown = canDoubleDown;
    }

    public boolean isCanSplit() {
        return canSplit;
    }

    public void setCanSplit(boolean canSplit) {
        this.canSplit = canSplit;
    }

    public boolean isCanHit() {
        return canHit;
    }

    public void setCanHit(boolean canHit) {
        this.canHit = canHit;
    }

    public boolean isWantsDoubleDown() {
        return wantsDoubleDown;
    }

    public void setWantsDoubleDown(boolean wantsDoubleDown) {
        this.wantsDoubleDown = wantsDoubleDown;
    }

    public boolean isWantsSplit() {
        return wantsSplit;
    }

    public void setWantsSplit(boolean wantsSplit) {
        this.wantsSplit = wantsSplit;
    }

    public boolean isWantsHit() {
        return wantsHit;
    }

    public void setWantsHit(boolean wantsHit) {
        this.wantsHit = wantsHit;
    }

    public int getWager() {
        return wager;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }
}
