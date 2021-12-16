package blackJack.game.cardsAndHands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards;
    int numOfDecks;

    public Deck(){
        cards = new ArrayList<>();
        for(Face face: Face.values()) {

            for(Suit suit: Suit.values()){
                cards.add(new Card(face,suit));
            }
        }
        this.numOfDecks = 1;
        shuffle();
    }
    public Deck(int num){
        cards = new ArrayList<>();
        for(int i=0; i<num;i++){
            for(Face face: Face.values()) {

                for(Suit suit: Suit.values()){
                    cards.add(new Card(face,suit));
                }
            }
        }
        this.numOfDecks = num;
        shuffle();
    }

    public List<Card> getDeck(){
        return cards;
    }
    public Card draw(){
        return cards.remove(0);
    }
    public int getSize(){
        return cards.size();
    }
    public int getNumOfDecks() {
        return numOfDecks;
    }
    private void shuffle(){
        Collections.shuffle(cards);
    }

}
