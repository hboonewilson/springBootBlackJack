package blackJack;
import blackJack.game.cards.Deck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BlackJackApplication {
	Deck deck;

	public static void main(String[] args) {
		SpringApplication.run(BlackJackApplication.class, args);
	}
	@GetMapping(path="api/v1/startGame")
	public String getStartGame(@RequestParam int num){
		deck = new Deck(num);
		return String.format("Initialized deck with %d cards.", deck.getSize());
	}
	@GetMapping(path="api/v1/draw")
	public String draw(){
		return deck.draw().toString();
	}

}
