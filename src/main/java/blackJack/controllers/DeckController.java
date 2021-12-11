package blackJack.controllers;

import blackJack.game.cardsAndHands.Deck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/deck")
public class DeckController {

    @GetMapping
    public int getDecks(@RequestParam Integer num){
        if (num == null){
            Deck deck = new Deck();
            return deck.getSize();
        }
        else{
            return new Deck(num).getSize();
        }
    }
//    @GetMapping
//    public Integer getDeckSizeGivenArgument(@RequestParam Integer num){
//        Deck deck = new Deck(num);
//        return deck.getSize();
//    }
}
