package blackJack.game.cardsAndHands;

import blackJack.game.SharedHandState;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DetermineHandWinnerTest {
    @Mock
    PlayerPot playerPot;
    @Mock
    TablePot tablePot;
    @Mock
    Hand playerHand = Mockito.mock(Hand.class);
    @Mock
    Hand tableHand = Mockito.mock(Hand.class);

    @Test
    void givendetermineHandWinner_whenPlayerLostShouldSetCorrectValuesInWinnerState() {
        //setUp
        SharedHandState sharedHandState = new SharedHandState(playerPot, tablePot);
        DetermineHandWinner determineHandWinner = new DetermineHandWinner(sharedHandState);
        when(playerHand.getHandValue()).thenReturn(4);
        when(tableHand.getHandValue()).thenReturn(21);

        determineHandWinner.determineHandWinner(playerHand, tableHand);

        Assertions.assertTrue(sharedHandState.getWinnerState().isTableWon());
        Assertions.assertFalse(sharedHandState.getWinnerState().isPlayerWon());
    }
}