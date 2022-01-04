# Black Jack With Spring Boot Application
<p>
In another project, I was able to create a working blackJackGame that used users' input to command line to run a game of 
BlackJack. I've now created a Mavanized Java Spring App that was deployed to AWS fargate to create an endpoint to be hit by an eventual JavaScript frontend
</p>
<h3>//SOFAR</h3>
<ul>
    <li>Created a spring boot app with GET/POST endpoints reachable on localhost through postman</li>
    <li>Added BlackJack Logic first iteration, returning correct output (initially with redundant and
    weird objects</li>
    <li>Refactored code to return correct output without weird objects</li>
    <li> Don't need a playerPot! Just double player money if he wins and if he doesn't take it from him</li>
    <li>Specific Objects to return to user for specific requests (StartGame/wagerInitHands/UserInput)</li>
    <li>Re-implement userInput method in gameService</li>
    <li>Deploy jar file to AWS fargate and hit endpoint (not running currently)</li>
    <li>Create a docker image of this project: first make a sample 
        docker image for spring in a tutorial and deploy to AWS then try with this.
        </li>
</ul>
<h3>//TODO</h3>
<ul>
    <li>Create frontend to harness functionality</li>
    <li>Add additional functionality (expand on doubling down and splitting deck)</li>
    
</ul>
<h3>GET/POST EndPoints</h3>

<b>api/v1/startGame:</b>
<br>
Requires: Number of Decks to play with (Int deckNum) & Amount of money in the pot, players starting money amount (Int potAmount)
<br>
Returns: Number of cards (int NUMBER_OF_CARDS) Player Pot amount (int PLAYER_POT_VALUE) T/F if the game is playing, True 
(boolean GAME_PLAYING)

<b>api/v1/playHand/wagerAndInitHands:</b>
<br>
Requires: Wager amount (Int wagerAmount)
<br>
Returns:
<ul>
    <li>private int wagerAmount amount set by request</li>
    <li>private Hand playerHand object holding player cards and hand points</li>
    <li>private Hand tableHand objects holding the tables cards and hand points</li>
    <li>private int playerPotLeft player's pot - wagered amount</li>
    <li>private String errorMsg message to send when request is wrong </li>
    <li>private boolean goodWager was the wager passed in valid? t/f</li>
    <li>private UserCan userCan object containing what the user can do (may
    help the user sending requests to decide what to do next</li>
</ul>
<b>api/v1/playHand/input:</b>
<br>
Requires:
User input object 
Boolean inputs to tell application what the player wants to do
<ul>
    <li>private boolean wantsToHit;</li>
    <li>private boolean wantsToDoubleDown;</li>
    <li>private boolean wantsToSplit;</li>
</ul>
<br>
Returns:
<ul>
    <li></li>
    <li>String msg message to return to sender</li>
    <li>Hand playerHand player hand and points from hand</li>
    <li>Hand tableHand table hand and points from hand</li>
    <li>int wager amount you bet</li>
    <li> TablePot tablePot wager amount * 2 (amount bet + amount to win)</li>
    <li>PlayerPot playerPot amount left for player</li>
    <li>WinnerState winnerState object with booleans for player win/tie/loss</li>
</ul>


