# KtanCore

KtanCore is the system representing the game core. Its responsibilities are the following :

1. Receive and process incoming inputs, convert them in internal Actions
2. Check the legality of the Action based on the owner, game phase and game state
3. If legal, apply the Action onto the game state and store the Action in the game History
4. Create an update holding information about how the Action was processed
5. Send the update as output

