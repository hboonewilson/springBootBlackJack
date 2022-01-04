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
<ul>
    <li>api/v1/startGame: requires Integer(Number of decks you want to play with</li>
</ul>

