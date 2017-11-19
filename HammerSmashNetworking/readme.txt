This code is still under development but i meant to post it as fast as i can to help you in the networking assignment.

Now you can play the hammer game throw network but at first you should run the server "Run.java" from the following package com.game.server 

then you have to run the client class "Run.java" twice to able to start a game "it's a multi-player game" from the package com.game.client

The Game simply the first player who hit the wall will be the winner.

you can notice if you implemented your game using MVC that the controller and the models are in the server package and the client only will have the game view code
and if the client get any user action it will pass it to the server "Game controller" and wait to UI update