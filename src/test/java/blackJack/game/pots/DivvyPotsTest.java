package blackJack.game.pots;

import blackJack.game.user.WinnerState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class DivvyPotsTest {
    @Mock
    WinnerState winnerState = Mockito.mock(WinnerState.class);

    int playerAmount;
    int wagerAmount;

    PlayerPot playerPot;
    TablePot tablePot;
    DivvyPots divvyPots;


    @BeforeEach
    void setUp(){
        playerAmount = 100;
        wagerAmount = 25;

        playerPot = new PlayerPot(playerAmount);
        tablePot = new TablePot(wagerAmount);

        divvyPots = new DivvyPots(playerPot, tablePot);
    }

    @Test
    void givenDivvy_whenPush_shouldReturnWagerToPlayerPot(){
        when(winnerState.isPlayerWon()).thenReturn(true);
        when(winnerState.isTableWon()).thenReturn(true);

        divvyPots.divvy(winnerState);

        Assertions.assertEquals(wagerAmount+playerAmount,playerPot.getAmount());
        testWipe();
    }


    @Test
    void givenDivvy_whenPlayerWins_shouldAddTablePotAmountToPlayerPot(){
        when(winnerState.isPlayerWon()).thenReturn(true);
        when(winnerState.isTableWon()).thenReturn(false);

        divvyPots.divvy(winnerState);

        Assertions.assertEquals((wagerAmount*2)+playerAmount, playerPot.getAmount());
        testWipe();
    }
    @Test
    void givenDivvy_whenTableWins_shouldWipeTablePotAndNotAddToPlayerPot(){
        when(winnerState.isPlayerWon()).thenReturn(false);
        when(winnerState.isTableWon()).thenReturn(true);

        divvyPots.divvy(winnerState);

        Assertions.assertEquals(playerAmount, playerPot.getAmount());
        testWipe();
    }
    private void testWipe() {
        Assertions.assertEquals(0, tablePot.getAmount());
        Assertions.assertEquals(0, tablePot.getWager());
    }

}