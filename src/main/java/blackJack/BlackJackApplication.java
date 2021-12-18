package blackJack;
import blackJack.game.GameService;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;
import blackJack.requestObjects.UserInput;
import blackJack.responseObjects.InitializedGameResponse;
import blackJack.responseObjects.WagerAndInitHandResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@ResponseBody
public class BlackJackApplication {
	GameService gameService;

	public static void main(String[] args) {
		SpringApplication.run(BlackJackApplication.class, args);
	}
	@GetMapping(path="api/v1/startGame")
	public InitializedGameResponse getStartGame(@RequestParam int deckNum, @RequestParam int potAmount){
		gameService = new GameService(deckNum, potAmount);
		return new InitializedGameResponse(gameService.getDeck().getSize(),
				gameService.getPlayerPot().getAmount(),
				gameService.isGamePlaying());
	}

	@GetMapping(path="api/v1/playHand/wagerAndInitHands")
	public ResponseEntity<WagerAndInitHandResponse> wager(@RequestParam int wagerAmount){

		ResponseEntity<WagerAndInitHandResponse> responseEntityStatus;
		WagerAndInitHandResponse wagerAndInitHandResponse = gameService.wager(wagerAmount);
		if (wagerAndInitHandResponse.isGoodWager()){
			gameService.initializeHands();
			return ResponseEntity.status(HttpStatus.OK).body(wagerAndInitHandResponse);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(wagerAndInitHandResponse);
		}
	}

	@PostMapping(path="api/v1/playHand/input", consumes = MediaType.APPLICATION_JSON_VALUE)
	public GameService userInput(@RequestBody UserInput userInput){
		gameService.setUserInput(userInput);
		gameService.respondToUserInput(userInput);
		return gameService;
	}

}
