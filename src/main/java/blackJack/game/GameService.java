package blackJack.game;

import blackJack.game.user.UserInputResponse;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.DetermineHandWinner;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.PotLogic;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;

public class GameService {
    private Deck deck;
    private PotLogic potLogic;
    private SharedGameState sharedGameState;

    public GameService(int deckNumber, int playerPotAmount) {
        this.deck = new Deck(deckNumber);

        PlayerPot playerPot = new PlayerPot(playerPotAmount);
        TablePot tablePot = new TablePot();
        this.potLogic = new PotLogic(playerPot, tablePot);

        this.sharedGameState = new SharedGameState(playerPot, tablePot);

    }
    public void initializeHands() {
        Hand playerHand = sharedGameState.getSharedHandState().getPlayerHand();
        Hand tableHand = sharedGameState.getSharedHandState().getTableHand();

        playerHand.addCard(deck.draw());
        tableHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        tableHand.addCard(deck.draw());

        sharedGameState.getSharedHandState().getUserCan().setCanHit(true);
    }

    public void respondToUserInput() {
        SharedHandState sharedHandState = sharedGameState.getSharedHandState();
        UserInputResponse userInputResponse = new UserInputResponse();
        DetermineHandWinner determineHandWinner = new DetermineHandWinner(sharedHandState);

        DblDown dblDown = new DblDown(sharedHandState, deck);
        if (dblDown.checkForDblDownState()){
            dblDown.playHand();
        }
        if(sharedHandState.getUserInput().isWantsToSplit()){
            userInputResponse.splitDeck();
        }
        if (sharedHandState.getUserInput().isWantsToHit() && sharedHandState.getUserCan().isCanHit()){
            userInputResponse.hit(deck, sharedHandState.getPlayerHand());
            userInputResponse.checkPlayerBust(sharedHandState);
        }
        //player is done.
        else{
            Hand tableHand = sharedHandState.getTableHand();
            tableHand.tableDraw(deck);
            Hand playerHand = sharedHandState.getPlayerHand();
            determineHandWinner.determineHandWinner(playerHand, tableHand);
            potLogic.divvyThePot(sharedHandState.getWinnerState());
            sharedHandState.setPlayingHand(false);
        }
    }
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }


    public SharedGameState getSharedGameState() {
        return sharedGameState;
    }

    public void setSharedGameState(SharedGameState sharedGameState) {
        this.sharedGameState = sharedGameState;
    }

    public PotLogic getPotLogic() {
        return potLogic;
    }
}
