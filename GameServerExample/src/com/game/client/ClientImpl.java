package com.game.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.game.server.Message;

public class ClientImpl  extends UnicastRemoteObject implements ClientInt {

	/**
	 * Client Implementation Class 
	 */
	private static final long serialVersionUID = -5871302596284686894L;

	public ClientImpl()throws RemoteException {
	
	}
	@Override
	public void recieve(Message msg) throws RemoteException {
		System.out.println("I have recieved a message from the server :\n"+ msg.getMessage());
	}

}
