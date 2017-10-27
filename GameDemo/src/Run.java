
public class Run {

	public static void main(String[] args) {

		GameView gameView  =  new GameView("Smash Wall Game",800,600);
        GameController gameController = new GameController(gameView);
        gameView.setGameController(gameController);
		gameController.start();
	
	}
}
