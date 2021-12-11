package blackJack.game.cardsAndHands;


import java.util.HashMap;
import java.util.List;


public class CalculateHandValue {
    private final HashMap<Face, Integer> VALUES = createMap();

    public Integer determineCardsValue(List<Card> cards){
        int sum = 0;
        for (Card card : cards){
            sum += VALUES.get(card.getFace());
        }
        if(sum > 21){
            sum = reduceByAces(sum, cards);
        }
        return sum;
    }

    private int reduceByAces(int sum, List<Card> cards) {
        int aceCount = 0;
        for (Card card : cards){
            if(card.getFace() == Face.ACE){
                aceCount += 1;
            }
        }
        while (aceCount > 0 && sum > 21){
            sum -= 10;
            aceCount--;
        }
        return sum;
    }

    private HashMap<Face, Integer> createMap(){
        HashMap<Face, Integer> mapToReturn = new HashMap<>();
        mapToReturn.put(Face.ACE, 11);
        mapToReturn.put(Face.TWO, 2);
        mapToReturn.put(Face.THREE, 3);
        mapToReturn.put(Face.FOUR, 4);
        mapToReturn.put(Face.FIVE, 5);
        mapToReturn.put(Face.SIX, 6);
        mapToReturn.put(Face.SEVEN, 7);
        mapToReturn.put(Face.EIGHT, 8);
        mapToReturn.put(Face.NINE, 9);
        mapToReturn.put(Face.TEN, 10);
        mapToReturn.put(Face.JACK, 10);
        mapToReturn.put(Face.QUEEN, 10);
        mapToReturn.put(Face.KING, 10);
        return mapToReturn;
    }
}
