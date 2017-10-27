import java.util.ArrayList;
import java.util.List;

public class GameController {

	private List<GameObject> gameObjects;
	private GameView gameView;
	MovableGameObject hammer;
	StaticGameObject wall ;
	
	public GameController(GameView gameView) {
		this.gameView = gameView;
		gameObjects = new ArrayList<>();
		initializeGameScene();
		initializeGameObjects();
	}
	
	private void initializeGameScene() {
		gameView.setSceneBackground();
	}

	private void initializeGameObjects(){
		 hammer = new MovableGameObject(ResourcesUtils.HAMMER_IMG, 100, 100, 350, 10,
				0,gameView.getWidth(), 0, gameView.getHeight(), MovableGameObject.MOVE_X);
		 wall = new StaticGameObject(ResourcesUtils.WALL_IMG, 150, 200, 350, 350);
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					hammer.move(10);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gameView.drawToScene(gameObjects);
					gameView.refreshScene();
				}
			}
		});
		hammer.setMover(th);
		hammer.startMoving();
		gameObjects.add(hammer);
		gameObjects.add(wall);
		gameView.drawToScene(gameObjects);
		
	}

	public void start() {
		gameView.setVisible(true);
	}

	public void fire() {
		MovableGameObject fire = new MovableGameObject(ResourcesUtils.HAMMER_IMG, 100, 100, hammer.getPosX(), hammer.getPosY(),
					0,gameView.getWidth(), 0, gameView.getHeight(), MovableGameObject.MOVE_Y);
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					fire.move(10);
					if(fire.isHit(wall)){
						System.out.println("The wall is hitted by the hammer");
						gameOver();
						fire.suspendMoving();
						
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					gameView.drawToScene(gameObjects);
					gameView.refreshScene();
				}
			}
		});
		
		fire.setMover(th);
		fire.startMoving();
		gameObjects.add(fire);
	}
	
	public void gameOver(){
		System.out.println("The game over is called..");
		hammer.suspendMoving();
		gameView.showGameOver();
	}
}
