package blackJack.game;

import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.user.UserCan;
import blackJack.requestObjects.UserInput;

public class DblDown {
    private Deck deck;
    Hand playerHand;
    Hand tableHand;

    public DblDown(Hand playerHand, Hand tableHand, Deck deck) {
        this.deck = deck;
        this.playerHand = playerHand;
        this.tableHand = tableHand;
    }


    public boolean doublDown(UserInput userInput, UserCan userCan) {
        if (userInput.isWantsToDoubleDown() && !userCan.isCanDoubleDown()){
            return true;
        }
        else if(userInput.isWantsToDoubleDown() && userCan.isCanDoubleDown()){
            playHand();
            return false;
        }
        else{
            return false;
        }
    }
    private void playHand() {

        playerHand.addCard(deck.draw());

        tableHand.tableDraw(deck);
    }
}
