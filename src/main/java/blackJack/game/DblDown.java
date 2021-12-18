package blackJack.game;

import blackJack.game.cardsAndHands.Card;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;

import java.util.List;

public class DblDown {
    private Deck deck;
    Hand playerHand;
    Hand tableHand;

    public DblDown(Hand playerHand, Hand tableHand, Deck deck) {
        this.deck = deck;
        this.playerHand = playerHand;
        this.tableHand = tableHand;
    }

    public void playHand() {

        playerHand.addCard(deck.draw());

        tableHand.tableDraw(deck);
    }
}
