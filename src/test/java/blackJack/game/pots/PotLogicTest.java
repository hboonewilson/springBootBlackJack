package blackJack.game.pots;

import blackJack.game.user.WinnerState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;


class PotLogicTest {
    @Mock
    WinnerState winnerState = Mockito.mock(WinnerState.class);
    PlayerPot playerPot;
    TablePot tablePot;
    PotLogic potLogic;
    int potAmount = 100;
    int wager = 20;

    @BeforeEach
    void setUp(){
        playerPot = new PlayerPot(potAmount);
        tablePot = new TablePot(wager);
        potLogic = new PotLogic(playerPot, tablePot);
    }
    @Test
    void givenDivvyThePot_whenTie_shouldReturnWagerToPlayerAndWipeTablePot(){

        when(winnerState.isTableWon()).thenReturn(true);
        when(winnerState.isPlayerWon()).thenReturn(true);

        potLogic.divvyThePot(winnerState);

        Assertions.assertEquals(potAmount+wager, playerPot.getAmount());
        Assertions.assertEquals(0, tablePot.getAmount());

    }
    @Test
    void givenDivvyThePot_whenPlayerWins_shouldAddTablePotAmountToPlayerPotAndWipeTablePot(){
        when(winnerState.isPlayerWon()).thenReturn(true);
        when(winnerState.isTableWon()).thenReturn(false);

        potLogic.divvyThePot(winnerState);
        //the amount in player pot with wager amount * 2 (table wagers same amount as player)
        Assertions.assertEquals(potAmount+(wager*2), playerPot.getAmount());
    }
    @Test
    void givenDivvyThePot_whenTableWins_shouldWipeTablePotOnly(){
        when(winnerState.isPlayerWon()).thenReturn(false);
        when(winnerState.isTableWon()).thenReturn(true);

        potLogic.divvyThePot(winnerState);

        Assertions.assertEquals(potAmount, playerPot.getAmount());
        Assertions.assertEquals(0, tablePot.getAmount());
    }

}