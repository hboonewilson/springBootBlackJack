package blackJack.game.cardsAndHands;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Hand {
    private List<Card> cards;
    private Integer handValue;
    private final CalculateHandValue calculateHandValue = new CalculateHandValue();

    public Hand(){
        cards = new ArrayList<>();
    }


    public Hand(List<Card> cards) {
        this.cards = cards;
        this.handValue = calculateHandValue.determineCardsValue(cards);
    }
    public void addCard(Card card){
        cards.add(card);
        this.handValue = calculateHandValue.determineCardsValue(cards);
    }
    public List<Card> getCards() {
        return cards;
    }

    public Integer getHandValue() {
        return handValue;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
        this.handValue =  calculateHandValue.determineCardsValue(cards);
    }
    public void tableDraw(Deck deck){
        while(this.handValue < 17){
            this.cards.add(deck.draw());
            this.handValue = calculateHandValue.determineCardsValue(cards);
        }
    }

}
