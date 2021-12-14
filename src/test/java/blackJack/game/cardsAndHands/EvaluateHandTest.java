package blackJack.game.cardsAndHands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateHandTest {
    Hand handOne;
    Hand handTwo;
    EvaluateHand evaluateHand;

    @BeforeEach
    void setUp(){
        List<Card> cardOneList = new ArrayList<>();
        cardOneList.add(new Card(Face.ACE, Suit.CLUB));
        cardOneList.add(new Card(Face.KING, Suit.CLUB));
        handOne = new Hand(cardOneList);

        List<Card> cardTwoList = new ArrayList<>();
        cardTwoList.add(new Card(Face.ACE, Suit.CLUB));
        cardTwoList.add(new Card(Face.TWO, Suit.CLUB));
        handTwo = new Hand(cardTwoList);

        evaluateHand = new EvaluateHand();
    }

    @Test
    void givenCheckCloser_whenFirstArgumentIsCloser_shouldReturnTrue() {
        Assertions.assertTrue(evaluateHand.checkCloser(handOne, handTwo));
    }
    @Test
    void givenCheckCloser_whenSecondArgumentIsCloser_shouldReturnFalse(){
        Assertions.assertFalse(evaluateHand.checkCloser(handTwo, handOne));
    }
}