package com.game.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import com.game.client.PlayerInt;

public class ServerImpl extends UnicastRemoteObject implements ServerInt {

	/**
	 * Server Implementation Class
	 */
	private static final long serialVersionUID = 5081658822112792121L;
	
	private HashMap<String, PlayerInt> connections = new HashMap<>();
	private HashMap<String, GameSetting> connectionsSettings = new HashMap<>();
	private GameController cont;
	
	public ServerImpl() throws RemoteException {
		super();
	}

	public HashMap<String, PlayerInt> getConnections() {
		return connections;
	}

	public void setConnections(HashMap<String, PlayerInt> connections) {
		this.connections = connections;
	}

	@Override
	public void addPlayer(PlayerInt clientInt) throws RemoteException {
		GameSetting gameSetting = new GameSetting();

		if (connections.get(gameSetting.getPlayerName()) == null) {
			connections.put(gameSetting.getPlayerName(), clientInt);
			connectionsSettings.put(gameSetting.getPlayerName(), gameSetting);
			System.out.println("The following client [" + gameSetting.getPlayerName() + "] has been connected now.");
		} else {
			System.out.println("The following client [" + gameSetting.getPlayerName() + "] is already connected now.");
		}

		if (connections.size() >= 2) {
			for (String name : connections.keySet()) {
				GameSetting sett = connectionsSettings.get(name);
				connections.get(name).start(sett);
			}
			cont = new GameController(this);
		} else {
			System.out.println("Still wating for people to connect..");
			
		}
	}

	@Override
	public void removePlayer(String name) throws RemoteException {
		connections.remove(name);
		System.out.println("The following client [" + name + "] has been disconnected now.");
	}

	public String showStatistics() {
		return "Server Stats :\n[connections=" + connections + "]";
	}

	@Override
	public void fire(String name) throws RemoteException {
		int playerId = connectionsSettings.get(name).getPlayerId();
		cont.fire(playerId);
		
	}

}
