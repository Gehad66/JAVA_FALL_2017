package com.game.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.game.server.Message;

public interface ClientInt extends Remote{

	public void recieve(Message msg) throws RemoteException;
}
