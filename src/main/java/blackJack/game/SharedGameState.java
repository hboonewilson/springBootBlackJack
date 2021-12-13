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

    public PlayerPot getPlayerPot() {
        return playerPot;
    }

    public SharedHandState getSharedHandState() {
        return sharedHandState;
    }
}
