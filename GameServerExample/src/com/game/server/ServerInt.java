package com.game.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.game.client.ClientInt;

public interface ServerInt extends Remote {

	public void broadcast(Message msg) throws RemoteException;
	public void register(String name, ClientInt clientInt) throws RemoteException;
	public void unRegister(String name) throws RemoteException;
	
}
