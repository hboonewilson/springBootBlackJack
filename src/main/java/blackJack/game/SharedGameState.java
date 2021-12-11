package blackJack.game;

import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;

public class SharedGameState {
    private boolean gamePlaying;
    private PlayerPot playerPot;
    private SharedHandState sharedHandState;

    public SharedGameState(PlayerPot playerPot) {
        this.playerPot = playerPot;
        this.gamePlaying = true;
        this.sharedHandState = new SharedHandState(playerPot, new TablePot());

    }

    public boolean isGamePlaying() {
        return gamePlaying;
    }

    public void setGamePlaying(boolean gamePlaying) {
        this.gamePlaying = gamePlaying;
    }

    public PlayerPot getPlayerPot() {
        return playerPot;
    }

    public void setPlayerPot(PlayerPot playerPot) {
        this.playerPot = playerPot;
    }

    public SharedHandState getSharedHandState() {
        return sharedHandState;
    }
}
