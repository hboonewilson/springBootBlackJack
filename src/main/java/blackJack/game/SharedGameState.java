package blackJack.game;

import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;

public class SharedGameState {

    private boolean gamePlaying;
    private PlayerPot playerPot;
    private SharedHandState sharedHandState;

    public SharedGameState(PlayerPot playerPot, TablePot tablePot) {
        this.playerPot = playerPot;
        this.gamePlaying = true;
        this.sharedHandState = new SharedHandState(playerPot, tablePot);

    }

    public PlayerPot getPlayerPot() {
        return playerPot;
    }

    public SharedHandState getSharedHandState() {
        return sharedHandState;
    }
    public boolean isGamePlaying() {
        return gamePlaying;
    }

    public void setGamePlaying(boolean gamePlaying) {
        this.gamePlaying = gamePlaying;
    }

}
