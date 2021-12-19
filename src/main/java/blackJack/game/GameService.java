package blackJack.game;

import blackJack.game.cardsAndHands.DetermineHandWinner;
import blackJack.game.pots.DivvyPots;
import blackJack.game.user.UserCan;
import blackJack.game.cardsAndHands.Deck;
import blackJack.game.cardsAndHands.Hand;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;
import blackJack.game.user.WinnerState;
import blackJack.requestObjects.UserInput;
import blackJack.responseObjects.UserInputResponse;
import blackJack.responseObjects.WagerAndInitHandResponse;

public class GameService {
    private boolean gamePlaying;
    private Deck deck;
    private PlayerPot playerPot;
    private TablePot tablePot;
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

        this.playerHand = new Hand();
        this.tableHand = new Hand();

        this.userInput = new blackJack.requestObjects.UserInput();
        this.userCan = new UserCan();
        this.winnerState = new WinnerState();
        this.gamePlaying = true;
    }
    public void initializeHands() {
        resetDeck();
        playerHand.addCard(deck.draw());
        tableHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        tableHand.addCard(deck.draw());

        userCan.setCanDoubleDown(true);
        userCan.setCanHit(true);
    }

    public UserInputResponse respondToUserInput(UserInput userInput) {
        /*TODO
        Start from scratch in this method! Can be cleaned up much better.
        *  */
        resetDeck();
        this.userInput = userInput;
        //checkDblDown
        DblDown dblDown = new DblDown(playerHand, tableHand, deck);
        UserInputResponse userInputResponseDblDown = new UserInputResponse();
        if(dblDown.doublDown(userInput, userCan)){
            userInputResponseDblDown.badDoubleDown();
        }
        else if (userInput.isWantsToHit()){
            playerHand.addCard(deck.draw());
            if (playerHand.getHandValue() > 21){
                userCan.setCanHit(false);
            }
        }
        else{
            tableHand.tableDraw(deck);
            DetermineHandWinner determineHandWinner = new DetermineHandWinner(winnerState);
            determineHandWinner.determineHandWinner(playerHand, tableHand);
        }
        DivvyPots divvyPots = new DivvyPots(playerPot, tablePot);
        divvyPots.divvy(winnerState);
        setUserInputRespVariables(userInputResponseDblDown);

        return userInputResponseDblDown;

    }

    private void setUserInputRespVariables(UserInputResponse userInputResponseDblDown) {
        userInputResponseDblDown.setPlayerHand(playerHand);
        userInputResponseDblDown.setPlayerPot(playerPot);
        userInputResponseDblDown.setWager(tablePot.getWager());
        userInputResponseDblDown.setTableHand(tableHand);
        userInputResponseDblDown.setTablePot(tablePot);
        userInputResponseDblDown.setWinnerState(winnerState);
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

    public void setUserInput(blackJack.requestObjects.UserInput userInput) {
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
    private void resetDeck(){
        if (deck.getSize() < 10){
            deck = new Deck(deckNum);
        }
    }
}
