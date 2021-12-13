package blackJack.game;

import blackJack.game.cardsAndHands.Card;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.Hand;

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
}
