package com.game.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UID;

import com.game.server.Message;
import com.game.server.ServerInt;

public class Run {
	
	public static void main(String[] args) {

		try {
			 
			UID myId = new UID();
			
			Registry reg = LocateRegistry.getRegistry("127.0.0.1",1111);
			ServerInt serverInt = (ServerInt) reg.lookup("serverService");
			serverInt.register(myId.toString(), new ClientImpl());
			serverInt.broadcast(new Message(myId.toString(), "Kindly noted that connection id ["+myId+"] has joined."));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
