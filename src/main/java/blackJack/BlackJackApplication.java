package blackJack;
import blackJack.game.SaredGameState;
import blackJack.game.cards.Deck;
import blackJack.game.pots.PlayerPot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BlackJackApplication {
	Deck deck;
	PlayerPot playerPot;
	SaredGameState saredGameState;

	public static void main(String[] args) {
		SpringApplication.run(BlackJackApplication.class, args);
	}
	@GetMapping(path="api/v1/startGame")
	public SaredGameState getStartGame(@RequestParam int deckNum, @RequestParam int potAmount){
		deck = new Deck(deckNum);
		playerPot = new PlayerPot(potAmount);
		saredGameState = new SaredGameState(playerPot);
		return saredGameState;
	}

	@GetMapping(path="api/v1/draw")
	public String draw(){
		return deck.draw().toString();
	}
	@GetMapping(path="api/v1/wager")
	public String draw(@RequestParam int wagerAmount){
		boolean canWager = playerPot.wager(wagerAmount);
		if(canWager){
			return String.format("Yes, you can wager $%d%nYou have $%d left.",
					wagerAmount,
					playerPot.getAmount());
		}
		else {
			return String.format("No, you can't wager $%d%nYou only have $%d left.",
					wagerAmount,
					playerPot.getAmount());
		}
	}

}
