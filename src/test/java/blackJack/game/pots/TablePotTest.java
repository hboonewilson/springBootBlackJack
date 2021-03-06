package blackJack.game.pots;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TablePotTest {
    @Test
    void givenPotIsSetWithWager_shouldInitializeWagerAmountAndPotAmountCorrectly(){
        int wager = 20;
        TablePot tablePot = new TablePot(wager);
        Assertions.assertEquals(wager, tablePot.getWager());
        Assertions.assertEquals(wager*2, tablePot.getAmount());
    }
    @Test
    void givenAddToPot_shouldDoubleWhatAmountIsInsidePotAndSetWager(){
        int wager = 20;
        TablePot tablePot = new TablePot();
        tablePot.addToPot(wager);
        Assertions.assertEquals(wager, tablePot.getWager());
        Assertions.assertEquals(wager*2, tablePot.getAmount());

    }
    @Test
    void givenSetWager_whenWagerIsTwenty_shouldSetWagerToTwentyAndPotAmountToFourty(){
        int wager = 20;
        TablePot tablePot = new TablePot();
        tablePot.setWager(wager);
        Assertions.assertEquals(wager, tablePot.getWager());
        Assertions.assertEquals(wager*2, tablePot.getAmount());
    }

}