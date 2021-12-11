package blackJack.game.pots;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerPotTest {
    @Test
    void givenWagerLowerThanPotAmount_shouldReturnTrueAndRemoveFromPlayerPot(){
        int wager = 5;
        int potSize = 10;

        PlayerPot playerPot = new PlayerPot(potSize);

        boolean enoughInPot = playerPot.wager(wager);

        Assertions.assertTrue(enoughInPot);
        Assertions.assertEquals(potSize-wager, playerPot.getAmount());
    }

}