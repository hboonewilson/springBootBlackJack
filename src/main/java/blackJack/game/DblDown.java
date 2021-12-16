package blackJack.game;

import blackJack.game.cardsAndHands.Card;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;

import java.util.List;

public class DblDown {
    private SharedHandState sharedHandState;
    private Deck deck;
    public DblDown(SharedHandState sharedHandState, Deck deck) {
        this.sharedHandState = sharedHandState;
        this.deck = deck;
    }

    public void playHand() {
        Hand playerHand = sharedHandState.getPlayerHand();
        Hand tableHand = sharedHandState.getTableHand();

        playerHand.addCard(deck.draw());

        tableHand.tableDraw(deck);
    }

    public boolean checkForDblDownState() {
        PlayerPot playerPot = sharedHandState.getPlayerPot();
        TablePot tablePot = sharedHandState.getTablePot();
        int wager = tablePot.getWager();

        return sharedHandState.getUserInput().isWantsToDoubleDown() && playerCanDouble() && playerPot.wager(wager, tablePot);
    }

    private boolean playerCanDouble() {
        return sharedHandState.getPlayerHand().getCards().size() == 2;
    }
}
