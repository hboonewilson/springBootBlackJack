package blackJack.game;

import blackJack.game.user.UserCan;
import blackJack.requestObjects.UserInput;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.PotLogic;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;
import blackJack.game.user.WinnerState;
import blackJack.responseObjects.WagerAndInitHandResponse;

public class GameService {
    private boolean gamePlaying;
    private Deck deck;
    private PlayerPot playerPot;
    private TablePot tablePot;
    private SharedHandState sharedHandState;
    private Hand playerHand;
    private Hand tableHand;

    private int deckNum;
    private UserInput userInput;
    private UserCan userCan;
    private WinnerState winnerState;

    public GameService(int deckNumber, int playerPotAmount) {
        this.deck = new Deck(deckNumber);
        this.deckNum = deckNumber;
        this.playerPot = new PlayerPot(playerPotAmount);
        this.tablePot = new TablePot();

        this.sharedHandState = new SharedHandState(playerPot, tablePot);
        this.playerHand = new Hand();
        this.tableHand = new Hand();

        this.userInput = new UserInput();
        this.userCan = new UserCan();
        this.winnerState = new WinnerState();

    }
    public void initializeHands() {

        playerHand.addCard(deck.draw());
        tableHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        tableHand.addCard(deck.draw());

        userCan.setCanHit(true);
    }

    public void respondToUserInput(UserInput userInput) {
        /*TODO
        Start from scratch in this method! Can be cleaned up much better.
        *  */
        this.userInput = userInput;


    }
    public WagerAndInitHandResponse wager(int amount){
        if(playerPot.wager(amount, tablePot)){
           return new WagerAndInitHandResponse(tablePot.getWager(),playerHand,tableHand,playerPot.getAmount(),true, userCan);
        }
        else {
            return new WagerAndInitHandResponse(tablePot.getWager(),playerHand,tableHand,playerPot.getAmount(),
                    "Not enough money to wager this amount", false);
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }

    public PlayerPot getPlayerPot() {
        return playerPot;
    }

    public TablePot getTablePot() {
        return tablePot;
    }

    public boolean isGamePlaying() {
        return gamePlaying;
    }
}
