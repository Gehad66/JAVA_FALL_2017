package com.game.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import com.game.server.ServerInt;

public class Run {

	public static void main(String[] args) {

		try {

			Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1111);
			ServerInt serverInt = (ServerInt) reg.lookup("serverService");
			PlayerInt player = new PlayerImpl(serverInt);
			serverInt.addPlayer(player);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
