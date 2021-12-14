package blackJack;
import blackJack.game.GameService;
import blackJack.game.SharedGameState;
import blackJack.game.user.UserInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@ResponseBody
public class BlackJackApplication {
	GameService gameService;

	public static void main(String[] args) {
		SpringApplication.run(BlackJackApplication.class, args);
	}
	@GetMapping(path="api/v1/startGame")
	public SharedGameState getStartGame(){
		gameService = new GameService(3, 200);
		return gameService.getSharedGameState();
	}

	@GetMapping(path="api/v1/draw")
	public String draw(){
		return gameService.getDeck().draw().toString();
	}
	@GetMapping(path="api/v1/playHand/wager")
	public ResponseEntity<SharedGameState> wager(@RequestParam int wagerAmount){
		boolean goodWager = gameService.wager(wagerAmount);
		if (goodWager){
			return ResponseEntity.status(HttpStatus.OK).body(gameService.getSharedGameState());
		}
		else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gameService.getSharedGameState());
		}
	}
	@GetMapping(path="api/v1/playHand/initHands")
	public SharedGameState initHands(){
		gameService.initializeHands();
		return gameService.getSharedGameState();

	}
	@PostMapping(path="api/v1/playHand/input", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SharedGameState userInput(@RequestBody UserInput userInput){
		gameService.getSharedHandState().setUserInput(userInput);
		gameService.respondToUserInput();
		return gameService.getSharedGameState();
	}

}
