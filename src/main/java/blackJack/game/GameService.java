package blackJack.game;

import blackJack.UserInput;
import blackJack.UserInputResponse;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;

public class GameService {
    private Deck deck;
    private PlayerPot playerPot;
    private TablePot tablePot;
    private SharedGameState sharedGameState;
    private SharedHandState sharedHandState;

    public GameService(int deckNumber, int playerPotAmount) {
        this.deck = new Deck(deckNumber);
        this.playerPot = new PlayerPot(playerPotAmount);
        this.sharedGameState = new SharedGameState(playerPot);
        this.sharedHandState = sharedGameState.getSharedHandState();
        this.tablePot = sharedGameState.getSharedHandState().getTablePot();
    }
    public boolean wager(int wagerAmount){
        boolean enoughMoney =  sharedGameState.getPlayerPot().wager(wagerAmount);
        if (enoughMoney){
            tablePot.addToPot(wagerAmount);
        }
        return enoughMoney;
    }
    public void initializeHands() {
        Hand playerHand = sharedGameState.getSharedHandState().getPlayerHand();
        Hand tableHand = sharedGameState.getSharedHandState().getTableHand();

        playerHand.addCard(deck.draw());
        tableHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        tableHand.addCard(deck.draw());

        sharedHandState.setCanHit(true);
    }
    public void changeUserInputFields(UserInput userInput){
        SharedHandState sharedHandState = getSharedHandState();
        sharedHandState.setWantsDoubleDown(userInput.isWantsToDoubleDown());
        sharedHandState.setWantsHit(userInput.isWantsToHit());
        sharedHandState.setWantsSplit(userInput.isWantsToSplit());
    }
    public void respondToUserInput() {
        SharedHandState sharedHandState = getSharedHandState();
        UserInputResponse userInputResponse = new UserInputResponse();
        if (sharedHandState.isWantsDoubleDown()){
            wager(tablePot.getWager());
        }
        if (sharedHandState.isWantsHit()){
            userInputResponse.hit(deck, sharedHandState.getPlayerHand());
        }
        if(sharedHandState.isWantsSplit()){
            userInputResponse.splitDeck();
        }
    }
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public PlayerPot getPlayerPot() {
        return playerPot;
    }

    public void setPlayerPot(PlayerPot playerPot) {
        this.playerPot = playerPot;
    }

    public SharedGameState getSharedGameState() {
        return sharedGameState;
    }

    public void setSharedGameState(SharedGameState sharedGameState) {
        this.sharedGameState = sharedGameState;
    }

    public SharedHandState getSharedHandState() {
        return sharedHandState;
    }

    public void setSharedHandState(SharedHandState sharedHandState) {
        this.sharedHandState = sharedHandState;
    }

}
