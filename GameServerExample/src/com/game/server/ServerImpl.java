package com.game.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import com.game.client.ClientInt;

public class ServerImpl extends UnicastRemoteObject implements ServerInt {

	/** 
	 * Server Implementation Class 
	 */
	private static final long serialVersionUID = 5081658822112792121L;
	
	public ServerImpl() throws RemoteException {
		super();
	}

	private HashMap<String, ClientInt> connections = new HashMap<>();
	@Override
	public void broadcast(Message msg) throws RemoteException {
		for(String name: connections.keySet()){
			connections.get(name).recieve(msg);
			System.out.println("The message had been sent to  client ["+name+"].");	
		}	
	}

	@Override
	public void register(String name, ClientInt clientInt) throws RemoteException {
		if(connections.get(name) == null){
			connections.put(name, clientInt);
			System.out.println("The following client ["+name+"] has been connected now.");	
		}else{
			System.out.println("The following client ["+name+"] is already connected now.");	
		}
	}

	@Override
	public void unRegister(String name) throws RemoteException {
		connections.remove(name);
		System.out.println("The following client ["+name+"] has been disconnected now.");
	}

	public String showStatistics() {
		return "Server Stats :\n[connections=" + connections + "]";
	}
	
	

}
