package blackJack.game.pots;


import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.Pot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PotTest {
    @Test
    void givenPotObject_shouldSetCorrectlyAndRemoveCorrectly(){
        Pot pot = new PlayerPot(200);
        Assertions.assertEquals(200, pot.getAmount());
        pot.removeAmount(20);
        Assertions.assertEquals(180, pot.getAmount());
    }

}