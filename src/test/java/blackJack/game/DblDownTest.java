package blackJack.game;

import blackJack.game.cardsAndHands.*;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;
import blackJack.requestObjects.UserInput;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class DblDownTest {
    @Mock
    Deck deck = Mockito.mock(Deck.class);
    @Mock
    UserInput userInput = Mockito.mock(UserInput.class);
    @Mock
    Hand playerHand = Mockito.mock(Hand.class);
    PlayerPot playerPot;
    TablePot tablePot;
    @Test
    void givenPlayHand_shouldDrawOneCardForPlayerAndAsManyCardsAsNeededForTableToBeOverSeventeen() {


    }

    @Test
    void checkForDblDownState() {
    }
}