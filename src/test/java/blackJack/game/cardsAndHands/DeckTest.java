package blackJack.game.cardsAndHands;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    @Disabled
    void givenGetDeck_shouldReturnShuffled() {
        Deck theDeck = new Deck();
        System.out.println(theDeck.getDeck());
    }
}