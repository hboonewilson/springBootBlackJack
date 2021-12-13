package blackJack.game.cardsAndHands;

public class EvaluateHand {

    public boolean checkOverSeventeen(Hand hand){
        return hand.getHandValue() > 17;
    }
    public boolean checkBust(Hand hand){
        return hand.getHandValue() > 21;
    }
    public boolean checkTie(Hand handOne, Hand handTwo){
        return handOne.getHandValue().equals(handTwo.getHandValue());
    }
    public boolean checkCloser(Hand closer, Hand further){
        //will check check bust before... so if neither have busted highest wins.
        return closer.getHandValue() > further.getHandValue();
    }
}
