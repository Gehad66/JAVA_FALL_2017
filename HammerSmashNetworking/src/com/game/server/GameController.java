package com.game.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import com.game.client.PlayerInt;

public class GameController extends UnicastRemoteObject implements Remote{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4149799855643600977L;
	private List<GameObject> gameObjects;
	private MovableGameObject hammer1;
	private MovableGameObject hammer2;
	private StaticGameObject wall;
	private MovableGameObject fire;
	private ServerImpl server;
	
	public GameController(ServerImpl server) throws RemoteException {
		super();
		this.server = server;
		gameObjects = new ArrayList<>();
		initializeGameObjects();
		
	}

	
	private void initializeGameObjects() throws RemoteException {
		hammer1 = new MovableGameObject(ResourcesUtils.HAMMER_IMG_1, 100, 100, 100, 10, 0, ResourcesUtils.GAME_WIDTH, 0, ResourcesUtils.GAME_HEIGHT, MovableGameObject.MOVE_X);
		hammer2 = new MovableGameObject(ResourcesUtils.HAMMER_IMG_2, 100, 100, 500, 10, 0, ResourcesUtils.GAME_WIDTH, 0, ResourcesUtils.GAME_HEIGHT, MovableGameObject.MOVE_X);
		wall = new StaticGameObject(ResourcesUtils.WALL_IMG, 150, 200, 350, 350);

		hammer1.setMover(new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					hammer1.move(10);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						updateUI(gameObjects);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
		}));

		hammer2.setMover(new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					hammer2.move(10);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						updateUI(gameObjects);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
		}));

		hammer1.startMoving();
		hammer2.startMoving();

		gameObjects.add(hammer1);
		gameObjects.add(hammer2);
		gameObjects.add(wall);

		updateUI(gameObjects);
	}


	private void updateUI(List<GameObject> objs) throws RemoteException{
		for(String name : server.getConnections().keySet()){
			server.getConnections().get(name).drawToScene(objs);
			server.getConnections().get(name).refreshScene();
		}
		
	}
	
	private void updateUI(GameObject obj) throws RemoteException{
		for(String name : server.getConnections().keySet()){
			server.getConnections().get(name).drawToScene(obj);
			server.getConnections().get(name).refreshScene();
		}
	}
	
	public void fire(int playerId) throws RemoteException {
		
		if(playerId == 1)
			fire = new MovableGameObject(ResourcesUtils.HAMMER_IMG_1, 100, 100, hammer1.getPosX(), hammer1.getPosY(), 0, ResourcesUtils.GAME_WIDTH, 0, ResourcesUtils.GAME_HEIGHT, MovableGameObject.MOVE_Y);
		else if(playerId == 2)
			fire = new MovableGameObject(ResourcesUtils.HAMMER_IMG_2, 100, 100, hammer2.getPosX(), hammer2.getPosY(), 0, ResourcesUtils.GAME_WIDTH, 0, ResourcesUtils.GAME_HEIGHT, MovableGameObject.MOVE_Y);
		
		fire.setMover( new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					fire.move(10);
					if (fire.isHit(wall)) {
						System.out.println("The wall is hitted by the hammer");
						try {
							gameOver();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						fire.suspendMoving();
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						updateUI(gameObjects);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}));
		
		fire.startMoving();
		gameObjects.add(fire);
		updateUI(gameObjects);
	}

	public void gameOver() throws RemoteException {
		System.out.println("The game over is called..");
		hammer1.suspendMoving();
		hammer2.suspendMoving();
		for(String name : server.getConnections().keySet()){
			server.getConnections().get(name).gameOver();
		}
	}
}
