package blackJack.game;

import blackJack.game.cards.Deck;
import blackJack.game.pots.PlayerPot;

public class SaredGameState {
    private boolean gamePlaying;
    private PlayerPot playerPot;
    private SharedHandState sharedHandState;

    public SaredGameState(PlayerPot playerPot) {
        this.playerPot = playerPot;
        this.gamePlaying = true;
        this.sharedHandState = new SharedHandState(playerPot);

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
