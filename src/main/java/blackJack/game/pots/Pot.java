package blackJack.game.pots;

public abstract class  Pot {
    private Integer amount;

    public Pot(Integer amount) {
        this.amount = amount;
    }
    public void removeAmount(Integer amountToRemove){
        amount -= amountToRemove;
    }
    public void addAmount(Integer amountToAdd){
        amount += amountToAdd;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
