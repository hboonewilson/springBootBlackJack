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

    public void checkPlayerBust(SharedHandState sharedHandState) {
        //do something
        }
    }

