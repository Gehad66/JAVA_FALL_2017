package com.game.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.game.client.PlayerInt;


public interface ServerInt extends Remote {

	public void addPlayer(PlayerInt clientInt) throws RemoteException;
	public void removePlayer(String name) throws RemoteException;
	public void fire(String name) throws RemoteException;
}
