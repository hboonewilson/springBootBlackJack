package blackJack;
import blackJack.game.GameService;
import blackJack.game.pots.PlayerPot;
import blackJack.game.pots.TablePot;
import blackJack.game.user.UserInput;
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
	public GameService getStartGame(){
		gameService = new GameService(3, 200);
		return gameService;
	}

	@GetMapping(path="api/v1/playHand/wagerAndInitHands")
	public ResponseEntity<GameService> wager(@RequestParam int wagerAmount){
		PlayerPot playerPot = gameService.getPotLogic().getPlayerPot();
		TablePot tablePot = gameService.getPotLogic().getTablePot();
		boolean goodWager = playerPot.wager(wagerAmount, tablePot);
		ResponseEntity<GameService> responseEntityStatus;
		if (goodWager){
			responseEntityStatus = ResponseEntity.status(HttpStatus.OK).body(gameService);
		}
		else{
			responseEntityStatus = ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(gameService);
		}
		gameService.initializeHands();
		return responseEntityStatus;
	}

	@PostMapping(path="api/v1/playHand/input", consumes = MediaType.APPLICATION_JSON_VALUE)
	public GameService userInput(@RequestBody UserInput userInput){
		gameService.setUserInput(userInput);
		gameService.respondToUserInput();
		return gameService;
	}

}
