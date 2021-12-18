package blackJack.game;

import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;

public class SharedHandState {
    private PlayerPot playerPot;
    private TablePot tablePot;



    private boolean playingHand;


    public SharedHandState(PlayerPot playerPot, TablePot tablePot) {
        this.playerPot = playerPot;
        this.tablePot = tablePot;



        this.playingHand = true;

    }
    public TablePot getTablePot() {
        return tablePot;
    }

    public void setPlayingHand(boolean playingHand) {
        this.playingHand = playingHand;
    }

    public PlayerPot getPlayerPot() {
        return playerPot;
    }

}
