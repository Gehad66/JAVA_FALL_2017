package com.game.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.game.server.GameObject;
import com.game.server.GameSetting;
import com.game.server.ResourcesUtils;
import com.game.server.ServerInt;

public class PlayerImpl extends UnicastRemoteObject implements  PlayerInt {


	private static final long serialVersionUID = -7657076306307031092L;
	private GameView view;
	private ServerInt serverInt;
	private GameSetting setting;
	
	public PlayerImpl(ServerInt serverInt) throws RemoteException {
		super();
		this.serverInt = serverInt;
	}

	public void setGameView(GameView view){
		this.view = view;
	}
	

	public GameSetting getSetting() {
		return setting;
	}

	public void setSetting(GameSetting setting) {
		this.setting = setting;
	}

	@Override
	public void start(GameSetting gameSetting) throws RemoteException {
		GameView gameView = new GameView("Smash Wall Game",ResourcesUtils.GAME_WIDTH, ResourcesUtils.GAME_HEIGHT);
		setGameView(gameView);
		setSetting(gameSetting);
		gameView.setPlayerInt(this);
		gameView.setVisible(true);
		gameView.setSceneBackground();
		gameView.setVisible(true);
	}

	@Override
	public void gameOver() throws RemoteException {
		view.showGameOver();
	}



	@Override
	public int getWidth() throws RemoteException {
		return view.getWidth();
	}

	@Override
	public int getHeight() throws RemoteException {
		return view.getHeight();
	}

	@Override
	public void drawToScene(GameObject obj) throws RemoteException {
		view.drawToScene(obj);
	}
	
	@Override
	public void drawToScene(List<GameObject> gameObjects) throws RemoteException {
		view.drawToScene(gameObjects);
	}

	@Override
	public void refreshScene() throws RemoteException {
		view.refreshScene();
	}

	@Override
	public void setVisible(boolean b) throws RemoteException {
		view.setVisible(b);
	}

	@Override
	public void fire() throws RemoteException {
		serverInt.fire(getSetting().getPlayerName());
	}



}
