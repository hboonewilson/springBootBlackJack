package blackJack.game.pots;

public class PlayerPot extends Pot {

    public PlayerPot(Integer amount) {
        super(amount);
    }
    public PlayerPot(){
        super(200);
    }
    public boolean wager(Integer wagerAmount){
        if((super.getAmount() - wagerAmount) < 0){
            return false;
        }
        else {
            removeAmount(wagerAmount);
            return true;
        }
    }
}
