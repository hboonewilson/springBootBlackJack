package blackJack.game;

import blackJack.game.user.UserInputResponse;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.DetermineHandWinner;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.DivvyThePot;
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
        this.deck.shuffle();

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

        sharedHandState.getUserCan().setCanHit(true);
    }

    public void respondToUserInput() {
        SharedHandState sharedHandState = getSharedHandState();
        UserInputResponse userInputResponse = new UserInputResponse();
        DetermineHandWinner determineHandWinner = new DetermineHandWinner(sharedHandState);

        if (sharedHandState.getUserInput().isWantsToDoubleDown()){
            wager(tablePot.getWager());
            DblDown dblDown = new DblDown(sharedHandState, deck);
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
            DivvyThePot divvyThePot = new DivvyThePot(playerPot, tablePot);
            divvyThePot.divvyThePot(sharedHandState.getWinnerState());
            sharedHandState.setPlayingHand(false);
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
