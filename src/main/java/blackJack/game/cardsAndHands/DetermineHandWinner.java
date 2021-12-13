package blackJack.game.cardsAndHands;

import blackJack.game.SharedHandState;

public class DetermineHandWinner {
    private final EvaluateHand evalHand = new EvaluateHand();
    private SharedHandState sharedHandState;
    private Hand playerHand;
    private Hand tableHand;

    public DetermineHandWinner(SharedHandState sharedHandState, Hand playerHand, Hand tableHand) {
        this.sharedHandState = sharedHandState;
        this.playerHand = playerHand;
        this.tableHand = tableHand;
    }

    public DetermineHandWinner(SharedHandState sharedHandState) {
        this.sharedHandState = sharedHandState;
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
        sharedHandState.getWinnerState().setPlayerWon(true);
        sharedHandState.getWinnerState().setTableWon(true);
    }

    private void tableWins() {
        sharedHandState.getWinnerState().setPlayerWon(false);
        sharedHandState.getWinnerState().setTableWon(true);
    }

    private void playerWins() {
        sharedHandState.getWinnerState().setPlayerWon(true);
        sharedHandState.getWinnerState().setTableWon(false);
    }

    public void checkPlayerBustOnHit() {
    }
}
