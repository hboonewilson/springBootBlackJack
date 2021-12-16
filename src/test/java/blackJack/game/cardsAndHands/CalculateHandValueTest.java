package blackJack.game.cardsAndHands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateHandValueTest {

    Card ace;
    Card king;
    Card two;
    List<Card> cardList;
    CalculateHandValue calculateHandValue;

    @BeforeEach
    void setUp(){
        ace = new Card(Face.ACE, Suit.CLUB);
        king = new Card(Face.KING, Suit.CLUB);
        two = new Card(Face.TWO, Suit.CLUB);
        cardList = new ArrayList<>();
        calculateHandValue = new CalculateHandValue();
    }

    @Test
    void givenDetermineCardsValue_whenAnAceAndFaceCard_shouldReturn21() {
        cardList.add(ace);
        cardList.add(king);

        Assertions.assertEquals(21, calculateHandValue.determineCardsValue(cardList));
    }
    @Test
    void givenDetermineCardsValue_whenAnAceAndATwo_shouldReturn13() {
        cardList.add(ace);
        cardList.add(two);

        Assertions.assertEquals(13, calculateHandValue.determineCardsValue(cardList));
    }
}