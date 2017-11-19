package com.game.client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.game.server.GameObject;
import com.game.server.GameSetting;

public interface PlayerInt extends Remote {

	public void start(GameSetting gameSetting) throws RemoteException;

	public void gameOver() throws RemoteException;

	public int getWidth() throws RemoteException;

	public int getHeight() throws RemoteException;

	public void drawToScene(GameObject gameObjects) throws RemoteException;
	
	public void drawToScene(List<GameObject> gameObjects) throws RemoteException;

	public void refreshScene() throws RemoteException;

	public void setVisible(boolean b) throws RemoteException;

	public void fire() throws RemoteException;
}
