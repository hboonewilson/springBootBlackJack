package blackJack.game.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        for(Face face: Face.values()) {

            for(Suit suit: Suit.values()){
                cards.add(new Card(face,suit));
            }
        }
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
    }

    public List<Card> getDeck(){
        return cards;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card draw(){
        return cards.remove(0);
    }
    public int getSize(){
        return cards.size();
    }

}
