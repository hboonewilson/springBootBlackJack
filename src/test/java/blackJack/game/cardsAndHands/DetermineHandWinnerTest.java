package blackJack.game.cardsAndHands;

import blackJack.game.SharedHandState;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;
import blackJack.game.user.WinnerState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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

        WinnerState winnerState = new WinnerState();
        DetermineHandWinner determineHandWinner = new DetermineHandWinner(winnerState);
        when(playerHand.getHandValue()).thenReturn(4);
        when(tableHand.getHandValue()).thenReturn(21);

        determineHandWinner.determineHandWinner(playerHand, tableHand);

        Assertions.assertTrue(winnerState.isTableWon());
        Assertions.assertFalse(winnerState.isPlayerWon());
    }
}