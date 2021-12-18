package blackJack.game.pots;


public class TablePot extends Pot {
    private Integer wager = 0;

    public TablePot() {
        super(0);
    }
    public TablePot(Integer wagerAmount){
        super(wagerAmount*2);
        this.wager = wagerAmount;
    }
    public void addToPot(int wagerAmount){
        super.setAmount(wagerAmount * 2);
        this.wager = wagerAmount;
    }
    public void wipe(){
        super.setAmount(0);
    }

    public Integer getWager() {
        return wager;
    }

    public void setWager(Integer wager) {
        super.setAmount(wager * 2);
        this.wager = wager;
    }
}
