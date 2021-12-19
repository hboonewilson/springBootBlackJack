package blackJack.game.cardsAndHands;

import blackJack.game.user.WinnerState;

public class DetermineHandWinner {
    private final EvaluateHand evalHand = new EvaluateHand();
    private WinnerState winnerState;



    public DetermineHandWinner(WinnerState winnerState) {
        this.winnerState = winnerState;
    }

    public DetermineHandWinner() {

    }

    public void determineHandWinner(Hand playerHand, Hand tableHand){
        //if table busted: player wins
        if (evalHand.checkBust(tableHand)){
            playerWins();
        }
        //if player busted: table wins
        else if (evalHand.checkBust(playerHand)){
            tableWins();
        }
        //if no one busted
        else {
            //if playerCloser: player wins
            if (evalHand.checkCloser(playerHand, tableHand)){
                playerWins();
            }
            //if player!Closer and tie: push
            else if (evalHand.checkTie(playerHand, tableHand)){
                tie();
            }
            //else: table is closer: table wins
            else {
                tableWins();
            }
        }
    }

    private void tie() {
        winnerState.setPlayerWon(true);
        winnerState.setTableWon(true);
    }

    private void tableWins() {
        winnerState.setPlayerWon(false);
        winnerState.setTableWon(true);
    }

    private void playerWins() {
        winnerState.setPlayerWon(true);
        winnerState.setTableWon(false);
    }

}
