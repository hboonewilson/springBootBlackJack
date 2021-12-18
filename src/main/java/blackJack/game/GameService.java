package blackJack.game;

import blackJack.game.user.UserCan;
import blackJack.game.user.UserInput;
import blackJack.game.user.UserInputResponse;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.DetermineHandWinner;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.PotLogic;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;
import blackJack.game.user.WinnerState;

public class GameService {
    private boolean gamePlaying;
    private Deck deck;
    private PotLogic potLogic;
    private PlayerPot playerPot;
    private TablePot tablePot;
    private SharedHandState sharedHandState;
    private Hand playerHand;
    private Hand tableHand;


    private UserInput userInput;
    private UserCan userCan;
    private WinnerState winnerState;

    public GameService(int deckNumber, int playerPotAmount) {
        this.deck = new Deck(deckNumber);

        this.playerPot = new PlayerPot(playerPotAmount);
        this.tablePot = new TablePot();
        this.potLogic = new PotLogic(playerPot, tablePot);

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

    public void respondToUserInput() {
        /*TODO
        Start from scratch in this method! Can be cleaned up much better.
        *  */

    }
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }


    public PotLogic getPotLogic() {
        return potLogic;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }
}
