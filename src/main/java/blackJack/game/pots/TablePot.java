package blackJack.game.pots;


public class TablePot extends Pot {
    private Integer wager;

    public TablePot() {
        super(0);
    }
    public TablePot(Integer wagerAmount){
        super(wagerAmount*2);
        this.wager = wagerAmount;
    }
    public void wipe(){
        super.setAmount(0);
    }

    public Integer getWager() {
        return wager;
    }

    public void setWager(Integer wager) {
        this.wager = wager;
    }
}
