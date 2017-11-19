package com.game.server;

import java.io.Serializable;
import java.rmi.server.UID;

public class GameSetting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2861568734679532504L;
	private int playerId;
	private String playerName;
	
	private static int idCount=1;
	
	public GameSetting(){
		super();
		this.playerId = idCount;
		this.playerName = new UID().toString();
		idCount++;
	}
	public GameSetting(int playerId, String playerName) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	
	
}
