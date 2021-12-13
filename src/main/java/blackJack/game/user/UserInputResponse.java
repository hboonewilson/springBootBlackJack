package blackJack.game.user;

import blackJack.game.SharedHandState;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.Hand;

public class UserInputResponse {
    public UserInputResponse(){}

    public void hit(Deck deck, Hand playerHand) {
        playerHand.addCard(deck.draw());
    }

    public void splitDeck() {
        //do someting!
    }

    public void checkPlayerBust(Deck deck, SharedHandState sharedHandState) {
    }

    public void checkPlayerBust(SharedHandState sharedHandState) {
        Hand playerHand = sharedHandState.getPlayerHand();
        if (playerHand.getHandValue() > 21){
            sharedHandState.getWinnerState().setPlayerWon(true);
            sharedHandState.getWinnerState().setTableWon(true);
            sharedHandState.getUserCan().setCanHit(false);
        }
    }
}
