# Black Jack With Spring Boot Application
<p>
In another project, I was able to create a working blackJackGame that used users' input to command line to run a game of 
BlackJack. Now I am attempting to recreate the functionality through HTTP GET/POST requests to a remote API. This way,
I'm able to create an application that's functionality can be much more user friendly on a browser/app. Also, the use of
common HTTP GET/POST request/responses will allow the API to be consumed in various types of front ends.
</p>
<h3>//SOFAR</h3>
<ul>
    <li>Created a spring boot app with GET/POT endpoints reachable on localhost through postman</li>
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

