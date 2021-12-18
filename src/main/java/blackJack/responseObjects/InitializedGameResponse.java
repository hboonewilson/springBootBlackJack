package blackJack.responseObjects;

public class InitializedGameResponse {
    private final int NUMBER_OF_CARDS;
    private final int PLAYER_POT_VALUE;
    private final boolean GAME_PLAYING;

    public InitializedGameResponse(int numberOfCards, int playerPotValue, boolean gamePlaying) {
        this.NUMBER_OF_CARDS = numberOfCards;
        this.PLAYER_POT_VALUE = playerPotValue;
        this.GAME_PLAYING = gamePlaying;
    }

    public int getCardsInDeck() {
        return NUMBER_OF_CARDS;
    }

    public int getPlayerPotValue() {
        return PLAYER_POT_VALUE;
    }

    public boolean isGamePlaying() {
        return GAME_PLAYING;
    }
}
