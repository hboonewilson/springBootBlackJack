package blackJack.game.cardsAndHands;

public class Card {
    private Face face;
    private Suit suit;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %ss", face, suit);
    }
}
